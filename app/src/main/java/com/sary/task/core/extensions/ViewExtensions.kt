package com.sary.task.core.extensions

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sary.task.R
import com.sary.task.core.android.BaseListAdapter
import timber.log.Timber

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
typealias InflateActivity<T> = (LayoutInflater) -> T

inline fun <T : ViewBinding> ViewGroup.viewBinding(
    crossinline bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T,
    attachToParent: Boolean = true
) =
    bindingInflater.invoke(LayoutInflater.from(this.context), this, attachToParent)

fun View.getAppDrawableFromColor(@ColorRes color: Int): Drawable =
    ColorDrawable(getAppColorFromRes(color))

fun View.getAppColorFromRes(@ColorRes color: Int): Int {
    return ContextCompat.getColor(context, color)
}

fun <T : Any?, L : LiveData<T>> LifecycleOwner.observe(flow: L, body: (T) -> Unit) {
    if (this is Activity) {
        flow.observe(this, body)
    } else {
        this as Fragment
        flow.observe(viewLifecycleOwner, body)
    }
}

fun String?.removeWhitespaces(): String = this?.replace(" ", "") ?: ""

fun String?.toSafeDouble(returnValue: Double = 0.0): Double {
    return try {
        if (isNullOrBlank()) returnValue else removeWhitespaces().toDouble()
    } catch (e: NumberFormatException) {
        returnValue
    }
}

fun Fragment.showKeyboard(): Unit? = activity?.let(FragmentActivity::showKeyboard)

fun Activity.showKeyboard() = WindowInsetsControllerCompat(window, window.decorView).show(
    WindowInsetsCompat.Type.ime()
)

fun View.show(show: Boolean = true) =
    if (show) visibility = View.VISIBLE else visibility = View.GONE

fun RecyclerView.setup(adapter: BaseListAdapter<*, *>, showDivider: Boolean = false): RecyclerView {
    if (showDivider) {
        val decoration = DividerItemDecoration(
            context,
            (layoutManager as LinearLayoutManager).orientation
        )
        addItemDecoration(decoration)
    }
    this.adapter = adapter
    return this
}

fun View.loadImage(
    data: Any?,
    disableCache: Boolean = false,
    disablePlaceholder: Boolean = false,
    isCircular: Boolean = false,
    progressBar: ProgressBar? = null
) {
    progressBar?.visible()
    val imageLoader = context.imageLoader
    val request = ImageRequest.Builder(context)
        .data(data)
        .crossfade(true)
        .target(
            onStart = {
                if (!disablePlaceholder)
                    if (this is ImageView) {
                        setImageResource(R.mipmap.ic_launcher)
                    }
            },
            onSuccess = { result ->
                when (this) {
                    is ImageView -> {
                        setImageDrawable(result)
                    }
                    is FloatingActionButton -> {
                        setImageResource(R.drawable.ic_cart)
                    }
                    else -> background = result
                }
            },
            onError = {
                when (this) {
                    is ImageView -> {
                        setImageResource(R.mipmap.ic_launcher_round)
                    }
                    else -> {
                        setBackgroundResource(R.mipmap.ic_launcher_round)
                    }
                }
            })
    request.networkCachePolicy(if (disableCache) CachePolicy.DISABLED else CachePolicy.ENABLED)
    if (isCircular)
        request.transformations(CircleCropTransformation())
    imageLoader.enqueue(request.build()).job.invokeOnCompletion {
        if (it !is IllegalStateException)
            Timber.e(it?.message)
        progressBar?.gone()
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}
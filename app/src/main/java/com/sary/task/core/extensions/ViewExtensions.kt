package com.sary.task.core.extensions

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sary.task.core.android.BaseListAdapter
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
typealias InflateActivity<T> = (LayoutInflater) -> T

fun <T : Any?, L : SharedFlow<T>> LifecycleOwner.observe(flow: L, body: (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                body.invoke(it)
            }
        }
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

fun RecyclerView.setup(adapter: BaseListAdapter<*, *>, showDivider: Boolean) {
    if (showDivider) {
        val decoration = DividerItemDecoration(
            context,
            (layoutManager as LinearLayoutManager).orientation
        )
        addItemDecoration(decoration)
    }
    this.adapter = adapter
}
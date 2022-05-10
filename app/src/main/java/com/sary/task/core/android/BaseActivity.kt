package com.sary.task.core.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.sary.task.core.extensions.InflateActivity

abstract class BaseActivity<B : ViewBinding>(
    private val inflate: InflateActivity<B>
) : AppCompatActivity() {

    val binding: B by lazy(LazyThreadSafetyMode.NONE) {
        inflate.invoke(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}
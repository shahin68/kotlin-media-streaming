package com.shahin.stream.ui

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding>(@LayoutRes val layout: Int): AppCompatActivity(layout) {

    protected var _binding: T? = null
    protected val binding: T get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
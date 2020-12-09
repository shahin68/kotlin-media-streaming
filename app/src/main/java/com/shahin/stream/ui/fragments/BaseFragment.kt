package com.shahin.stream.ui.fragments

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(@LayoutRes val layout: Int) : Fragment(layout) {
    protected var _binding: T? = null
    protected val binding: T get() = _binding!!

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}
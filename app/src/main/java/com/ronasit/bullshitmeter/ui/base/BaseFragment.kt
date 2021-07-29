package com.ronasit.bullshitmeter.ui.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB: ViewDataBinding>: Fragment() {

    abstract val layoutId : Int
    abstract val viewModel: BaseViewModel

    protected var binding: VDB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            binding?.lifecycleOwner = this
        }
        return binding?.root
    }
}
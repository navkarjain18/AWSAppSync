package com.appsyncsample.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * Created by Rupesh Saxena
 */
abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    lateinit var viewDataBinding: T
    lateinit var mViewModel: V

    abstract fun setBindingVariable(): Int

    @LayoutRes
    abstract fun setLayoutId(): Int

    abstract fun setViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, setLayoutId())
        mViewModel = setViewModel()
        viewDataBinding.setVariable(setBindingVariable(), mViewModel)
        viewDataBinding.executePendingBindings()
    }
}
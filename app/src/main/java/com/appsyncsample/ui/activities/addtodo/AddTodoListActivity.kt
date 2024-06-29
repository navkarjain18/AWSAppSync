package com.appsyncsample.ui.activities.addtodo

import android.os.Bundle
import androidx.activity.viewModels
import com.appsyncsample.BR
import com.appsyncsample.R
import com.appsyncsample.databinding.ActivityAddTodoListBinding
import com.appsyncsample.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTodoListActivity : BaseActivity<ActivityAddTodoListBinding, AddTodoViewModel>() {

    private val viewModel: AddTodoViewModel by viewModels()
    override fun setBindingVariable(): Int {
        return BR.addTodoVM
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_add_todo_list
    }

    override fun setViewModel(): AddTodoViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initViews()
    }

    private fun init() {
        viewDataBinding.holderAdd.setOnClickListener {
            viewModel.addTodo(viewDataBinding.etId.text.toString()) {
                viewDataBinding.etId.setText("")
            }
        }
    }

    private fun initViews() {

    }
}
package com.example.awsappsyncsampleapp.ui.activities.addtodo

import android.os.Bundle
import androidx.activity.viewModels
import com.example.awsappsyncsampleapp.BR
import com.example.awsappsyncsampleapp.R
import com.example.awsappsyncsampleapp.databinding.ActivityAddTodoListBinding
import com.example.awsappsyncsampleapp.ui.base.BaseActivity
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
            viewModel.createTodo(viewDataBinding.etId.text.toString()) {
                viewDataBinding.etId.setText("")
            }
        }
    }

    private fun initViews() {

    }
}
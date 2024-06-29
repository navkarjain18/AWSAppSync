package com.appsyncsample.ui.activities.todoList

import android.os.Bundle
import androidx.activity.viewModels
import com.appsyncsample.BR
import com.appsyncsample.GetTodoDetailsListQuery
import com.appsyncsample.R
import com.appsyncsample.databinding.ActivityTodoListBinding
import com.appsyncsample.ui.adapters.TodoListItemsAdapter
import com.appsyncsample.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TodoListActivity : BaseActivity<ActivityTodoListBinding, TodoListViewModel>() {

    private val viewModel: TodoListViewModel by viewModels()

    @Inject
    lateinit var todoListItemsAdapter: TodoListItemsAdapter

    override fun setBindingVariable(): Int {
        return BR.todoListVM
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_todo_list
    }

    override fun setViewModel(): TodoListViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initViews()
    }

    private fun init() {
        viewDataBinding.listResidents.adapter = todoListItemsAdapter

        viewModel.getTodoList {
            todoListItemsAdapter.setData(it)
        }


        viewModel.subscribeTodoDetails { todo ->
            val todoItem = GetTodoDetailsListQuery.Item(
                "",
                todo?.id().toString(),
                todo?.name().toString(),
                todo?.description().toString(),
                todo?.createdAt().toString(),
                todo?.updatedAt().toString(),
            )
            todoListItemsAdapter.todoList.add(0, todoItem)
            todoListItemsAdapter.notifyDataSetChanged()
        }
    }

    private fun initViews() {}


}
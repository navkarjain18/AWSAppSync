package com.example.awsappsyncsampleapp.ui.activities.todoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awsappsyncsampleapp.remote.CoreRepository
import com.sample.core.GetTodoDetailsListQuery
import com.sample.core.OnCreateTodoSubscription
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor() : ViewModel() {

    private var coreRepository: CoreRepository = CoreRepository()

    fun getTodoList(onResponse: (List<GetTodoDetailsListQuery.Item>?) -> Unit) {
        viewModelScope.launch {
            coreRepository.getTodoDetailsList(onResponse = {
                onResponse(it)
            }, onFailure = {

            })
        }
    }


    fun subscribeTodoDetails(onResponse: (OnCreateTodoSubscription.OnCreateTodo?) -> Unit) {
        viewModelScope.launch {
            coreRepository.subscribeTodoDetails(onResponse = {
                onResponse(it)
            }, onFailure = {

            }, onCompleted = {

            })
        }

    }
}


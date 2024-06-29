package com.appsyncsample.ui.activities.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsyncsample.remote.CoreRepository
import com.sample.core.type.CreateTodoInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor() : ViewModel() {

    private var coreRepository: CoreRepository = CoreRepository()

    fun createTodo(id: String, onResponse: () -> Unit) {
        viewModelScope.launch {
            coreRepository.createTodo(createTodoInput = CreateTodoInput.builder().name("New Added")
                .id(id).description("Description").build(), onResponse = {
                onResponse()
            }, onFailure = {

            })
        }
    }
}
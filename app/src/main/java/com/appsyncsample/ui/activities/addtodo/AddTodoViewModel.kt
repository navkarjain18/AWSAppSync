package com.appsyncsample.ui.activities.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsyncsample.remote.CoreRepository
import com.appsyncsample.type.CreateTodoInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor() : ViewModel() {

    private var coreRepository: CoreRepository = CoreRepository()

    fun addTodo(id: String, onResponse: () -> Unit) {
        viewModelScope.launch {
            coreRepository.addTodo(createTodoInput = CreateTodoInput.builder().name("New Added")
                .id(id).description("Description").build(), onResponse = {
                onResponse()
            }, onFailure = {

            })
        }
    }
}
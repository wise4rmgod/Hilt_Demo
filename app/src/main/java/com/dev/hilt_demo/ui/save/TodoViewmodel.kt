package com.dev.hilt_demo.ui.save

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.hilt_demo.db.Todo
import com.dev.hilt_demo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewmodel @ViewModelInject constructor(
    private val todoRepository: TodoRepository
) :
    ViewModel() {
    val todolist = todoRepository.getAlltodos()

    var todo = Todo()

    val status: MutableLiveData<Boolean> = MutableLiveData()

    fun save() {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                todoRepository.saveTodo(todo)
                status.postValue(true)
            }

        }
    }
}


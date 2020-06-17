package com.dev.hilt_demo.repository

import androidx.lifecycle.MutableLiveData
import com.dev.hilt_demo.db.AppDb
import com.dev.hilt_demo.db.Todo
import javax.inject.Inject

class TodoRepository @Inject constructor(appDb: AppDb) {

    private val tododao = appDb.todoDao()

    fun saveTodo(todo: Todo) {
        tododao.insert(todo)
    }

    fun getAlltodos() = tododao.getAllTodos()

}
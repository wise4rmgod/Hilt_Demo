package com.dev.hilt_demo.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dev.hilt_demo.R
import com.dev.hilt_demo.adapter.ListAdapter
import com.dev.hilt_demo.ui.save.TodoViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list.*

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    private val todoViewmodel: TodoViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        todoViewmodel.todolist.observe(this, Observer {
            recycler.adapter = ListAdapter(it)

        })

    }
}
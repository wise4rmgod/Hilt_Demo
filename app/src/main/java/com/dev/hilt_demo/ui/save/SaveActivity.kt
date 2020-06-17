package com.dev.hilt_demo.ui.save

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.dev.hilt_demo.R
import com.dev.hilt_demo.databinding.ActivityMainBinding
import com.dev.hilt_demo.db.Todo
import com.dev.hilt_demo.ui.list.ListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveActivity : AppCompatActivity() {
    private val todoViewmodel: TodoViewmodel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.todoViewmodel = todoViewmodel


        todoViewmodel.status.observe(this, Observer {
            if (it == true) {
                Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "not successful", Toast.LENGTH_SHORT).show()
            }
        })

        binding.rebtn.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }

        binding.savebtn.setOnClickListener {
            todoViewmodel.save()
        }

    }

}
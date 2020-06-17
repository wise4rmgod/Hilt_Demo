package com.dev.hilt_demo.adapter

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.hilt_demo.R
import com.dev.hilt_demo.databinding.TodolistBinding
import com.dev.hilt_demo.db.Todo

class ListAdapter(private val todoitems: List<Todo>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodolistBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = todoitems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(todoitems[position])

    inner class ViewHolder(val binding: TodolistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Todo) {
            binding.todo = item
            binding.executePendingBindings()

        }
    }
}
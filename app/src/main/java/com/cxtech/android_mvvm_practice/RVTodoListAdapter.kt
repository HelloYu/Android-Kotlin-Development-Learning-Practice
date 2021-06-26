/*
 * MIT License
 *
 * Copyright (c) 2021 Alan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * File Name: RVTodoListAdapter.kt
 * Project: Android-MVVM-Practice
 * Module: Android-MVVM-Practice.app
 * Author: Alan
 * Author URI: https://www.seozen.top
 * Email: Mr.Yu1991@gmail.com
 * Current Modification Date: 6/26/21 9:15 PM
 * Last Modified Date: 6/26/21 8:34 PM
 */

package com.cxtech.android_mvvm_practice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cxtech.android_mvvm_practice.databinding.TodoListItemBinding

class RVTodoListAdapter : ListAdapter<TodoItem, RVTodoListAdapter.ViewHolder>(TodoDiffCallback()) {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: TodoListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: TodoItem) {
            with(binding) {
                todoItem = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.todo_list_item,
                parent,
                false
            )
        )
    }
}

private class TodoDiffCallback : DiffUtil.ItemCallback<TodoItem>() {

    override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        Log.d("todoList","3344")
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem == newItem
    }
}
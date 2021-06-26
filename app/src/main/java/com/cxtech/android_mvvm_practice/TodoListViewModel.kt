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
 * File Name: TodoListViewModel.kt
 * Project: Android-MVVM-Practice
 * Module: Android-MVVM-Practice.app
 * Author: Alan
 * Author URI: https://www.seozen.top
 * Email: Mr.Yu1991@gmail.com
 * Current Modification Date: 6/26/21 9:15 PM
 * Last Modified Date: 6/26/21 9:00 PM
 */

package com.cxtech.android_mvvm_practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class TodoListViewModel : ViewModel() {

    private  val list = loadTodoList()
    private val _todoList: MutableLiveData<List<TodoItem>> by lazy {
        MutableLiveData<List<TodoItem>>(list)


    }

    val todoList: LiveData<List<TodoItem>>
        get() =_todoList


    fun loadTodoList(): List<TodoItem> {

        var result: ArrayList<TodoItem> = ArrayList<TodoItem>()
        var i: Int = 0;

        while (i < 10000) {
            result.add(TodoItem("TODO$i", "remark$i"))
            i++
        }

        return result.toList()
    }
}
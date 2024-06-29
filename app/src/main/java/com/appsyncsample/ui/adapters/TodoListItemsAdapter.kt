/*
 * Copyright 2023 DigiValet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appsyncsample.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.appsyncsample.GetTodoDetailsListQuery
import com.appsyncsample.R
import com.appsyncsample.databinding.RowTodoListItemBinding
import com.appsyncsample.utils.listeners.OnViewClickListener
import javax.inject.Inject

class TodoListItemsAdapter @Inject constructor() :
    RecyclerView.Adapter<TodoListItemsAdapter.ViewHolder>() {

    var todoList = mutableListOf<GetTodoDetailsListQuery.Item>()
    private var itemClickListener: OnViewClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RowTodoListItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.row_todo_list_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    class ViewHolder(var binding: RowTodoListItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setView(position, holder.binding)
    }

    /**
     * Set View
     * */
    private fun setView(
        position: Int, binding: RowTodoListItemBinding
    ) {
        binding.tvTitle.text = todoList[position].id()
        binding.tvSubTitle.text = todoList[position].createdAt()
    }

    /**
     * Set Data
     * */
    fun setData(list: List<GetTodoDetailsListQuery.Item>?) {
        this.todoList = list.orEmpty().toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Set Item Click Listener
     * */
    fun setItemClick(itemClickListener: OnViewClickListener) {
        this.itemClickListener = itemClickListener
    }
}
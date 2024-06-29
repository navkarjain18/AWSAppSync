package com.appsyncsample.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.appsyncsample.R
import com.appsyncsample.databinding.ActivityMainBinding
import com.appsyncsample.remote.CoreRepository
import com.appsyncsample.ui.activities.addtodo.AddTodoListActivity
import com.appsyncsample.ui.activities.todoList.TodoListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
    }

    private fun init() {
        binding.holderListScreen.setOnClickListener {
            startActivity(Intent(this, TodoListActivity::class.java))
        }

        binding.holderMutation.setOnClickListener {
            startActivity(Intent(this, AddTodoListActivity::class.java))
        }

        binding.holderClearCache.setOnClickListener {
            CoreRepository().clearCache()
        }
    }
}
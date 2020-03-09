package com.example.myskills.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myskills.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var todosViewModel: TodoViewModel = TodoViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todosViewModel = ViewModelProviders.of(this).get(todosViewModel::class.java)
        todosViewModel.getDataFromServer()

        val adapter = todoAdapter(this)
        myRecy.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        myRecy.adapter = adapter

        todosViewModel.liveData.observe(this, Observer { list ->
            adapter.arr = list
            adapter.notifyDataSetChanged()
        })
    }

}

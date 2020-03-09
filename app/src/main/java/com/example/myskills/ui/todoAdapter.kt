package com.example.myskills.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myskills.R
import com.example.myskills.pojo.TodoModel

class todoAdapter(var conx: Context) :
    RecyclerView.Adapter<todoAdapter.MyHolder>() {

    var arr = ArrayList<TodoModel>()

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userId = view.findViewById<TextView>(R.id.userid)
        var todoId = view.findViewById<TextView>(R.id.todoId)
        var todoTitle = view.findViewById<TextView>(R.id.todoTitle)
        var isCompleted = view.findViewById<TextView>(R.id.isCompleted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val myView = LayoutInflater.from(conx).inflate(R.layout.todo_card, parent, false)
        return MyHolder(myView)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.userId.text = arr[position].userId.toString()
        holder.todoId.text = arr[position].id.toString()
        holder.todoTitle.text = arr[position].title
        if (arr[position].completed) {
            holder.isCompleted.setTextColor(Color.parseColor("#1F8023"))
            holder.isCompleted.text = "Completed"
        } else {
            holder.isCompleted.setTextColor(Color.RED)
            holder.isCompleted.text = "Not Completed"
        }

    }

}
package com.example.myskills.data

import com.example.myskills.pojo.TodoModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoClient {
    private val BaseUrl = "https://jsonplaceholder.typicode.com/"
    private var todoInterface: TodoInterface? = null
    private var INSTANT: TodoClient? = null


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        todoInterface = retrofit.create(TodoInterface::class.java)
    }

    fun getINSTANCE(): TodoClient {
        if (INSTANT == null) {
            INSTANT = TodoClient()
        }
        return INSTANT!!
    }

    fun getTodos(): Observable<ArrayList<TodoModel>> {
        return todoInterface!!.getTodos()
    }

}
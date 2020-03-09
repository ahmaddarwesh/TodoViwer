package com.example.myskills.data

import com.example.myskills.pojo.TodoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface TodoInterface {
    @GET("todos")
    public fun getTodos(): Observable<ArrayList<TodoModel>>
}
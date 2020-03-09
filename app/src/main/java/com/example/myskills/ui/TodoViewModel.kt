package com.example.myskills.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myskills.data.TodoClient
import com.example.myskills.pojo.TodoModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class TodoViewModel : ViewModel() {

    var liveData = MutableLiveData<ArrayList<TodoModel>>()
    var TAG = "infoTage"

    fun getDataFromServer() {
        val observable = TodoClient().getINSTANCE().getTodos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer = object : Observer<ArrayList<TodoModel>> {
            override fun onComplete() {
                Log.d(TAG, "Completed!")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "Subscribed!")
            }

            override fun onNext(value: ArrayList<TodoModel>) {
                liveData.value = value
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "Error! ${e}")
            }


        }
        observable.subscribe(observer)
    }
}
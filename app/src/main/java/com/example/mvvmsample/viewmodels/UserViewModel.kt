package com.example.mvvmsample.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.repositories.UserRepository
import com.example.mvvmsample.models.User
import com.example.mvvmsample.utils.Utility.isInternetAvailable

class UserViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<User>>()

    init{
        val userRepository : UserRepository by lazy {
            UserRepository
        }
        if(context.isInternetAvailable()) {
            listData = userRepository.getMutableLiveData(context)
        }
    }

    fun getData() : MutableLiveData<ArrayList<User>>{
        return listData
    }

}
package com.example.mvvmsample.api

import com.example.mvvmsample.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>

}
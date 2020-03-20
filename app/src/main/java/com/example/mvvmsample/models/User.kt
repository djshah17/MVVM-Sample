package com.example.mvvmsample.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("username")
    val userName: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("address")
    val addressObject : Address? = null,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("website")
    val website: String? = null
    ) : Serializable




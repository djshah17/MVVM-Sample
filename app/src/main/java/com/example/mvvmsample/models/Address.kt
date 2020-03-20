package com.example.mvvmsample.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(

    @SerializedName("street")
    val street: String? = null,

    @SerializedName("suite")
    val suite: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("zipcode")
    val zipCode: String? = null

) : Serializable
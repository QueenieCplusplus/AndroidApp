package com.katesapp2019.android.katesintentapp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


//Json to Kotlin
//convert to JavaIO.Serialize
data class UserInfo(

    @SerializedName("result")
    @Expose
    var result: Int,

    @SerializedName("error_msg")
    @Expose
    var errorMessage: String,

    @SerializedName("data")
    @Expose
    var data: Data

): Serializable {

    data class Data(
         @SerializedName("username")
         @Expose
         var userName: String,

         @SerializedName("accesstoken")
         @Expose
         var accessToken: String

    ): Serializable
}
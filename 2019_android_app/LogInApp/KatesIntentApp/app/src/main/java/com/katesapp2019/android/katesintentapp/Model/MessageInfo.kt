package com.katesapp2019.android.katesintentapp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MessageInfo(


    @SerializedName("result")
    @Expose
    var result: Int,

    @SerializedName("error_msg")
    @Expose
    var errorMessage: String,

    @SerializedName("data")
    @Expose
    var data: List<Data>

//    @SerializedName("title")
//    @Expose
//    val title: String,
//
//    @SerializedName("context")
//    @Expose
//    val context: String

) : Serializable { //Todo

    data class Data (
        @SerializedName("title")
        @Expose
        val title: String,

        @SerializedName("context")
        @Expose
        val context: String

    ):Serializable
}




package com.katesapp2019.android.katesintentapp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MailBox(

    @SerializedName("title")
    @Expose
     val title: String,
    @SerializedName("add_time")
    @Expose
     val addTime: String,
    @SerializedName("")
    @Expose
     val reply: List<ReplyMail>

): Serializable
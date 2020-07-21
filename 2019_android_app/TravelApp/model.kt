package com.app.travel.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Model(
    @SerializedName("data")
    @Expose
    val balance: String,

    @SerializedName("type")
    @Expose
    val type: Int

) : Serializable
package com.app.travel.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class AirlineListModel(
    @SerializedName("Aireline")
    @Expose
    val bank: String,

    @SerializedName("code")
    @Expose
    val code: String
    
) : Serializable
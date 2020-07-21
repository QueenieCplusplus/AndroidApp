package com.app.travel.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName("access-token")
    @Expose
    var accessToken: String,

    @SerializedName("money")
    @Expose
    var money: String,

    @SerializedName("username")
    @Expose
    var userName: String,

    @SerializedName("alias")
    @Expose
    var alias: String,

    @SerializedName("vip_level")
    @Expose
    var vipLevel : Int
    
)
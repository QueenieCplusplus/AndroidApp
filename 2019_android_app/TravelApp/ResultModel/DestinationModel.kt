package com.app.travel.model

import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat

import com.app.travel.base.BaseApplication
import java.io.Serializable

data class DestinationModel(
    val CountryCode: String,
    val DestNameCn: String,
    val DestNameEng: String,
    val PlaceIcon: Int
) : Serializable {
    val imgBackground: Drawable
        get() = ResourcesCompat.getDrawable(BaseApplication.instance.resources, PlaceIcon, null)!!
}
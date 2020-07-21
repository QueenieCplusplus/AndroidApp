package com.app.travel.model.response

import com.bannerlayout.listener.BannerModelCallBack
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CouponListModel(

    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("start_time")
    @Expose
    val startTime: String,

    @SerializedName("end_time")
    @Expose
    val endTime: String,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("intro")
    @Expose
    val intro: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("wap")
    @Expose
    val wap: Int,

    @SerializedName("wap_big_img")
    @Expose
    val wapBigImg: String,


    // 序列中的序列，陣列中的陣列
    @SerializedName("wap_small_img")
    @Expose
    val wapSmallImg: String
) : Serializable, BannerModelCallBack {
    override val bannerTitle: String
        get() = ""
    override val bannerUrl: Any
        get() = wapSmallImg
    val formatDate: String
        get() = formatDate()

    private fun formatDate(): String {
        val mStartTime = startTime.split(" ")
        val mEndTime = endTime.split(" ")
        return mStartTime[0] + " ~ " + mEndTime[0]
    }

}
package com.app.travel.apiRequestInterface

//model
import com.app.travel.model.*
import com.app.travel.model.response.*
import com.app.travel.model.response.UserModel
import com.app.travel.model.response.AllMessageModel
import com.app.travel.model.response.ResultModel

//module & dependency of Data Retriever
import io.reactivex.Observable

//module & dependency of HttpReqRes
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody

//module & dependency of GetPost
import retrofit2.http.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


/*
istall Interface of Networking
use Http method & @ 
uri goes after get||POST
get is within header
post is within body
token is inside header
*/

/* usage:
// @FormUrlEncoded
// @POST("user/login")
// fun userLogin(@Field("userName") userName: Travel, 
                 @Field("password") password: Travel):Observable<ResultModel<UserModel>>
*/

interface ApiService {
// @FormUrlEncoded
// @POST("user/login")
// fun userLogin(@Field("userName") userName: Travel, @Field("password") password: Travel):Observable<ResultModel<UserModel>>
    /**
     * Login
     */
    @POST("main/login")
    fun userLogin(@Body body: RequestBody): Observable<ResultModel<UserModel>>

    /**
     * SignUp
     */
    @POST("main/register")
    fun register(@Body body: RequestBody): Observable<ResultModel<UserModel>>

    /**
     * LogOut
     */
    @POST("user/loginout")
    fun logout(@Header("access-token") token: Travel): Observable<ResultModel<Object>>


    /**
     * ResetPassword
     */
    @POST("user/ChangeLoginPassword")
    fun resetLoginPassword(@Header("access-token") token: Travel, @Body body: RequestBody): Observable<ResultModel<Object>>

    
    /**
     * Coupon
     */
    @POST("Activity/CouponList")
    fun discountList(): Observable<ResultModel<List<CouponListModel>>>


    /**
     * Forget Password
     */
    @POST("main/ForgetLoginPassword")
    fun findPwd(@Body body: RequestBody): Observable<ResultModel<Object>>

    /**
     * Security
     */
    @POST("main/question")
    fun securityQuestion(): Observable<ResultModel<List<SecurityQuestion>>>

    /**
     * Captcha
     */
    @POST("index/Captcha")
    fun captcha(@Body body: RequestBody): Observable<CaptchaModel>

    /**
     * Check User is Exist
     */
    @POST("Main/MemExist")
    fun memExist(@Body body: RequestBody): Observable<ResultModel<Object>>

    /**
     * CS
     */
    @POST("website/CustomerService")
    fun customerService(): Observable<ResultModel<Object>>


    /**
     * 安卓安裝包
     */
    @POST("Main/Android")
    fun updateVersion(): Observable<ResultModel<VersionModel>>

    /**
     * TravelRecommendModel
     */
    @POST("Travel/index")
    // fun TravelRecommend(@Header("access-token")token: Travel, @Body body: RequestBody): Observable<ResultModel<TravelRecommendModel>>
    fun TravelRecommend(@Body body: RequestBody): Observable<ResultModel<TravelRecommendModel>>

    /**
     * Unread Msg
     */
    @GET("message/Unread")
    fun getUnreadMail(@Header("access-token") token: Travel): Observable<ResultModel<Object>>

    /**
     * Message List
     */
    @GET("Message/MessageList")
    fun getMailList(@Header("access-token") token: Travel): Observable<ResultModel<List<MailModel>>>

    /**
     * Message Detail
     */
    @POST("Message/MessageDetail")
    fun getMailDetail(@Header("access-token") token: Travel, @Body body: RequestBody): Observable<ResultModel<MailDetailModel>>

    /**
     * Message Delete
     */
    @POST("Message/MessageDel")
    fun deleteMail(@Header("access-token") token: Travel, @Body body: RequestBody): Observable<ResultModel<Travel>>

    /**
     * Message Reply
     */
    @POST("Message/MessageReply")
    fun replyMail(@Header("access-token") token: Travel, @Body body: RequestBody): Observable<ResultModel<Travel>>


//    /**
//     * Travel Info with Token
//     */
//    @POST("Travel/index")
// //   fun travelTravelMorningMessage(@Header("access-token")token: Travel, @Body body: RequestBody): Observable<ResultModel<Map<Travel, Map<Travel,GeneralTravelMessageModel>>>>
//    fun travelTravelMorningMessage(@Body body: RequestBody): Observable<ResultModel<Map<Travel, Map<Travel,GeneralTravelMessageModel>>>>
}
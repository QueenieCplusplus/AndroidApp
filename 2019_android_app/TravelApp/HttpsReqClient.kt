package com.app.travel.request

//add module & dependency of Model
import com.app.travel.model.response.*
import com.app.travel.model.response.UserModel
import com.app.travel.model.response.ResultModel
import com.app.travel.model.response.AllMessageModel

//add module & dependency of Sys Log
import android.util.Log
import com.orhanobut.logger.Logger

// add module & dependency of Networking
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer

// add module & dependency of Data Format, Converter
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder

// add module & dependency of Java Util
import java.io.IOException
import java.lang.StringBuilder
import java.net.CookieManager
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap

/* Usage from Interface called apiService to  Class called HttpRequestClient

        // object is <List<ModelClass>>
        open fun methodB(): Observable<ResultModel<Object>> {
            return apiService.methodA().subscribeOn(Schedulers.io())
        }

*/

/* Usage with Info with token, 
   just put below obj inside the ApiInterface.method() as Param

         UserHelper.instance().accessToken!! 

*/

class HttpRequestClient {

    //static singleton pattern in Java is as same as this in Kotlin
    companion object { 

        private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create()
        private val cookieHandler = CookieManager()

        private val apiService by lazy {
            create()
        }

        private fun create(): ApiService {
            val httpClient = OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .cookieJar(JavaNetCookieJar(cookieHandler))
                .connectTimeout(20, TimeUnit.SECONDS)
                .build()

            val restAdapter = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return restAdapter.create(ApiService::class.java)
        }

        open fun getUserData(name: String, password: String): Observable<ResultModel<UserModel>> {
            val body: RequestBody = RequestBodyBuilder()
                .addParam("username", name)
                .addParam("password", password).build()
            return apiService.userLogin(body).subscribeOn(Schedulers.io())
        }

        /**
         * Notice
         */
        open fun getAllMessageData(): Observable<ResultModel<List<AllMessageModel>>> {
            return apiService.getAllMessage().subscribeOn(Schedulers.io())
        }

        /**
         * Logout
         */
        open fun logout(): Observable<ResultModel<Object>> {
            return apiService.logout(UserHelper.instance().accessToken!!).subscribeOn(Schedulers.io())
        }

        /**
         * Reset password
         * @param oldPwd 
         * @param newPwd 
         */
        open fun resetLoginPwdData(oldPwd: String, newPwd: String): Observable<ResultModel<Object>> {
            val body: RequestBody = RequestBodyBuilder()
                .addParam("password", oldPwd)
                .addParam("newPassword", newPwd).build()
            return apiService.resetLoginPassword(UserHelper.instance().accessToken!!, body).subscribeOn(Schedulers.io())
        }
    
        /**
            register Account
         */
        open fun registerAccount(
            name: String,
            password: String,
            realName: String,
            withdrawalPwd: String,
            securityQuestion: Int,
            securityAnswer: String,
            captcha: String,
            agents: String?,
            userBirthday: String?,
            captchaSessionID:String
        ): Observable<ResultModel<UserModel>> {
            val requestBody = RequestBodyBuilder()
                .addParam("username", name)
                .addParam("password", password)
                .addParam("alias", realName)
                .addParam("question", securityQuestion)
                .addParam("answer", securityAnswer)
                .addParam("RegisterCaptcha", captcha)
                .addParam("withdrawal_passwd", withdrawalPwd)
                .addParam("sessionid", captchaSessionID)

            if (agents != null) {
                requestBody.addParam("agents", agents)
            }

            if (userBirthday != null) {
                requestBody.addParam("birthday", userBirthday)
            }

            val body: RequestBody = requestBody.build()
            return apiService.register(body).subscribeOn(Schedulers.io())
        }

        
        /**
         * getTravelAgentList()
         */
        open fun getTravelAgentList(): Observable<ResultModel<List<TravelAgentListModel>>> {
            Logger.i(UserHelper.instance().accessToken!!)
            return apiService.getTravelAgentList(UserHelper.instance().accessToken!!).subscribeOn(Schedulers.io())
        }

        /**
         * Coupon
         */
        open fun couponList(): Observable<ResultModel<List<CouponListModel>>> {
            return apiService.couponList().subscribeOn(Schedulers.io())
        }

    
        /**
         * Travel Message
         */
        open fun travelMessage(
//            token: String,
            travelAgent: String,
            mtype: String,
            mdate: String?
        ): Observable<ResultModel<List<TravelMessageModel>>> {
            val request = RequestBodyBuilder()
                .addParam("type", 2)
                .addParam("terminal", 1)
                .addParam("travelAgent", travelAgent)
                .addParam("mtype", mtype)

            if (mdate != null) {
                request.addParam("mdate", mdate)
            }
            var requestBody = request.build()
            return apiService.travelGameMessage(requestBody).subscribeOn(Schedulers.io())
        }

        /**
         * Travel Query
         */
        open fun travelSearchMessage(
            inputVal: String,
            mleagueid: String?,
            travelAgent: String?,
            mtype: String?,
            mdate: String?,
            rtype: String?,
            valType: String?
        ): Observable<ResultModel<List<travelLeagueMessageModel>>> {
            val request = RequestBodyBuilder()
                .addParam("type", 4)
                .addParam("inputVal", inputVal)

            if (mleagueid != null) {
                request.addParam("mleagueid", mleagueid)
            }

            if (travelAgent != null) {
                request.addParam("travelAgent", travelAgent)
            }

            if (mtype != null) {
                request.addParam("mtype", mtype)
            }

            if (mdate != null) {
                request.addParam("mdate", mdate)
            }

            if (rtype != null) {
                request.addParam("rtype", rtype)
            }

            if (valType != null) {
                request.addParam("valType", valType)
            }

            var requestBody = request.build()
//            Logger.e("search game type 4 = ${printBody(requestBody)}")
            return apiService.travelSearchGame(requestBody).subscribeOn(Schedulers.io())
        }

        /**
         * Travel Search Engine
         */
        open fun ticketSearchEngine(
            mid: String?,
            travelAgent: String?,
            mtype: String?,
            mdate: String?,
            rtype: String?
        ): Observable<ResultModel<List<ticketResultModel>>> {
            val request = RequestBodyBuilder()
                .addParam("type", 3)

            if (mid != null) {
                request.addParam("mid", mid)
            }


            if (travelAgent != null) {
                request.addParam("travelAgent", travelAgent)
            }

            if (mdate != null) {
                request.addParam("mdate", mdate)
            }

            if (rtype != null) {
                request.addParam("rtype", rtype)
            }

            var requestBody = request.build()
            return apiService.travelSearchEngine(requestBody).subscribeOn(Schedulers.io())
        }


        /**
         * Security
         */
        open fun securityQuestion(): Observable<ResultModel<List<SecurityQuestion>>> {
            return apiService.securityQuestion().subscribeOn(Schedulers.io())
        }

        /**
         * Captcha
         */
        open fun captcha(type: String): Observable<CaptchaModel> {
            val requestBody = RequestBodyBuilder()
                .addParam("type", type).build()
            return apiService.captcha(requestBody).subscribeOn(Schedulers.io())
        }

        /**
         * Check User is exist.
         */
        open fun memExist(username: String): Observable<ResultModel<Object>> {
            val requestBody = RequestBodyBuilder()
                .addParam("username", username).build()
            return apiService.memExist(requestBody).subscribeOn(Schedulers.io())
        }

        /**
         * find Password
         */
        open fun findPwdSecurity(
            type: String,
            username: String,
            question: Int,
            answer: String,
            newPwd: String
        ): Observable<ResultModel<Object>> {
            val requestBody = RequestBodyBuilder()
                .addParam("type", type)
                .addParam("username", username)
                .addParam("question", question)
                .addParam("answer", answer)
                .addParam("newPassword", newPwd).build()

            return apiService.findPwd(requestBody).subscribeOn(Schedulers.io())
        }

        
        /**
         * CS
         */
        open fun customerService(): Observable<ResultModel<Object>> {
            return apiService.customerService().subscribeOn(Schedulers.io())
        }

        /**
         * Banner
         */
        open fun indexBanner(): Observable<ResultModel<List<IndexBannerModel>>> {
            val body: RequestBody = RequestBodyBuilder()
                .addParam("type", 1).build()
            return apiService.indexBanner(body).subscribeOn(Schedulers.io())
        }

        /**
         * Android Version
         */
        open fun updateVersion(): Observable<ResultModel<VersionModel>> {
            return apiService.updateVersion().subscribeOn(Schedulers.io())
        }

       /**
       * Travel Info
        */
        open fun travelTravelMorningMessage(
            travelAgent: String,
            mtype: String,
            mdate: String?
        ): Observable<ResultModel<TravelMessageModel>> {
            val request = RequestBodyBuilder
                .addParam("type", 2)
                .addParam("terminal", 1)
               .addParam("travelAgent", travelAgent)
                .addParam("mtype", mtype)

            if (mdate != null) {
                request.addParam("mdate", mdate)
           }
            var requestBody = request.build()
            return apiService.travelTravelMorningMessage(requestBody).subscribeOn(Schedulers.io())
        }

        /**
         * Msg
         */
        open fun getMailList(): Observable<ResultModel<List<MailModel>>> {
            return apiService.getMailList(UserHelper.instance().accessToken!!).subscribeOn(Schedulers.io())
        }

        /**
         * Msg detail
         */
        open fun getMailDetail(id: Int): Observable<ResultModel<MailDetailModel>> {
            val body = RequestBodyBuilder().addParam("id", id).build()
            return apiService.getMailDetail(UserHelper.instance().accessToken!!, body).subscribeOn(Schedulers.io())
        }

        /**
         * reply Msg
         */
        open fun replyMail(id: Int, context: String, toUser: Int): Observable<ResultModel<String>> {
            val body = RequestBodyBuilder().addParam("id", id)
                .addParam("context", context)
                .addParam("to_user", toUser)
                .build()
            return apiService.replyMail(UserHelper.instance().accessToken!!, body).subscribeOn(Schedulers.io())

        }

        /**
         * delete Msg
         */
        open fun deleteMail(id: Int): Observable<ResultModel<String>> {
            val body = RequestBodyBuilder().addParam("id", id).build()
            return apiService.deleteMail(UserHelper.instance().accessToken!!, body).subscribeOn(Schedulers.io())
        }

        /**
         * Ticket Count
         */
        open fun getTicketCount(): Observable<travelCountModel> {
            return apiService.getTicketCount().subscribeOn(Schedulers.io())
        } // func


    } //companion object in KOTLIN as same as static final in JAVA


} // HttpRequestClient




// other Class
class RequestBodyBuilder {

    private var params: MutableMap<String, Any> = HashMap()

    fun addParam(key: String, value: Any): RequestBodyBuilder {
        params[key] = value
        return this
    }

    fun build(): RequestBody {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonUtil.toJson(params))
    }

}


// other func
fun printBody(requestBody: RequestBody): String {
    return try {
        var buffer = Buffer()
        requestBody.writeTo(buffer)
        buffer.readUtf8()
    } catch (e: IOException) {
        "RequestBody Failure"
    }   
}
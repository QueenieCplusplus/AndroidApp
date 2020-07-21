package com.katesapp2019.android.katesintentapp.Helper

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import com.katesapp2019.android.katesintentapp.Model.HttpResponse
import com.katesapp2019.android.katesintentapp.Model.MessageInfo
import com.katesapp2019.android.katesintentapp.Model.UserInfo
import com.katesapp2019.android.katesintentapp.Util.JsonConverter
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okio.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Socket
import java.util.concurrent.TimeUnit

class HttpRequest {
    @TargetApi(Build.VERSION_CODES.O)
    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.O)
    companion object { // top level

        //gson
        //cookieHandler
        private val httpResponse: HttpResponse by lazy {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createConnect()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun createConnect(): HttpResponse {

            val httpClient = OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build()

            // 建立請求物件的實例
            val retrofit = Retrofit.Builder()
                .baseUrl("http://apibox.55667788.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
//        return retrofit.create(HttpResponse::class.java)
            val api = retrofit.create(HttpResponse::class.java)
            return api
            /**
             * Sets the default read timeout for new connections. A value of 0 means no timeout, otherwise
             * values must be between 1 and {@link Integer#MAX_VALUE} when converted to milliseconds.
             *
             * <p>The read timeout is applied to both the TCP socket and for individual read IO operations
             * including on {@link Source} of the {@link Response}. The default value is 10 seconds.
             *
             * @see Socket#setSoTimeout(int)
             * @see Source#timeout()
             */
        }

        open fun getUser(name: String, password: String) {
            // var callBack: Callback<UserInfo?>
            // return httpResponse.logIn().request()
            val body = BodyCreate().addParam("username", name).addParam("password", password).create()
            return httpResponse.logIn(body).enqueue(object : Callback<UserInfo> {
                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.v("gg", "你GG了")
                    Log.v("onFailure", "=${t.message}")
                }

                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    Log.v("no gg", "你沒GG了")
                    Log.v("Success", "="+response.body()!!.data.userName+"&"+response.body()!!.data.accessToken)
                }
            })
        }
//
//        open fun getMessage(): Call<List<MessageInfo>> =
//            httpResponse.getMessage().enqueue(object : Callback<List<UserInfo>>)
    }
}

class BodyCreate {
    private var params: MutableMap<String, Any> = HashMap()
    fun addParam(key: String, value: Any): BodyCreate {
        params[key] = value
        return this
    }

    //    fun create(): RequestBody = RequestBody.create(MediaType.get())
    fun create(): RequestBody =
        RequestBody.create(MediaType.parse("application/json; charset=utf-8)"), JsonConverter.toJson(params))
}

/**
fun catsFood() = httpResponse.getCatsFood()

fun getCatsFood(){

catsFood().enqueue(object : Callback<List<CatsFavoritFood>>{

override fun onResponse(call: Call<atsFavoritFood>>?, response: Response<List<atsFavoritFood>>?){
for(i in 0.. response!!.body()!!.size-1){
System.out.println(response!!.body()!!.get(i).name)}
}

override fun onFailure(call: Call<List<Province>>?, t: Throwable?) {
}
)
}
 **/

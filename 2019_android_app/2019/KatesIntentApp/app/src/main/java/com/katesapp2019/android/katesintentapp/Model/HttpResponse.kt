package com.katesapp2019.android.katesintentapp.Model

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Url
import retrofit2.http.POST
import com.katesapp2019.android.katesintentapp.Util.SharePrefernce


interface HttpResponse {


    @POST("main/login")
    fun logIn(@Body body: RequestBody): SharePrefernce

    /**
     * A relative or absolute path, or full URL of the endpoint. This value is optional if the first
     * parameter of the method is annotated with {@link Url @Url}.
     * <p>
     * See {@linkplain retrofit2.Retrofit.Builder#baseUrl(HttpUrl) base URL} for details of how
     * this is resolved against a base URL to create the full endpoint URL.
     */

}
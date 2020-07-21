package com.katesapp2019.android.katesintentapp.Helper

import android.os.Build
import android.support.annotation.RequiresApi
import com.katesapp2019.android.katesintentapp.Model.HttpResponse
import okhttp3.OkHttpClient
import okio.Source
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.net.Socket
import java.time.Duration
import java.util.concurrent.TimeUnit


class HttpRequest {

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createConnection(): HttpResponse {

        val httpClient = OkHttpClient.Builder()
            .readTimeout(10000,TimeUnit.MILLISECONDS)
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://apisport.l56668.com/")
            .client(httpClient)
            .build()

        return retrofit.create(HttpResponse::class.java)

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
}

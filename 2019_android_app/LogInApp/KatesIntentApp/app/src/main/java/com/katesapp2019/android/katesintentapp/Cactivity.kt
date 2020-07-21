package com.katesapp2019.android.katesintentapp

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.TextView
import com.katesapp2019.android.katesintentapp.Adapter.MssgAdapter
import com.katesapp2019.android.katesintentapp.Helper.AppManager
import com.katesapp2019.android.katesintentapp.Helper.BodyCreate
import com.katesapp2019.android.katesintentapp.Helper.HttpRequest
import com.katesapp2019.android.katesintentapp.Model.HttpResponse
import com.katesapp2019.android.katesintentapp.Model.MessageInfo
import com.katesapp2019.android.katesintentapp.Model.UserInfo
import retrofit2.Callback
import retrofit2.Response

class Cactivity : Activity() {

    var textView: TextView? = null
    var recycleView: RecyclerView? = null

    private val tag: String = "Cactivity is an View to render the MessageInfo model by using the MssgAdapter"

    private val httpResponse: HttpResponse by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            HttpRequest.createConnect()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        AppManager.getInstance().addActivity(this)
        getMessage()
        textView = findViewById(R.id.tv_C)
        recycleView = findViewById(R.id.rv_C)
        recycleView!!.layoutManager =LinearLayoutManager(this) //Todo
    }

    fun goToFragD(view: View) {
        val intent = Intent(applicationContext, Dactivity::class.java)
        startActivity(intent)//finish()
    }

    override fun onResume() {
        super.onResume()
        Log.v("C page", "onResume Phase")

    }

    fun getMessage() {
        httpResponse.getMessage().enqueue(object : Callback<MessageInfo> {

            override fun onFailure(call: retrofit2.Call<MessageInfo>, t: Throwable) {
                Log.v("Fail", "get no message")
                Log.v("onFailure", "=${t.message}")
            }

            override fun onResponse(call: retrofit2.Call<MessageInfo>, response: Response<MessageInfo>) {
                Log.v("OK", "get Message")
                Log.v("Success", "=" + response.body()!!)
                Log.v("size", "==" + response.body()!!.data.size)
                for (i in response.body()!!.data) {
                    Log.v("title", "==" + i.title)
                    Log.v("content", "==" + i.context)
                }

                val adpt = MssgAdapter(R.layout.item_recycle_view_for_c_layout,response.body()!!.data) //Todo
                recycleView!!.adapter = adpt //Todo
            }
        })
    }
}





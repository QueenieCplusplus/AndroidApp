package com.katesapp2019.android.katesintentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.katesapp2019.android.katesintentapp.Helper.AppManager

class BActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        AppManager.getInstance().addActivity(this)
    }


    fun goToFragC(view: View) {
        val intent = Intent(applicationContext,Cactivity::class.java)
        startActivity(intent)
        //finish()
    }

}
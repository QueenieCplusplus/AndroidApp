package com.katesapp2019.android.katesintentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.katesapp2019.android.katesintentapp.Helper.AppManager


class Dactivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        AppManager.getInstance().addActivity(this)
    }

    fun backToActivityA (view: View) {
        val intent = Intent(applicationContext,Aactivity::class.java)
        startActivity(intent)
//        this.finish()
        AppManager.getInstance().finishCurrentActivity()
    }
    
}
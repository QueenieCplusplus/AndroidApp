package com.katesapp2019.android.katesintentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.katesapp2019.android.katesintentapp.Helper.AppManager

class Aactivity : Activity() {

    var aM: AppManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        AppManager.getInstance().addActivity(this)
    }

    fun goToFragB(view: View) {
        val intent = Intent(applicationContext, BActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
    }

}

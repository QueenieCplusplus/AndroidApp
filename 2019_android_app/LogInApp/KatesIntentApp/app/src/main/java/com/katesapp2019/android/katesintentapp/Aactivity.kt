package com.katesapp2019.android.katesintentapp

import com.katesapp2019.android.katesintentapp.Util.SharePrefernce
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.katesapp2019.android.katesintentapp.Helper.AppManager
import com.katesapp2019.android.katesintentapp.Helper.HttpRequest
import com.katesapp2019.android.katesintentapp.Model.MessageInfo
import com.katesapp2019.android.katesintentapp.Model.UserInfo
import retrofit2.Callback

class Aactivity : Activity() {

    companion object {
        private val tag = "Login Activity"
        private val request_signUp = 0
    }

    var aM: AppManager? = null
    var userName: EditText? = null
    var passWord: EditText? = null
    var logIn: Button? = null
    var signUp: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        AppManager.getInstance().addActivity(this)
        initView()
    }

    fun initView() {
        userName = findViewById(R.id.et_username) as EditText
        passWord = findViewById(R.id.et_numberpassword) as EditText
        logIn = findViewById(R.id.btn_login) as Button
        signUp = findViewById(R.id.tv_signup) as TextView
        logIn!!.setOnClickListener { logIn() }
        signUp!!.setOnClickListener { intenSignUp() }
        val str = SharePrefernce.getStr(this, "key", "")
        userName!!.setText(str)
    }

    fun intenSignUp() {
        val intent = Intent(applicationContext, BActivity::class.java)
        startActivityForResult(intent, request_signUp)
        finish()
    }

    fun logIn() {
        val username = userName!!.text.toString()
        val password = passWord!!.text.toString()
        // todo logic Auth
        logIn!!.isEnabled = false
        Log.v(tag, "Log In Process Now")

        if (!validate()) {
            logInFail()
        } else {
            logInOK()
            haveUser()
//            haveMessage()
        }
    }

    fun validate(): Boolean {
        var valid = true
        val username = userName!!.text.toString()
        val password = passWord!!.text.toString()

        // todo logic || matches for sharePrefrence
        if (username.isEmpty()) {
            valid = false
            userName!!.error = "plz enter a valid User Name"
        } else {
            userName!!.error = null
        }

        // todo logic
        if (password.isEmpty() || password.length < 4 || password.length > 6) {
            valid = false
            passWord!!.error = "plz enter 4-6 numbers passwords"
        } else {
            passWord!!.error = null
        }
        return valid
    }

    fun logInOK() {
        SharePrefernce.setStr(this, "key", userName?.text.toString())
        logIn!!.isEnabled = true
        startActivity(Intent(this, Cactivity::class.java))
    }

    fun logInFail() {
        logIn!!.isEnabled = false
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
    }

    fun goToFragB(view: View) {
        val intent = Intent(applicationContext, BActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
    }

    fun haveUser() {

        HttpRequest.Companion.getUser("can999","qqq000")

    }

//    fun haveMessage() {
//        fun message() = HttpRequest.Companion.getMessage()
//        message().enqueue(object: Callback<List<MessageInfo>>)
//    }
}

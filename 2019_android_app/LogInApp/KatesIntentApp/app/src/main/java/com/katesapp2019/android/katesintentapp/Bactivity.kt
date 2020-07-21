package com.katesapp2019.android.katesintentapp

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
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : Activity() {

    var inputUsername: EditText? = null
    var inputAddress: EditText? = null
    var inputEmail: EditText? = null
    var inputMobile: EditText? = null
    var inputPassword: EditText? = null
    var inputRePass: EditText? = null
    var btnSignUp: Button? = null
    var linkLogIn: TextView? = null

    companion object {
        private val tag = "SignUp Page now"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        AppManager.getInstance().addActivity(this)
        initView()
    }

    fun goToFragC(view: View) {
        val intent = Intent(applicationContext, Cactivity::class.java)
        startActivity(intent)
        //finish()
    }

    fun initView() {

        inputUsername = findViewById(R.id.input_username) as EditText
        inputAddress = findViewById(R.id.input_address) as EditText
        inputEmail = findViewById(R.id.input_email) as EditText
        inputMobile = findViewById(R.id.input_mobile) as EditText
        inputPassword = findViewById(R.id.input_password) as EditText
        inputRePass = findViewById(R.id.input_rePassword) as EditText
        btnSignUp = findViewById(R.id.btn_signup) as Button
        linkLogIn = findViewById(R.id.link_login) as TextView

        btnSignUp!!.setOnClickListener {
            signUp()
        }

//    btns alternative (按鈕的另一種寫法)
//        btnGoBackLogIn()
        linkLogIn!!.setOnClickListener {
        }

    }

//    btns alternative (按鈕的另一種寫法)
//    fun btnGoBackLogIn() {
//
//        signUp()
//        val intent = Intent(applicationContext, Aactivity::class.java)
//        startActivity(intent)
//
//
//    }

    fun signUp() {
        Log.v(tag, "Now in Sign Up Process")
        if (!validateSignUp()) {
            signUpFail()
            return
        } else {
            signUpOK()
        }
    }

    fun signUpOK() {
        btnSignUp!!.isEnabled = true
        startActivity(Intent(this, Aactivity::class.java))
        finish() // why finish()
    }

    fun signUpFail() {
        btnSignUp!!.isEnabled = true
        Toast.makeText(baseContext, "Sign Up Fail, Sorry! Plz Try Again", Toast.LENGTH_LONG).show()
    }

    fun validateSignUp(): Boolean {
        var valid = true
        val name = inputUsername!!.text.toString()
        val address = inputAddress!!.text.toString()
        val email = inputEmail!!.text.toString()
        val mobile = inputMobile!!.text.toString()
        val pass = inputPassword!!.text.toString()
        val rePass = inputRePass!!.text.toString()

        if (name.isEmpty() || name.length < 3) {
            inputUsername!!.error = "plz input a least 3 char for user name"
            valid = false
        } else {
            inputUsername!!.error = "your request is permitted"
        }

        if (address.isEmpty()) {
            inputAddress!!.error = "plz type in a valid Address"
            valid = false
        } else {
            inputAddress!!.error = "your request is permitted"
        }

        if (email.isEmpty()) { // !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            inputEmail!!.error = "plz enter a valid Email Address"
            valid = false
        } else {
            inputEmail!!.error = "your request is permitted"
        }

        if (mobile.isEmpty() || mobile.length != 10) {
            inputMobile!!.error = "plz enter a valid Phone Number"
            valid = false
        } else {
            inputMobile!!.error = "your request is permitted"
        }

        if (pass.isEmpty() || pass.length < 4 || pass.length > 6) {
            inputPassword!!.error = "plz write in a password in 4-6 numbers"
            valid = false
        } else {
            inputPassword!!.error = "your request is permitted"
        }

        if (rePass.isEmpty() || rePass != pass || rePass.length < 4 || rePass.length > 6) {
            inputRePass!!.error = "plz write in a password in 4-6 numbers"
            valid = false
        } else {
            inputRePass!!.error = "your request is permitted"
        } // sloc 113-153(40 line) seems not perform in expectation

        return valid

    }

}
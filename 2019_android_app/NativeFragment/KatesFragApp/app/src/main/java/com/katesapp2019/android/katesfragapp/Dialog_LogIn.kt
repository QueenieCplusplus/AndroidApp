package com.katesapp2019.android.katesfragapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_login.*

class Dialog_LogIn (c: Context): AppCompatActivity() {

    var userAcc: TextView? = null
    var userNum: TextView? = null
    var etUserAcc: EditText? = null
    var etUserNum: EditText? = null
    var ok: Button? = null
    var cancel: Button? = null
    val mC = c

    override fun onCreateView(name: String?, c: Context?, attrs: AttributeSet?): View? {
        val f = LayoutInflater.from(c)
        val v = f.inflate(R.layout.dialog_login, null)
        userAcc = v.findViewById(R.id.tv_account)
        userNum = v.findViewById(R.id.tv_number)
        etUserAcc = v.findViewById(R.id.et_account)
        etUserNum = v.findViewById(R.id.et_number)
        ok = v.findViewById(R.id.btn_go)
        cancel = v.findViewById(R.id.btn_cancel)

        ok!!.setOnClickListener { jumpView() }
        cancel!!.setOnClickListener {  }
        //return super.onCreateView(name, c, attrs)
        return v
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    fun jumpView() {
        val vBasic = this
        val intent = Intent()
        intent.setClass(this, frag_Pay::class.java)
        startActivity(intent)
    }

}
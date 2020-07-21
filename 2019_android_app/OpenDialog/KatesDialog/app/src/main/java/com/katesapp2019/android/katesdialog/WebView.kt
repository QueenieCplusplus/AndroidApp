package com.katesapp2019.android.katesdialog

import android.view.View

internal object WebView {

    private var enable: Boolean = false
    private val enableTrue = Runnable { enable = true }

    fun ableToPlay(v: View): Boolean {

        if(enable) {
            enable = false
            v.post(enableTrue)
            return false
        }
        return true
    }

    internal fun <T: View> T.on(click: (v: T) -> Unit) {
        setOnClickListener {
            if (WebView.ableToPlay(it)){
                click(it as T)
            }
        }
    }


}
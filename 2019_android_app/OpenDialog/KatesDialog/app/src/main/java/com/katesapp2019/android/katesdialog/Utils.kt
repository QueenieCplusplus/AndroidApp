package com.katesapp2019.android.katesdialog

import android.app.Activity
import android.content.SharedPreferences
//import android.content.SharedPreferences
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Calendar

private  var toast: Toast? = null

//typealias PrefEditor = sharePrefernces.

internal fun Activity.toast(msg: CharSequence) {

    toast!!.cancel() // toast?.cancel()
    toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT) // 2nd param can be res.id: Int
        .apply { show() }

}

//internal fun SharedPreferences.booleean(
//
//    key: String = "a",
//    defaultValue: Boolean = false
//
//    ): Boolean {
//
//    return getBoolean(key, defaultValue) // k, v: Boolean
//}

internal fun Calendar.formatDate(): String {
    return SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(this.time)
}

internal fun Int.toHex() = "#${Integer.toHexString(this)}"

//internal inline fun SharedPreferences.commit(crossinline exec: PrefEditor.() -> Unit) {
//    val editor = this.edit()
//    editor.exec()
//    editor.apply()
//}
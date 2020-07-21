package com.katesapp2019.android.kslitesportyapp.Util

interface AlertDialog {

    fun showLoading()
    fun dismissLoading()
    fun showMsg(
        message: String,
        closeEvent: () -> Unit,
        btn: String? = null,
        event: () -> Unit
    )
}
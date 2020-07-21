package com.katesapp2019.android.katesfragapp

import android.app.Dialog
import android.content.Context

class LoadingDialog : Dialog {

    constructor(context: Context) : super(context) {}

    lateinit var dialog: LoadingDialog

//    fun showDialog(context: Context, message: CharSequence?, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?): LoadingDialog {
//        dialog.setContentView(R.layout.dialog_loading)
//        dialog.setCanceledOnTouchOutside(false)
//        dialog.setCancelable(cancelable)
//        dialog.setOnCancelListener(cancelListener)
//        dialog.show()
//        return dialog
//    }


    fun showDialog(context: Context, cancelable: Boolean): LoadingDialog {
        return showDialog(context, cancelable)
    }

    fun dismissDialog() {
        if (dialog.isShowing)
            dialog.dismiss()
    }
}
package com.katesapp2019.android.kslitesportyapp.ViewModel

import android.app.Activity
import android.app.Application
import android.app.DownloadManager

import android.os.Environment

import com.katesapp2019.android.kslitesportyapp.Base.BaseVM
import io.reactivex.disposables.Disposable
import android.arch.lifecycle.MutableLiveData

import android.support.v7.app.AlertDialog

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class mainViewModel(app: Application): BaseVM(app) {

    private var disposable: Disposable? = null
    var dM: DownloadManager? = null
    var updateVersion = MutableLiveData<Int>()
    var dR = MutableLiveData<DownloadManager.Request>()

    /**
     * storage permission
     */
    fun askSoragePermission(activity: Activity) {
        if (

                ) {

        } else {

        }
    }

    /**
     * download
     */
    fun startDownLoad(activity: Activity) {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdir()
        dR.value?.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "KsLiteSportyApp.apk")

    }

    /**
     * version
     */
    fun getVesions(activity: Activity) {


    }

    /**
     * update
     */
    fun updateVersions(activity: Activity) {

    }


}
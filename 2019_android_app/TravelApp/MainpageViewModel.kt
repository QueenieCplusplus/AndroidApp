package com.app.travel.ui.main.mainpage

import android.app.Application

// add modules of Sys Log
import com.orhanobut.logger.Logger

// add modules of DataClass & Data formator
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.app.travel.base.BaseViewModel
import com.app.travel.model.BannerModel
import com.app.travel.model.DestinationModel
import com.app.travel.model.response.couponListModel
import com.app.travel.model.response.IndexBannerModel

// add modules of Networking Class, not interface called apiService
import com.app.travel.request.HttpRequestClient
import com.app.travel.travel20.R
import com.app.travel.util.*

// add modules of RXJava
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

// add modules of Java Util
import java.util.*


/* Usage of RXjava, android native MutableData & AndroidSchedulers, NetworkingClass, 
 
    fun method() {
            disposable = HttpRequestClient.indexBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        Logger.v("getIndexBannerList > response==$response")
                        if (response.result == 0) {
                            indexBannerList.postValue(response.messageData as MutableList<Object>?)
                        }
                    }, { error ->
                        error.printStackTrace()
                    }
                )
        }
*/

class MainPageViewModel(app: Application) : BaseViewModel(app) {

    private var disposable: Disposable? = null
    private val couponList = MutableLiveData<MutableList<couponListModel>>()
    private val indexBannerList = MutableLiveData<MutableList<IndexBannerModel>>()

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    //輪播圖
    fun getIndexBannerListRequest() {
        disposable = HttpRequestClient.indexBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    Logger.v("getIndexBannerList > response==$response")
                    if (response.result == 0) {
                        indexBannerList.postValue(response.messageData as MutableList<IndexBannerModel>?)
                    }
                }, { error ->
                    error.printStackTrace()
                }
            )
    }

    // ｃｏｕｐｏｎ
    fun getcouponListRequest() {
        disposable = HttpRequestClient.discountList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    Logger.v("getcouponList > response==$response")
                    if (response.result == 0) {
                        couponList.postValue(response.messageData as MutableList<couponListModel>?)
                    }
                }, { error ->
                    error.printStackTrace()
                }
            )
    }

    //取得目的地
    fun setDefaultDestinationList(): ArrayList<DestinationModel> {
        val desList = ArrayList<DestinationModel>()
        desList.add(
            DestinationModel(
                Asia,
                getApplication<Application>().resources.getString(R.string.str_by),
                getApplication<Application>().resources.getString(R.string.str_by_eng),
                R.mipmap.icon_home_by
            )
        )
        desList.add(
            DestinationModel(
                Europe,
                getApplication<Application>().resources.getString(R.string.str_ty),
                getApplication<Application>().resources.getString(R.string.str_ty_eng),
                R.mipmap.icon_home_ty
            )
        )
        desList.add(
            DestinationModel(
                Africa,
                getApplication<Application>().resources.getString(R.string.str_ag),
                getApplication<Application>().resources.getString(R.string.str_ag_eng),
                R.mipmap.icon_home_ag
            )
        )
        desList.add(
            DestinationModel(
                USA,
                getApplication<Application>().resources.getString(R.string.str_mg),
                getApplication<Application>().resources.getString(R.string.str_mg_eng),
                R.mipmap.icon_home_mg
            )
        )    
        return desList
    }


    fun indexBannerList(): LiveData<MutableList<IndexBannerModel>> {
        return indexBannerList
    }

    fun couponList(): LiveData<MutableList<couponListModel>> {
        return couponList
    }


}
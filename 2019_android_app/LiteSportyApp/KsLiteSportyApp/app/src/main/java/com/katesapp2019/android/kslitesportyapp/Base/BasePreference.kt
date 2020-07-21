package com.katesapp2019.android.kslitesportyapp.Base

import android.content.Context

object BasePreference {

    private val MAIN_APK_NAME = "Ks Lite Sporty App"

    fun delAll(cn: Context) {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE).edit().clear().commit()
    }

    fun getSting(cn: Context, key: String, defVal: String): String {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        return ksp.getString(key, defVal)
    }

    fun setString(cn: Context, key: String, value: String) {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        ksp.edit().putString(key, value).commit()
    }

    fun getBool(cn: Context, key: String, defVal: Boolean): Boolean {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        return ksp.getBoolean(key, defVal)
    }

    fun setBool(cn: Context, key: String, value: Boolean) {


        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        ksp.edit().putBoolean(key, value).commit()
    }

    fun getInt(cn: Context, key: String, defVal: Int): Int {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        return ksp.getInt(key, defVal)
    }

    fun setInt(cn: Context, key: String, value: Int) {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        ksp.edit().putInt(key, value).commit()
    }

    fun getLong(cn: Context, key: String, defVal: Long): Long {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        return ksp.getLong(key, defVal)
    }

    fun setLong(cn: Context, key: String, value: Long) {
        val ksp = cn.getSharedPreferences(MAIN_APK_NAME, Context.MODE_PRIVATE)
        ksp.edit().putLong(key, value).commit()
    }

}
package com.katesapp2019.android.katesintentapp.Util

import android.content.Context

/**
 * simple memory for String, Bool, Integer, Long
 */

object SharePrefernce {

    /**
     * Retrieve and hold the contents of the preferences file 'name', returning
     * a SharedPreferences through which you can retrieve and modify its
     * values.  Only one instance of the SharedPreferences object is returned
     * to any callers for the same name, meaning they will see each other's
     * edits as soon as they are made.
     *
     * This method is thead-safe.
     *
     * @param name Desired preferences file. If a preferences file by this name
     * does not exist, it will be created when you retrieve an
     * editor (SharedPreferences.edit()) and then commit changes (Editor.commit()).
     * @param mode Operating mode.
     *
     * @return The single {@link SharedPreferences} instance that can be used
     *         to retrieve and modify the preference values.
     *
     * @see #MODE_PRIVATE
     */

    private val mainVal = "cat"

    fun setStr(context: Context, key: String, value: String) {
//        val sp = context.getSharedPreferences(mainVal, Context.MODE_PRIVATE)
//        sp.edit().putString(key, value).commit()
        context.getSharedPreferences(mainVal, Context.MODE_PRIVATE).edit().putString(key, value).apply()
    }

    fun getStr(cont: Context, key: String, defVal: String?): String {
        return cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).getString(key, defVal)}


    fun setBool(cont: Context, key: String, value: Boolean) {
        cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).edit().putBoolean(key, value).commit()
    }

    fun getBool(cont: Context, key: String, defVal: Boolean): Boolean {
        return cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).getBoolean(key, defVal)
    }

    fun setLong(cont: Context, key: String, value: Long) {
        cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).edit().putLong(key, value).commit()
    }

    fun getLong(cont: Context, key: String, defVal: Long): Long {
        return cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).getLong(key, defVal)
    }

    fun setInt(cont: Context, key: String, value: Int) {
        cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).edit().putInt(key, value).commit()
    }

    fun getInt(cont: Context, key: String, defVal: Int): Int {
        return cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).getInt(key, defVal)
    }

    fun deleteData(cont: Context) {
//        cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).all.clear()
        cont.getSharedPreferences(mainVal, Context.MODE_PRIVATE).edit().clear().commit()

    }
}
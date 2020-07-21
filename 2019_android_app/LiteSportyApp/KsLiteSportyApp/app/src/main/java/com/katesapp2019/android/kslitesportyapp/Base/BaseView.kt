package com.katesapp2019.android.kslitesportyapp.Base

import android.util.SparseArray
import android.view.View
import android.widget.TextView

open class BaseView  {

    private lateinit var onlyView: View
    private lateinit var viewsArray: SparseArray<View>

    companion object {
        fun createView(v: View): BaseView {
            return BaseView(v)
        }
    }

    constructor(v: View) {
        onlyView = v
        viewsArray = SparseArray()
    }

    fun <T: View> setView(viewId: Int): T {
        var v: View? = viewsArray.get(viewId)
        if (v == null){
            v = onlyView.findViewById(viewId)
            viewsArray.put(viewId, v)
        }
        return (v as T?)!! //todo
    }

    fun setOnClickListener(viewId: Int, resId: Int) {
        val v = setView<View>(viewId)
        v.setBackgroundResource(resId)
    }

    fun setVisible(viewId: Int, isVisible: Boolean) {
        val v = setView<View>(viewId)
        v.visibility = if (isVisible)View.VISIBLE else View.GONE
    }

}

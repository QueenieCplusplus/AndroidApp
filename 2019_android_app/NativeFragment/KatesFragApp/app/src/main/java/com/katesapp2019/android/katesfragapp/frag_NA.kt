package com.katesapp2019.android.katesfragapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class frag_NA : Fragment() {

    var tvNA: TextView? = null //容器
    val bundle: Bundle = Bundle() //物件

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v2 = inflater.inflate(R.layout.fragment_na, container, false)
        tvNA = v2.findViewById(R.id.tv_na)

        if (arguments != null) {
            val s = arguments!!.getString("fee2").toString()
            tvNA!!.setText(s)
        }
        return v2
    }
}
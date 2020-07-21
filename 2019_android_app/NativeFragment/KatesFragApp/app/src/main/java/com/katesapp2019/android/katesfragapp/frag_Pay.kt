package com.katesapp2019.android.katesfragapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class frag_Pay : Fragment() {

    var tvPay: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v3 = inflater.inflate(R.layout.fragment_pay, container, false)
        val b = arguments!!.getString("feeAll").toString()
        tvPay = v3.findViewById(R.id.tv_pay)
        tvPay!!.setText(b)
        return v3
    }
}

package com.katesapp2019.android.katesfragapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class frag_SA : Fragment() {

    var tvSA: TextView? = null
    val bundle: Bundle = Bundle()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sa, container, false)
        tvSA = v.findViewById(R.id.tv_sa)
        if (arguments != null) {
            val s = arguments!!.getString("fee").toString() // 回傳值，這句是關鍵～讚喔
            tvSA!!.setText(s)
        }
        return v
        //return inflater.inflate(R.layout.fragment_sa, container, false) 尚未改寫前的原句，可呈現碎片畫面
    }
}

package com.katesapp2019.android.nativeadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.katesapp2019.android.nativeadapter.Helper.Adapter
import com.katesapp2019.android.nativeadapter.Model.Info

class MainActivity : AppCompatActivity() {
    var tv: TextView? = null
    var rv: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv_xml)
        rv = findViewById(R.id.rv_xml)
        rv!!.layoutManager = LinearLayoutManager(this)
        getRecyclerView()
    }


    fun getRecyclerView() {
        val adp = Adapter(Info.name) //todo (write in param) 6/16 !!!B
        rv!!.adapter = adp
    }

}
/**
 * https://android.devdon.com/archives/113
 */

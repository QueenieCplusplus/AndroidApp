package com.katesapp2019.android.linearlayout

import android.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var ll: LinearLayout? = null
    var lp: LayoutParams? = null
    var tvA: TextView? = null
    var tvB: TextView? = null
    var tvC: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvA = findViewById(R.id.tx_a)
        tvB = findViewById(R.id.tx_b)
        tvC = findViewById(R.id.tx_c)

        ll = LinearLayout(this)
//        ll.addView(tvA)
    }

}

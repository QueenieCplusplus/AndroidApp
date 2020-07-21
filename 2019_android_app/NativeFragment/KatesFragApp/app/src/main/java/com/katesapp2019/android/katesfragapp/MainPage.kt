package com.katesapp2019.android.katesfragapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainPage : AppCompatActivity() {
    var tp: Button? = null
    var sl: Button? = null
    var tk: Button? = null
    var sn: Button? = null
    var sa: Button? = null
    var na: Button? = null
    var ca: Button? = null

    val fmg = supportFragmentManager //private fmg: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)

        tp = findViewById(R.id.tp)
        sl = findViewById(R.id.sl)
        tk = findViewById(R.id.tk)
        sn = findViewById(R.id.sn)
        sa = findViewById(R.id.btn_sa)
        na = findViewById(R.id.btn_na)
        ca = findViewById(R.id.btn_chinaAir)

        tp!!.setOnClickListener { changeFragmentTo(1) }
        sl!!.setOnClickListener { changeFragmentTo(0) }
        sn!!.setOnClickListener { changeFragmentTo(3) }
        tk!!.setOnClickListener { changeFragmentTo(2) }

        sa!!.setOnClickListener { changeFragToSA() }
        na!!.setOnClickListener { changeFragToNA() }
        ca!!.setOnClickListener { userWannaPay() }
    }
    fun changeFragmentTo(type: Int) {
        val transaction = fmg.beginTransaction()
        when (type) {
            0 -> {
                //val bundle: Bundle = Bundle()
                //bundle.putString("fee", "Seoul's Tour Fee: NTD20000")
                //seoulFragment.arguments
                val seoulFragment = Fragment_Seoul()
                transaction.replace(R.id.frame, seoulFragment)
            }

            1 -> {
                val taipeiFragment = Fragment_Taipei()
                transaction.replace(R.id.frame, taipeiFragment)
            }

            2 -> {
                val tokyoFragment = Fragment_Tokyo()
                transaction.replace(R.id.frame, tokyoFragment)
            }

            3 -> {
                val sinFragment = Fragment_Singa()
                transaction.replace(R.id.frame, sinFragment)
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun changeFragToSA() {
        val transaction = fmg.beginTransaction() // fmg 在 line 17 已經宣告
        var saFragment = frag_SA()
        val bundle: Bundle = Bundle()
        bundle.putString("fee", "NTD30000") //pair of key val
        transaction.replace(R.id.frame, saFragment)
        saFragment.arguments = bundle // 取代以往的 fragObj.setArguments(bundleInstance);
        transaction.addToBackStack("fee")
        transaction.commit()
    }

    fun changeFragToNA() {
        val transaction = fmg.beginTransaction()
        val naFragment = frag_NA()
        transaction.replace(R.id.frame, naFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun userWannaPay() {
        val transaction = fmg.beginTransaction()
        val payFragment = frag_Pay()
        transaction.replace(R.id.frame, payFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

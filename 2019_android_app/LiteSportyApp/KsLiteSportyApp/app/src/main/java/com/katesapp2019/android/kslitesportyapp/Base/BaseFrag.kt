package com.katesapp2019.android.kslitesportyapp.Base

//frag
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

//inflater
import android.view.LayoutInflater

//view
import android.view.View
import android.view.ViewGroup

//os
import android.os.Bundle

//content
import android.content.Context
import android.databinding.DataBindingUtil

//databind
import android.databinding.ViewDataBinding
import com.katesapp2019.android.kslitesportyapp.Util.AlertDialog

abstract class BaseFrag<VM: BaseVM, DB: ViewDataBinding>(private val kVMClass: Class<VM>) : Fragment(), AlertDialog {

    var vm: VM? = null
    private fun getFragVM(): VM = ViewModelProviders.of(this).get(kVMClass)

    open lateinit var  kBinding: DB
    abstract fun getLayoutRes(): Int

    private fun initInflater(inflater: LayoutInflater, container: ViewGroup) {
        kBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
    }

    open fun init() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = getFragVM()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        return kBinding.root
        initInflater(inflater, container!!)
        init()
    }
}
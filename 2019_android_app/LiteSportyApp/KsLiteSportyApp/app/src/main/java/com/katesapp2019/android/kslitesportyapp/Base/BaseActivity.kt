package com.katesapp2019.android.kslitesportyapp.Base

//lifecycle
import android.arch.lifecycle.ViewModelProviders

//databind
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

//content
import android.content.Context

//graphics
import android.graphics.Rect

//OS
import android.os.Bundle
import android.os.PersistableBundle

//support
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

//MotionEvent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager

//Edit Text
import android.widget.EditText

//???
import com.katesapp2019.android.kslitesportyapp.Util.AlertDialog
//BaseViewModel

abstract class BaseActivity<VM: BaseVM,DB: ViewDataBinding>(private val kVMClass: Class<VM>): AppCompatActivity(), AlertDialog {

    abstract  fun getLayoutRes(): Int

    val binding: DB by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    val viewModel: VM by lazy {
        ViewModelProviders.of(this).get(kVMClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    abstract fun initViewModel(viewModel: VM)

}


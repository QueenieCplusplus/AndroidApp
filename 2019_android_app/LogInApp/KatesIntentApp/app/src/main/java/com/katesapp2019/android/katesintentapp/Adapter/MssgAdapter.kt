package com.katesapp2019.android.katesintentapp.Adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.katesapp2019.android.katesintentapp.Model.MessageInfo
import com.katesapp2019.android.katesintentapp.R

class MssgAdapter (layoutResId: Int, data: List<MessageInfo.Data>): BaseQuickAdapter<MessageInfo.Data, MssgAdapter.ViewHolder>(layoutResId, data) {
    override fun convert(helper: ViewHolder?, item: MessageInfo.Data?) {
        Log.v("","=="+item!!.title)
        val mTitle = helper!!.getView<TextView>(R.id.tv_msg) //todo
        mTitle.text = item.title // todo
    }

    inner class ViewHolder(v: View): BaseViewHolder(v) {

    }

    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        return super.getItemView(layoutResId, parent)

        Log.v("Adapters Process", "get those Items View")
    }
}
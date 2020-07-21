package com.katesapp2019.android.nativeadapter.Helper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.katesapp2019.android.nativeadapter.Model.Info
import com.katesapp2019.android.nativeadapter.R

class Adapter(val items: List<Info>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindModel(info: Info) {
            v = info.name // todo 6/16 !!!A
        }
    }

    override fun onBindViewHolder(hold: ViewHolder, p: Int) {
        hold?.bindModel(items[p]) // todo 6/16
    }

    override fun onCreateViewHolder(root: ViewGroup, viewType: Int): ViewHolder {
        val vInflate = LayoutInflater.from(root.context).inflate(R.layout.layout_info_item, root, false)
        return ViewHolder(vInflate)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(p: Int): Int {
        return super.getItemViewType(p)
    }
}
/**
 * https://android.devdon.com/archives/113
 */
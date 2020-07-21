package com.app.travel.ui.main.MainPage

// add Android TableView Adapter<T>
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

// add Android UI components
import android.view.View
import android.view.ViewGroup

// add module of ModelClass & MVVM databinder
import com.app.travel.model.TravelAgentModel
import com.app.travel.travel20.databinding.ItemTravelAgentRecyclerviewBinding

/* Usage of Adapter

        class ExampleAdapter(data) :
            RecyclerView.Adapter<T>(){obj}

        class ExampleAdapter(private val modelData: List<ModelClass>) :
            RecyclerView.Adapter<ExampleAdapter.BindingHolder>(){obj}

*/

class TravelAgentAdapter(private val travelAgentData: List<TravelAgentModel>) :
    RecyclerView.Adapter<TravelAgentAdapter.BindingHolder>() {

      // Late Init in KOTLIN  
    lateinit var listener: TravelAgentAdapter.OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTravelAgentRecyclerviewBinding.inflate(layoutInflater, parent, false)
        return BindingHolder(binding)
    }


    override fun getItemCount(): Int {
        return travelAgentData.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val itemData = travelAgentData[position]
        holder.binding.gameTypeItemData = itemData
        holder.binding.rlItemGameTypeBg.setOnClickListener {
            listener.onItemClick(it, itemData)
        }
    }


    interface OnItemClickListener {
        fun onItemClick(view: View, data: TravelAgentModel)
    }


    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    // MVVM Binder
    class BindingHolder(var binding: ItemTravelAgentRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)
}
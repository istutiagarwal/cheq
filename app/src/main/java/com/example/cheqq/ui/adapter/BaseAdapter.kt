package com.example.cheqq.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<T : Any>(
    private val dataSet: ArrayList<T>,
    @LayoutRes val layoutID: Int,
    private val bindingInterface: GenericSimpleRecyclerBindingInterface<T>
) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(layoutID, parent, false) as View
        return BaseViewHolder(view)

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item,bindingInterface)
    }


    override fun getItemCount(): Int {
       return  dataSet.size
    }
}


interface GenericSimpleRecyclerBindingInterface<T> {
    fun bindData(item: T,view:View)
}

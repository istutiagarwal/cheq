package com.example.cheqq.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun <T : Any> bind(
        item: T,
        bindingInterface: GenericSimpleRecyclerBindingInterface<T>
    ) = bindingInterface.bindData(item,itemView,adapterPosition)

}
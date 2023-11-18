package com.example.mvvmcheck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatAdapter(
    val list: List<Cat>,
    val onClicItem: OnClicItem,
    val onClicItemActivity: OnClicItem
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: TextView = itemView.findViewById(R.id.tv)
    }

    interface OnClicItem {
        fun onclickItem(pos: Int, cat: Cat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cats, parent, false)

        return CatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.imageView.text = list[position].id
        holder.imageView.setOnClickListener {
            onClicItem.onclickItem(position, list[position])
            onClicItemActivity.onclickItem(position, list[position])
        }
    }

}
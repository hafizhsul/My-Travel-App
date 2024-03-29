package com.example.submission_proejct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTourismAdapter(private val listTourism: ArrayList<Tourism>) : RecyclerView.Adapter<ListTourismAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Tourism)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_tourism, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, overview, photo) = listTourism[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvOverview.text = overview
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listTourism[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listTourism.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvOverview: TextView = itemView.findViewById(R.id.tv_item_overview)
    }
}
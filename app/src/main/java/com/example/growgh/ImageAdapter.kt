package com.example.growgh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.viewHolder>() {

    private val items: ArrayList<String> = ArrayList()

    class viewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val imageView: ImageView = itemView.findViewById(R.id.Api_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return viewHolder(itemview)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = items[position]
        Picasso.get().load(currentItem).into(holder.imageView)
    }
    fun updateImages(updatedImages: ArrayList<String>) {
        items.clear()
        items.addAll(updatedImages)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
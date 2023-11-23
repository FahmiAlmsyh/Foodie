package com.example.foodie.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodie.databinding.ItemViewBinding
import com.example.foodie.model.dataRestaurant

class ListRestAdapter (var listRest: ArrayList<dataRestaurant>):
RecyclerView.Adapter<ListRestAdapter.ListViewHolder>()
{
    class ListViewHolder(val Binding: ItemViewBinding) : RecyclerView.ViewHolder(Binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val Binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ListViewHolder(Binding)
    }

    override fun getItemCount(): Int = listRest.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val rest = listRest[position]

        Glide.with(holder.itemView.context)
            .load(rest.image)
            .into(holder.Binding.avatar)

        holder.Binding.titleTextView.text = rest.name
        holder.Binding.minute.text = rest.minutes
        holder.Binding.kilometer.text = rest.miles
        holder.Binding.rate.text = rest.star
    }
}
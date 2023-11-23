package com.example.foodie.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodie.databinding.ItemViewBinding
import com.example.foodie.model.dataRestaurant

class ListFoodAdapter (var listFood: ArrayList<dataRestaurant>):
    RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    class ListViewHolder(val Binding: ItemViewBinding) : RecyclerView.ViewHolder(Binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listFood.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food = listFood[position]

        Glide.with(holder.itemView.context)
            .load(food.image)
            .into(holder.Binding.avatar)

        holder.Binding.titleTextView.text = food.name
        holder.Binding.minute.text = food.minutes
        holder.Binding.kilometer.text = food.miles
        holder.Binding.rate.text = food.star
    }
}
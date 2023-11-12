package com.dicoding.foodappandroiddesign.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.foodappandroiddesign.data.model.MainModel
import com.dicoding.foodappandroiddesign.databinding.ParentItemBinding

class MainListAdapter(private val collection : List<MainModel>) : RecyclerView.Adapter<MainListAdapter.CollectionViewholder>() {
    inner class CollectionViewholder(binding: ParentItemBinding) : RecyclerView.ViewHolder(binding.root)  {

        val bind = ParentItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewholder {
        val binding = ParentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CollectionViewholder(binding)
    }

    override fun getItemCount(): Int = collection.size
    override fun onBindViewHolder(holder: CollectionViewholder, position: Int) {
        holder.bind.apply {
            val collection = collection[position]
            tvListTour.text = collection.title
            val tourAdapter = TourListAdapter(collection.toursModel)
            rvTourChild.adapter = tourAdapter
        }

    }
}
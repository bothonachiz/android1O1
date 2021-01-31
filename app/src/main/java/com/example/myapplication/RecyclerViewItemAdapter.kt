package com.example.myapplication

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LayoutRecyclerViewItemBinding

class RecyclerViewItemAdapter(
    private val items: ArrayList<RecyclerViewItemModel> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutRecyclerViewItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun update(list: List<RecyclerViewItemModel>) {
        items.clear();
        items.addAll(list)
        notifyDataSetChanged()
    }


    class ItemViewHolder(
        private val binding: LayoutRecyclerViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: RecyclerViewItemModel) {
            binding.ivLogo.setImageResource(model.image)
            binding.tvName.setText(model.name)
        }
    }
}
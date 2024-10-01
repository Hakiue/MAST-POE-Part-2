package com.example.poe22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poe22.databinding.MenuItemBinding // Ensure this matches your item layout XML name

class MenuListAdapter(private val menuItems: List<CulinaryMenuItem>) : // Updated type
    RecyclerView.Adapter<MenuListAdapter.MenuItemViewHolder>() {

    class MenuItemViewHolder(val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MenuItemBinding.inflate(inflater, parent, false)
        return MenuItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val menuItem = menuItems[position]
        holder.binding.dishNameTextView.text = menuItem.dishName
        holder.binding.descriptionTextView.text = menuItem.description
        holder.binding.courseTextView.text = menuItem.course
        holder.binding.priceTextView.text = "$${menuItem.price}"
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }
}

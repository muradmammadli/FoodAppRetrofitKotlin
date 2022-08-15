package com.example.foodappretrofitkotlin.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodappretrofitkotlin.R
import com.example.foodappretrofitkotlin.databinding.ItemCategoryBinding
import com.example.foodappretrofitkotlin.models.Category
import com.example.foodappretrofitkotlin.models.CategoryX

class CategoryAdapter(private val categoryList : List<CategoryX>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemCategoryBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.apply {
            Glide.with(itemView.context).load(currentItem.strCategoryThumb).into(binding.imgCategory)
            binding.titleCategory.text = currentItem.strCategory
            binding.categoryLayout
            binding.categoryLayout.setOnClickListener {
                Log.d("Category", "Checked")
            }
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


}
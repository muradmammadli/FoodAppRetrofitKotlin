package com.example.foodappretrofitkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodappretrofitkotlin.R
import com.example.foodappretrofitkotlin.databinding.ItemRandomMealBinding
import com.example.foodappretrofitkotlin.models.Meal

class RandomMealAdapter(private val randomMealList: List<Meal>) : RecyclerView.Adapter<RandomMealAdapter.RandomMealViewHolder>() {

    inner class RandomMealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding =  ItemRandomMealBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomMealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_random_meal,parent,false)
        return RandomMealViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomMealViewHolder, position: Int) {
       val currenItem = randomMealList[position]
        holder.apply {
            Glide.with(itemView.context).load(currenItem.strMealThumb).into(binding.imgRandomMeal)
            binding.txtRandomMeal.text = currenItem.strMeal

        }
    }

    override fun getItemCount(): Int {
        return randomMealList.size
    }


}
package com.example.foodappretrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappretrofitkotlin.adapters.CategoryAdapter
import com.example.foodappretrofitkotlin.adapters.RandomMealAdapter
import com.example.foodappretrofitkotlin.api.ApiInterface
import com.example.foodappretrofitkotlin.api.ApiUtilities
import com.example.foodappretrofitkotlin.databinding.ActivityMainBinding
import com.example.foodappretrofitkotlin.databinding.ItemCategoryBinding
import com.example.foodappretrofitkotlin.models.Category
import com.example.foodappretrofitkotlin.models.CategoryX
import com.example.foodappretrofitkotlin.models.RandomMeals
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryRv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.categoryRv.setHasFixedSize(true)

        binding.mealRv.layoutManager = LinearLayoutManager(this)
        binding.mealRv.setHasFixedSize(true)

        val categoryApi = ApiUtilities.getRetrofit().create(ApiInterface::class.java)
        val callCategory = categoryApi.getCategories()
        val callMeals = categoryApi.getRandomMeal()

        GlobalScope.launch {
            callCategory.enqueue(object : Callback<Category> {
                override fun onResponse(call: Call<Category>, response: Response<Category>) {
                    binding.categoryRv.adapter = CategoryAdapter(response.body()!!.categories)
                }

                override fun onFailure(call: Call<Category>, t: Throwable) {

                }

            })

            callMeals.enqueue(object : Callback<RandomMeals>{
                override fun onResponse(call: Call<RandomMeals>, response: Response<RandomMeals>) {
                    binding.mealRv.adapter = RandomMealAdapter(response.body()!!.meals)
                }

                override fun onFailure(call: Call<RandomMeals>, t: Throwable) {

                }

            })


        }
    }
}
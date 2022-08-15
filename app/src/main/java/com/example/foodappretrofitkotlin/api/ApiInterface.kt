package com.example.foodappretrofitkotlin.api

import com.example.foodappretrofitkotlin.models.Category
import com.example.foodappretrofitkotlin.models.RandomMeals
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("v1/1/categories.php")
    fun getCategories(): Call<Category>

    @GET("v2/1/randomselection.php")
    fun getRandomMeal(): Call<RandomMeals>


}
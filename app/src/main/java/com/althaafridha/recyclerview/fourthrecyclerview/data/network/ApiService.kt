package com.althaafridha.recyclerview.fourthrecyclerview.data.network

import com.althaafridha.recyclerview.fourthrecyclerview.data.RecipeResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {

	@GET("api/recipes")
	fun getNewRecipe(): Flowable<RecipeResponse>
}
package com.althaafridha.recyclerview.fourthrecyclerview.data

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

	@field:SerializedName("results")
	val results: List<NewRecipeItem>? = null,

	)

data class NewRecipeItem(

	@field:SerializedName("times")
	val times: String? = null,

	@field:SerializedName("thumb")
	val imageUrl: String? = null,

	@field:SerializedName("portion")
	val portion: String? = null,

	@field:SerializedName("key")
	val name: String? = null,

	@field:SerializedName("dificulty")
	val dificulty: String? = null
)

package com.althaafridha.recyclerview.fourthrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.recyclerview.databinding.RecipeItemBinding
import com.althaafridha.recyclerview.fourthrecyclerview.data.NewRecipeItem
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

	private var listRecipe = ArrayList<NewRecipeItem>()

	class RecipeViewHolder(val itemRecipe: RecipeItemBinding): RecyclerView.ViewHolder(itemRecipe.root)

	fun setData(data: List<NewRecipeItem>?) {
		if (data == null) return
		listRecipe.clear()
		listRecipe.addAll(data)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  RecipeViewHolder(
		RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)

	override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
		val data = listRecipe[position]
		holder.itemRecipe.apply {
			val splittedData = data.name?.substring(5, data.name.length)?.split("-")?.toTypedArray()
			val capitalizedData = splittedData?.map {
				it.capitalize()
			}
			val joinedData = capitalizedData?.joinTo(StringBuilder(), separator = " ")

			tvNamaRecipe.text = joinedData
			Glide.with(imageRecipe.context)
				.load(data.imageUrl)
				.apply(RequestOptions())
				.override(500, 500)
				.diskCacheStrategy(DiskCacheStrategy.ALL)
				.priority(Priority.HIGH)
				.into(imageRecipe)
		}
	}

	override fun getItemCount(): Int  = listRecipe.size

}
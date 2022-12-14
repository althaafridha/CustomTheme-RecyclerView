package com.althaafridha.recyclerview.firstrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.recyclerview.databinding.AnimalItemBinding

class AnimalAdapter(private val animalList: Array<String>) :
	RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

	inner class AnimalViewHolder(private val itemBinding: AnimalItemBinding) :
		RecyclerView.ViewHolder(itemBinding.root) {
		fun bind(word: String) {
			itemBinding.animalText.text = word
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
		val itemBinding =
			AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

		return AnimalViewHolder(itemBinding)
	}

	override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
		val word = animalList[position]
		holder.bind(word)
	}

	override fun getItemCount(): Int = animalList.size
}
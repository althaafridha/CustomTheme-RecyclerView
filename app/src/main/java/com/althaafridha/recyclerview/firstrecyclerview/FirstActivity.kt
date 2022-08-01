package com.althaafridha.recyclerview.firstrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.althaafridha.recyclerview.R
import com.althaafridha.recyclerview.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

	private lateinit var binding: ActivityFirstBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityFirstBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val animalList = AnimalModel(this).getAnimalList()
		binding.recyclerView.adapter = AnimalAdapter(animalList)
	}
}
package com.althaafridha.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.althaafridha.recyclerview.databinding.ActivityMainBinding
import com.althaafridha.recyclerview.firstrecyclerview.FirstActivity
import com.althaafridha.recyclerview.fourthrecyclerview.FourthActivity
import com.althaafridha.recyclerview.secondrecyclerview.SecondActivity
import com.althaafridha.recyclerview.thirdrecyclerview.ThirdActivity

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.firstRecyclerView.setOnClickListener {
			startActivity(Intent(this, FirstActivity::class.java))
		}

		binding.secondRecyclerView.setOnClickListener {
			startActivity(Intent(this, SecondActivity::class.java))
		}

		binding.thirdRecyclerView.setOnClickListener {
			startActivity(Intent(this, ThirdActivity::class.java))
		}

		binding.fourthRecyclerView.setOnClickListener {
			startActivity(Intent(this, FourthActivity::class.java))
		}
	}
}
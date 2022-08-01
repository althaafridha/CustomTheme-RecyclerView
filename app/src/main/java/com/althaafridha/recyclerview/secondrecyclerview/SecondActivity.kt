package com.althaafridha.recyclerview.secondrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.althaafridha.recyclerview.databinding.ActivitySecondBinding
import com.althaafridha.recyclerview.secondrecyclerview.data.VehicleAdapter
import com.althaafridha.recyclerview.secondrecyclerview.data.VehicleData

class SecondActivity : AppCompatActivity() {

	private lateinit var binding: ActivitySecondBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySecondBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.recyclerView.apply {
			adapter = VehicleAdapter(VehicleData.listVehicle)
		}
	}
}
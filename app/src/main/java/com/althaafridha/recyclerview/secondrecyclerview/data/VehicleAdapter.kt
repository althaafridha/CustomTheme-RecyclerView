package com.althaafridha.recyclerview.secondrecyclerview.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.recyclerview.databinding.VehicleItemBinding
import com.bumptech.glide.Glide

class VehicleAdapter(private val listVehicle: ArrayList<Vehicle>) :
	RecyclerView.Adapter<VehicleAdapter.MyViewHolder>() {

	inner class MyViewHolder(val itemBinding: VehicleItemBinding) :
		RecyclerView.ViewHolder(itemBinding.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
		VehicleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		holder.itemBinding.apply {
			with(listVehicle[position]){
				textViewVehicle.text = name
				Glide.with(imageViewVehicle.context)
					.load(image)
					.override(1000, 1000)
					.into(imageViewVehicle)
			}
		}
	}

	override fun getItemCount(): Int = listVehicle.size
}
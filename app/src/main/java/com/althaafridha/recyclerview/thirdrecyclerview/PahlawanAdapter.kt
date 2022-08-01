package com.althaafridha.recyclerview.thirdrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.recyclerview.databinding.PahlawanItemBinding
import com.bumptech.glide.Glide

class PahlawanAdapter(val listPahlawan: MutableList<ModelPahlawan>): RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {
	inner class PahlawanViewHolder(val itemPahlawan: PahlawanItemBinding): RecyclerView.ViewHolder(itemPahlawan.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
		PahlawanItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)

	override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
		holder.itemPahlawan.apply {
			with(listPahlawan[position]){
				tvNamaPahlawan.text = nama
				tvNamaLengkap.text = namaLengkap

				Glide.with(imagePahlawan).load(image).into(imagePahlawan)
			}
		}
	}

	override fun getItemCount() = listPahlawan.size
}
package com.althaafridha.recyclerview.secondrecyclerview.data

object VehicleData {
	private val name = arrayOf(
		"mobil",
		"motor"
	)

	private val image = arrayOf(
		"https://pict-b.sindonews.net/dyn/850/pena/news/2021/09/28/120/553016/mobil-sport-buatan-china-ini-lebih-kencang-dari-lamborghini-aventador-kdd.jpg",
		"https://imgcdn.oto.com/medium/gallery/exterior/88/1129/kawasaki-ninja-h2-marketing-image-427751.jpg"
	)

	val listVehicle: ArrayList<Vehicle>
	get() {
		val list = arrayListOf<Vehicle>()
		for (position in name.indices) {
			val vehicle = Vehicle(
				name = name[position],
				image = image[position]
			)
			list.add(vehicle)
		}
		return list
	}

}
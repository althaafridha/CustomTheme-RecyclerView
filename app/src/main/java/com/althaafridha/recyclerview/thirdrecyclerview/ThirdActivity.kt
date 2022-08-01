package com.althaafridha.recyclerview.thirdrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.althaafridha.recyclerview.R
import com.althaafridha.recyclerview.databinding.ActivityThirdBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class ThirdActivity : AppCompatActivity() {

	private var modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
	lateinit var pahlawanAdapter: PahlawanAdapter

	private lateinit var binding: ActivityThirdBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityThirdBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.rvListPahlawan.apply {
			setHasFixedSize(true)
			layoutManager = LinearLayoutManager(this@ThirdActivity)
		}

		getListPahlawan()

	}

	private fun getListPahlawan() {
		try {
//				membuka asset json
			val stream = assets.open("pahlawan_nasional.json")
			val size = stream.available()
			val buffer = ByteArray(size)
			stream.read(buffer)
			stream.close()

			val strContent = String(buffer, StandardCharsets.UTF_8)
			try {
				val jsonObject = JSONObject(strContent)
				val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")
				for (i in 0 until jsonArray.length()) {
					val jsonObjectData = jsonArray.getJSONObject(i)
					val dataApi = ModelPahlawan()
					dataApi.nama = jsonObjectData.getString("nama")
					dataApi.namaLengkap = jsonObjectData.getString("nama2")
					dataApi.image = jsonObjectData.getString("img")
					modelPahlawan.add(dataApi)
				}
				pahlawanAdapter = PahlawanAdapter(modelPahlawan)
//				set up recycler view
				binding.rvListPahlawan.adapter = pahlawanAdapter

			} catch (e: JSONException) {
				e.printStackTrace()
//					atau bisa menggunakan log e
//					Log.e("Error", e.toString())
			}
		} catch (e: IOException) {
			Toast.makeText(applicationContext, "maaf error", Toast.LENGTH_SHORT).show()
		}
	}

}
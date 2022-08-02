package com.althaafridha.recyclerview.fourthrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.althaafridha.recyclerview.R
import com.althaafridha.recyclerview.databinding.ActivityFourthBinding
import com.althaafridha.recyclerview.fourthrecyclerview.data.NewRecipeItem
import com.althaafridha.recyclerview.fourthrecyclerview.data.RecipeResponse
import com.althaafridha.recyclerview.fourthrecyclerview.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class FourthActivity : AppCompatActivity() {

	private lateinit var binding : ActivityFourthBinding

	private val apiService = ApiClient.getApiService()
	val newRecipe = MutableLiveData<RecipeResponse>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityFourthBinding.inflate(layoutInflater)
		setContentView(binding.root)

		getDetail()
		newRecipe.observe(this){
			showData(it.results as List<NewRecipeItem>)
		}

	}

	private fun showData(data: List<NewRecipeItem>?) {
		binding.rvListRecipe.apply {
			val mAdapter = RecipeAdapter()
			mAdapter.setData(data)
			layoutManager = LinearLayoutManager(applicationContext)
			adapter = mAdapter
		}
	}

	private fun getData(
		responseHandler: (RecipeResponse) -> Unit,
		errorHandler: (Throwable) -> Unit
	){
		apiService.getNewRecipe()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe({
				responseHandler(it)
			},{
				errorHandler(it)
			})
	}

	fun getDetail(){
		getData({
			newRecipe.value = it
		},{

		})
	}
}
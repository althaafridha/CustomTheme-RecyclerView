package com.althaafridha.recyclerview.secondrecyclerview.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vehicle(
	var name: String,
	var image: String
) : Parcelable

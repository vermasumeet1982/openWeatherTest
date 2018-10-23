package com.test.domain.openweather.networkmodel

import com.google.gson.annotations.SerializedName

data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
)
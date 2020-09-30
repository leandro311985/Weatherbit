package com.study.deliverycenter.api

import com.study.deliverycenter.data.CityForecast
import retrofit2.Response

interface ApiHelper {
    suspend fun getForecast( post:String): Response<CityForecast>
}
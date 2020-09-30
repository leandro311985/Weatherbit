package com.study.deliverycenter.api

import com.study.deliverycenter.data.CityForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICityForecastService {
    @GET("forecast/daily")
    suspend fun getForecast(@Query("city") city: String,
                              @Query("key") key: String,
                              @Query("lang") lang: String,
                              @Query("days") days: Int): Response<CityForecast>
}
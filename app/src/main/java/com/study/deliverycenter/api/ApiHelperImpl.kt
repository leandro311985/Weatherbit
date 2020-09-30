package com.study.deliverycenter.api

import com.study.deliverycenter.data.CityForecast
import com.study.deliverycenter.utils.API_KEY
import com.study.deliverycenter.utils.SEARCH_DAYS
import com.study.deliverycenter.utils.SEARCH_LANG
import retrofit2.Response

class ApiHelperImpl(private val apiService: ICityForecastService) : ApiHelper {

    override suspend fun getForecast(post:String): Response<CityForecast> =
        apiService.getForecast(city = post,key = API_KEY,lang = SEARCH_LANG,days = SEARCH_DAYS )


}
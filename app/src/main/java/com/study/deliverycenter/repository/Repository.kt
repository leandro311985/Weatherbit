package com.study.deliverycenter.repository

import com.study.deliverycenter.api.ApiHelper

class Repository(private val apiHelper: ApiHelper) {

    suspend fun getForecast(post:String) = apiHelper.getForecast(post)

}
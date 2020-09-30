package com.study.deliverycenter.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CityForecast : Serializable {

    @SerializedName("city_name")
    @Expose
    var cityName: String? = null

    @SerializedName("lon")
    @Expose
    var longitude: String? = null

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    @SerializedName("lat")
    @Expose
    var latitude: String? = null

    @SerializedName("country_code")
    @Expose
    var countryCode: String? = null

    @SerializedName("state_code")
    @Expose
    var stateCode: String? = null

    @SerializedName("data")
    @Expose
    var forecastData: ArrayList<ForecastData>? = null

}
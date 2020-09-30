package com.study.deliverycenter.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ForecastData : Serializable {
    @SerializedName("moonrise_ts")
    @Expose
    var moonriseTimestamp: Long? = null
    @SerializedName("wind_cdir")
    @Expose
    var windDirection: String? = null
    @SerializedName("rh")
    @Expose
    var relativeHumidity: Int? = null
    @SerializedName("pres")
    @Expose
    var averagePressure: String? = null
    @SerializedName("high_temp")
    @Expose
    var higherTemperature: Double? = null
    @SerializedName("sunset_ts")
    @Expose
    var sunsetTimestamp: Long? = null
    @SerializedName("ozone")
    @Expose
    var ozoneAverage:  Double? = null
    @SerializedName("moon_phase")
    @Expose
    var moonPhase:  Double? = null
    @SerializedName("wind_gust_spd")
    @Expose
    var windGustSpeed:  Double? = null
    @SerializedName("snow_depth")
    @Expose
    var snowDepth:  Double? = null
    @SerializedName("clouds")
    @Expose
    var cloudCoverage: Int? = null
    @SerializedName("ts")
    @Expose
    var forecastStartTimestamp: Long? = null
    @SerializedName("sunrise_ts")
    @Expose
    var sunriseTimestamp: Long? = null
    @SerializedName("app_min_temp")
    @Expose
    var feelsLikeMin:  Double? = null
    @SerializedName("wind_spd")
    @Expose
    var windSpeed:  Double? = null
    @SerializedName("pop")
    @Expose
    var probabilityOfPrecipitation: Int? = null
    @SerializedName("wind_cdir_full")
    @Expose
    var verbalWindDirection: String? = null
    @SerializedName("slp")
    @Expose
    var seaLevelPressure:  Double? = null
    @SerializedName("valid_date")
    @Expose
    var forecastValidDate: String? = null
    @SerializedName("app_max_temp")
    @Expose
    var feelsLikeMax:  Double? = null
    @SerializedName("vis")
    @Expose
    var visibility:  Double? = null
    @SerializedName("dewpt")
    @Expose
    var dewPoint:  Double? = null
    @SerializedName("snow")
    @Expose
    var accumulatedSnowfall:  Double? = null
    @SerializedName("uv")
    @Expose
    var maximumUvIndex:  Double? = null
    @SerializedName("wind_dir")
    @Expose
    var windDirectionValue: Int? = null
    @SerializedName("clouds_hi")
    @Expose
    var highLevelCloudCoverage: Int? = null
    @SerializedName("precip")
    @Expose
    var accumulatedPrecipitation:  Double? = null
    @SerializedName("low_temp")
    @Expose
    var lowTemperature:  Double? = null
    @SerializedName("max_temp")
    @Expose
    var maxTemperature:  Double? = null
    @SerializedName("moonset_ts")
    @Expose
    var moonsetTimestamp: Long? = null
    @SerializedName("temp")
    @Expose
    var averageTemperature:  Double? = null
    @SerializedName("min_temp")
    @Expose
    var minimumTemperature:  Double? = null
    @SerializedName("clouds_mid")
    @Expose
    var midLevelCloudCoverage: Int? = null
    @SerializedName("clouds_low")
    @Expose
    var lowLevelCloudCoverage: Int? = null
    @SerializedName("weather")
    @Expose
    var weatherInfo: WeatherInfo? = null
}
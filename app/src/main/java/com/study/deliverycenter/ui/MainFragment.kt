package com.study.deliverycenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.study.deliverycenter.R
import com.study.deliverycenter.data.CityForecast
import com.study.deliverycenter.utils.Status
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


class MainFragment : Fragment() {

    companion object {
        var locationT = String()

        fun newInstance(text: String): MainFragment {
            locationT = text
            return MainFragment()
        }
    }

    private val mainViewModel: MainViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onResponse()
        floatActionButtom()
        mainViewModel.city(locationT)
        mainViewModel.fetchMovie()
    }

    private fun onResponse() {
        mainViewModel.cityForecast.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    forecastLoading.visibility = View.GONE
                    forecastInfo.visibility = View.VISIBLE
                    it.data?.let { city ->
                        cityResponse(city)
                    }

                }
                Status.LOADING -> {
                    forecastLoading?.visibility = View.VISIBLE

                }
                Status.ERROR -> {
                    forecastLoading?.visibility = View.GONE
                    erro(it.message ?: "")
                }

            }
        })

    }

    private fun cityResponse(res: CityForecast) {
        val forecast = res.forecastData?.first()

        cityText.text = res.cityName
        temperatureText.text = forecast?.averageTemperature.toString().plus("° C")
        weatherDescText.text = forecast?.weatherInfo?.description
        rainChanceValueText.text = forecast?.probabilityOfPrecipitation.toString().plus("% ")
        maxTempValueText.text = forecast?.maxTemperature.toString().plus("° C")
        minTempValueText.text = forecast?.minimumTemperature.toString().plus("° C")
        windSpeedValueText.text = forecast?.windSpeed?.roundToInt().toString().plus(" Km/h ")

        val timestampFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        timestampFormat.timeZone = TimeZone.getDefault()

        val sunriseTime = Date(forecast?.sunriseTimestamp!! * 1000)
        val sunsetTime = Date(forecast.sunsetTimestamp!! * 1000)

        sunriseValueText.text = timestampFormat.format(sunriseTime).plus(" ")
        sunsetValueText.text = timestampFormat.format(sunsetTime).plus(" ")

    }

    private fun floatActionButtom() {
        fab.setOnClickListener { view ->
            activity!!.supportFragmentManager.beginTransaction()
                .add(R.id.container, SearchFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun erro(message: String) {
        val dialogBuilder = context?.let { it1 -> AlertDialog.Builder(it1) }
        dialogBuilder?.setMessage(message)
            ?.setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }
        val dialog = dialogBuilder?.create()
        dialog?.setTitle(getString(R.string.get_forecast_failed_message))
        dialog?.show()
        activity?.supportFragmentManager?.popBackStack()
    }
}
package com.study.deliverycenter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.deliverycenter.data.CityForecast
import com.study.deliverycenter.repository.Repository
import com.study.deliverycenter.utils.NetworkHelper
import com.study.deliverycenter.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: Repository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _cityForecast = MutableLiveData<Resource<CityForecast>>()
    val cityForecast: LiveData<Resource<CityForecast>>
        get() = _cityForecast


    val cityResponse = MutableLiveData<String>().apply { value = "" }

    fun city(city: String) {
        cityResponse.value = city
    }

     fun fetchMovie() {
        var result = cityResponse.value ?:""
        viewModelScope.launch {
            _cityForecast.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getForecast(result).let {
                    if (it.isSuccessful) {
                        if (it.body()?.cityName == null){
                            _cityForecast.postValue(Resource.error(it.errorBody().toString(), null))
                        }else
                        _cityForecast.postValue(Resource.success(it.body()))
                    } else
                        _cityForecast.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
    }

}


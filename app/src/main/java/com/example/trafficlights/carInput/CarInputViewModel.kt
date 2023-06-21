package com.example.trafficlights.carInput

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarInputViewModel : ViewModel() {

    private val carModelNameMinLength = 3

    var carModel = MutableLiveData<String?>()
    var isCarModelValid = MediatorLiveData<Boolean>().apply {
        value = false
        addSource(carModel) { model ->
            value = model?.let {
                it.length >= carModelNameMinLength
            } ?: false
        }
    }
}
package com.example.trafficlights.di

import com.example.trafficlights.carInput.CarInputViewModel
import com.example.trafficlights.trafficLights.TrafficLightsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { CarInputViewModel() }
    viewModel { TrafficLightsViewModel() }
}

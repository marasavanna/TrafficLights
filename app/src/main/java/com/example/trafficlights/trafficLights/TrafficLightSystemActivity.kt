package com.example.trafficlights.trafficLights

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trafficlights.databinding.ActivityTrafficLightSystemBinding
import com.example.trafficlights.utils.Constants.carNameKey
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrafficLightSystemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrafficLightSystemBinding
    private val trafficLightsViewModel: TrafficLightsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrafficLightSystemBinding.inflate(layoutInflater)

        binding.apply {
            carModelName = intent.extras?.getString(carNameKey)
            viewModel = trafficLightsViewModel
            lifecycleOwner = this@TrafficLightSystemActivity
        }

        setContentView(binding.root)
    }

}
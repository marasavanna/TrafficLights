package com.example.trafficlights.carInput

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trafficlights.databinding.ActivityCarInputBinding
import com.example.trafficlights.trafficLights.TrafficLightSystemActivity
import com.example.trafficlights.utils.Constants.carNameKey
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarInputBinding
    private val carInputViewModel: CarInputViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.carInputViewModel = carInputViewModel
        binding.lifecycleOwner = this

        binding.submit.setOnClickListener {
            navigateToTrafficLightsScreen()
        }
    }

    private fun navigateToTrafficLightsScreen() {
        Intent(this, TrafficLightSystemActivity::class.java).also {
            it.putExtra(carNameKey, carInputViewModel.carModel.value)
            startActivity(it)
        }
    }
}
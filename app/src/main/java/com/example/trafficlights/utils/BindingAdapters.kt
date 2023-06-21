package com.example.trafficlights.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.trafficlights.R
import com.example.trafficlights.customView.TrafficLightView
import com.example.trafficlights.enums.TrafficLightState
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("handleTrafficLightState")
fun TrafficLightView.handleTrafficLightState(isActive: Boolean) {
    alpha = if (isActive) 1.0f else 0.1f
}

@BindingAdapter("carNameTitle")
fun TextView.handleCarNameTitle(title: String?) {
    if (title.isNullOrEmpty()) {
        visibility = View.GONE
    } else {
        text = context.getString(R.string.traffic_lights_welcome, title)
    }
}

@BindingAdapter("trafficMessage")
fun TextView.handleTrafficMessage(trafficLightState: TrafficLightState?) {
    trafficLightState?.let {
        text = resources.getString(trafficLightState.trafficMessageResId)
        setTextColor(resources.getColor(trafficLightState.colorResId, null))
    }
}

@BindingAdapter("inputHelperEnabled")
fun TextInputLayout.handleInputHelper(isCriteriaSatisfied: Boolean) {
    helperText = if (!isCriteriaSatisfied) {
        resources.getString(R.string.car_model_input_helper_text)
    } else {
        resources.getString(R.string.empty)
    }
}
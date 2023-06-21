package com.example.trafficlights.customView


import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.trafficlights.R
import com.example.trafficlights.databinding.ViewTrafficLightBinding
import com.example.trafficlights.enums.TrafficLightState

class TrafficLightView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    private lateinit var trafficLightState: TrafficLightState
    private var binding: ViewTrafficLightBinding

    init {
        binding = ViewTrafficLightBinding.inflate(LayoutInflater.from(context), this, true)
        val trafficLightAttrs = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TrafficLightView,
            0, 0
        )
        setTrafficLightColor(trafficLightAttrs)
    }

    private fun setTrafficLightColor(trafficLightAttrs: TypedArray) {
        val ordinal = trafficLightAttrs.getInt(R.styleable.TrafficLightView_trafficLight, 0)
        if (ordinal >= 0 && ordinal < TrafficLightState.values().size) {
            trafficLightState = TrafficLightState.fromParams(ordinal)
        }
        binding.trafficLight.backgroundTintList = ColorStateList.valueOf(resources.getColor(trafficLightState.colorResId, null))
    }
}
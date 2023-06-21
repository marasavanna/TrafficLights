package com.example.trafficlights.enums

import com.example.trafficlights.R

enum class TrafficLightState(
    val durationActiveInMillis: Long,
    val colorResId: Int,
    val trafficMessageResId: Int
) {
    RED(4000, R.color.traffic_light_red, R.string.traffic_lights_text_red),
    YELLOW(1000, R.color.traffic_light_yellow, R.string.traffic_lights_text_yellow),
    GREEN(4000, R.color.traffic_light_green, R.string.traffic_lights_text_green);

    companion object {
        fun fromParams(id: Int): TrafficLightState {
            return when (id) {
                0 -> RED
                1 -> YELLOW
                2 -> GREEN
                else -> throw IllegalAccessException("Unsupported Traffic Light")
            }
        }

        fun getNextState(currentState: TrafficLightState): TrafficLightState {
            return when (currentState) {
                RED -> {
                    GREEN
                }
                GREEN -> {
                    YELLOW
                }
                else -> {
                    RED
                }
            }
        }
    }
}
package com.example.trafficlights.trafficLights

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.trafficlights.enums.TrafficLightState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class TrafficLightsViewModel : ViewModel() {

    val currentTrafficLightsState: LiveData<TrafficLightState> = liveData(Dispatchers.Default) {
        showLight(this)
    }

    tailrec suspend fun showLight(
        liveDataScope: LiveDataScope<TrafficLightState>,
        currentState: TrafficLightState = TrafficLightState.GREEN
    ) {
        liveDataScope.emit(currentState)
        delay(currentState.durationActiveInMillis)
        return showLight(liveDataScope, TrafficLightState.getNextState(currentState))
    }
}
package com.rpfcoding.sensorwithcleanarchapp

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
) : ViewModel() {

    private val _isDark = MutableStateFlow(false)
    val isDark = _isDark.asStateFlow()

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values.first()
            _isDark.update {
                Log.d("MainViewModel", "Liwanag: $lux")
                lux < 60f
            }
        }
    }
}
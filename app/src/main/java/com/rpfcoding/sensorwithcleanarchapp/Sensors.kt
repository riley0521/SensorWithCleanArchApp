package com.rpfcoding.sensorwithcleanarchapp

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

class LightSensor(
    ctx: Context
): AndroidSensor(
    ctx = ctx,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
) {

}

class ProximitySensor(
    ctx: Context
): AndroidSensor(
    ctx = ctx,
    sensorFeature = PackageManager.FEATURE_SENSOR_PROXIMITY,
    sensorType = Sensor.TYPE_PROXIMITY
) {

}
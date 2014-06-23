package com.example.balanceit;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/** Die GravitySensorListener-Klasse implementiert die SensorEventListener-Schnittstelle von Android. 
 *  Dadurch wird sie vom System bei neuen Datenwerten der Accelerometer (Neigungssensoren) informiert und speichert diese für die 
 *  anderen Klassen des Spiels zwischen.
 */
public class GravitySensorListener implements SensorEventListener {

	//Membervariablen
    public float mSensorX;
    public float mSensorY;
    public long mSensorTimeStamp;

    // Callback-Methode von SensorEventListener, die aufgerufen wird, wenn dem System neue Sensordaten vorliegen
    @Override
    public void onSensorChanged(SensorEvent event) {
        //wir sind nur an Daten des Gravitationssensors interessiert
        if (event.sensor.getType() != Sensor.TYPE_GRAVITY)
            return;

        //aktuelle Sensorwerte zwischenspeichern
        mSensorX = event.values[0];
        mSensorY = event.values[1];
        mSensorTimeStamp = event.timestamp;
    }

    // Callback-Methode von SensorEventListener (bleibt leer, da uns Genauigkeitsänderungen nicht interessieren)
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

}
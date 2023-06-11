package com.akim.atividade3;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView coordinate;
    private final float threshold = 15.0F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinate = (TextView) findViewById(R.id.textViewX);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            String format = sensorX + " " + sensorY + " " + sensorZ;
            //Log.d("ACCEL", format);
            if(coordinate != null) {
                coordinate.setText(format);
            }
            if(Math.abs(sensorX)>threshold || Math.abs(sensorX)>threshold || Math.abs(sensorX)>threshold){
                Intent i = new Intent(this, MainActivity2.class);
                i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //garante que apenas uma instância da atividade será criada
                startActivity(i);
            }

        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}
package com.akim.parte2magnetometro;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor magnetometer;
    private TextView norma;
    private TextView componenteX;
    private TextView componenteY;
    private TextView componenteZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        norma = (TextView)findViewById(R.id.norma);
        componenteX = (TextView)findViewById(R.id.valorX);
        componenteY = (TextView)findViewById(R.id.valorY);
        componenteZ = (TextView)findViewById(R.id.valorZ);

        if(magnetometer != null) {
            sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            norma.setText("magnetometer not supported");
        }
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    public void onSensorChanged(SensorEvent event) {
        //Sensor sensor = event.sensor;
        double mCompX = event.values[0];
        double mCompY = event.values[1];
        double mCompZ = event.values[2];
        double mNorma = Math.sqrt(mCompX*mCompX + mCompY*mCompY + mCompZ*mCompZ);
        norma.setText("Intensidade campo magnético: " + mNorma);
        componenteX.setText("Componente X: "+ mCompX);
        componenteY.setText("Componente Y: "+ mCompY);
        componenteZ.setText("Componente Z: "+ mCompZ);
    }

}
package com.example.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";

    private SensorManager sensorManager;

    private Sensor accelerometer, mGyro, mMagno, mLight, mPressure, mTemp, mHumi, mProxi, mHr;

    TextView xValue, yValue, zValue, xGyroValue, yGyroValue, zGyroValue, xMagnoValue, yMagnoValue, zMagnoValue, light, pressure, temp, humi, proxi, hr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Accelerometer values:
        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);
        //Gyroscopic values:
        xGyroValue = findViewById(R.id.xGyroValue);
        yGyroValue = findViewById(R.id.yGyroValue);
        zGyroValue = findViewById(R.id.zGyroValue);
        //Magnetometer values:
        xMagnoValue = findViewById(R.id.xMagnoValue);
        yMagnoValue = findViewById(R.id.yMagnoValue);
        zMagnoValue = findViewById(R.id.zMagnoValue);
        //Ambient Light Sensor:
        light = findViewById(R.id.light);
        //Pressure Sensor:
        pressure = findViewById(R.id.pressure);
        //Temperature Sensor:
        temp = findViewById(R.id.temp);
        //Humidity Sensor:
        humi = findViewById(R.id.humi);
        //Proximity Sensor:
        proxi = findViewById(R.id.proxi);
        //Heart rate Sensor:
        hr = findViewById(R.id.hr);
        //Starting Sensor Service
        Log.d(TAG, "onCreate: Initializing Sensor Services.");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //Sensor Check
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered accelerometer listner.");
        } else {
            xValue.setText("Accelerometer not Supported");
            yValue.setText("Accelerometer not Supported");
            zValue.setText("Accelerometer not Supported");
        }

        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyro != null) {
            sensorManager.registerListener(MainActivity.this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Gyro listner.");
        } else {
            xGyroValue.setText("Gyro not Supported");
            yGyroValue.setText("Gyro not Supported");
            zGyroValue.setText("Gyro not Supported");
        }

        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagno != null) {
            sensorManager.registerListener(MainActivity.this, mMagno, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Magnometer listner.");
        } else {
            xMagnoValue.setText("Magno not Supported");
            yMagnoValue.setText("Magno not Supported");
            zMagnoValue.setText("Magno not Supported");

        }

        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null) {
            sensorManager.registerListener(MainActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Light listner.");
        } else {
            light.setText("Light not Supported");

        }

        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure != null) {
            sensorManager.registerListener(MainActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Pressure listner.");
        } else {
            pressure.setText("Pressure not Supported");
        }

        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemp != null) {
            sensorManager.registerListener(MainActivity.this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Temperature listner.");
        } else {
            temp.setText("Temprature not Supported");
        }

        mHumi = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumi != null) {
            sensorManager.registerListener(MainActivity.this, mHumi, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Humidity listner.");
        } else {
            humi.setText("Humidity not Supported");
        }

        mProxi = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (mProxi != null) {
            sensorManager.registerListener(MainActivity.this, mProxi, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Proximity listner.");
        } else {
            proxi.setText("Proximity not Supported");
        }

        mHr = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        if (mHr != null) {
            sensorManager.registerListener(MainActivity.this, mHr, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered Heart rate listner.");
        } else {
            hr.setText("Heart rate not Supported");
        }
    }
    public void onPress(View v)
    {
        if(v.getId()==R.id.button1)
        {
            startActivity(new Intent(this, AccelerometerActivity.class));
        }
    }
    @Override
    public void onAccuracyChanged (Sensor sensor,int i){
    }
    @Override
    public void onSensorChanged (SensorEvent sensorEvent){
       Sensor sensor = sensorEvent.sensor;
       if (sensor.getType() == Sensor.TYPE_ACCELEROMETER){
          // Log.d(TAG, "onSensorChanged: X:" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
           xValue.setText("xValue: " + sensorEvent.values[0]);
           yValue.setText("yValue: " + sensorEvent.values[1]);
           zValue.setText("zValue: " + sensorEvent.values[2]);
       }else if (sensor.getType() == Sensor.TYPE_GYROSCOPE){
           xGyroValue.setText("xGValue: " + sensorEvent.values[0]);
           yGyroValue.setText("yGValue: " + sensorEvent.values[1]);
           zGyroValue.setText("zGValue: " + sensorEvent.values[2]);
       } else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
           xMagnoValue.setText("xMValue: " + sensorEvent.values[0]);
           yMagnoValue.setText("yMValue: " + sensorEvent.values[1]);
           zMagnoValue.setText("zMValue: " + sensorEvent.values[2]);
       } else if (sensor.getType() == Sensor.TYPE_LIGHT){
           light.setText("Light: " + sensorEvent.values[0]);
       } else if (sensor.getType() == Sensor.TYPE_PRESSURE){
           pressure.setText("Pressure: " + sensorEvent.values[0]);
       }else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
           temp.setText("Temprature: " + sensorEvent.values[0]);
       }else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
           humi.setText("Hunidity: " + sensorEvent.values[0]);
       }else if (sensor.getType() == Sensor.TYPE_PROXIMITY){
           proxi.setText("Proximity: " + sensorEvent.values[0]);
       }else if (sensor.getType() == Sensor.TYPE_HEART_RATE){
           hr.setText("Heart rate: " + sensorEvent.values[0]);
       }
    }
}
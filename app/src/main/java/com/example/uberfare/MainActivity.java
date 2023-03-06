package com.example.uberfare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button request = (Button)findViewById(R.id.button);
        Spinner carChoice = (Spinner)findViewById(R.id.carSpinner);
        EditText distance = (EditText)findViewById(R.id.travelDistance);
        Spinner measurement = (Spinner)findViewById(R.id.distMeasurement);

        SharedPreferences carPrefs = getSharedPreferences("carPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editCarPrefs = carPrefs.edit();

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carChoice.getSelectedItem().toString().equals("Request Smart Car")) {
                    editCarPrefs.putString("car", "Smart Car");
                    editCarPrefs.putString("carImage", "@drawable/smartcar.webp");
                } else if (carChoice.getSelectedItem().toString().equals("Request Sedan")) {
                    editCarPrefs.putString("car", "Sedan");
                    editCarPrefs.putString("carImage", "@drawable/whatisasedan.png");
                } else if (carChoice.getSelectedItem().toString().equals("Request Minivan")) {
                    editCarPrefs.putString("car", "Minivan");
                    editCarPrefs.putString("carImage", "@drawable/minivan.webp");
                } else {
                    editCarPrefs.putString("car", "None");
                    editCarPrefs.putString("carImage", "@drawable/whatisasedan.png");
                }
                editCarPrefs.putString("distance", distance.getText().toString());
                editCarPrefs.putString("measurement", measurement.getSelectedItem().toString());
                editCarPrefs.apply();
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}
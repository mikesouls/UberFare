package com.example.uberfare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Create new view finders
        Button goBack = (Button)findViewById(R.id.button2);
        Button requestCar = (Button)findViewById(R.id.button3);

        SharedPreferences carPrefs = getSharedPreferences("carPrefs", MODE_PRIVATE);
        String car = carPrefs.getString("car", ""),
        distance = carPrefs.getString("distance", ""),
        measurement = carPrefs.getString("measurement", ""),
                image = carPrefs.getString("carImage", "");

        double Total = 3.00;

        // Didn't show up, maybe should be a button click?
//        Toast.makeText(this, car, Toast.LENGTH_LONG);

        TextView distanceTo = (TextView)findViewById(R.id.distanceToTravel),
                carOrder = (TextView)findViewById(R.id.requestCar),
                totalCost = (TextView)findViewById(R.id.totalCost);
        ImageView carImage = (ImageView) findViewById(R.id.carImage);

        // what car was chosen, car fee?
        if(car.equals("Smart Car")){
            carImage.setImageResource(R.drawable.smartcar);
            Total += 2.00;
        } else if (car.equals("Sedan")) {
            carImage.setImageResource(R.drawable.whatisasedan);
        }
        else {
            carImage.setImageResource(R.drawable.minivan);
            Total += 5.00;
        }

        // calculate total price
        double parsedMileage = Double.parseDouble(distance.toString());
        Total += (parsedMileage * 3.25);

        distanceTo.setText(" "+distance+" "+measurement);
        carOrder.setText(" "+car);
        totalCost.setText(String.format(" %.2f", Total));

        // go back or proceed
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
        requestCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });


        // distanceTo.setText();


    }
}

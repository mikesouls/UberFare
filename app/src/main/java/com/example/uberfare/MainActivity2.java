package com.example.uberfare;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences carPrefs = getSharedPreferences("carPrefs", MODE_PRIVATE);
        String car = carPrefs.getString("car", ""),
        distance = carPrefs.getString("distance", ""),
        measurement = carPrefs.getString("measurement", ""),
                image = carPrefs.getString("carImage", "");


        Toast.makeText(this, car, Toast.LENGTH_LONG);

        TextView distanceTo = (TextView)findViewById(R.id.distanceToTravel),
                carOrder = (TextView)findViewById(R.id.requestCar),
                totalCost = (TextView)findViewById(R.id.totalCost);
        ImageView carImage = (ImageView) findViewById(R.id.carImage);

        distanceTo.setText(" "+distance+" "+measurement);
        carOrder.setText(" "+car);


        if(car.equals("Smart Car")){
            carImage.setImageResource(R.drawable.smartcar);
        } else if (car.equals("Sedan")) {
            carImage.setImageResource(R.drawable.whatisasedan);
        }
        else {
            carImage.setImageResource(R.drawable.minivan);
        }

        // TODO: IMPLEMENT THE MATH CALCULATIONS TO GET TOTAL

        // distanceTo.setText();


    }
}

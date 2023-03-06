package com.example.uberfare;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView driver = (TextView)findViewById(R.id.driverBox);

        String[] name = {"Jeremy Craig", "Lawrence Douglas", "Tucker Carlson", "Jerry Springer", "Harry Jacobs"};
        int nameLength = name.length;
        Random random = new Random();
        driver.setText(String.format("Your driver %s is on their way", name[random.nextInt(nameLength)]));

        TextView randomTime = (TextView)findViewById(R.id.randomETA);
        randomTime.setText(String.format("Possible Estimated Time of Arrival:\n %d Minutes", random.nextInt(60)));

    }
}

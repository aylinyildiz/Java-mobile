package com.example.buttontypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCalculator, btnAge, btnMass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculator = findViewById(R.id.btn_Calculator);
        btnAge = findViewById(R.id.btn_Age);
        btnMass = findViewById(R.id.btn_Mass);

        btnMass.setOnClickListener(this);
        btnCalculator.setOnClickListener(this);
        btnAge.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int ID = view.getId();
        Intent i;
        switch (ID){
            case R.id.btn_Calculator:
                //bir activityden diğer activitye intent ile gideriz.
                i = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Age:
                i = new Intent(MainActivity.this, AgeActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Mass:
                i = new Intent(MainActivity.this, MassActivity.class);
                startActivity(i);
                break;
        }

    }
}
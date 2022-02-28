package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.btn_Mass:
                //intent farklı activityler arasında geçiş yapmayı sağlar
               // Intent i = new Intent(MainActivity.this, MassActivity.class);
                i = new Intent(MainActivity.this, MassActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Calculator:
                i = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Age:
                i = new Intent(MainActivity.this, AgeActivity.class);
                startActivity(i);
        }
    }
}
package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etFirstNumber, etSecondNumber;
    Button btnAdd, btnSubtract, btnMultiply, btnDivision;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirstNumber = findViewById(R.id.et_FirstNumber);
        etSecondNumber = findViewById(R.id.et_SecondNumber);
        btnAdd = findViewById(R.id.btn_Add);
        btnSubtract = findViewById(R.id.btn_Subtract);
        btnMultiply = findViewById(R.id.btn_Multiply);
        btnDivision = findViewById(R.id.btn_Division);
        tvResult = findViewById(R.id.tv_Result);
    }

    public void ButtonClick(View v){
        int ID = v.getId();
        int firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
        int secondNumber = Integer.parseInt(etSecondNumber.getText().toString());
        int result = 0;

        switch (ID){
            case R.id.btn_Add: result = firstNumber + secondNumber; break;
            case R.id.btn_Subtract: result = firstNumber - secondNumber; break;
            case R.id.btn_Multiply: result = firstNumber * secondNumber; break;
            case R.id.btn_Division: result = firstNumber / secondNumber; break;
        }

        tvResult.setText("Sonuç:" + result);

    }
}
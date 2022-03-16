package com.example.buttontypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber;
    Button btnAdd, btnSubtract, btnMultiply, btnDivision;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
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
        String first =etFirstNumber.getText().toString();
        String second = etSecondNumber.getText().toString();


        if(!TextUtils.isEmpty(first) && !TextUtils.isEmpty(second)){
            double firstNumber = Double.parseDouble(first);
            double secondNumber = Double.parseDouble(second);
            double result = 0.0;

            switch (ID){
                case R.id.btn_Add: result = firstNumber + secondNumber; break;
                case R.id.btn_Subtract: result = firstNumber - secondNumber; break;
                case R.id.btn_Multiply: result = firstNumber * secondNumber; break;
                case R.id.btn_Division:
                    if(secondNumber!=0)
                        result = firstNumber / secondNumber;
                    else
                            Toast.makeText(getApplicationContext(), "Divided by 0 error", Toast.LENGTH_SHORT).show();
                    break;
            }
            tvResult.setText("Sonuç:" + result);
        }else{
            Toast.makeText(getApplicationContext(), "You did not enter two numbers", Toast.LENGTH_SHORT).show();
        }


    }
}
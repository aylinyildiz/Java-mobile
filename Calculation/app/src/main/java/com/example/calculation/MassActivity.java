package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MassActivity extends AppCompatActivity {

    EditText etWeight, etHeight;
    Button btnMassCalculate;
    TextView tvMassValue, tvMassInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        etWeight=findViewById(R.id.et_weight);
        etHeight=findViewById(R.id.et_height);
        btnMassCalculate=findViewById(R.id.btn_MassCalculation);
        tvMassInfo=findViewById(R.id.tv_MassInfo);
        tvMassValue=findViewById(R.id.tv_MassValue);

        btnMassCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double weight = Double.parseDouble(etWeight.getText().toString());
                Double height = Double.parseDouble(etHeight.getText().toString());
                Double massIndex = weight/Math.pow(height,2);
                tvMassValue.setText(String.valueOf(massIndex));
                if(massIndex > 25){
                    tvMassInfo.setText("Obex");
                }else{
                    tvMassInfo.setText("Normal");
                }
            }
        });


    }
}
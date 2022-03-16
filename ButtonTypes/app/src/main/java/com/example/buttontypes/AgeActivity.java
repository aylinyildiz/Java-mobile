package com.example.buttontypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeActivity extends AppCompatActivity {
    Button btnAge;
    EditText etBirthYear;
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        btnAge = findViewById(R.id.btn_AgeCalculator);
        etBirthYear = findViewById(R.id.et_BirthYear);
        tvAge = findViewById(R.id.tv_Age);

        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_birthYear = etBirthYear.getText().toString();
                int age =0;
                if(!TextUtils.isEmpty(str_birthYear)){
                    int birth_Year = Integer.parseInt(str_birthYear);
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    if(birth_Year <= currentYear)
                        age = currentYear-birth_Year;
                    else
                        Toast.makeText(getApplicationContext(), "You entered a wrong birth year", Toast.LENGTH_SHORT).show();
                    tvAge.setText("Your age is :" + age);

                }
            }
        });
    }
}
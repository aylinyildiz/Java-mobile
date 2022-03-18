 package com.example.intentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSmsService, btnMailService, btnLinkService, btnShareService, btnReturn;
    final static int REQUEST_CODE=100;
    TextView tvReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSmsService = findViewById(R.id.btn_SMSService);
        btnMailService = findViewById(R.id.btn_MailService);
        btnLinkService = findViewById(R.id.btn_LinkService);
        btnShareService = findViewById(R.id.btn_SMSService);
        tvReturn = findViewById(R.id.tv_Return);
        btnReturn = findViewById(R.id.btn_Return);
        btnSmsService.setOnClickListener(this);
        btnMailService.setOnClickListener(this);
        btnLinkService.setOnClickListener(this);
        btnShareService.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }


     @Override
     public void onClick(View view) {
         int ID = view.getId();
         Intent intent;
         switch (ID){
             case R.id.btn_SMSService:
                 intent = new Intent(MainActivity.this, SmsActivity.class);
                 startActivity(intent);
                 break;
             case R.id.btn_MailService:
                 intent = new Intent(MainActivity.this, MailActivity.class);
                 startActivity(intent);
                 break;
             case R.id.btn_LinkService:
                 intent = new Intent(MainActivity.this, LinkActivity.class);
                 startActivity(intent);
                 break;
             case R.id.btn_ShareService:
                 intent = new Intent(MainActivity.this, ShareActivity.class);
                 startActivity(intent);
                 break;
             case R.id.btn_Return:
                 intent = new Intent(MainActivity.this, ReturnActivity.class);
                 startActivityForResult(intent, REQUEST_CODE);
                 break;
         }
     }
     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if(requestCode ==REQUEST_CODE)
             if(resultCode == Activity.RESULT_OK){
                 String name = data.getStringExtra("USERNAME");
                 tvReturn.setText(name);
             }
     }

 }
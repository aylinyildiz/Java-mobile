package com.example.callapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton ibCall;
    EditText etPhoneNumber;
    final static int CALL_REQUEST=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibCall = findViewById(R.id.ib_Call);
        etPhoneNumber = findViewById(R.id.et_PhoneNumber);

        ibCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ilk adım izin var mı kontrol etmeliyiz
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
                    Call();
                else{//izin verilmemişse izin isteriz
                    //----kullanıcının kafası karışık mı----
                    if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Info");
                        builder.setMessage("This application needs CALL permision to call someone");
                        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.show();
                    }
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},CALL_REQUEST);

                }

            }
        });
    }

    private void Call() {
        String phoneNumber = etPhoneNumber.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(callIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CALL_REQUEST){
            //tek istek olduğu için 0 dedik.
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
                Call();
            else //izin verilmediyse
                Toast.makeText(getApplicationContext(), "You have denied to call process", Toast.LENGTH_SHORT).show();
        }
    }
}
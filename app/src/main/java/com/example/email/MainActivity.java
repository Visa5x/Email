package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText etMsg,etSub,etAddr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAddr=findViewById(R.id.etAddr);
        etMsg=findViewById(R.id.etMsg);
        btnSend=findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAddress=etAddr.getText().toString();
                String userMessage=etMsg.getText().toString();
                String userSubject=etSub.getText().toString();

                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto"));
                emailIntent.setType("text/plain");
                String []mailaddress={userAddress};
                emailIntent.putExtra(Intent.EXTRA_EMAIL,mailaddress);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,userMessage);
                startActivity(Intent.createChooser(emailIntent,"Send Email"));














            }
        });

    }
}
package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView tvWelcome;
    Button btnLogout;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvWelcome=findViewById(R.id.tvWelcome);
        btnLogout=findViewById(R.id.btnLogout);

        sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
        String user=sharedPreferences.getString("user","Failed");

        if(user!=null && user!="Failed")
        {
            tvWelcome.setText("Welcome"+user);
        }
        else
        {
            Intent intent=new Intent(Welcome.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                Intent intent=new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
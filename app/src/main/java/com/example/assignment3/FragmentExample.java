package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                Fragment fragment = null;
                if(view == findViewById(R.id.button1)){
                    fragment = new OneFragment();
                } else {
                    fragment = new TwoFragment();
                }
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.output, fragment);
                transaction.commit();
            }
        };
        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(listener);
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(listener);
    }

}


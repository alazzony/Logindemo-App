package com.my.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomActivity extends MainActivity {

    public TextView textWelcom, textGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        textWelcom = findViewById(R.id.textWelcom);
        textGoBack = findViewById(R.id.goBack);

        Intent i = getIntent();
        String name = i.getStringExtra("user_name");
        textWelcom.setText("Welcom \n " + name);


        textGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });


    }
}
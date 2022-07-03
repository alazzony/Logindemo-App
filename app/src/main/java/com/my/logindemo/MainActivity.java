package com.my.logindemo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputName, inputPassword;
    TextView attempt;
    Button btnLogin;
    String Name = "Maram Alazzony";
    String Password = "12345";
    int count = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_in);

        inputName = findViewById(R.id.inputName);
        inputPassword = findViewById(R.id.inputPassword);
        attempt = findViewById(R.id.attempRemin);
        btnLogin = findViewById(R.id.btnLogin);
        //Log.d(TAG, "Value is: " );


        btnLogin.setOnClickListener(new View.OnClickListener() {
            // @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                inputInfo();

            }


            public void inputInfo() {


                String userName = inputName.getText().toString();
                String userPassword = inputPassword.getText().toString();

                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter information correctly", Toast.LENGTH_SHORT).show();


                } else if (userName.equals(Name) && userPassword.equals(Password)) {

                    loginSuccessful();

                } else {

                    failedLogin();

                }

            }

            public void loginSuccessful() {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), WelcomActivity.class);
                i.putExtra("user_name", inputName.getText().toString());
                startActivity(i);
            }


            //@SuppressLint("ResourceAsColor")
            public void failedLogin() {

                count--;

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 20, 40);

                TextView tv = new TextView(MainActivity.this);
                // tv.setBackgroundColor(R.color.gray);
                tv.setBackgroundResource(R.drawable.toast_border);
                //tv.setBackgroundResource(R.color.white);

                tv.setTextColor(Color.GRAY);
                tv.setTextSize(12);

                Typeface typeface = Typeface.create("serif", Typeface.BOLD_ITALIC);
                tv.setTypeface(typeface);
                tv.setPadding(35, 35, 35, 35);
                tv.setText("The information entered is incorrect,Try again");
                toast.setView(tv);
                toast.show();
                attempt.setText("Not of attempts remaining: " + count);

                if (count == 0) {
                    btnLogin.setEnabled(false);
                    btnLogin.setBackgroundResource(R.drawable.border_login_disenable);

                    attempt.setText("There was an error logging in, your attempts failed ");
                    attempt.setTextSize(12);
                    attempt.setTextColor(Color.parseColor("#FF0505"));
                }
            }


        });

    }


}



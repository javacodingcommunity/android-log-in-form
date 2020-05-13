package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPassword;
    private Button sendInfoButton;
    private int counter = 5;
    private TextView attempts;
    private Boolean isBlocked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        sendInfoButton = findViewById(R.id.button);
        attempts = findViewById(R.id.attempts);


        sendInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userEmail.getText().toString().equals("info@javacodingcommunity.com") && userPassword.getText().toString().equals("123")) {
                    if(!isBlocked) {
                        Toast.makeText(MainActivity.this,"Success!",Toast.LENGTH_LONG).show();
                        switchAcitvity();
                    }
                }
                else {
                    if(counter >= 2) {
                        counter--;
                        Toast.makeText(MainActivity.this,"Invalid Input!",Toast.LENGTH_LONG).show();
                        attempts.setText("You have "+ counter +" attempts left!");
                    }
                    else {
                        isBlocked = true;
                        attempts.setText("You've been blocked!");
                    }
                }

            }
        });

    }

    private void switchAcitvity() {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}

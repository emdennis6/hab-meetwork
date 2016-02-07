package com.hab.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.button);
        signupBtn = (Button) findViewById(R.id.button2);

        loginBtn.setOnClickListener(this);
        signupBtn.setOnClickListener(this);
    }

    /**
     * Switches the activity when button 1 (login) is clicked
     * Transitions into the Existing login page
     */
    private void button1Click() {
        startActivity(new Intent("com.hab.newapp.ExistingLoginActivity"));
    }

    /**
     * Switches the activity when button 2 (Sign up) is clicked
     * Transitions into the Sign up page
     */
    private void button2Click() {
        startActivity(new Intent("com.hab.newapp.SignUpActivity"));
    }

    /**
     * Sets up the onClick environment for the button and calls the appropriate methods
     * based on which button you clicked
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                button1Click();
                break;
            case R.id.button2:
                button2Click();
                break;
        }
    }


}

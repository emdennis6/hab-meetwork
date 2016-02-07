package com.hab.newapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ExistingLoginActivity extends AppCompatActivity implements View.OnClickListener {


    private HashMap<String, String> database;
    private Button existingLoginBtn;
    private Button linkedInBtn;

    /**
     * Test database for simple purposes
     */
    public void addToDatabase(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.test)));
        String dbentry = reader.readLine();

        this.database = new HashMap<String, String>();

        // loop until you reach the end of the file
        while (dbentry != null) {
            String[] userandpw = dbentry.split(",");
            this.database.put(userandpw[0], userandpw[1]); // adds the username and password to the database hash map
            dbentry = reader.readLine();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_login);

        existingLoginBtn = (Button) findViewById(R.id.regular_login);
        linkedInBtn = (Button) findViewById(R.id.linkedin);

        existingLoginBtn.setOnClickListener(this);
        linkedInBtn.setOnClickListener(this);

        try {
            addToDatabase("test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lets the user log in with the supplied credentials
     * Sends them to screen 1 - message board
     */
    private void regLoginClick() {
        EditText inputUserID = (EditText) findViewById(R.id.editText3);
        EditText inputPW = (EditText) findViewById(R.id.editText4);
        String queryUsername = inputUserID.getText().toString();
        String queryPW = inputPW.getText().toString();
        TextView errorText = new TextView(this);

        if (!this.database.containsKey(queryUsername)) {
            errorText.setText("Incorrect username - please try again.");
            ((RelativeLayout) findViewById(R.id.layout)).addView(errorText);

            return;
        } else if (!this.database.containsKey(queryPW)) {
            errorText.setText("Incorrect password - please try again.");
            ((RelativeLayout) findViewById(R.id.layout)).addView(errorText);
            return;
        }


        startActivity(new Intent("MainActivity")); // change this to the list screen
    }

    /**
     * Lets the user log in with LinkedIn
     */
    private void linkedInClick() {
//        startActivity(new Intent("com.hab.newapp.LinkedInActivity")); // implement LinkedIn API
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regular_login:
                regLoginClick();
                break;
            case R.id.linkedin:
                linkedInClick();
                break;
        }
    }
}

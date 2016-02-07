package hi.meetwork;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        startActivity(new Intent("hi.meetwork.ExistingLoginActivity"));
    }

    /**
     * Switches the activity when button 2 (Sign up) is clicked
     * Transitions into the Sign up page
     */
    private void button2Click() {
        startActivity(new Intent("hi.meetwork.SignUpActivity"));
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

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

<<<<<<< HEAD
        loginBtn = (Button) findViewById(R.id.button);
        signupBtn = (Button) findViewById(R.id.button2);

        loginBtn.setOnClickListener(this);
        signupBtn.setOnClickListener(this);
=======
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        {
            rules: {
                ".read": true,
                ".write": false
            }
        }

        {
            people: {
                $userid: {
                    ".write": $userid == auth.id
                }
            }
        }


        {
            users: {
                $userid: {
                    ".write": $userid == auth.id,
                            following: {},
                    followers: {},
                    feed: {}
                }
            }

            {
                feed: {
                    "$sparkid": {
                        ".write":
                        root.child('users/' + $userid + '/following').hasChild(auth.id) &&
                                root.child('sparks/' + $sparkid + '/author').val() == auth.id
                    }
                }
            }

            Firebase ref = new Firebase("https://fiery-heat-5087.firebaseio.com/");
       // ref.child("users").child("alanisawesome").push().setValue("hello");

        Firebase usersRef = ref.child("users");

        Map<String, String> alanisawesomeMap = new HashMap<String, String>();
        alanisawesomeMap.put("birthYear", "1912");
        alanisawesomeMap.put("fullName", "Alan Turing");

        Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
        users.put("alanisawesome", alanisawesomeMap);

        usersRef.setValue(users);
>>>>>>> 06f15bb41aa7c2333f31acbb417d330450e6e2fc
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

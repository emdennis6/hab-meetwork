package hi.meetwork;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ListSelect extends AppCompatActivity {

    private TextView BigText;
    private CollapsingToolbarLayout Topic_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String data = (String)getIntent().getExtras().get("message");
        Log.i("Test",data);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        BigText = (TextView) findViewById(R.id.BigText);
        BigText.setText(data);
        Topic_Layout = (CollapsingToolbarLayout) findViewById(R.id.Topic_Layout);
        Topic_Layout.setTitle(data);


    }
}

package hi.meetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MessageBoard extends AppCompatActivity {

    private ListView info_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.Messageboard);
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

        info_items = (ListView) findViewById(R.id.info_items);
        final List<String> generated_list = new ArrayList<String>();
        generated_list.add("Hopefully");
        generated_list.add("This Works");
        Event TestEvent = new Event("Fight Me Scrub", 0, "This may be a very long description");
        ArrayList<Event> TestEventList = new ArrayList<Event>();
        TestEventList.add(TestEvent);
        for(int i = 0; i <= 12; i++){
            generated_list.add(TestEvent.getTopic());
        }

        info_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(view.getContext(), ListSelect.class);
                    String message = generated_list.get(position);
                    intent.putExtra("message", message);
                    startActivity(intent);
            }
        });



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                generated_list);

        info_items.setAdapter(arrayAdapter);

    }

    void populateArrayList(ArrayList<Object> generated_list){

    }

}

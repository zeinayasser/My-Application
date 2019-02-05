package com.example.thermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
   private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String values[]=new String[]{"Android","IOS","Blackberry","Windows"};
        listView=findViewById(R.id.list_item);
        ArrayAdapter<String>  adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Intent myIntent = new Intent(ListActivity.this, DeviceDetailActivity.class);

                                                startActivity(myIntent);
                                            }
                                        });





        }
    }


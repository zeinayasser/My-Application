package com.example.thermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
   private ListView listView;
     int[] images ={R.drawable.android,
     R.drawable.ios,R.drawable.blackberry,R.drawable.windows};
     String[] names ={"android","IOS","Blackberry","Windows"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
       // String values[]=new String[]{"android","IOS","Blackberry","Windows"};
        listView=(ListView) findViewById(R.id.list_item);
        CostumAdapter costumAdapter=new CostumAdapter();
        listView.setAdapter(costumAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(ListActivity.this, DeviceDetailActivity.class);

                startActivity(myIntent);
                                            }
                                        });





        }
        class CostumAdapter extends BaseAdapter{

            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.costumlayout,null);
                ImageView imageView =convertView.findViewById(R.id.imageView11);
                TextView textView = convertView.findViewById(R.id.TextView112);
                imageView.setImageResource(images[position]);
                textView.setText(names[position]);
                return convertView;
            }
        }
    }


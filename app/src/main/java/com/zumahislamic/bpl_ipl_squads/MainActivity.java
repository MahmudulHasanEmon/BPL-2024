package com.zumahislamic.bpl_ipl_squads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        gridView.setAdapter(new Adapter());






    }
    private class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 4;
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
            LayoutInflater layoutInflater=getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.main_layout,parent,false);
            String [] ddd={"দল ও খেলোয়াড়","স্টেডিয়াম","পয়েন্ট টেবিল","কে কত টাকা পাবে"};

            RelativeLayout claick=view.findViewById(R.id.claick);
            TextView textView=view.findViewById(R.id.hhhhhhhhhh);
            textView.setText(ddd[position]);



            claick.setOnClickListener(v -> {
                if (position==0) startActivity(new Intent(getApplicationContext(),SquadsActivity.class));
                else if (position==2) startActivity(new Intent(getApplicationContext(),PointActivity.class));
            });



            return view;
        }
    }
}
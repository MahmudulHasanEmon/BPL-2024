package com.zumahislamic.bpl_ipl_squads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SquadsActivity extends AppCompatActivity {

    String [] doll_list={"দুরন্ত ঢাকা","কুমিল্লা ভিক্টোরিয়ান্স","চট্টগ্রাম চ্যালেঞ্জার্স","খুলনা টাইগার্স","রংপুর রাইডার্স","ফরচুন বরিশাল","সিলেট স্ট্রাইকার্স"};
    int [] doll_icon_list={R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squads);
        GridView gridView=findViewById(R.id.gridView);
        gridView.setAdapter(new Adapter());
        findViewById(R.id.back).setOnClickListener(v -> onBackPressed());


    }
    private class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return doll_list.length;
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
            View view=layoutInflater.inflate(R.layout.squads_grid_itme,parent,false);

            RelativeLayout claick=view.findViewById(R.id.claick);
            ImageView doll_icon=view.findViewById(R.id.CircleImageView);
            TextView textView=view.findViewById(R.id.name);

            textView.setText(doll_list[position]);
            doll_icon.setImageResource(doll_icon_list[position]);



            claick.setOnClickListener(v -> {
                if (position==0) {
                    MainSquads.NAME="dhaka";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }else if (position==1) {
                    MainSquads.NAME="comilla";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }else if (position==2) {
                    MainSquads.NAME="chattogram";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }else if (position==3) {
                    MainSquads.NAME="khulna";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }else if (position==4) {
                    MainSquads.NAME="rangpur";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }else if (position==5) {
                    MainSquads.NAME="barishal";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }else if (position==6) {
                    MainSquads.NAME="sylhet";
                    MainSquads.doolNAME=doll_list[position];
                    startActivity(new Intent(getApplicationContext(),MainSquads.class));
                }
            });



            return view;
        }
    }

}
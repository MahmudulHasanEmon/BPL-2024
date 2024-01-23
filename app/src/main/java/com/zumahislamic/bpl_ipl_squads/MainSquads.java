package com.zumahislamic.bpl_ipl_squads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainSquads extends AppCompatActivity {
    List<model> modelList = new ArrayList<>();
    List<model2> modelList2 = new ArrayList<>();
    TextView textView,textView2,toolBarText;RecyclerView recyclerView,recyclerView2;
    public static String NAME;
    public static String doolNAME;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_squads);
        textView = findViewById(R.id.pppppppp);
        textView2 = findViewById(R.id.ppppp);
        textView2 = findViewById(R.id.ppppp);
        toolBarText = findViewById(R.id.toolbarText);
        JSONObjectFile();
        recyclerView = findViewById(R.id.listView);
        recyclerView2 = findViewById(R.id.listView2);
        recyclerView.setAdapter(new Adapter());
        recyclerView2.setAdapter(new Adapter2());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        textView.setText("দেশি ক্রিকেটার " + getStringInBangla("" + modelList.size()) + "জন");
        textView2.setText("বিদেশি ক্রিকেটার " + getStringInBangla("" + modelList2.size()) + "জন");

        toolBarText.setText(doolNAME+" স্কোয়াড");
        findViewById(R.id.back).setOnClickListener(v -> onBackPressed());


    }

    private class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.playar_itma_bangladesh, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.Name.setText(modelList.get(position).getName());
            holder.Category.setText(modelList.get(position).getCategory());
            holder.Country.setText(modelList.get(position).getCountry());
            int i=position;
            int ii= 1+i;
            holder.Number.setText(getStringInBangla(""+ii));


        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            RelativeLayout baackground, baackground2;
            TextView Name, Number, Country, Category;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                baackground = itemView.findViewById(R.id.baackground);
                baackground2 = itemView.findViewById(R.id.baackground2);
                Name = itemView.findViewById(R.id.name);
                Number = itemView.findViewById(R.id.number);
                Country = itemView.findViewById(R.id.addres);
                Category = itemView.findViewById(R.id.catagori);
            }
        }
    }
    private class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.playar_itma_bangladesh, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.Name.setText(modelList2.get(position).getName());
            holder.Category.setText(modelList2.get(position).getCategory());
            holder.Country.setText(modelList2.get(position).getCountry());
            int i=position;
            int ii= 1+i;
            holder.Number.setText(getStringInBangla(""+ii));

        }

        @Override
        public int getItemCount() {
            return modelList2.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            RelativeLayout baackground, baackground2;
            TextView Name, Number, Country, Category;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                baackground = itemView.findViewById(R.id.baackground);
                baackground2 = itemView.findViewById(R.id.baackground2);
                Name = itemView.findViewById(R.id.name);
                Number = itemView.findViewById(R.id.number);
                Country = itemView.findViewById(R.id.addres);
                Category = itemView.findViewById(R.id.catagori);
            }
        }
    }


    private void JSONObjectFile() {
        try {
            JSONObject jsonObject = new JSONObject(lodeJSONfromAssets());
            JSONArray jsonArray = jsonObject.getJSONArray(NAME);

            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("bangladesh");
            JSONArray jsonArray11 = jsonObject1.getJSONArray("toor");

            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
                modelList.add(new model(jsonObject2.getString("name"),
                        jsonObject2.getString("image"),
                        jsonObject2.getString("category"),
                        jsonObject2.getString("country")));

            }
            for (int i = 0; i < jsonArray11.length(); i++) {
                JSONObject jsonObject22 = jsonArray11.getJSONObject(i);
                modelList2.add(new model2(jsonObject22.getString("name"),
                        jsonObject22.getString("image"),
                        jsonObject22.getString("category"),
                        jsonObject22.getString("country")));



            }


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    private String lodeJSONfromAssets() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("all_squads.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }

    public String getStringInBangla(String string) {
        Character[] bangla_number = {'০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯'};
        Character[] eng_number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder values = new StringBuilder();
        char[] character = string.toCharArray();

        for (char value : character) {
            char c = ' ';
            for (int j = 0; j < eng_number.length; j++) {
                if (value == eng_number[j]) {
                    c = bangla_number[j];
                    break;
                } else {
                    c = value;
                }
            }
            values.append(c);
        }

        return values.toString();
    }


}
package com.example.json_file_parsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     ArrayList<Country> countryNames = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {

            String json= loadJSONFromAsset();
            // create a json object

            JSONArray countryarray = new JSONArray(json);



            for(int i=0;i<countryarray.length();i++){

                JSONObject countrydetail = countryarray.getJSONObject(i);

                Country country=new Country(countrydetail.getString("name"),"");
                countryNames.add(country);

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        CountryAdapter customAdapter = new CountryAdapter(MainActivity.this, countryNames);

        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


    }

    public String loadJSONFromAsset() {

        try {
            InputStream is = getAssets().open("country.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }


    }
    }


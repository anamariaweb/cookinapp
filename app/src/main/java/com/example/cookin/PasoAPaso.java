package com.example.cookin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PasoAPaso extends AppCompatActivity {

    private ArrayList<JSONObject> pasosData;
    private RecyclerView recyclerView;
    private PasosAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso_apaso);
        setTitle("PREPARACIÓN");

        recyclerView = findViewById(R.id.recicle);

        Bundle extras = getIntent().getExtras();

        pasosData = new ArrayList<>();

        try {
            JSONArray pasos = new JSONArray(extras.getString("pasos"));
            for (int i = 0; i < pasos.length(); i++) {
                pasosData.add((JSONObject) pasos.get(i));
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            pAdapter = new PasosAdapter(this, pasosData);
            recyclerView.setAdapter(pAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
package com.example.cookin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cookin.json.ReadJSONFile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Principiante extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principiante);
        setTitle("PRINCIPIANTE");

        View backgroundimage = findViewById(R.id.principiante);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(95);

    }


    public void openRecipe(View view) {
        String view_name = view.getResources().getResourceName(view.getId());
        String[] view_name_parts = view_name.split("/");
        String recipe_name = view_name_parts[1];

        Bundle recipe_info = ReadJSONFile.getRecipe(recipe_name, this.getBaseContext());

        if (recipe_info.size() > 0) {
            Intent receta = new Intent(this, Receta.class);
            receta.putExtras(recipe_info);
            startActivity(receta);
        }
        else {
            Toast.makeText(this, R.string.recipe_not_exist, Toast.LENGTH_SHORT).show();
        }

    }
}
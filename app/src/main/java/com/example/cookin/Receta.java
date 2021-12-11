package com.example.cookin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;

public class Receta extends AppCompatActivity {

    private ImageView recipeImg;

    private TextView recipeTitle, recipeTime, recipeIngredients;

    FloatingActionButton btnPasos, btnUbica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        btnUbica = findViewById(R.id.btn_ordermaps);
        btnPasos = findViewById(R.id.btn_play);


        View backgroundimage = findViewById(R.id.receta);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(80);

        recipeTitle = findViewById(R.id.recipe_title);
        recipeTime = findViewById(R.id.recipe_time);
        recipeIngredients = findViewById(R.id.ingredients);
        recipeImg = findViewById(R.id.recipe_img);


        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        setTitle("Detalle de la receta");
        recipeTitle.setText(title);
        recipeTime.setText(extras.getString("time") + " MIN");
        int id = getResources().getIdentifier(extras.getString("img"), "drawable", getPackageName());
        recipeImg.setImageResource(id);

        try {
            String ing_txt = "";

            JSONArray ingredients = new JSONArray(extras.getString("ingredients"));
            for (int i=0; i < ingredients.length(); i++) {
                ing_txt = ing_txt.concat(ingredients.get(i).toString() + "\n");
            }
            recipeIngredients.setText(ing_txt);
        } catch (JSONException e) {
            e.printStackTrace();

        }



        btnPasos.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),PasoAPaso.class);
            intent.putExtra("pasos", extras.getString("preparation"));
            startActivity(intent);
        });

        btnUbica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);

            }
        });
    }


}
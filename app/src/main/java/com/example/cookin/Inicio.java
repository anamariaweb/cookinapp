package com.example.cookin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    String x= "Texto de prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        setTitle("CATEGORIAS");

        View backgroundimage = findViewById(R.id.inicio);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(95);
    }

    public void nPrincipiante(View view){
        Intent i = new Intent(this, Principiante.class);

        i.putExtra("dato01", x);
        i.putExtra("dato02","...");
        startActivity(i);

    }
    public void nIntermedio(View view){
        Intent i = new Intent(this, Intermedio.class);
        startActivity(i);


    }
    public void nAvanzado(View view){
        Intent i = new Intent(this, Avanzado.class);
        startActivity(i);

    }
    public void nExperto(View view){
        Intent i = new Intent(this, Experto.class);
        startActivity(i);

    }
    public void nChef(View view){
        Intent i = new Intent(this, Chef.class);
        startActivity(i);

    }

}
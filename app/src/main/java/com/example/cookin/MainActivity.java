package com.example.cookin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void iSesion(View view)
    {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }


    public void iRegistrarse(View view)
    {
        Intent i = new Intent(this, Registro.class);
        startActivity(i);





    }


}
package com.example.cookin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText emaill, usuar, contraseña, contraseña_conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setTitle("REGISTRO");

        emaill = findViewById(R.id.correo);
        usuar = findViewById(R.id.usua);
        contraseña = findViewById(R.id.contrasena);
        contraseña_conf = findViewById(R.id.contrasena_conf);
    }

    public void nInicio(View view)
    {
        adminSQLite admin = new adminSQLite(this, "administracion", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String correo = emaill.getText().toString();
        String persona = usuar.getText().toString();
        String password = contraseña.getText().toString();
        String passwconfi = contraseña_conf.getText().toString();

        if(!correo.isEmpty() && !persona.isEmpty() && !password.isEmpty() && !passwconfi.isEmpty()){

            if(password.equals(passwconfi))
            {

                ContentValues registro = new ContentValues();
                registro.put("email", correo);
                registro.put("usuario", persona);
                registro.put("password", password);

                BasedeDatos.insert("usuarios", null, registro);
                BasedeDatos.close();
                emaill.setText("");
                usuar.setText("");
                contraseña.setText("");
                contraseña_conf.setText("");

                Toast.makeText(this, "El Registro se Realizo Exitosamente", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Login.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(this, "Debe Digitar todos los Campos", Toast.LENGTH_SHORT).show();

        }


    }
}
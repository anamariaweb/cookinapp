package com.example.cookin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("INGRESO");

        email = findViewById(R.id.correo);
        contrasena = findViewById(R.id.clave);

    }

    public void nInicio(View view)
    {
        adminSQLite admin = new adminSQLite(this, "administracion", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String correo = email.getText().toString();
        String clave = contrasena.getText().toString();

        if (!correo.isEmpty() && !clave.isEmpty())
        {
            Cursor fila = BasedeDatos.rawQuery( "select usuario from Usuarios where email = ? and password = ?", new String[] {correo, clave});

            if(fila.moveToFirst()){
                BasedeDatos.close();
                Intent i = new Intent(this, Inicio.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "El Usuario no existe", Toast.LENGTH_LONG).show();
            }

        }
        else {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();

        }



    }
}
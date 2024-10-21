package com.example.practica_base_de_datos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.practica_base_de_datos.db.dbHelper;

public class MainActivity extends AppCompatActivity {
    Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbHelper db_helper = new dbHelper(MainActivity.this);
                SQLiteDatabase db = db_helper.getWritableDatabase();

                if (db!=null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA DE FORMA EXITOSA",Toast.LENGTH_LONG).show();




                }

                else {

                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS",Toast.LENGTH_LONG).show();


                }

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

/* Url del video: https://www.youtube.com/watch?v=iWQIXjQ8ucA      */
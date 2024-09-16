package com.example.laboratorio_controles_android_studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {
    private Button boton; //Declaracion de las variables para los botones
    private Button boton2;
    private ProgressBar progressBar; //Declaracion de la variable para el progressBar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        boton = findViewById(R.id.Button_A3); // Asociacion de los botones con el respectivo id
        boton2 = findViewById(R.id.Button_S3);
        progressBar = findViewById(R.id.progressBar); // Asociacion del progressbar con el id
        progressBar.setProgress(75); // Establecemos el progreso al 75%
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        }); // Evento del boton que ira de vuelta al segundo activity


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, Fourth_Activity.class);
                startActivity(intent);
            }
        }); // Evento del boton que ira al cuarto activity



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
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

public class Fourth_Activity extends AppCompatActivity {
    private Button boton; // Declaracion de la variable para el boton
    private ProgressBar progressBar; //Declaracion de la variable para la barra de progreso
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        boton = findViewById(R.id.Button_A4); // Asociacion de la variable con el id del boton
        progressBar = findViewById(R.id.progressBar); // Asociacion de la variable con el id del progressBar
        progressBar.setProgress(100); // Establecemos el progreso al 100%

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fourth_Activity.this, ThirdActivity.class);
                startActivity(intent);
            }
        }); // Evento que asocia el boton a volver al tercer activity

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
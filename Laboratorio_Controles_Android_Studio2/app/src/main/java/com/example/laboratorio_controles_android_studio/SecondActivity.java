package com.example.laboratorio_controles_android_studio;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private Button boton; //Declaracion de las variables para los botones
    private Button boton2;
    private ProgressBar progressBar; // Declaracion de la variable para la barra de progreso
    private EditText fechaNac; //Declaracion de la variable fechaNac
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        boton = findViewById(R.id.Button_A4); // Asociacion de los botones con el respectivo id
        boton2 = findViewById(R.id.Button_S2);

        progressBar = findViewById(R.id.progressBar); // Asociacion del progressBar con su id
        progressBar.setProgress(50); // Establecemos el progreso al 50%

        fechaNac = findViewById(R.id.editTextFechaN); // Asociacion del id con la variable fechaNac

        fechaNac.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String texto = s.toString();
                if (texto.length() > 0) {
                    if (texto.length() == 2) {
                        if (!texto.endsWith("/")) {
                            texto += "/";
                            fechaNac.setText(texto);
                            fechaNac.setSelection(fechaNac.getText().length());
                        }
                    } else if (texto.length() == 5) {
                        if (!texto.endsWith("/")) {
                            texto += "/";
                            fechaNac.setText(texto);
                            fechaNac.setSelection(fechaNac.getText().length());
                        }
                    } else if (texto.length() > 10) {
                        fechaNac.setText(texto.substring(0, 10));
                        fechaNac.setSelection(fechaNac.getText().length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }); // Evento del boton que ira de vuelta al primer activity


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        }); // Evento del boton que ira al tecer activity

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

// Joy Nelaton - Josue Perez 
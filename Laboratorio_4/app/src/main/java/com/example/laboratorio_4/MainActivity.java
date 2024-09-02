package com.example.laboratorio_4;

import static java.lang.String.*;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    Button btnIr;     /* Declaracion del boton */
    Button btnDeterminar;
    TextView InEdad;
    TextView Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnIr = (Button)findViewById(R.id.btnIr);
        Button btnDeterminar = (Button)findViewById(R.id.btnDeterminar);
        TextView InEdad = (TextView)findViewById(R.id.InEdad);
        TextView Resultado = (TextView)findViewById(R.id.Resultado);
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent packageContext;
                Intent btnIr = new Intent (MainActivity.this, SecondActivity.class); /* Llamada a la segunda actividad */
                startActivity(btnIr);

            }

        });

        btnDeterminar.setOnClickListener(new View.OnClickListener(){
             @SuppressLint("SetTextI18n")
             @Override
            public void onClick (View v) {
              String edadTexto = InEdad.getText().toString();
              if (!edadTexto.isEmpty()){

                  try {
                  int aNacimiento = Integer.parseInt(edadTexto);
                  int aActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                  int edad = aActual - aNacimiento;
                  Resultado.setText(MessageFormat.format("Edad {0}", edad));

              } catch (NumberFormatException exception) {
                   Resultado.setText("Por favor valide el dato ingresado: ");

                 }

             }

              else {

                  Resultado.setText("Por favor ingrese el dato solicitado: ");

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

/* Joy Nelaton */
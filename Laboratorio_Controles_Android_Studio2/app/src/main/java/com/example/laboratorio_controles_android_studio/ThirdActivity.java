package com.example.laboratorio_controles_android_studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {
    private Button boton; //Declaracion de las variables para los botones
    private Button boton2;
    private ProgressBar progressBar; //Declaracion de la variable para el progressBar
    private EditText telefono; // Declaracion de las variables asociadas a los editText
    private EditText direccion;
    private EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        boton = findViewById(R.id.Button_A3); // Asociacion de los botones con el respectivo id
        boton2 = findViewById(R.id.Button_S3);
        progressBar = findViewById(R.id.progressBar); // Asociacion del progressbar con el id
        progressBar.setProgress(75); // Establecemos el progreso al 75%

        telefono = findViewById(R.id.editTextTelefono); // Asociacion de los edittexts con sus ids
        direccion = findViewById(R.id.editTextDirec);
        correo = findViewById(R.id.editTextCorreo);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampos()) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);

                }

                else  {
                    Toast.makeText(ThirdActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        }); // Evento del boton que ira de vuelta al segundo activity


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampos()) {
                Intent intent = new Intent(ThirdActivity.this, Fourth_Activity.class);
                startActivity(intent);

                }

                else  {
                    Toast.makeText(ThirdActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        }); // Evento del boton que ira al cuarto activity



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





    }



    private boolean validarCampos() {   //Validar que no se dejen los editText vacios
        return
                !telefono.getText().toString().isEmpty() &&
                !direccion.getText().toString().isEmpty() &&
                !correo.getText().toString().isEmpty();

    }
}

// Joy Nelaton - Josue Perez
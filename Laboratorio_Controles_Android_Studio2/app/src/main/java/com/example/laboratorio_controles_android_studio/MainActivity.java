package com.example.laboratorio_controles_android_studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button  boton;  // Declaracion de la variable boton
    private ProgressBar progressBar; // Declaracion de la variable progressBar
    private AutoCompleteTextView autoCompleteTextView; // Declaracion de la variable autoCompleteTextView
    private EditText nombre; // Declaracion de las variables editText
    private EditText edad;
    private EditText carrera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.Button_S3); // Asociacion del id con la variable boton
        progressBar = findViewById(R.id.progressBar); // Asociacion del id con la variable progressBar
        progressBar.setProgress(25); // Establecemos el porcentaje de progreso al 25%

        autoCompleteTextView = findViewById(R.id.editTextFacultad); // Asociacion del id con la variable autoCompleteTextView

        String[] facultades = {"Sistemas", "Civil", "Industrial", "Eléctrica", "Ciencias y Tecnología", "Mecánica"}; // Array para las sugerencias de facultades

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, facultades);
        autoCompleteTextView.setAdapter(adapter);

        nombre = findViewById(R.id.editTextCedula); // Asociacion de los ids con el editText
        edad = findViewById(R.id.editTextFechaN);
        carrera = findViewById(R.id.editTextCarrera);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean validarCampos() {
        return !autoCompleteTextView.getText().toString().isEmpty() &&
                !nombre.getText().toString().isEmpty() &&
                !edad.getText().toString().isEmpty() &&
                !carrera.getText().toString().isEmpty();
    }
}

// Joy Nelaton - Josue Perez
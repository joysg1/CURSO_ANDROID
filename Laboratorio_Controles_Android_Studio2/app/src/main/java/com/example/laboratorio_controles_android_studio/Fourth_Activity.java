package com.example.laboratorio_controles_android_studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fourth_Activity extends AppCompatActivity {
    private Button boton; // Declaracion de la variable para el boton
    private ProgressBar progressBar; //Declaracion de la variable para la barra de progreso
    private AutoCompleteTextView aEst; //Declaracion de las variables los los edittexts
    private AutoCompleteTextView sede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        boton = findViewById(R.id.Button_01); // Asociacion de la variable con el id del boton
        progressBar = findViewById(R.id.progressBar); // Asociacion de la variable con el id del progressBar
        progressBar.setProgress(100); // Establecemos el progreso al 100%

        aEst = findViewById(R.id.editText2); // Asociacion de los ids de los textViews
        sede = findViewById(R.id.editText1);

        String[] sedes = {"Campus Central", "Colón", "Panamá Oeste", "Chiriquí", "Azuero", "Coclé"}; // Array para las sugerencias de facultades

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, sedes);
        sede.setAdapter(adapter);

        String[] años = {"1", "2", "3", "4", "5", "6"}; // Array para las sugerencias de los años
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, años);
        aEst.setAdapter(adapter2);



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                Intent intent = new Intent(Fourth_Activity.this, ThirdActivity.class);
                startActivity(intent);
                }

                else {
                    Toast.makeText(Fourth_Activity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        }); // Evento que asocia el boton a volver al tercer activity

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private boolean validarCampos() {   //Validar que no se dejen los editText Vacios
        return !aEst.getText().toString().isEmpty() &&
                !sede.getText().toString().isEmpty();

    }

}
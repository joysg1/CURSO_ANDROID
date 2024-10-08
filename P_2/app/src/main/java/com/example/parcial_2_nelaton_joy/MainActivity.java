package com.example.parcial_2_nelaton_joy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ImageButton botonSiguiente;  // Declaraion de variables
    private ImageButton botonCerrar;
    private EditText editNombre;
    private EditText editApellido;
    private EditText editFechaNac;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonSiguiente = findViewById(R.id.botonSiguiente);
        botonSiguiente.setEnabled(false); // Por default el boton siguiente esta deshabilitado

        botonCerrar = findViewById(R.id.botonCerrar);

        editNombre = findViewById(R.id.editTextNombre);
        editApellido = findViewById(R.id.editTextApellido);
        editFechaNac = findViewById(R.id.editTextFecha); // Asociación de variables con los id

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    Intent intent = new Intent(MainActivity.this, second.class);
                    startActivity(intent);

                    String nombre = editNombre.getText().toString();
                    String apellido = editApellido.getText().toString();
                    String fechaNacimiento = editFechaNac.getText().toString();
                    int edad = calcularEdad(fechaNacimiento);

                    Intent intent2 = new Intent(MainActivity.this, second.class);
                    intent2.putExtra("nombre", nombre);
                    intent2.putExtra("apellido", apellido);
                    intent2.putExtra("edad", edad);
                    startActivity(intent2);
                } // Validacion de campos para poderlos usar en la clase second
            }
        });

        botonCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            } // Cerrar aplicacion con el boton cerrar
        });

        editFechaNac.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            } // Validamos que la fecha se inserte correctamente

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String fechaNacimiento = s.toString();
                if (fechaNacimiento.length() == 10) {
                    if (fechaNacimiento.matches("\\d{2}-\\d{2}-\\d{4}")) {
                        int edad = calcularEdad(fechaNacimiento);
                        if (edad >= 18) {
                            Toast.makeText(MainActivity.this, "Puede continuar es mayor de edad", Toast.LENGTH_SHORT).show();
                            if (validarCampos()) {
                                botonSiguiente.setEnabled(true);
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "No puede continuar, es menor de edad", Toast.LENGTH_SHORT).show();
                            botonSiguiente.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato dd-MM-yyyy", Toast.LENGTH_SHORT).show();
                        botonSiguiente.setEnabled(false);
                    }
                } else {
                    botonSiguiente.setEnabled(false);
                }
            } // Validacion de la condicion de mayoria de edad para habilitar boton

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean validarCampos() {
        if (editNombre.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor, ingrese su nombre", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editApellido.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor, ingrese su apellido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editFechaNac.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor, ingrese su fecha de nacimiento", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true; // Validamos que los campos no queden vacios
    }

    private int calcularEdad(String fechaNacimiento) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        int anioActual = calendar.get(Calendar.YEAR);
        int mesActual = calendar.get(Calendar.MONTH) + 1;
        int diaActual = calendar.get(Calendar.DAY_OF_MONTH);

        String[] partes = fechaNacimiento.split("-");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        int edad = anioActual - anio;
        if (mesActual < mes || (mesActual == mes && diaActual < dia)) {
            edad--;
        }
        return edad; // Calculo de la edad basado en la fecha de nacimiento
    }
}

/* Joy Nelaton */

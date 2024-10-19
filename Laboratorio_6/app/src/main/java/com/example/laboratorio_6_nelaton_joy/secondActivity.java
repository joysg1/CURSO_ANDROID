package com.example.laboratorio_6_nelaton_joy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

// Importaciones necesarias

public class secondActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;
    private TextView txtResult;
    private RadioButton RBuSuma, RBuResta, RBuMulti, RBuDivi;
    private Button btnCalculo, btnAnterior, btnCerrar;

    // Declaracion de las variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        txtResult = (TextView) findViewById(R.id.txtRespuestaCalc);
        RBuSuma = (RadioButton) findViewById(R.id.RButtonSuma);
        RBuResta = (RadioButton) findViewById(R.id.RButtonResta);
        RBuMulti = (RadioButton) findViewById(R.id.RButtonMultiplicar);
        RBuDivi = (RadioButton) findViewById(R.id.RButtonDividir);
        btnAnterior = (Button) findViewById(R.id.btnAnterior);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);
        btnCalculo = (Button) findViewById(R.id.BtnCalcular);

        // Asociacion de las variables con los objetos

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Funcionalidad de desplazamiento al antivity anterior


        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });

        // Funcionalidad para cerrar la aplicacion


        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = txtNum1.getText().toString();
                String num2 = txtNum2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(secondActivity.this, "Por favor, ingrese ambos números", Toast.LENGTH_SHORT).show();
                    return;
                }

                double numero1 = Double.parseDouble(num1);
                double numero2 = Double.parseDouble(num2);

                if (RBuSuma.isChecked()) {
                    double resultado = numero1 + numero2;
                    txtResult.setText("Resultado: " + resultado);
                } else if (RBuResta.isChecked()) {
                    double resultado = numero1 - numero2;
                    txtResult.setText("Resultado: " + resultado);
                } else if (RBuMulti.isChecked()) {
                    double resultado = numero1 * numero2;
                    txtResult.setText("Resultado: " + resultado);
                } else if (RBuDivi.isChecked()) {
                    if (numero2 == 0) {
                        Toast.makeText(secondActivity.this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double resultado = numero1 / numero2;
                    txtResult.setText("Resultado: " + resultado);
                } else {
                    Toast.makeText(secondActivity.this, "Por favor, seleccione una operación", Toast.LENGTH_SHORT).show();
                }
            }
        });


      // Funcion para realizar los calculos segun que checkbox este seleccionado





    }
}

// Joy Nelaton
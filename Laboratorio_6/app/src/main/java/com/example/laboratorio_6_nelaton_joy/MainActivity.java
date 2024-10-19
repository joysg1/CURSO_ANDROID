package com.example.laboratorio_6_nelaton_joy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtBanana, txtManzana, txtNaranja, txtPera;
    private Button btnSiguientee, btnCalcular;
    private TextView tvRespuesta;
    private CheckBox checkM, checkP, checkB, checkN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtBanana = (EditText) findViewById(R.id.txtBanana);
        txtManzana = (EditText) findViewById(R.id.txtManzana);
        txtNaranja = (EditText) findViewById(R.id.txtNaranja);
        txtPera = (EditText) findViewById(R.id.txtPera);
        checkM = (CheckBox) findViewById(R.id.checkM);
        checkP = (CheckBox) findViewById(R.id.checkP);
        checkN = (CheckBox) findViewById(R.id.checkN);
        checkB = (CheckBox) findViewById(R.id.checkB);
        tvRespuesta = (TextView) findViewById(R.id.tvRespuesta);
        btnSiguientee = (Button) findViewById(R.id.btnSiguiente);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int cantidadP = obtenerCantidad(txtPera);
                    int cantidadN = obtenerCantidad(txtNaranja);
                    int cantidadM = obtenerCantidad(txtManzana);
                    int cantidadB = obtenerCantidad(txtBanana);

                    double total = 0;
                    String resultado = "";

                    if (checkB.isChecked()) {
                        double banana = 0.30;
                        double totalbanana = banana * cantidadB;
                        total += totalbanana;
                        resultado += "Banana: " + totalbanana + "\n";
                    }

                    if (checkM.isChecked()) {
                        double manzana = 0.40;
                        double totalmanzana = manzana * cantidadM;
                        total += totalmanzana;
                        resultado += "Manzana: " + totalmanzana + "\n";
                    }

                    if (checkN.isChecked()) {
                        double naranja = 0.50;
                        double totalnaranja = naranja * cantidadN;
                        total += totalnaranja;
                        resultado += "Naranja: " + totalnaranja + "\n";
                    }

                    if (checkP.isChecked()) {
                        double pera = 0.30;
                        double totalpera = pera * cantidadP;
                        total += totalpera;
                        resultado += "Pera: " + totalpera + "\n";
                    }

                    resultado += "Total: " + total;
                    tvRespuesta.setText(resultado);
                } catch (NumberFormatException e) {
                    tvRespuesta.setText("Error: Por favor, ingrese un número válido");
                } catch (Exception e) {
                    tvRespuesta.setText("Error: " + e.getMessage());
                }
            }
        });

        btnSiguientee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                startActivity(intent);
            }
        });
    }

    private int obtenerCantidad(EditText editText) throws NumberFormatException {
        String texto = editText.getText().toString();
        if (texto.isEmpty()) {
            throw new NumberFormatException("Por favor, ingrese un número");
        }
        int cantidad = Integer.parseInt(texto);
        if (cantidad < 0) {
            throw new NumberFormatException("Por favor, ingrese un número positivo");
        }
        return cantidad;
    }
}

// Joy Nelaton








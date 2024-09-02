package com.example.laboratorio_4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;


public class SecondActivity extends AppCompatActivity {
    Button btnRegresar; // Declaracion de variables
    Button btnCalcular;
    TextView InCantidad;
    TextView Result;
    TextView Precio;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        Button btnRegresar = (Button)findViewById(R.id.btnRegresar); // Declaracion de widgets
        Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
        TextView InCantidad = (TextView)findViewById(R.id.InCantidad);
        TextView Result = (TextView)findViewById(R.id.Result);
        TextView Precio = (TextView)findViewById(R.id.Precio);


        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);

        });

        btnCalcular.setOnClickListener(v -> {
            // Obtener el texto ingresado en InCantidad y convertirlo a un número
            String cantidadStr = InCantidad.getText().toString();
            String precioStr = Precio.getText().toString();
            double cantidad;
            double precio;

            try {
                cantidad = Double.parseDouble(cantidadStr);
                precio = Double.parseDouble(precioStr);
            } catch (NumberFormatException e) {
                // Manejo de error si la conversión falla
                Result.setText("Por favor valide los datos ingresados.");
                return;
            }

            // Realizar el cálculo
            double precioTotal = cantidad * precio;

            // Mostrar el resultado en el TextView Result
            Result.setText(MessageFormat.format("Precio total: {0,number,#.##}", precioTotal));
        });







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}


/* Joy Nelaton */
package com.example.laboratorio_2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2;
    TextView tv1;
    Button btnsumar;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txtNum1);
        et2 = (EditText) findViewById(R.id.txtNum2);
        tv1 =(TextView) findViewById(R.id.resultado);
        btnsumar = (Button) findViewById(R.id.btnSumar);
        btnsumar.setOnClickListener(this);
        
        
        
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
    }

    @Override
    public void onClick(View v) {
        
        Toast.makeText(getApplicationContext(),"Ha presionado el boton", Toast.LENGTH_SHORT).show();
        float valor1;
        float valor2;
        float resultado;
        valor1 = Float.parseFloat(et1.getText().toString());
        valor2 = Float.parseFloat(et2.getText().toString());
        resultado = valor1 + valor2;
        tv1.setText(String.format("La Suma es %s", resultado));
        Toast.makeText(getApplicationContext(), "EL TOTAL ES "+resultado, Toast.LENGTH_LONG).show();
        
        
                

        
        
        
        
    }
}
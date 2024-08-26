package com.example.laboratorio_3;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    TextView tv1;
    Button sumar,restar,multiplicar,dividir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txtnum1);
        et2 = (EditText) findViewById(R.id.txtnum2);
        tv1 = (TextView) findViewById(R.id.lblrespuesta);
        sumar = (Button) findViewById(R.id.btnsumar);
        restar = (Button) findViewById(R.id.btnrestar);
        multiplicar = (Button) findViewById(R.id.btnmultiplicar);
        dividir = (Button) findViewById(R.id.btndividir);

        sumar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                float num1 = new Float(et1.getText().toString());
                float num2 = new Float(et2.getText().toString());
                float res = num1 + num2;
                tv1.setText("La Suma es "+res);


            }

        });

        restar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                float num1 = new Float(et1.getText().toString());
                float num2 = new Float(et2.getText().toString());
                float res = num1 - num2;
                tv1.setText("La Resta es "+res);


            }

        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                float num1 = new Float(et1.getText().toString());
                float num2 = new Float(et2.getText().toString());
                float res = num1 * num2;
                tv1.setText("La Multiplicacion es "+res);


            }

        });


        dividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                float num1 = new Float(et1.getText().toString());
                float num2 = new Float(et2.getText().toString());
                float res = num1 / num2;
                tv1.setText("La Division es "+res);


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
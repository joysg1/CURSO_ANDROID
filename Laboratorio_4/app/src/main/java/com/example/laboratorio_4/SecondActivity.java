package com.example.laboratorio_4;

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


public class SecondActivity extends AppCompatActivity {
    Button btnRegresar;
    Button btnCalcular;
    TextView InCantidad;
    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        Button btnRegresar = (Button)findViewById(R.id.btnRegresar);
        Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
        TextView InCantidad = (TextView)findViewById(R.id.InCantidad);
        TextView Result = (TextView)findViewById(R.id.Result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}


/* Joy Nelaton */
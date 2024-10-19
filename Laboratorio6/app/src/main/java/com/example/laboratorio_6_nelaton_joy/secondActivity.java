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

public class secondActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;
    private TextView txtResult;
    private RadioButton RBuSuma, RBuResta, RBuMulti, RBuDivi;
    private Button btnCalculo, btnAnterior, btnCerrar;

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

        



    }
}
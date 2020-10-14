package com.rodrigo.repuestos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnVulca, btnTiendas,btnTalleres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVulca = findViewById(R.id.btnVulca);
        btnTalleres = findViewById(R.id.btnTalleres);
        btnTiendas = findViewById(R.id.btnTiendas);

        btnVulca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentV = new Intent(getApplicationContext(), Vulcanizacion.class);
                startActivity(intentV);
            }
        });

        btnTiendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTi = new Intent(getApplicationContext(),Tiendas.class);
                startActivity(intentTi);
            }
        });

        btnTalleres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTa = new Intent(getApplicationContext(),Talleres.class);
                startActivity(intentTa);
            }
        });
    }
}
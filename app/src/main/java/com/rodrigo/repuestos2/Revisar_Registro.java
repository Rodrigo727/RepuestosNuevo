package com.rodrigo.repuestos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.rodrigo.repuestos2.Registro.adaptadorListView;
import static com.rodrigo.repuestos2.Registro.arrayUsuarios;

public class Revisar_Registro extends AppCompatActivity {
    Button btnActualizar, btnEliminar;
    ListView listviewClientes;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar__registro);
        listviewClientes = findViewById(R.id.listviewClientes);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Revisar_Registro.this,Actualizar.class);
                startActivity(intent);
            }
        });
    }
}
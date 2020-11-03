package com.rodrigo.repuestos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rodrigo.repuestos2.BaseDatos.ConexionSQLiteHelper;

public class Inicio_Sesion extends AppCompatActivity {
    EditText txtCorreo, txtContraseña;
    Button btnIniciar,btnRegistro;
    private boolean EmailOk = false;
    private boolean PasswordOk = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio__sesion);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_Usuario",null,1);
        txtCorreo = findViewById(R.id.txtEmail);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistro = findViewById(R.id.btnRegistro);



        txtCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 8){
                    txtCorreo.setError("Correo Muy Corto");
                    EmailOk = false;
                }else {
                    EmailOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 8){
                    txtContraseña.setError("Contraseña Muy Corta");
                    PasswordOk = false;
                }else {
                    PasswordOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Inicio_Sesion.this, "Sesion Iniciada",
                        Toast.LENGTH_SHORT).show();
                Intent intento = new Intent(Inicio_Sesion.this, MainActivity.class);
                startActivity(intento);

            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Inicio_Sesion.this, Registro.class);
                startActivity(intento);
            }
        });
    }
}
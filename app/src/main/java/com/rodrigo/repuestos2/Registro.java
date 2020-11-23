package com.rodrigo.repuestos2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class Registro extends AppCompatActivity {
    EditText txtId, txtNombre, txtApellido, txtCorreo, txtContraseña, txtRContraseña, txtTelefono;
    Spinner spinner;
    Button btnRegistrar, btnCancelar;
    //ImageButton visible1, visible2;
    private boolean NombreOk = false;
    private boolean ApellidoOk = false;
    private boolean EmailOk = false;
    private boolean PasswordOk = false;
    private boolean ConfirmacionOk = false;
    private boolean PhoneOk = false;
    private boolean esVisible;
    static ArrayList<Usuario> arrayUsuarios;
    static Usuario usuario;
    static ArrayAdapter<Usuario> adaptadorListView;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombreProducto);
        txtApellido = findViewById(R.id.txtApellido);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContraseña = findViewById(R.id.txtContraseña);
        txtRContraseña = findViewById(R.id.txtRContraseña);
        txtTelefono = findViewById(R.id.txtTelefono);
        spinner = findViewById(R.id.spinner);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnCancelar = findViewById(R.id.btnCancelar);
        //visible1 = findViewById(R.id.visible1);
        //visible2 = findViewById(R.id.visible2);
        conectarFirebase();

        arrayUsuarios = new ArrayList<>();
        adaptadorListView = new ArrayAdapter<>(Registro.this,android.R.layout.simple_list_item_1,arrayUsuarios);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(Registro.this,R.array.Genero_array,
                        android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 2){
                    txtNombre.setError("Nombre Muy Corto");
                    NombreOk = false;
                }else {
                    NombreOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 2){
                    txtApellido.setError("Apellido Muy Corto");
                    ApellidoOk = false;
                }else {
                    ApellidoOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

        txtRContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (PasswordOk == ConfirmacionOk){
                    txtRContraseña.setError("Contraseña no coinside");
                    ConfirmacionOk = false;
                }else{
                    ConfirmacionOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 8){
                    txtTelefono.setError("Telefono Muy Corto");
                    PhoneOk = false;
                }else {
                    PhoneOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtContraseña.getText().equals(txtRContraseña.getText())) {
                String Id = UUID.randomUUID().toString();
                String Nombre = txtNombre.getText().toString().trim();
                String Apellido = txtApellido.getText().toString().trim();
                String Correo = txtCorreo.getText().toString().trim();
                String Contrasenia = txtContraseña.getText().toString().trim();
                String Telefono = txtTelefono.getText().toString().trim();
                String Genero = spinner.getSelectedItem().toString();
                Usuario usuario = new Usuario(Id, Nombre, Apellido, Correo, Contrasenia, Telefono, Genero);
                insertarUsuario(usuario);
                LimpiarCajas();
            }else {
                    //Error
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Registro.this, Inicio_Sesion.class);
                startActivity(intento);
            }
        });

    }

    private void LimpiarCajas() {
        txtNombre.setText(" ");
        txtApellido.setText(" ");
        txtCorreo.setText(" ");
        txtContraseña.setText(" ");
        txtRContraseña.setText(" ");
        txtTelefono.setText(" ");
        spinner.setSelection(0);
    }

    public void conectarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        Toast.makeText(this,"Conectado a firebase",Toast.LENGTH_LONG).show();
}
    public void insertarUsuario(Usuario u){
        if(u != null){
            reference.child("usuarios").child(u.getId()).setValue(u, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    Toast.makeText(getApplicationContext(), "Usuario creado",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}




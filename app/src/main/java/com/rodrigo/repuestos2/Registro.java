package com.rodrigo.repuestos2;

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

import com.rodrigo.repuestos2.BaseDatos.ConexionSQLiteHelper;
import com.rodrigo.repuestos2.BaseDatos.Utilidades;

import java.util.ArrayList;

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
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,null,null,1);
    static ArrayAdapter<Usuario> adaptadorListView;


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
                Integer Id = Integer.parseInt(txtId.getText().toString());
                String Nombre = txtNombre.getText().toString();
                String Apellido = txtApellido.getText().toString();
                String Correo = txtCorreo.getText().toString();
                String Contrasenia = txtContraseña.getText().toString();
                String RContrasenia = txtRContraseña.getText().toString();
                String Telefono = txtTelefono.getText().toString();
                String Genero = spinner.getSelectedItem().toString();

               /* Usuario usuario = new Usuario(Id,Nombre, Apellido, Correo, Contrasenia,
                        RContrasenia, Telefono, Genero);
                listaUsuarios.add(usuario);*/
                RegistrarUsuarios(Id,Nombre,Apellido,Correo,Contrasenia,RContrasenia,Telefono,Genero);
                //Revisar_Registro.obtenerClientes();
                Intent intent = new Intent(Registro.this,Revisar_Registro.class);
                startActivity(intent);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Registro.this, Inicio_Sesion.class);
                startActivity(intento);
            }
        });


        /*visible1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!esVisible) {
                    txtContraseña.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    esVisible = true;

                }
                else {
                    txtContraseña.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    esVisible = false;
                    visible1.setBackgroundResource(R.drawable.novisible);
                }
            }
        });

        visible2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!esVisible) {
                    txtRContraseña.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    esVisible = true;

                }
                else {
                    txtRContraseña.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    esVisible = false;
                    visible2.setBackgroundResource(R.drawable.novisible);
                }
            }
        });*/
    }

    private void LimpiarCajas() {
        txtNombre.setText(" ");
        txtApellido.setText(" ");
        txtCorreo.setText(" ");
        txtContraseña.setText(" ");
        txtRContraseña.setText(" ");
        txtTelefono.setText(" ");
    }

    private void RegistrarUsuarios(int Id, String Nombre , String Apellido , String Correo ,
           String Contrasenia,String RContrasenia,String Telefono,String Genero) {
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,Id);
        values.put(Utilidades.CAMPO_NOMBRE,Nombre);
        values.put(Utilidades.CAMPO_APELLIDO,Apellido);
        values.put(Utilidades.CAMPO_CORREO,Correo);
        values.put(Utilidades.CAMPO_CONTRASENIA,Contrasenia);
        values.put(Utilidades.CAMPO_RCONTRASENIA,RContrasenia);
        values.put(Utilidades.CAMPO_TELEFONO,Telefono);
        values.put(Utilidades.CAMPO_GENEROO,Genero);

        db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID,values);

        Toast.makeText(Registro.this,"Usuario Registrado ",Toast.LENGTH_SHORT).show();
        db.close();


    }
}
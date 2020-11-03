package com.rodrigo.repuestos2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.rodrigo.repuestos2.BaseDatos.ConexionSQLiteHelper;
import com.rodrigo.repuestos2.BaseDatos.Utilidades;

import static com.rodrigo.repuestos2.Registro.adaptadorListView;
import static com.rodrigo.repuestos2.Registro.arrayUsuarios;

public class Revisar_Registro extends AppCompatActivity {
    Button button;
    ListView listviewClientes;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,null,null,1);
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar__registro);
        listviewClientes = findViewById(R.id.listviewClientes);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerClientes();
            }
        });

    }

    public void obtenerClientes(){
        adaptadorListView.clear();
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIO,null);
        while (cursor.moveToNext()){
            usuario = new Usuario(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)
            );
            arrayUsuarios.add(usuario);
        }
        adaptadorListView = new ArrayAdapter<>(Revisar_Registro.this,
                android.R.layout.simple_list_item_1,arrayUsuarios);
        listviewClientes.setAdapter(adaptadorListView);
        cursor.close();
        db.close();

    }
}
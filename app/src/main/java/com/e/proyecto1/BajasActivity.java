package com.e.proyecto1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import Controlador.ClienteDAO;
import Modelo.Cliente;

public class BajasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText et_nombre;
    private EditText et_primerAp;
    private EditText et_segundoAp;
    private EditText et_direccion;
    private EditText et_fechaNac;
    private EditText et_telefono;
    private EditText et_email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bajas);


        et_nombre = (EditText) findViewById(R.id.et_nombre_eliminar);


    }
    public void cancelar(View v) {
        switch (v.getId()) {


            case R.id.btn_cancelar_bajas:
                Intent e = new Intent(this, SistemaActivity.class);
                startActivity(e);
                break;


        }
    }
    public  boolean Eliminar(View v) {
        ClienteDAO dao = new ClienteDAO(this);
        String nombre = et_nombre.getText().toString();
        dao.Eliminar(nombre);

        if (!nombre.isEmpty()) {

            if (dao.Eliminar(nombre) == true) {
                Toast.makeText(this, "Cliente eliminado exitosamente", Toast.LENGTH_SHORT).show();
                et_nombre.setText("");
            } else {
                Toast.makeText(this, "El cliente no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el nombre del empleado", Toast.LENGTH_SHORT).show();
        }

        return false;
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

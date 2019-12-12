package com.e.proyecto1;

import android.content.ContentValues;
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

public class AltasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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

        setContentView(R.layout.activity_altas);

        et_nombre = (EditText) findViewById(R.id.et_nombre_altas);
        et_primerAp = (EditText) findViewById(R.id.et_primerap_altas);
        et_segundoAp = (EditText) findViewById(R.id.et_segundoap_altas);
        et_direccion = (EditText) findViewById(R.id.et_direccion_altas);
        et_fechaNac = (EditText) findViewById(R.id.et_fechnac_altas);
        et_telefono = (EditText) findViewById(R.id.et_telefono_altas);
        et_email = (EditText) findViewById(R.id.et_email_altas);




    }

    public void cancelar(View v) {
        switch (v.getId()) {

            case R.id.btn_cancelar_altas:
                Intent a = new Intent(this, SistemaActivity.class);
                startActivity(a);
                break;


        }
    }
    public void Agregar(View v ){

        String nombre = et_nombre.getText().toString();
        String primerAp = et_primerAp.getText().toString();
        String segundoAp = et_segundoAp.getText().toString();
        String direccion = et_direccion.getText().toString();
        String fechaNac = et_fechaNac.getText().toString();
        String telefono = et_telefono.getText().toString();
        String email = et_email.getText().toString();

        if(!nombre.isEmpty() && !primerAp.isEmpty() && !segundoAp.isEmpty() && !direccion.isEmpty() &&
                !fechaNac.isEmpty() && !telefono.isEmpty() && !email.isEmpty()) {

            ClienteDAO dao = new ClienteDAO(this);
            Cliente c = new Cliente(nombre, primerAp, segundoAp, direccion, fechaNac, telefono, email);
            dao.agregarCliente(c);
            if (dao.agregarCliente(c)== true) {
                Toast.makeText(this, "Registro existoso", Toast.LENGTH_SHORT).show();

                et_nombre.setText("");
                et_primerAp.setText("");
                et_segundoAp.setText("");
                et_direccion.setText("");
                et_fechaNac.setText("");
                et_telefono.setText("");
                et_email.setText("");
            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

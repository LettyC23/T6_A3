package com.e.proyecto1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Controlador.ClienteDAO;
import Modelo.Cliente;

public class ModificacionesActivity extends Activity implements AdapterView.OnItemSelectedListener{

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

        setContentView(R.layout.activity_modificaciones);

        et_nombre = (EditText) findViewById(R.id.et_nombre_mod);
        et_primerAp = (EditText) findViewById(R.id.et_primerap_mod);
        et_segundoAp = (EditText) findViewById(R.id.et_segundoap_mod);
        et_direccion = (EditText) findViewById(R.id.et_direccion_mod);
        et_fechaNac = (EditText) findViewById(R.id.et_fechanac_mod);
        et_telefono = (EditText) findViewById(R.id.et_tel_mod);
        et_email = (EditText) findViewById(R.id.et_email_mod);


        }


    public void cancelar(View v) {
        switch (v.getId()) {
            case R.id.btn_cancelar_mod:
                Intent lo = new Intent(this, SistemaActivity.class);
                startActivity(lo);
                break;

        }
    }
        public void Modificar(View v){

            String nombre = et_nombre.getText().toString();
            String primerAp = et_primerAp.getText().toString();
            String segundoAp = et_segundoAp.getText().toString();
            String direccion = et_direccion.getText().toString();
            String fechaNac = et_fechaNac.getText().toString();
            String telefono = et_telefono.getText().toString();
            String email = et_email.getText().toString();

            if(!nombre.isEmpty() && !primerAp.isEmpty() && !segundoAp.isEmpty() && !direccion.isEmpty() &&
                    !fechaNac.isEmpty() && !telefono.isEmpty() && !email.isEmpty()){

                ClienteDAO dao = new ClienteDAO(this);
                Cliente c = new Cliente(nombre, primerAp, segundoAp, direccion, fechaNac, telefono, email);
                dao.Modificar(nombre, c);
                if(dao.Modificar(nombre, c)== true){
                    Toast.makeText(this, "Datos modificados correctamente", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "El cliente no existe", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
        }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

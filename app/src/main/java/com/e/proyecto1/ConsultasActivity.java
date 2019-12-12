package com.e.proyecto1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class ConsultasActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private EditText et_nombre;
    private EditText et_primerAp;
    private EditText et_segundoAp;
    private EditText et_telefono;
    private String et_fechaNac;
    private EditText et_sueldo;
    private String et_horario;
    private Spinner año;
    private Spinner mes;
    private Spinner dia;
    private Spinner he;
    private Spinner me;
    private Spinner fe;
    private Spinner hs;
    private Spinner ms;
    private Spinner fs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buscar);

        et_nombre = (EditText) findViewById(R.id.et_nombre_altas);
        et_primerAp = (EditText) findViewById(R.id.et_primerap_altas);
        et_segundoAp = (EditText) findViewById(R.id.et_segundoap_altas);
        et_telefono = (EditText) findViewById(R.id.et_direccion_altas);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    } public void cancelar(View v) {
        switch (v.getId()) {

            case R.id.btn_cancelar_buscar:
                Intent m = new Intent(this, SistemaActivity.class);
                startActivity(m);
                break;

        }
    }

/*
    public void Buscar(View view){


        ClienteDAO em = new ClienteDAO(this, "Desec", null, 1);
        SQLiteDatabase db = em.getWritableDatabase();

        String nombre = et_nombre.getText().toString();

        if(!nombre.isEmpty()){
            Cursor fila = db.rawQuery("select nombre, precio from clientes where nombre = ?",new String[]{String.valueOf(nombre)});


            if(fila.moveToFirst()){

                et_nombre.setText(fila.getString(0));
                et_primerAp.setText(fila.getString(1));
                db.close();
            } else {
                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                db.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }*/


}

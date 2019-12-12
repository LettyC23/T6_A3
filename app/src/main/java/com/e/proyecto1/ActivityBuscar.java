package com.e.proyecto1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import Controlador.ClienteDAO;


public class ActivityBuscar  extends Activity implements AdapterView.OnItemSelectedListener {

    private  EditText nc;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buscar);

        nc = (EditText) findViewById(R.id.et_nombre_buscar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void listViewClientes(View v ){
        switch (v.getId()){
            case R.id.btn_buscar: Intent a = new Intent(this,ActivityConsultas.class);
                startActivity(a);
                break;


        }
    }
    public void cancelar(View v) {
        switch (v.getId()) {

            case R.id.btn_cancelar_bajas:
                Intent a = new Intent(this, SistemaActivity.class);
                startActivity(a);
                break;


        }
    }
}

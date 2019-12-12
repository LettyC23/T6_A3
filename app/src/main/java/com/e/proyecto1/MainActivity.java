package com.e.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnLoginAceptar = (Button) findViewById(R.id.btn_aceptar_login);
        btnLoginAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario =  ((EditText) findViewById(R.id.text_usuario)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.text_contraseña)).getText().toString();

                if(usuario.equals("admin")&& contraseña.equals("123")){
                    Intent i = new Intent(MainActivity.this, SistemaActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(btnLoginAceptar.getContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


    //Metodo para botones



    public void abrirActivities(View v){




        switch (v.getId()) {
            case R.id.btn_aceptar_login:
                Intent i = new Intent(this, SistemaActivity.class);
                startActivity(i);
                break;


        }

    }
    public void cancelarLogin (View v){
        finish();

    }
}

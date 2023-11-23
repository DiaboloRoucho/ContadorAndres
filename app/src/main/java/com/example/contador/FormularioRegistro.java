package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contador.db.DbVariables;

public class FormularioRegistro extends AppCompatActivity {

    EditText txtNombre, txtPassword;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);
        txtNombre =  findViewById(R.id.editTextNombre);
        txtPassword = findViewById(R.id.editTextPassword);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbVariables dbVariables = new DbVariables(FormularioRegistro.this);
                long id = dbVariables.insertarVariable(txtNombre.getText().toString(), txtPassword.getText().toString());
                if (id>0) {
                    Toast.makeText(FormularioRegistro.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }
            }
        });
    }
    private void limpiar (){
        txtNombre.setText("");
        txtPassword.setText("");
    }
}
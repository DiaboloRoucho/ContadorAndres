package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;


public class Tienda extends AppCompatActivity {

    TextView contador;
    Button compra, compraraton;
    ImageView prick;
    BigInteger suma;
    int click = 1;
    int contpesao=0;
    int incremento = 0;
    BigInteger precio;
    BigInteger precioraton;
    BigInteger valGordo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        contador = (TextView) findViewById(R.id.texto);
        compra= findViewById(R.id.textomejora3);
        compraraton = findViewById(R.id.textomejora23);
        valGordo = new BigInteger("0");
        precio = new BigInteger("100");
        precioraton = new BigInteger("150");
        Bundle extras = getIntent().getExtras();
        String dinero =extras.getString("dinero");
        suma = new BigInteger(dinero);
        contador.setText(suma.toString());
    }

    public void compraclick(View v){

        if (suma.compareTo(BigInteger.valueOf(precio.intValue()))>=0) {
            suma = suma.subtract(precio);
            click++;
            contador.setText(suma.toString());
            precio = precio.add(BigInteger.valueOf(20));
            if (suma.compareTo(BigInteger.valueOf(1000000))>=0){
                valGordo = suma.divide(BigInteger.valueOf(1000000));
                contador.setText(String.valueOf(valGordo)+" millones");
            } else if (suma.compareTo(BigInteger.valueOf(1000))>=0) {
                valGordo = suma.divide(BigInteger.valueOf(1000));
                contador.setText(String.valueOf(valGordo)+" miles");
            }else {
                contador.setText(suma.toString());
            }
            compra.setText(String.valueOf(precio)+ " Pepinillos");

        }else {if (contpesao>=5) {
            Toast tpesao = Toast.makeText(this, R.string.pesao, Toast.LENGTH_LONG);
            tpesao.show();
        }else{
            Toast toast = Toast.makeText(this, R.string.nopepis, Toast.LENGTH_SHORT);
            toast.show();
            contpesao++;
        }
        }

    }

    public void inc(View v){
        if (suma.compareTo(BigInteger.valueOf(precioraton.intValue()))>=0) {
            suma = suma.subtract(precioraton);
            incremento++;
            precioraton = precioraton.add(BigInteger.valueOf(50));
            if (suma.compareTo(BigInteger.valueOf(1000000))>=0){
                valGordo = suma.divide(BigInteger.valueOf(1000000));
                contador.setText(String.valueOf(valGordo)+" millones");
            } else if (suma.compareTo(BigInteger.valueOf(1000))>=0) {
                valGordo = suma.divide(BigInteger.valueOf(1000));
                contador.setText(String.valueOf(valGordo)+" miles");
            }else {
                contador.setText(suma.toString());
            }
            compraraton.setText(String.valueOf(precioraton)+ " Pepinillos");

        }else {if (contpesao>=5) {
            Toast tpesao = Toast.makeText(this, R.string.pesao, Toast.LENGTH_LONG);
            tpesao.show();
        }else{
            Toast toast = Toast.makeText(this, R.string.nopepis, Toast.LENGTH_SHORT);
            toast.show();
            contpesao++;
        }
        }
    }
    public void volverDeTienda(View v){
        Intent intent = new Intent();
        intent.putExtra("dinero", suma.toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}

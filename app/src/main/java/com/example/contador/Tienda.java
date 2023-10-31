package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Tienda extends AppCompatActivity {

    TextView contador;
    Button compra, compraraton;
    ImageView prick;
    BigInteger suma, click, incremento, precio, precioraton, valGordo;
    int contpesao=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        contador = (TextView) findViewById(R.id.texto);
        compra= findViewById(R.id.textomejora3);
        compraraton = findViewById(R.id.textomejora23);
        valGordo = new BigInteger("0");
        Bundle extras = getIntent().getExtras();
        incremento = new BigInteger(extras.getString("sumaraton"));
        click = new BigInteger(extras.getString("click"));
        precio= new BigInteger(extras.getString("precio"));
        suma = new BigInteger(extras.getString("dinero"));
        precioraton = new BigInteger(extras.getString("precioraton"));
        format(suma);
        compra.setText(String.valueOf(precio)+ " Pepinillos");
        compraraton.setText(String.valueOf(precioraton)+ " Pepinillos");
        incTemporal();
    }

    public void compraclick(View v){

        if (suma.compareTo(BigInteger.valueOf(precio.intValue()))>=0) {
            suma = suma.subtract(precio);
            click = click.add(new BigInteger("1"));
            contador.setText(suma.toString());
            precio = precio.add(BigInteger.valueOf(20));
            format(suma);
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
            incremento = incremento.add(new BigInteger("1"));
            precioraton = precioraton.add(BigInteger.valueOf(50));
            format(suma);
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
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("suma", suma.toString());
        i.putExtra("sumaraton", incremento);
        i.putExtra("click", click);
        i.putExtra("precio", precio.toString());
        i.putExtra("precioraton", precioraton.toString());
        startActivity(i);
        finish();
    }
    public void incTemporal(){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(()->{

            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                suma = suma.add(incremento);
                handler.post(()->{
                    format(suma);
                });
            }
        });
    }
    public void format(BigInteger x){
        if (x.compareTo(BigInteger.valueOf(1000000))>=0){
            valGordo = x.divide(BigInteger.valueOf(1000000));
            contador.setText(String.valueOf(valGordo)+" millones");
        } else if (x.compareTo(BigInteger.valueOf(1000))>=0) {
            valGordo = x.divide(BigInteger.valueOf(1000));
            contador.setText(String.valueOf(valGordo)+" miles");
        }else {
            contador.setText(suma.toString());
        }
    }

}

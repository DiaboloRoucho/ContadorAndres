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
    Button compra, compraraton, compra2, compra3;
    ImageView prick;
    BigInteger suma, click, incremento, precio, precioraton, valGordo, inc2, precio2, inc3, precio3, n1, n2, n3;
    String usuario;
    int contpesao=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        contador = (TextView) findViewById(R.id.texto);
        compra= findViewById(R.id.textomejora3);
        compraraton = findViewById(R.id.textomejora23);
        compra2= findViewById(R.id.textomejora33);
        compra3= findViewById(R.id.textomejora43);
        valGordo = new BigInteger("0");
        Bundle extras = getIntent().getExtras();
        incremento = new BigInteger(extras.getString("sumaraton"));
        click = new BigInteger(extras.getString("click"));
        precio= new BigInteger(extras.getString("precio"));
        suma = new BigInteger(extras.getString("dinero"));
        precioraton = new BigInteger(extras.getString("precioraton"));
        inc2 = new BigInteger(extras.getString("inc2"));
        precio2 = new BigInteger(extras.getString("precio2"));
        inc3 = new BigInteger(extras.getString("inc3"));
        precio3 = new BigInteger(extras.getString("precio3"));
        n1 = new BigInteger(extras.getString("n1"));
        n2 = new BigInteger(extras.getString("n2"));
        n3 = new BigInteger(extras.getString("n3"));
        format(suma);
        compra.setText(String.valueOf(precio)+ " Pepinillos");
        compraraton.setText(String.valueOf(precioraton)+ " Pepinillos");
        compra2.setText(String.valueOf(precio2)+ " Pepinillos");
        compra3.setText(String.valueOf(precio3)+ " Pepinillos");
        usuario = extras.getString("usuario");
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
            n1 = n1.add(new BigInteger("1"));

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
    }public void inc2(View v){
        if (suma.compareTo(BigInteger.valueOf(precio2.intValue()))>=0) {
            suma = suma.subtract(precio2);
            inc2 = inc2.add(new BigInteger("2"));
            precio2 = precio2.add(BigInteger.valueOf(100));
            format(suma);
            n2 = n2.add(new BigInteger("1"));
            compra2.setText(String.valueOf(precio2)+ " Pepinillos");

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
    public void inc3(View v){
        if (suma.compareTo(BigInteger.valueOf(precio3.intValue()))>=0) {
            suma = suma.subtract(precio3);
            inc3 = inc3.add(new BigInteger("4"));
            precio3 = precio3.add(BigInteger.valueOf(200));
            format(suma);
            n3 = n3.add(new BigInteger("1"));
            compra3.setText(String.valueOf(precio3)+ " Pepinillos");

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
        i.putExtra("sumaraton", incremento.toString());
        i.putExtra("click", click.toString());
        i.putExtra("precio", precio.toString());
        i.putExtra("precioraton", precioraton.toString());
        i.putExtra("precio2", precio2.toString());
        i.putExtra("inc2", inc2.toString());
        i.putExtra("precio3", precio3.toString());
        i.putExtra("inc3", inc3.toString());
        i.putExtra("n1", n1.toString());
        i.putExtra("n2", n2.toString());
        i.putExtra("n3", n3.toString());
        i.putExtra("user", usuario);
        startActivity(i);
        finish();
    }
    public void incTemporal(){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(()->{

            while (true){
                try {
                    Thread.sleep(333);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                suma = suma.add(incremento);
                handler.post(()->{
                    format(suma);
                });
                try {
                    Thread.sleep(333);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                suma = suma.add(inc2);
                handler.post(()->{
                    format(suma);
                });
                try {
                    Thread.sleep(333);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                suma = suma.add(inc3);
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

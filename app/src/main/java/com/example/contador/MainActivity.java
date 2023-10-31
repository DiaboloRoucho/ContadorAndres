package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    ImageView prick;
    BigInteger suma, click, incremento, precio, precioraton, valGordo;
    int contpesao=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        contador = (TextView) findViewById(R.id.texto);
        prick = findViewById(R.id.imagen1);
        valGordo = new BigInteger("0");
        if (extras==null) {
            suma = new BigInteger("0");//suma = Integer.parseInt( contador.getText().toString());
            precio = new BigInteger("100");
            precioraton = new BigInteger("150");
            click = new BigInteger("1");
            incremento = new BigInteger("0");
        }else {
            //Log.e("localizador",extras.getString("precioraton")+ " " );
            suma = new BigInteger(extras.getString("suma"));
            precio = new BigInteger(extras.getString("precio"));
            precioraton = new BigInteger(extras.getString("precioraton"));
            incremento = new BigInteger(extras.getString("sumaraton"));
            click = new BigInteger(extras.getString("click"));
            format(suma);
        }
        incTemporal();
    }

    public void sumar(View v) {

        suma = suma.add(click);
        format(suma);
        contpesao=0;
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(500);
        prick.startAnimation(fade_in);
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

    public void irTienda(View v){
        Intent i = new Intent(this, Tienda.class);
        i.putExtra("dinero", suma.toString());
        i.putExtra("sumaraton", incremento);
        i.putExtra("click", click);
        i.putExtra("precio", precio.toString());
        i.putExtra("precioraton", precioraton.toString());
        startActivity(i);
        finish();
    }
}
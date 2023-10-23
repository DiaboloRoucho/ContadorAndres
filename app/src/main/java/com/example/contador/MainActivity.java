package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
        setContentView(R.layout.activity_main);
        contador = (TextView) findViewById(R.id.texto);
        prick = findViewById(R.id.imagen1);
        suma = new BigInteger("0");//suma = Integer.parseInt( contador.getText().toString());
        valGordo = new BigInteger("0");
        precio = new BigInteger("100");
        precioraton = new BigInteger("150");
        incTemporal();
    }

    public void sumar(View v) {

        suma = suma.add(BigInteger.valueOf(click));
        if (suma.compareTo(BigInteger.valueOf(1000000))>=0){
            valGordo = suma.divide(BigInteger.valueOf(1000000));
            contador.setText(String.valueOf(valGordo)+" millones");
        } else if (suma.compareTo(BigInteger.valueOf(1000))>=0) {
            valGordo = suma.divide(BigInteger.valueOf(1000));
            contador.setText(String.valueOf(valGordo)+" miles");
        }else {
            contador.setText(suma.toString());
        }
        contpesao=0;
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(500);
        prick.startAnimation(fade_in);
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
                suma = suma.add(BigInteger.valueOf(incremento));
                handler.post(()->{
                    contador.setText(suma.toString());
                });
            }
        });
    }

    public void irTienda(View v){
        Intent i = new Intent(this, Tienda.class);
        i.putExtra("dinero", suma.toString());
        startActivity(i);
    }
}
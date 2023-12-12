package com.example.contador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    ImageView prick;
    String id, usuario, contraseña;
    BigInteger suma, click, incremento, precio, precioraton, valGordo, inc2, precio2, inc3, precio3, n1, n2, n3;
    int contpesao=0;
    DbHelper db;
    //ArrayList<String> us_id, us_usuarios, us_contraseñas, us_suma, us_precio1, us_precio2, us_precio3, us_precio4, us_incremento1, us_incremento2,us_incremento3, us_click, us_n1, us_n2, us_n3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        contador = (TextView) findViewById(R.id.texto);
        prick = findViewById(R.id.imagen1);
        valGordo = new BigInteger("0");
        registerForContextMenu(contador);
        db = new DbHelper(MainActivity.this);
        if (getIntent().hasExtra("usuario")) {
            usuario = extras.getString("usuario");
            storeData();
        }else {
            //Log.e("localizador",extras.getString("precioraton")+ " " );
            suma = new BigInteger(extras.getString("suma"));
            precio = new BigInteger(extras.getString("precio"));
            precioraton = new BigInteger(extras.getString("precioraton"));
            incremento = new BigInteger(extras.getString("sumaraton"));
            click = new BigInteger(extras.getString("click"));
            inc2 = new BigInteger(extras.getString("inc2"));
            precio2 = new BigInteger(extras.getString("precio2"));
            inc3 = new BigInteger(extras.getString("inc3"));
            precio3 = new BigInteger(extras.getString("precio3"));
            n1 = new BigInteger(extras.getString("n1"));
            n2 = new BigInteger(extras.getString("n2"));
            n3 = new BigInteger(extras.getString("n3"));
            usuario = extras.getString("user");
            RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerViewMain);
            rv.setHasFixedSize(true);
            rv.setLayoutManager(new LinearLayoutManager(this));
            List<Persona> l = Arrays.asList(
                    new Persona("Nvl exoesqueleto", extras.getString("n1"), R.drawable.cursor),
                    new Persona("Ratones excavando", extras.getString("sumaraton"),R.drawable.raton),
                    new Persona("Plumbus plumbeando", extras.getString("n2"), R.drawable.pichon),
                    new Persona("Pichones esclavizados", extras.getString("n3"),R.drawable.increment)
            );
            rv.setAdapter(new PersonaAdapter(l));
        }
        format(suma);
//        us_id = new ArrayList<>();
//        us_usuarios = new ArrayList<>();
//        us_contraseñas = new ArrayList<>();
//        us_suma = new ArrayList<>();
//        us_precio1 = new ArrayList<>();
//        us_precio2 = new ArrayList<>();
//        us_precio3 = new ArrayList<>();
//        us_precio4 = new ArrayList<>();
//        us_incremento1 = new ArrayList<>();
//        us_incremento2 = new ArrayList<>();
//        us_incremento3 = new ArrayList<>();
//        us_click = new ArrayList<>();
//        us_n1 = new ArrayList<>();
//        us_n2 = new ArrayList<>();
//        us_n3 = new ArrayList<>();
//        if (extras==null) {
//            suma = new BigInteger("0");//suma = Integer.parseInt( contador.getText().toString());
//            precio = new BigInteger("100");
//            precioraton = new BigInteger("150");
//            click = new BigInteger("1");
//            incremento = new BigInteger("0");
//            inc2 = new BigInteger("0");
//            precio2 = new BigInteger("300");
//            inc3 = new BigInteger("0");
//            precio3 = new BigInteger("600");
//            n1 = new BigInteger("0");
//            n2 = new BigInteger("0");
//            n3 = new BigInteger("0");
//          }else {
//            //Log.e("localizador",extras.getString("precioraton")+ " " );
//            suma = new BigInteger(extras.getString("suma"));
//            precio = new BigInteger(extras.getString("precio"));
//            precioraton = new BigInteger(extras.getString("precioraton"));
//            incremento = new BigInteger(extras.getString("sumaraton"));
//            click = new BigInteger(extras.getString("click"));
//            inc2 = new BigInteger(extras.getString("inc2"));
//            precio2 = new BigInteger(extras.getString("precio2"));
//            inc3 = new BigInteger(extras.getString("inc3"));
//            precio3 = new BigInteger(extras.getString("precio3"));
//            n1 = new BigInteger(extras.getString("n1"));
//            n2 = new BigInteger(extras.getString("n2"));
//            n3 = new BigInteger(extras.getString("n3"));

 //       }


    }
    void storeData(){
        Cursor cursor = db.ReadData(usuario);
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Sin datos", Toast.LENGTH_SHORT).show();
        }else{


            id = cursor.getString(0);
            usuario = cursor.getString(1);
            contraseña = cursor.getString(2);
            suma = new BigInteger(cursor.getString(3));
            precio = new BigInteger(cursor.getString(4));
            precioraton = new BigInteger(cursor.getString(5));
            precio2 = new BigInteger(cursor.getString(6));
            precio3 = new BigInteger(cursor.getString(7));
            incremento = new BigInteger(cursor.getString(8));
            inc2 = new BigInteger(cursor.getString(9));
            inc3 = new BigInteger(cursor.getString(10));
            click = new BigInteger(cursor.getString(11));
            n1 = new BigInteger(cursor.getString(12));
            n2 = new BigInteger(cursor.getString(13));
            n3 = new BigInteger(cursor.getString(14));
            incTemporal();
        }
    }
    public void guardar(View v){
        DbHelper db = new DbHelper(this);
        db.guardarDatos(usuario, suma.toString(), precio.toString(), precioraton.toString(), precio2.toString(), precio3.toString(), incremento.toString(), inc2.toString(), inc3.toString(), click.toString(), n1.toString(), n2.toString(), n3.toString());
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        if (v.getId()==R.id.texto){
            getMenuInflater().inflate(R.menu.menumero, menu);
        }
    }

    public void volver(View v) {

        finish();
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){

        suma = new BigInteger("0");
        contador.setText("0");
        precio = new BigInteger("100");
        precioraton = new BigInteger("150");
        precio2 = new BigInteger("300");
        precio3 = new BigInteger("600");
        incremento = new BigInteger("0");
        inc2 = new BigInteger("0");
        inc3 = new BigInteger("0");
        click = new BigInteger("1");
        n1 = new BigInteger("0");
        n2 = new BigInteger("0");
        n3 = new BigInteger("0");
        format(suma);
        return super.onContextItemSelected(item);

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
        }else if (x.compareTo(BigInteger.valueOf(1000000))==0){
            valGordo = x.divide(BigInteger.valueOf(1000000));
            contador.setText(String.valueOf(valGordo)+" millon");
        } else if (x.compareTo(BigInteger.valueOf(1000))>=0) {
            valGordo = x.divide(BigInteger.valueOf(1000));
            contador.setText(String.valueOf(valGordo)+" k");
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

    public void irTienda(View v){
        Intent i = new Intent(this, Tienda.class);
        i.putExtra("usuario", usuario);
        i.putExtra("dinero", suma.toString());
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
        startActivity(i);
        finish();
    }
}
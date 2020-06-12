package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class choose extends AppCompatActivity {
public int jaka;
public int jdlacalejklasy;

    public void setJdlacalejklasy(int a)
    {
        jdlacalejklasy=a;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.drawable.trzykropek, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //tytol
        setTitle("Kieszonkowe zadania ( ͡° ͜ʖ ͡°)");

        return true;
    }
    //reportBug
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(choose.this, reportError.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //COFANIE NA PASKU AKCJI
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        final Spinner roz = (Spinner) findViewById(R.id.rodzials);
        final Spinner zad = (Spinner) findViewById(R.id.zadanie);
         final Book book=new Book();
        //Pobieranie jaka ksiazka zostala wybrana
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();



        if(bundle != null){
          jaka = bundle.getInt("pos");
            //System.out.println(jaka);;
            book.setWybranaksiazka(jaka);

        }
        final int ilerozdz = book.getRozdz(jaka);
        final String [] rozdzialy = new String [ilerozdz];
        String [] arrmile ={"Rozdział I","Rozdział II","Rozdział III","Rozdział IV","Rozdział V","Rozdział VI","Rozdział VII","Rozdział VIII","Rozdział IX","Rozdział X","Rozdział XI","Rozdział XII","Rozdział XIII"};
        for(int i = 0; i< ilerozdz; i++)
        {
            rozdzialy[i]=arrmile[i];
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(choose.this, android.R.layout.simple_spinner_item, rozdzialy);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roz.setAdapter(adapter);

        zad.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final int jakiR = roz.getSelectedItemPosition();
                     int ilezad=book.ilezadan(jaka, jakiR);
                    String [] zadabia = new String [ilezad];
                    for(int i=1;i<=ilezad;i++)
                    {
                        zadabia[i-1]="zadanie "+i;
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(choose.this, android.R.layout.simple_spinner_item, zadabia);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    zad.setAdapter(adapter);
                }

                return false;
            }
        });
    }



    public void OnClickSearch(View v)
    {
        final Book book = new Book();
        book.setWybranaksiazka(jaka);
        //Pobieranie widoku do spinnerów
        Spinner roz = (Spinner)findViewById(R.id.rodzials);
        Spinner zad = (Spinner)findViewById(R.id.zadanie);
       //Pole tekstowe z nr rozdzialu i zadania np: 1.18
        TextView textView = (TextView) findViewById(R.id.RZ);
        int spinner_pos = roz.getSelectedItemPosition();
        int spinner_pos1 = zad.getSelectedItemPosition();
        int n = spinner_pos + 1;
        int n1= spinner_pos1 + 1;
        textView.setText("Zadanie: "+n + "." +n1);

        //Ustawianie pola z odpowiedziami
        TextView rozwiazanie = (TextView) findViewById(R.id.zadanko);
        rozwiazanie.setText(book.getText());
        ImageView rozww = (ImageView) findViewById(R.id.zdjecie);
        int jakaK=jaka+1;
        int j = getResources().getIdentifier("k"+jakaK+"r"+n+"z"+n1, "drawable", getPackageName());
        setJdlacalejklasy(j);
        rozww.setImageResource(0);
        ImageView podp = (ImageView) findViewById(R.id.podp);
        podp.setImageResource(0);
        if(j!=0)
        {
            //rozww.setImageResource(j);
          //rozwiazanie.setText(R.string.rozwiazanie);
            rozwiazanie.setText(R.string.znaleziono);
        }

        else
        {
            rozwiazanie.setText("Ooops, wystąpił błąd ❣◕ ‿ ◕❣ ");
            rozww.setImageResource(j);
        }

    }

    public void OnClickPokazPodpowiedz(View v)
    {
        if(jdlacalejklasy!=0) {
            Spinner roz = (Spinner) findViewById(R.id.rodzials);
            Spinner zad = (Spinner) findViewById(R.id.zadanie);
            int r = roz.getSelectedItemPosition() + 1;
            int z = zad.getSelectedItemPosition() + 1;
            int k = jaka + 1;

            int j = getResources().getIdentifier("pk"+k+"r"+r+"z"+z, "drawable", getPackageName());
            System.out.println("pk"+k+"r"+r+"z"+z);
            ImageView podp = (ImageView) findViewById(R.id.podp);
            podp.setImageResource(j);
            ImageView rozww = (ImageView) findViewById(R.id.zdjecie);
            rozww.setImageResource(0);

            TextView rozwiazanie = (TextView) findViewById(R.id.zadanko);

            rozwiazanie.setText("");
        }
    }
    public void OnClickPokazOdpowiedz(View v)
    {
        if(jdlacalejklasy!=0)
        {
            ImageView podp = (ImageView) findViewById(R.id.podp);
            podp.setImageResource(0);
           // TextView rozwiazanie = (TextView) findViewById(R.id.zadanko);
            //rozwiazanie.setText(R.string.rozwiazanie);
            ImageView rozww = (ImageView) findViewById(R.id.zdjecie);
            rozww.setImageResource(jdlacalejklasy);
            //rozwiazanie.setText(R.string.rozwiazanie);
        }

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    }









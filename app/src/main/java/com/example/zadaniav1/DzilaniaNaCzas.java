package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class DzilaniaNaCzas extends AppCompatActivity {

    int sec = 5;
    int pkt=0;
    int wynik;
    public boolean running=false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.drawable.trzykropek, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzilania_na_czas);
        //COFANIE NA PASKU AKCJI
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        runtimer();
        final TextView pkty= (TextView) findViewById(R.id.punkty);
        final EditText odpu = (EditText) findViewById(R.id.wynik);

        odpu.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void afterTextChanged(Editable mEdit)
            {
                String wpis = mEdit.toString();
                if(running)
                {
                    try{

                        int ww = Integer.parseInt(wpis);
                        if (ww == wynik) {
                            System.out.println("git");
                            odpu.setText("");
                            pkt++;
                            String s = "Punkty: "+pkt;
                            pkty.setText(s);
                            ixy();
                        }
                    }catch (Exception e){}
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
    }


    public void OnClickStart(View v) {
        final TextView timeView = (TextView) findViewById(R.id.stopwatch);
        Button but = (Button) findViewById(R.id.start);
        but.setText("Jeszcze raz!");
        running=true;
        sec=59;
        wynik=0;
        ixy();
        timeView.setTextColor(Color.parseColor("#808080"));
        // System.out.println("click");
    }

    public void ixy()
    {
        Random generator = new Random();
        int znak = generator.nextInt()%4;
        final TextView x1= (TextView) findViewById(R.id.x1);
        final TextView x2= (TextView) findViewById(R.id.x2);
        TextView plus = (TextView) findViewById(R.id.plus);
        int a = generator.nextInt()%15;
        int b = generator.nextInt()%15;
        if(a<0) a=a*-1;
        if(b<0) b=b*-1;

        switch (znak)
        {
            case 0:
            {
                wynik=a+b;
                plus.setText("+");
                break;
            }
            case 1:
            {
                wynik=a-b;
                plus.setText("-");
                break;
            }
            case 2:
            {
                wynik=a*b;
                plus.setText("*");
                System.out.println(wynik);
                break;
            }
            case 3:
            {
                if(a%b!=0)
                {
                    ixy();
                    break;
                }
                else
                {
                    wynik=a/b;
                    plus.setText("/");
                    break;
                }

            }
        }
        System.out.println(a+" "+b);
        System.out.println(wynik);
        x1.setText(""+a);
        x2.setText(""+b);
    }


    public void runtimer()
    {
        //MINUTNIK

        final TextView timeView = (TextView) findViewById(R.id.stopwatch);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String dd="00:";
                if(sec==0)
                {
                    running=false;
                    timeView.setTextColor(Color.parseColor("#B00020"));
                    dd+="0"+sec;
                    timeView.setText(dd);
                }
                if(running==true && sec>=0)
                {
                    if(sec>9)
                        dd+=sec;
                    else
                    {
                        dd+="0"+sec;
                    }
                    timeView.setText(dd);
                    sec=sec-1;
                }
                handler.postDelayed(this,1000);
            }

        });
    }

    //cofanie
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

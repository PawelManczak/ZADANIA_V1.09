package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class WyubierzRozdzialDoSciag extends AppCompatActivity {
    public int jaka;
    public int iledotkniete=0;

    //TRZYKROPEK
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.drawable.trzykropek, menu);
        return true;
    }
    //reportBug
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(WyubierzRozdzialDoSciag.this, reportError.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //COFANIE NA PASKU AKCJI
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyubierz_rozdzial_do_sciag);

        final Spinner roz = (Spinner) findViewById(R.id.rodzials);
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
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(WyubierzRozdzialDoSciag.this, android.R.layout.simple_spinner_item, rozdzialy);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roz.setAdapter(adapter);




    }

    public void OnClickSearch(View v)
    {
        final Spinner roz = (Spinner) findViewById(R.id.rodzials);
        TextView error = (TextView) findViewById(R.id.error);
        ImageView sciaga = (ImageView) findViewById(R.id.sciaga);

        final int jakiR = roz.getSelectedItemPosition();

        int j = getResources().getIdentifier("sciag"+jakiR ,"drawable", getPackageName());

        if(j!=0)
        {
            sciaga.setImageResource(j);
            error.setText("");
        }
        else
        {
            sciaga.setImageResource(0);
            error.setText("Ooops, wystąpił błąd ❣◕ ‿ ◕❣ ");
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

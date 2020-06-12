package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import static java.security.AccessController.getContext;

public class MenuMinigierki extends AppCompatActivity {

    private Context context = null;

    @Override
    protected void onResume() {
        super.onResume();
        Wjasne();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_minigierki);
        //COFANIE NA PASKU AKCJI
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Minigierki");
        context = this;

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MenuMinigierki.this, DodawanieNaCzas.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MenuMinigierki.this, DzilaniaNaCzas.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(MenuMinigierki.this, ListaKsiazekDoSciag.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.gry);
        listView.setOnItemClickListener(itemClickListener);
    }
    public void OnClickDodawanie(View v)
    {
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.Dodawanie);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent intent = new Intent(MenuMinigierki.this, DodawanieNaCzas.class);
        startActivity(intent);
    }
    public void OnClickDzialania(View v)
    {
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.Dzialania);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent intent = new Intent(MenuMinigierki.this, DzilaniaNaCzas.class);
        startActivity(intent);
    }
    //COFANIE NA PASKU AKCJI
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    //TRZYKROPEK
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.drawable.trzykropek, menu);
        return true;
    }

    //reportBug
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                Intent intent = new Intent(MenuMinigierki.this, reportError.class);
                startActivity(intent);
                return true;
    }

    public Context getContext(){
        return context;
    }

    public void Wjasne()
    {
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.Dodawanie);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
        RelativeLayout r1 = (RelativeLayout)  findViewById(R.id.Dzialania);
        r1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
    }
}

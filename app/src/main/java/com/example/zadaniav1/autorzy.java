package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class autorzy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorzy2);
        //COFANIE NA PASKU AKCJI
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //tytol
    setTitle("Autorzy");
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.drawable.trzykropek, menu);
        return true;
    }

    //reportBug
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(autorzy.this, reportError.class);
        startActivity(intent);
        return true;
    }

    //guzik cofajacy do glownego menu
    public void back(View v)
    {
        Intent intent = new Intent(autorzy.this, MainActivity.class);
        startActivity(intent);
    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}

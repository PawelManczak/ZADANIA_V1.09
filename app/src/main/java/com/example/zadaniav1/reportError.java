package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class reportError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_error);
    }
    //error jakis
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

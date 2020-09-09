package com.example.zadaniav1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //chowanie action baru
        getSupportActionBar().hide();
        context = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Wjasne();
    }

    //MENU NA LAYOUTACH
    public void OnClickKsiazki(View v)
    {
        //efekt ciemniejszego koloru
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.layout);
        RelativeLayout r1 = (RelativeLayout)  findViewById(R.id.layoutK);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));
        r1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent intent = new Intent(MainActivity.this, WyborKsiazek.class);
        startActivity(intent);
    }

    public void OnClickSciagi(View v)
    {
        //efekt ciemniejszego koloru
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.layoutS);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent intent = new Intent(MainActivity.this, ListaKsiazekDoSciag.class);
        startActivity(intent);
    }
    public void OnClickMinigierki(View v)
    {
        //efekt ciemniejszego koloru
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.layoutG);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent intent = new Intent(MainActivity.this, MenuMinigierki.class);
        startActivity(intent);
    }
    public void OnClickAutorzy(View v)
    {
        //efekt ciemniejszego koloru
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.layoutI);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent intent = new Intent(MainActivity.this, autorzy.class);
        startActivity(intent);
    }
    public Context getContext(){
        return context;
    }


    public void OnClickGit(View v)
    {
        //efekt ciemniejszego koloru
        ImageView r = (ImageView)  findViewById(R.id.button3);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        //LINK DO ZMIANY
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://github.com/PawelManczak/ZADANIA_V1.09"));

        startActivity(intent);
    }
    public void OnClickShare(View v)
    {
        //efekt ciemniejszego koloru
        ImageView r = (ImageView)  findViewById(R.id.button2);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        Intent sendIntent = new Intent();
        //LIMK DO ZMIANY
        String url="https://play.google.com/store/apps/dev?id=7962586262608152907&hl=pl";
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, url);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, "Poleć aplikacje znajomym!"));
    }
    public void OnClickMessage(View v)
    {
        //efekt ciemniejszego koloru
        ImageView r = (ImageView)  findViewById(R.id.button4);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        //Intent intent = new Intent(MainActivity.this, ListaKsiazekDoSciag.class);
        //startActivity(intent);
    }
    public void OnClickBugReport(View v)
    {
        //efekt ciemniejszego koloru
        ImageView r = (ImageView)  findViewById(R.id.button1);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbuttonclick));

        //Intent intent = new Intent(MainActivity.this, ListaKsiazekDoSciag.class);
        //startActivity(intent);
    }


    public void Wjasne()
    {
        RelativeLayout r = (RelativeLayout)  findViewById(R.id.layout);
        RelativeLayout r1 = (RelativeLayout)  findViewById(R.id.layoutK);
        r.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
        r1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));

        RelativeLayout r2 = (RelativeLayout)  findViewById(R.id.layoutS);
        r2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));

        RelativeLayout r3 = (RelativeLayout)  findViewById(R.id.layoutG);
        r3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));

        RelativeLayout r4 = (RelativeLayout)  findViewById(R.id.layoutI);
        r4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));

        //1
        ImageView z1 = (ImageView)  findViewById(R.id.button1);
        z1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
        //2
        ImageView z2 = (ImageView)  findViewById(R.id.button2);
        z2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
        //3
        ImageView z3 = (ImageView)  findViewById(R.id.button3);
        z3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
        //4
        ImageView z4 = (ImageView)  findViewById(R.id.button4);
        z4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.roundedbutton));
    }
}


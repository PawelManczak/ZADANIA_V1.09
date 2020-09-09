package com.example.zadaniav1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.security.KeyPairGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WyborKsiazek extends AppCompatActivity {

    String[] listviewTitle = new String[]{
            "Zbiór zadań do liceów i techników klasa 1", "Zbiór zadań do liceów i techników klasa 2", "Zbiór zadań do liceów i techników klasa 3", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
    };

    int[] listviewImage = new int[]{
            R.drawable.klasa1,R.drawable.klasa2,R.drawable.klasa3,R.drawable.klasa1,
            R.drawable.klasa2,R.drawable.klasa3,R.drawable.klasa1,R.drawable.klasa2,
    };

    String[] listviewShortDescription = new String[]{
            "Marcin Kurczab, Elżbieta Kurczab, Elżbieta Świda", "Marcin Kurczab, Elżbieta Kurczab, Elżbieta Świda", "Marcin Kurczab, Elżbieta Kurczab, Elżbieta Świda", "Android ListView Short Description",
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
    };

    //TRZYKROPEK
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.drawable.trzykropek, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //COFANIE NA PASKU AKCJI
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Zadania");
        setContentView(R.layout.activity_wybor_ksiazek);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.books_list);
        androidListView.setAdapter(simpleAdapter);


    final Book book = new Book();
    //System wybierania (position);

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0 || position == 1 || position == 2) {
                Intent intent = new Intent(WyborKsiazek.this, choose.class);
                book.setWybranaksiazka(position);
                intent.putExtra("pos", position);
                startActivity(intent);

            }
        }
    };
         ListView listView = (ListView) findViewById(R.id.books_list);
        listView.setOnItemClickListener(itemClickListener);
}


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

package com.example.zadaniav1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Book {

    int wybranaksiazka;
    int wybranyRozdzial;
    int iloscrozdzialowwybranejksiazki;
    String text ="";
    int ilerozdzialow[] = {8,4,7};


    ArrayList<Integer> zadania = new ArrayList<Integer>();

    public void setWybranaksiazka(int wybranaksiazka) {
        this.wybranaksiazka = wybranaksiazka;
        iloscrozdzialowwybranejksiazki=ilerozdzialow[wybranaksiazka];
        //System.out.println(iloscrozdzialowwybranejksiazki);
    }

    public int ilezadan(int jaka, int rozdz)
    {

            if(jaka==0)
            {
                switch (rozdz)
                {
                    case 0 : return 111;
                    case 1: return 43;
                    case 2: return 12;
                    case 3: return 13;
                    case 4: return 54;
                    case 5: return 34;
                    case 6: return 124;
                    case 7: return 76;
                }
            }
        if(jaka==1)
            {
                switch (rozdz)
                {
                    case 0: return 111;
                    case 1: return 43;
                    case 2: return 12;
                    case 3: return 13;
                    case 4: return 54;
                }
            }
        if(jaka==2)
            {
                switch (rozdz)
                {
                    case 0: return 111;
                    case 1: return 43;
                    case 2: return 12;
                    case 3: return 13;
                    case 4: return 54;
                    case 5: return 34;
                    case 6: return 124;
                }
            }
        return jaka;
    }

    public int getRozdz(int n) {
        return ilerozdzialow[n];
    }

    public String getText() {
        return text;
    }

    public void setWybranyRozdzial(int wybranyRozdzial) {
        this.wybranyRozdzial = wybranyRozdzial;
        System.out.println(wybranyRozdzial);
    }

    public void setText(String text) {
        this.text = text;
    }
}

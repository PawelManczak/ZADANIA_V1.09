package com.example.zadaniav1;

public class Rozdzialy {
    String[] rozdz(int jaka)
    {
        Book book= new Book();
        final int ilerozdz = book.getRozdz(jaka);
        final String [] rozdzialy = new String [ilerozdz];
        String [] arrmile ={"Rozdział I","Rozdział II","Rozdział III","Rozdział IV","Rozdział V","Rozdział VI","Rozdział VII","Rozdział VIII","Rozdział IX","Rozdział X","Rozdział XI","Rozdział XII","Rozdział XIII"};
        for(int i = 0; i< ilerozdz; i++)
        {
            rozdzialy[i]=arrmile[i];
        }
        return  rozdzialy;
    }


}

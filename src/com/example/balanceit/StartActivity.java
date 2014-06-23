package com.example.balanceit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/** Die StartActivity-Klasse ist die erste Activity (Bildschirmseite), die beim Start der App angezeigt wird.
 * Sie ist eine Kindklasse der Activity-Basisklasse von Android, die die einzelnen Bilschirme einer App repräsentiert.
 * Es werden die Bedienelemente des Startbildschirms angezeigt und auf die Benutzereingaben (Klicks) reagiert. */
public class StartActivity extends Activity {

    /** Callback-Methode, die beim Initialisieren der Activity aufgerufen wird (eine Art Konstruktor für die Activity) */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Aufruf der entsprechenden Basisklassen-Methode
        super.onCreate(savedInstanceState);

        //setzen des Content, der in der Datei activity_start.xml beschrieben ist
        setContentView(R.layout.activity_start);
    }

    /** Callback-Methode, die beim Klick auf die Buttons aufgerufen wird */
    public void startGame(View view){

        //rufe die GameActivity über einen Intent auf 
    	//TODO AP Framework: übergib gewünschtes Spiel-Level und Schwierigkeitsgrad
        Intent intent=new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    
}

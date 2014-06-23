package com.example.balanceit;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.balanceit.R;

/** Die GameActivity-Klasse ist die zentrale Activity des Spiels (Bildschirmseite die das Spielgeschehen darstellt).
 * Sie ist eine Kindklasse der Activity-Basisklasse von Android, die die einzelnen Bilschirme einer App repräsentiert.
 * Es wird eine Spielwelt der World-Klasse angelegt und angezeigt und die Benutzerinteraktion (Neigungssensoren) aufgesetzt.
 */
public class GameActivity extends Activity {

	//Membervariablen
    private World mWorld;
    private SensorManager mSensorManager;
    private GravitySensorListener mSensorListener;

    /** Callback-Methode, die beim Initialisieren der Activity aufgerufen wird (eine Art Konstruktor für die Activity) */
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        //Aufruf der entsprechenden Basisklassen-Methode
		super.onCreate(savedInstanceState);

        // verhindert, dass der Bildschirm ausgeht, wenn keine Touch-Events mehr kommen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
        //TODO AP Framework: Level, Schwierigkeitsgrad von der aufrufenden Activity lesen und an World-Objekt übergeben

        //TODO AP2: Member initialisieren (SensorManager, SensorListener und World Instanzen)
		
		//TODO AP2: World-Instanz als ContentView setzen
	}
    
    /** Callback-Methode, wenn die Aktivität aktiv wird (in den Vordergrund kommt) */
    @Override
     protected void onResume() {
         //Aufruf der Basisklassen-Methode
         super.onResume();

         //TODO AP2: registriere den SensorListener
     }

     /** Callback-Methode, wenn die Aktivität inaktiv wird (nicht mehr im Vordergrund ist) */
   @Override
     protected void onPause() {
         //Aufruf der Basisklassen-Methode
         super.onPause();

         //TODO AP2: stoppe den SensorListener (das spart Strom, wenn die App nicht im Vordergrund ist)
     }

}

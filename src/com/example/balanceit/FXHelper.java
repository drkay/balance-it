package com.example.balanceit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Vibrator;
import android.util.Log;

/**
 * Diese Klasse umfasst Hilfsfunktionen zur Integration von Grafik-, Sound- und Vibrationseffekten, 
 * sowie einige weitere bereits fertig programmierte Hilfsfunktionen für das Spiel.
 */
public class FXHelper {

    /** ENUM-Typ, der die Art des betreffenden Objekts bzw. Effekts beschreibt */
    enum ObjectType {BOARD, WALL, BALL, TARGET, HOLE };

    // App-Context von Android
    private Context mContext;
  

    //TODO AP Effekte: weitere Membervariablen (Android Manager Klassen für Sound & Vibrations, IDs für verschiedene Sounds, Bitmaps für die Objekte)

    private Vibrator mV;
/** Konstruktor
     * @param context Kontext der Android-Activity
     */ 
    FXHelper(Context context) {
    	//TODO AP Effekte: Membervariablen anlegen, Managerklassen vom System holen, Sounds laden
    	mContext = context;
    	mV = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
    }
 
    /** löse Vibration aus
     * @param durationInMs Dauer in ms
     */
    public void vibrate(int durationInMs){
    	//TODO AP Effekte: Vibrationseffekt auslösen
    	 mV.vibrate(50);

    }

    /**spiele Soundeffekt ab
     * @param type Typ des Objekts, das den Soundeffekt auslöst
     */
    public void playSound(ObjectType type){
    	//TODO AP Effekte: Sound für den entsprechenden Objekttyp abspielen
    }

    /** lade und initialisiere alle Bitmaps (das kann noch nicht im Konstruktor passieren, da die Screen-Größe beim Konstruktoraufruf noch nicht bekannt ist)
     * @param screenWidth Spielfeldbreite
     * @param screenHeight Spielfeldhöhr
     * @param tileSize Kachelgröße
     * @param ballRadius Radius der Spielkugel
     */
    public void initBitmaps(int screenWidth, int screenHeight, int tileSize, int ballRadius){
    	//TODO AP Effekte: die Bitmaps für die verschiedenen Spielobjekte (Hindernis, Zielbereich, Spielkugel, Hintergrund) einlesen
    	// auf die richtige Größe (abhängig von Bildschirm-& Kachelgröße) skalieren und in Membervariablen zwischenspeichern    	
    }

    /** Zugriff auf die Bitmap eines Objekts
     * @param type Typ des Objekts, für das die Bitmap zurückgegeben wird
     * @return Bitmap
     */
    public Bitmap getBitmap(ObjectType type){
    	//TODO AP Effekte: die passende Bitmap für das Objekt zurückgeben
        return null;
    }

    
   //fertig programmierte Hilfsfunktionen:
    
   /** zeige eine Erfolgsmeldung an und kehre zur aufrufenden Activity zurück
    * @param context Verweis auf die aufrufende Activity (kann meist als this übergeben werden)
    * @param title Titel der Dialogbox
    * @param message Text der Dialogbox
    */
	static public void showDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(android.R.string.ok, null)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .show();
		
	}
	
}

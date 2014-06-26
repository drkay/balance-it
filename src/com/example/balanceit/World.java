package com.example.balanceit;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Die World-Klasse repräsentiert die Spielwelt.
 * Sie ist eine Kindklasse von View, die die Basisklasse aller UI-Elemente von Android ist.
 * Zum Zeichnen der Spielwelt wird die onDraw-Methode aus der View-Basisklasse neu implementiert.
 */
public class World extends View {

	//Hilfsobjekte
    private FXHelper mHelper;
    private GravitySensorListener mSensorListener;

    //Statusvariablen
    private boolean mTargetReached=false;
    private boolean mHoleDropped=false;

    //Variablen zur Spielfeldgröße
    private int mWidth;
    private int mHeight;
    private int mTileSize;

    // Spielfeldobjekte
    private Ball mBall;
    private List<Tile> mTargets = new ArrayList<Tile>();
    private List<Tile> mHoles = new ArrayList<Tile>();

    //String der das Spielfeld beschreibt
    private String mBoard;

    //Spielfeldgröße 16x26 Kacheln, das ist ~16:9, das Seitenverhältnis der meisten Smartphones
    private static final int NUM_ROWS=26;
    private static final int NUM_COLS=16;

    /** Ein Beispiel für die Definition eines Levels über einen String
     * Die einzelnen Buchstaben repräsentieren die Spielobjekte und ihre Position:
     * . - leere Kachel
     * b - Startposition der Spielkugel
     * h - Position der Hindernisse (Löcher)
     * t - Position des Zielbereichs
     * Mit Hilfe des Strings werden die Tile-Objekte und das Ball-Objekt in der onSizeChanged-Methode angelegt. 
     */
    private static final String BOARD1=
            "b..............."+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "hhhhhhhhhhhhhh.."+
            "................"+
            "................"+
            "................"+
            "..hhhhhhhhhhhhhh"+
            "................"+
            "................"+
            "................"+
            "hhhhhhh..hhhhhhh"+
            "......h..h......"+
            "......h..h......"+
            "................"+
            "................"+
            "................"+
            "................"+
            "...hhhhhhhhhh..."+
            "................"+
            ".......tt......."+
            ".......tt......."+
            "................";
    
    /** Konstruktor
     * @param context Kontext-Objekt der Android-Activity
     * @param sensorListener SensorListener-Objekt mit aktuellen Sensordaten 
     * @param level Spielstufe
     * @param difficulty Schwierigkeitsgrad
     */
    public World(Context context, GravitySensorListener sensorListener, int level, int difficulty) {
    	super(context);
    	//TODO AP2: Übergabeparameter sensorListener in Membervariable speichern
    	//TODO AP Welt: restliche Übergabeparameter speichern, Hilfsobjekte anlegen
    }

    /** vom System gelieferte Bildschirmgröße merken und die Kachelgröße berechnen, Spielfeld anlegen 
     * @param width neue Spielfeldbreite
     * @param height neue Spielfeldhöhe
     * @param oldw vorherige Spielfeldbreite (nicht verwendet)
     * @param oldh vorherige Spielfeldhöhe (nicht verwendet)
     */
    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
    	//TODO AP2: Spielkugel mit Dummywerten anlegen
    	//TODO AP Welt: Kachelgröße berechnen
    	//TODO AP Welt: Bitmaps initialisieren
        //TODO AP Welt: Spielfeld-Objekte anlegen (Kugel, Ziel, Hindernisse)

    }

    /** Spielwelt darstellen (Hintergrund,Kugel,Hindernisse, Ziel), Spiellogik (Reaktion auf Ziel, Hindernisse)
     * @param canvas Leinwandobjekt
     */
    @Override
    protected void onDraw(Canvas canvas) {

    	//TODO AP2: Hintergrund löschen
    	//TODO AP2: Kugel bewegen
    	//TODO AP2: Kugel zeichnen
    	
    	//TODO AP Welt: Hintergrund zeichnen
    	//TODO AP Welt: Ziel & Hindernisse zeichnen
    	//TODO AP Welt: Kugel bewegen und zeichnen

    	//TODO AP Welt: Test auf Kollision mit Hindernissen und Reaktion
    	//TODO AP Welt: Test auf Erreichen des Ziels und Reaktion

        // sofortiges Neuzeichnen auslösen
        invalidate();
    }

}

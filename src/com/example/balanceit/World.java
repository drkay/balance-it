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

    private FXHelper mHelper;
    private GravitySensorListener mSensorListener;

    private boolean mTargetReached=false;
    private boolean mHoleDropped=false;
    private int mHoleDroppedCounter;

    private int mWidth;
    private int mHeight;
    private int mTileSize;

    private Ball mBall;
    private List<Tile> mTargets = new ArrayList<Tile>();
    private List<Tile> mHoles = new ArrayList<Tile>();

    private String mBoard;

    //Spielfeldgröße 16x26 Kacheln, das ist ~16:9, das Seitenverhältnis der meisten Smartphones
    private static final int NUM_ROWS=26;
    private static final int NUM_COLS=16;

    // Ein Beispiel für die Definition eines Levels über einen String
    // Die einzelnen Buchstaben repräsentieren die Spielobjekte und ihre Position:
    // . - leere Kachel
    // b - Startposition der Spielkugel
    // h - Position der Hindernisse (Löcher)
    // t - Position des Zielbereichs
    // Mit Hilfe des Strings werden die Tile-Objekte und das Ball-Objekt in der onSizeChanged-Methode angelegt.
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
    
    //Konstruktor
    public World(Context context, GravitySensorListener sensorListener, int level, int difficulty) {
    	super(context);
    	//TODO member initilisieren (außer Spielfeld)
    }

    // vom System gelieferte Bildschirmgröße merken und die Kachelgröße berechnen, Spielfeld anlegen 
    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
    	//TODO Kachelgröße berechnen
    	//TODO bitmaps initialisieren
        //TODO Spielfeld-Objekte anlegen (Kugel, Ziel, Hindernisse)

    }

    // Spielwelt darstellen (Hintergrund,Kugel,Hindernisse, Ziel), Spiellogik (Reaktion auf Ziel, Hindernisse)
    @Override
    protected void onDraw(Canvas canvas) {

    	//TODO Hintergrund zeichnen
    	//TODO Ziel zeichnen
    	//TODO Hindernisse zeichnen
    	//TODO Kugel bewegen und zeichnen

    	//TODO Test auf Kollision mit Hindernissen und Reaktion
    	//TODO Test auf Erreichen des Ziels und Reaktion

        // sofortiges Neuzeichnen auslösen
        invalidate();
    }

}
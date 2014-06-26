package com.example.balanceit;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Die Tile-Klasse repräsentiert eine Kachel der Spielwelt.
 * Sie speichert Informationen zu Typ, Position und Darstellung der Kachel.
 */
public class Tile {

    /** ENUM-Typ für die Form des Kachelobjekts: quadratisch/kreisförmig */
    enum Type {SQUARE,CIRCLE};

    public Type mType;

    //TODO AP Welt: weitere Membervariablen (mPosX, mPosY, mBitmap) 

    /** Konstruktor
     * @param type Art der Kachel (Rechteck, Kreis)
     * @param x Position X
     * @param y Position Y
     * @param size Kachelgröße
     * @param bitmap Bitmap des Kachelobjekts
     */
    Tile (Type type, int x, int y, int size, Bitmap bitmap){
    	//TODO AP Welt: initialisiere die Membervariablen
    }

    /**zeichne die Kachelbitmap an der Position mPosX/Y
     * @param canvas Leinwand
     */
    void draw(Canvas canvas){
        //TODO AP Welt: Kachelbitmap zeichnen
    }
}

package com.example.balanceit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Die Ball-Klasse repräsentiert die Spielkugel.
 * Sie speichert die aktuelle  und die letzte Position, die Geschwindigkeit, die Startposition, den Kugelradius
 * und die Bitmap zur Darstellung.
 * Es existieren Methoden zur Kugelbewegung, zur Kollisionserkennung mit dem Spielfeldrand und zum Bestimmen,
 * ob sich die Kugel innerhalb einer bestimmten Spielfeldkachel befindet.
 * Außerdem wird eine Methode zum Zeichnen der Kugel bereitgestellt.
 */
class Ball {

    //Membervariablen mit unveränderlichen Kugeldaten (Startposition, Kachelgröße, Kugelradius, Bitmap)
    private int mStartX;
    private int mStartY;
    private int mTileSize;
    private int mBallRadius;
    private Paint mPaint;
    private Bitmap mBitmap;

    //Membervariablen mit bewegtne Kugeldaten (aktuelle und letzte Position, im letzten Schritt zurückgelegte Bewegung)
    private float mPosX;
    private float mPosY;
    private float mMovementX;
    private float mMovementY;
    private float mLastPosX;
    private float mLastPosY;

    //Konstruktor
    Ball(int x, int y, int tileSize, int radius, Bitmap bitmap) {
    //TODO AP2: Übergabeparamter in Membervariablen speichern, mPaint initialisieren
    }

    //setze Kugel auf Startposition zurück
    public void reset(){
     }

    //berechne neue Kugelposition aus Accelerometerwerten
    public void update(float sensorX, float sensorY) {
        //TODO AP2: als Testimplementierung die Sensorwerte auf die Kugelposition aufaddieren
    	//TODO AP Kugel: Kugelposition mit Sensordaten aktualisieren 
    }

    //korrigiere die Position, wenn die Kugel das Spielfeld verlässt
    //signalisiere eine Kollision an den Aufrufer, wenn die letzte Bewegung größer als die Schwelle ist
    public boolean resolveCollisionWithBounds(int width, int height) {
    	return false;
    }

    //teste ob Kugelzentrum innerhalb des Kachelobjekts ist
    //bei quadratischen Objekten betrachte Abstand entlang X/Y-Achse
    //bei kreisförmigen Objekten berechne Abstand zum Kreisrand
    public boolean centerIsOnTile(Tile tile) {
    	return false;
    }

    //berechne X-Abstand von Kugelzentrum zu Kachelzentrum
    private float calcDistanceX(Tile tile){
    	return 0.0f;
    }
    //berechne Y-Abstand von Kugelzentrum zu Kachelzentrum
    private float calcDistanceY(Tile tile){
    	return 0.0f;
    }

    //zeichne die Kugelbitmap an der aktuellen (gerundeten) Position
    public void draw(Canvas canvas) {
        //TODO AP2: einen Kreis mit Kugelradius an der Kugelposition zeichnen
    	//TODO AP Kugel: die Kugelbitmap an der Kugelposition darstellen 
    }
}

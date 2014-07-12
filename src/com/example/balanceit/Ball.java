package com.example.balanceit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
    private int mTileSize;
    private int mRadius;
    private int mDifficulty;
    private Bitmap mBitmap;
    private Paint mPaint;

    //Membervariablen mit bewegten Kugeldaten (aktuelle Position)
    public float mPosX;
    public float mPosY;

    /** Konstruktor 
     * @param x Startposition X der Kugel
     * @param y Startposition Y der Kugel
     * @param tileSize Kachelgröße
     * @param radius Kugelradius
     * @param bitmap Bitmap der Kugel
     */
    Ball(int x, int y, int tileSize, int radius, int difficulty, Bitmap bitmap) {
    //TODO AP2: Übergabeparameter in Membervariablen speichern, mPaint initialisieren
    	mPosX=x;
    	mPosY=y;
    	mTileSize=tileSize;
    	mRadius=radius;
    	mDifficulty=difficulty;
    	mPaint=new Paint();
    	mPaint.setColor(Color.RED);
    //TODO AP Kugel: restliche Membervariablen initialisieren, Startposition merken
    }

    /** setze Kugel auf Startposition zurück */
    public void reset(){
    	//TODO AP Kugel: Position zurücksetzen
     }

    /** berechne neue Kugelposition aus Accelerometerwerten 
     * @param sensorX X-Wert des Neigungssensors
     * @param sensorY Y-Wert des Neigungssensors
     */
    public void updatePosition(float sensorX, float sensorY) {
        //TODO AP2: als Testimplementierung die Sensorwerte auf die Kugelposition aufaddieren
    	mPosX=mPosX+8*sensorX;
    	mPosY=mPosY+8*sensorY;
    	
    	//TODO AP Kugel: Kugelposition mit Sensordaten aktualisieren 
    }

    /** korrigiere die Position, wenn die Kugel das Spielfeld verlässt
     * @param width Spielfeldbreite
     * @param height Spielfeldhöhe
     * @return true, wenn eine Kollision mit den Wänden erfolgt ist
     */
    public boolean resolveCollisionWithBounds(int width, int height) {
    	//TODO AP Kugel: Kugelposition innerhalb des Spielfelds halten
    	//TODO AP Kugel: true zurückliefern bei Kollision mit den Wänden 
    	return false;
    }

    /** teste ob Kugelzentrum innerhalb des Kachelobjekts ist,
     * bei quadratischen Objekten betrachte Abstand entlang X/Y-Achse,
     * bei kreisförmigen Objekten berechne Abstand zum Kreisrand
     * @param tile Kachel
     * @return true, wenn Kugelzentrum über aktivem (Rechteck,Kreis)-Bereich der Kachel ist
     */
    public boolean centerIsOnTile(Tile tile) {
    	//TODO AP Kugel: Kugelposition testen
    	return false;
    }

    /** berechne X-Abstand von Kugelzentrum zu Kachelzentrum
     * @param tile Kachel
     * @return Abstand in X-Koordinatenrichtung
     */
    private float calcDistanceX(Tile tile){
    	//TODO AP Kugel: Abstand X berechnen
    	return 0.0f;
    }

    /** berechne Y-Abstand von Kugelzentrum zu Kachelzentrum
     * @param tile Kachel
     * @return Abstand in Y-Koordinatenrichtung
     */
    private float calcDistanceY(Tile tile){
    	//TODO AP Kugel: Abstand Y berechnen
    	return 0.0f;
    }

    /** zeichne die Kugelbitmap an der aktuellen (gerundeten) Position
     * @param canvas Leinwand
     */
    public void draw(Canvas canvas) {
        //TODO AP2: einen Kreis mit Kugelradius an der Kugelposition zeichnen
    	canvas.drawCircle(mPosX,mPosY,mRadius,mPaint);
    	//TODO AP Kugel: die Kugelbitmap an der Kugelposition darstellen 
    }
}

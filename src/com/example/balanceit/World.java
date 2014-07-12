package com.example.balanceit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Die World-Klasse repräsentiert die Spielwelt.
 * Sie ist eine Kindklasse von View, die die Basisklasse aller UI-Elemente von Android ist.
 * Zum Zeichnen der Spielwelt wird die onDraw-Methode aus der View-Basisklasse neu implementiert.
 */
public class World extends View {

	//LOGTAG Konstante zum Markieren von Debugausgaben im System Log
	public static final String LOGTAG="BalanceIt";
	
	//Hilfsobjekte
    private FXHelper mHelper;
    private GravitySensorListener mSensorListener;
    private Paint mPaint;
    
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

    /** Ein Beispiel für die Definition eines Levels über einen String (NUM_ROWS x NUM_COLS)
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
    
    //TODO AP ALL: weitere Level entwerfen
    
    /** Konstruktor
     * @param context Kontext-Objekt der Android-Activity
     * @param sensorListener SensorListener-Objekt mit aktuellen Sensordaten 
     * @param level Spielstufe
     * @param difficulty Schwierigkeitsgrad
     */
    public World(Context context, GravitySensorListener sensorListener, int level, int difficulty) {
    	super(context);
    	//TODO AP2: Übergabeparameter sensorListener in Membervariable speichern
    	mSensorListener=sensorListener;
    	mPaint=new Paint();
    	mPaint.setColor(Color.GRAY);
    	mHelper=new FXHelper(context);
    	
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
    	//TODO AP2: width, height speichern, nur Kugel in Spielfeldmitte anlegen
    	mWidth = width;
    	mHeight = height;
    	mBall = new Ball(width/2,height/2,width/20,width/20,0,null);
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
    	canvas.drawColor(Color.BLACK);
    	//TODO AP2: Ziel zeichnen
    	canvas.drawRect(0, 0.8f*mHeight, mWidth, mHeight, mPaint);
    	//TODO AP2: Kugel bewegen
    	mBall.updatePosition(-mSensorListener.mSensorX,mSensorListener.mSensorY);
    	//TODO AP2: Kugel zeichnen
    	mBall.draw(canvas);
    	//TODO AP2: Test ob Ziel erreicht
    	if (mBall.mPosY>0.8*mHeight){
    		Activity activity = (Activity) getContext();
     		activity.setResult(Activity.RESULT_OK);
    		activity.finish();
    	}
    	
    	
    	//TODO AP Welt: Hintergrund zeichnen
    	//TODO AP Welt: Ziel & Hindernisse zeichnen
    	//TODO AP Welt: Kugel bewegen und zeichnen

    	//TODO AP Welt: Test auf Kollision mit Hindernissen und Reaktion
    	//TODO AP Welt: Test auf Erreichen des Ziels und Reaktion

        // sofortiges Neuzeichnen auslösen
        invalidate();
    }

}

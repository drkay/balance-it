package com.example.balanceit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.example.balanceit.FXHelper.ObjectType;

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
    private int mDifficulty;
    
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
   
    private static final String BOARD2=
            "tt.............."+
            "tt.............."+
            "hhhhhhhhhhhhhh.."+
            "................"+
            "................"+
            "..hhhhhhhhhhhhhh"+
            "................"+
            "................"+
            "hhhhhhhhhhhhhh.."+
            "................"+
            "................"+
            "..hhhhhhhhhhhhhh"+
            "................"+
            "................"+
            "hhhhhhhhhhhhhh.."+
            "................"+
            "................"+
            "..hhhhhhhhhhhhhh"+
            "................"+
            "................"+
            "hhhhhhhhhhhhhh.."+
            "................"+
            "................"+
            "..hhhhhhhhhhhhhh"+
            "................"+
            "...............b";
    
    private static final String BOARD3=
            ".......tt......."+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            ".......bb......."+
            ".......bb......."+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            "................"+
            ".......tt.......";
    
    private static final String BOARD4=
            ".....h......h..b"+
            "............h..."+
            "...h...hh...h..."+
            "...h...hh......."+
            "...h............"+
            "...hhhhhhhhhhhhh"+
            "................"+
            ".......h........"+
            "hhhhhhhhhh...hhh"+
            ".......h........"+
            ".......h........"+
            "...h...h..hhh..."+
            "...h...h..hhh..."+
            "...h...h........"+
            "...h...hhh...hhh"+
            "...h............"+
            "...h............"+
            "...hhhhhhhhhhhhh"+
            "........h......."+
            "....h.......h..."+
            "hhhhhhhhhhhhh..."+
            "....h.......h..."+
            "....h.......h..."+
            "hhhhh...h...h..."+
            "tt..h...h...h..."+
            "tt......h......."+
            "tt......h.......";
  
    
    
    
    private void createGameObjects(char objectType, int col, int row) {
    	    	
    	if(objectType == 'h') {
    		Bitmap holeBitmap = mHelper.getBitmap(ObjectType.HOLE);
    		mHoles.add(new Tile(Tile.Type.CIRCLE, col*mTileSize, row*mTileSize, mTileSize, holeBitmap));
    	}
    	
    	if(objectType == 't') {
    		Bitmap tileBitmap = mHelper.getBitmap(ObjectType.TARGET);
    		mTargets.add(new Tile(Tile.Type.SQUARE, col*mTileSize, row*mTileSize, mTileSize, tileBitmap));
    	}
    	
    	if(objectType == 'b') {
    		Bitmap ballBitmap = mHelper.getBitmap(ObjectType.BALL);
        	mBall = new Ball(col*mTileSize, row*mTileSize, mTileSize/2, mTileSize, mDifficulty, ballBitmap);
    	}
    }
    
    
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
    	mDifficulty=difficulty;
    	mHelper=new FXHelper(context);

    		if (level==1){
    		mBoard = BOARD1;
    		}
    		else if (level == 2){
    			mBoard = BOARD2;
    		}
    		else if (level == 3){
    			mBoard = BOARD3;
    		}
    		else if (level == 4){
    			mBoard = BOARD4;
    		}
    	

    	
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
    	
    	mTileSize = width/NUM_COLS;
    	mHelper.initBitmaps(mWidth, mHeight, mTileSize, width/20);
    	//TODO AP Welt: Kachelgr��e berechnen
    	//TODO AP Welt: Bitmaps initialisieren
        //TODO AP Welt: Spielfeld-Objekte anlegen (Kugel, Ziel, Hindernisse)
    	 
        char c=' ';
        int index = 0;
        
        	for(int row = 0; row < NUM_ROWS; row++) {
        		for(int col = 0; col < NUM_COLS; col++) {
        				c = mBoard.charAt(index++);
        			createGameObjects(c, col, row);
        		}    	
        	}    
        
    }

    /** Spielwelt darstellen (Hintergrund,Kugel,Hindernisse, Ziel), Spiellogik (Reaktion auf Ziel, Hindernisse)
     * @param canvas Leinwandobjekt
     */
    @Override
    protected void onDraw(Canvas canvas) {

    	//TODO AP2: Hintergrund l�schen
    	canvas.drawColor(Color.BLACK);
    	//TODO AP2: Ziel zeichnen
    	  	    	    	
    	//TODO AP Welt: Hintergrund zeichnen
    	//TODO AP Welt: Ziel & Hindernisse zeichnen
    	
    	//canvas.drawBitmap(bitmap, 0, 0, null);
   	for(Tile t:mHoles) {
    		t.draw(canvas);
    	}
    	
    	for(Tile z:mTargets) {
    		z.draw(canvas);
    	}
    	
    	//TODO AP2: Kugel bewegen
    	mBall.updatePosition(-mSensorListener.mSensorX,mSensorListener.mSensorY);
    	mBall.resolveCollisionWithBounds(mWidth, mHeight);
    	 //TODO AP2: Kugel zeichnen
    	mBall.draw(canvas);
    	//TODO AP2: Test ob Ziel erreicht

    	//TODO AP Welt: Test auf Kollision mit Hindernissen und Reaktion
    	for(Tile t:mHoles) {
    		if(mBall.centerIsOnTile(t)) {
    			mBall.reset();
    		}
    	}
    	
    	//TODO AP Welt: Test auf Erreichen des Ziels und Reaktion
    	for(Tile z:mTargets) {
    		if(mBall.centerIsOnTile(z)) {
    			Activity a = (Activity) getContext();
    			a.setResult(Activity.RESULT_OK);
    			a.finish();
    		}
    	}
        // sofortiges Neuzeichnen auslösen
        invalidate();
    }

}

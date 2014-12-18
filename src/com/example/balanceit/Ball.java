package com.example.balanceit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

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
    private int mStartPosX;
    private int mStartPosY;
    private int mSpeed;
    //Membervariablen mit bewegten Kugeldaten (aktuelle Position)
    public float mPosX;
    public float mPosY;
    public float mStepX;
    public float mStepY;

    /** Konstruktor 
     * @param x Startposition X der Kugel
     * @param y Startposition Y der Kugel
     * @param radius Kugelradius
     * @param tileSize Kachelgröße
     * @param difficulty Schwierigkeitsgrad/Geschwindigkeit der Kugelbewegung
     * @param bitmap Bitmap der Kugel
     */
    Ball(int x, int y, int radius,  int tileSize, int difficulty, Bitmap bitmap) {
    //TODO AP2: Übergabeparameter in Membervariablen speichern, mPaint initialisieren
    	mPosX=x;
    	mPosY=y;
    	mTileSize=tileSize;
    	mRadius=radius;
    	mDifficulty=difficulty;
    	mPaint=new Paint();
    	mPaint.setColor(Color.RED);
		mStartPosX=x;
		mStartPosY=y; 
		
		if (mDifficulty ==0){
			mSpeed = 4;
		
		}
		if (mDifficulty == 1){
			mSpeed = 8;
		}
		if  (mDifficulty ==2){
			mSpeed =12;
		}
    //TODO AP Kugel: restliche Membervariablen initialisieren, Startposition merken
    }

    /** setze Kugel auf Startposition zurück */
    public void reset(){
    	mPosY=mStartPosY;
       mPosX=mStartPosX;
    	
    	//TODO AP Kugel: Position zurücksetzen
     }

    /** berechne neue Kugelposition aus Accelerometerwerten 
     * @param sensorX X-Wert des Neigungssensors
     * @param sensorY Y-Wert des Neigungssensors
     */
    public void updatePosition(float sensorX, float sensorY) {
        //TODO AP2: als Testimplementierung die Sensorwerte auf die Kugelposition aufaddieren
    	mStepX=mSpeed*sensorX;
    	if (mStepX>mTileSize){
    		mStepX=mTileSize;
    	}
    	mStepY=mSpeed*sensorY;
    	if (mStepY>mTileSize){
    		mStepY=mTileSize;
    	}
    	mPosX=mPosX+mStepX;
    	mPosY=mPosY+mStepY;
    	
    	//TODO AP Kugel: Kugelposition mit Sensordaten aktualisieren 
    }

    /** korrigiere die Position, wenn die Kugel das Spielfeld verlässt
     *  @param width Spielfeldbreite
     * @param height Spielfeldhöhe
     * @return true, wenn eine Kollision mit den Wänden erfolgt ist
     */
    public boolean resolveCollisionWithBounds(int width, int height) {
    if ( mPosX<0){
    	mPosX=0;
    }
    if (mPosX>width-(2*mRadius)){
    	mPosX=width-(2*mRadius);
    }
    	
    if(mPosY<0){
    	mPosY=0;
    }
    if(mPosY>height-(2*mRadius)){
    	mPosY=height-(2*mRadius);
    }
    
    	//TODO AP Kugel: Kugelposition innerhalb des Spielfelds halten
    	//TODO AP Kugel: true zurückliefern bei Kollision mit den Wänden 

    if (mPosX==0 || mPosX==width-(2*mRadius) || mPosY==0 || mPosY==height-(2*mRadius) ){
    	return true;
    }
    else return false;
  
    }

    /** teste ob Kugelzentrum innerhalb des Kachelobjekts ist,
     * bei quadratischen Objekten betrachte Abstand entlang X/Y-Achse,
     * bei kreisförmigen Objekten berechne Abstand zum Kreisrand
     * @param tile Kachel
     * @return true, wenn Kugelzentrum über aktivem (Rechteck,Kreis)-Bereich der Kachel ist
     */
    public boolean centerIsOnTile(Tile tile) {
    	//Log.v(World.LOGTAG,"Pos:"+mPosX+","+mPosY);
    	//Log.v(World.LOGTAG,"Posk:"+tile.mPosX+","+tile.mPosY);
    	//Log.v(World.LOGTAG,"kt:"+tile.mType);
    	//TODO AP Kugel: Kugelposition testen
    	if(tile.mType == Tile.Type.SQUARE){
    	
    		if ((mPosX+ mRadius)>tile.mPosX && (mPosX+ mRadius)<tile.mPosX+mTileSize
    			&&( mPosY+ mRadius)>tile.mPosY && (mPosY +mRadius)<tile.mPosY+mTileSize){
    		
    			return true; 
    		}
    	}
//    	Log.v(World.LOGTAG,"Pos:"+mPosX+","+mPosY);
    	if(tile.mType == Tile.Type.CIRCLE){
			if (Math.sqrt((mPosX-tile.mPosX) * (mPosX-tile.mPosX)+ (mPosY-tile.mPosY)*(mPosY-tile.mPosY)) <= 0.5* mTileSize){
				return true;
			}
		}
    return false ;
    }

    /** berechne X-Abstand von Kugelzentrum zu Kachelzentrum
     * @param tile Kachel
     * @return Abstand in X-Koordinatenrichtung
     */
    private float calcDistanceX(Tile tile){
//    	Math.abs(x);
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
    	//solange keine Bitmap vorhanden ist, einen Kreis zeichen
    	if (mBitmap==null){
            //TODO AP2: einen Kreis mit Kugelradius an der Kugelposition zeichnen
    		canvas.drawCircle(mPosX+mRadius,mPosY+mRadius,mRadius,mPaint);
    	} else {
    		canvas.drawBitmap(mBitmap, (int) (mPosX+0.5), (int) (mPosY+0.5), null);
    	}
    		
    }
}

package com.example.balanceit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Die Tile-Klasse repräsentiert eine Kachel der Spielwelt.
 * Sie speichert Informationen zu Typ, Position und Darstellung der Kachel.
 */
public class Tile {

    /** ENUM-Typ für die Form des Kachelobjekts: quadratisch/kreisförmig */
    enum Type {SQUARE,CIRCLE};

    public Type mType;
    int mPosX;
    int mPosY;
    int mTileSize;
    Bitmap mBitmap;
    Paint mPaintBlue;
    Paint mPaintGray;

    //TODO AP Welt: weitere Membervariablen (mPosX, mPosY, mBitmap) 

    /** Konstruktor
     * @param type Art der Kachel (Rechteck, Kreis)
     * @param x Position X
     * @param y Position Y
     * @param size Kachelgröße
     * @param bitmap Bitmap des Kachelobjekts
     */
    Tile (Type type, int x, int y, int tileSize, Bitmap bitmap){
    	mType=type;
    	mPosX=x;
    	mPosY=y;
    	mTileSize=tileSize;
    	mBitmap=bitmap;
    	mPaintBlue=new Paint();
    	mPaintBlue.setColor(Color.BLUE);
    	mPaintGray=new Paint();
    	mPaintGray.setColor(Color.GRAY);

    }

    /** zeichne die Kachelbitmap an der Position mPosX/Y
     * @param canvas Leinwand
     */
    void draw(Canvas canvas){
        if (mBitmap==null){
        	if (mType==Type.SQUARE)
        		canvas.drawRect(mPosX,mPosY,mPosX+mTileSize,mPosY+mTileSize, mPaintGray);
        	else
        		canvas.drawCircle(mPosX+mTileSize/2,mPosY+mTileSize/2,mTileSize/2,mPaintBlue);        		
        } else        	
        	canvas.drawBitmap(mBitmap,mPosX,mPosY,null);
        
    }
}

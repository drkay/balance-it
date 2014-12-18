package com.example.balanceit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/** Die StartActivity-Klasse ist die erste Activity (Bildschirmseite), die beim Start der App angezeigt wird.
 * Sie ist eine Kindklasse der Activity-Basisklasse von Android, die die einzelnen Bilschirme einer App repräsentiert.
 * Es werden die Bedienelemente des Startbildschirms angezeigt und auf die Benutzereingaben (Klicks) reagiert. */
public class StartActivity extends Activity {
	private static final int LEVEL_SUCCESS=123456;
	int mDifficulty=0;
	long mTimeA=0;
	long mTimeB=0;
	long mTimeMS=0;
	long mTime=0;
	float mTimeLevel1=1000;
	float mTimeLevel2=1000;
	float mTimeLevel3=1000;
	float mTimeLevel4=1000;
	

    /** Callback-Methode, die beim Initialisieren der Activity aufgerufen wird (eine Art Konstruktor für die Activity) */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Aufruf der entsprechenden Basisklassen-Methode
        super.onCreate(savedInstanceState);

        //setzen des Content, der in der Datei activity_start.xml beschrieben ist
        setContentView(R.layout.activity_start);
    }

    /** Callback-Methode, die beim Klick auf die Buttons aufgerufen wird 
     * @param view Objekt, auf das geklickt wurde
     */
    public void startGame(View view){
    	
        Intent intent=new Intent(this, GameActivity.class);
    	int level=0;
    	if(view.getId() == R.id.button1)
    		level=1;
    	else if (view.getId() == R.id.button2)
    		level=2;
    	else if (view.getId() == R.id.button3)
    		level=3;
    	else if (view.getId() == R.id.button4)
    		level=4;
    	intent.putExtra("LEVEL", level);
    	intent.putExtra("DIFFICULTY", mDifficulty);
        //rufe die GameActivity über einen Intent auf 
    	//TODO AP Framework: übergib gewünschtes Spiel-Level und Schwierigkeitsgrad
    	mTimeA = System.currentTimeMillis();
        startActivityForResult(intent, LEVEL_SUCCESS);
    }

    public void selectDifficulty(View view){
    	
    	if(view.getId() == R.id.radio0)
    		mDifficulty=0;
    	else if (view.getId() == R.id.radio1)
    		mDifficulty=1;
    	else if (view.getId() == R.id.radio2)
    		mDifficulty=2;
    	
    }
    public void showInfoActivity (View view){
    	Intent intent =new Intent(this, InfoActivity.class);
    	startActivity(intent);
    		
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent date) {
 	   if (requestCode==LEVEL_SUCCESS) { //ist es die Antwort zum LEVEL-SUCCESS-Aufruf
 		   if (resultCode == RESULT_OK){
 			   Log.v(World.LOGTAG, "Level erfolgreich");
			   mTimeB= System.currentTimeMillis();
			   mTimeMS = mTimeB-mTimeA;
			   mTime= mTimeMS / 100;
			   Log.v(World.LOGTAG, "mTime");
			   FXHelper.showDialog(this, "Level Geschafft!", "Gut gemacht!!");
 		   }
 		   else if (resultCode == RESULT_CANCELED)
 			   Log.v(World.LOGTAG, "Level abgebrochen");
 		   
 	   }
    }
    
}

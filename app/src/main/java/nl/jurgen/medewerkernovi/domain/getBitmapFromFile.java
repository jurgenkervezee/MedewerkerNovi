package nl.jurgen.medewerkernovi.domain;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class getBitmapFromFile {

        private Activity currentActivity;

        public getBitmapFromFile(Activity activity){

            setCurrentActivity(activity);
        }

        void setCurrentActivity(Activity currentActivity) {
            this.currentActivity = currentActivity;
        }


        public Bitmap writeToBitmap(){

            Bitmap mBitmap = null;


            Uri mUri = Uri.parse(currentActivity.getIntent().getStringExtra("uri"));

            try{

                InputStream mInputStream = currentActivity.getContentResolver().openInputStream(mUri);
                mBitmap = BitmapFactory.decodeStream(mInputStream);


            } catch (IOException e) {

                e.printStackTrace();

            }
            return mBitmap;
        }
    }


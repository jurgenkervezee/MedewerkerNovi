package nl.jurgen.medewerkernovi.domain;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class RequestPermissions {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
    //do I need to check camera permission?

    public boolean requestWriteExternalStoragePermission(Activity activity,  Context applicationContext){

        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                Toast.makeText(applicationContext, "This application requires write permission to be able to store the images created", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            } else {

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        }
        return true;
    }
}


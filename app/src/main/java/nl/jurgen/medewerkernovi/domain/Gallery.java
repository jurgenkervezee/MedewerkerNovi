package nl.jurgen.medewerkernovi.domain;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class Gallery {

    void galleryAddPicture(Activity mActivity, File mFile) {


        Intent mIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);

        Uri mUri = Uri.fromFile(mFile);
        mIntent.setData(mUri);

        mActivity.sendBroadcast(mIntent);
    }

    public void choosePicture(Activity activity, Integer num){
        Intent mIntent = new Intent();

        mIntent.setType("image/*");
        mIntent.setAction(Intent.ACTION_GET_CONTENT);

        activity.startActivityForResult(Intent.createChooser(mIntent, "Select image"), num);
    }
}

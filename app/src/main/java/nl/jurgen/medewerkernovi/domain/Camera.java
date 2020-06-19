package nl.jurgen.medewerkernovi.domain;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;

import androidx.core.content.FileProvider;
import java.io.IOException;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class Camera {

    private Picture mPicture;
    private Gallery mGallery = new Gallery();


    private static final int TAKE_PICTURE = 1;

    public void takePicture(Activity activity){

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        this.mPicture = new Picture(activity);
        this.mPicture.newPictureName();

        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {

                this.mPicture.createPictureFile();

            if (this.mPicture.getPictureFile() != null) {

                    this.mPicture.setPictureUri(FileProvider.getUriForFile(activity,
                            "nl.jurgen.medewerkernovi.fileprovider",
                            this.mPicture.getPictureFile()));

                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            mPicture.getPictureUri());

                    activity.startActivityForResult(takePictureIntent,
                            TAKE_PICTURE);

                    this.mGallery.galleryAddPicture(activity,
                            mPicture.getPictureFile());
            }
        }
    }

    public Picture getPicture(){
        return this.mPicture;
    }
}

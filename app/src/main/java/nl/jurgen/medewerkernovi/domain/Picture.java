package nl.jurgen.medewerkernovi.domain;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class Picture {

    private String mPictureName;
    private File mGalleryDirectory;
    private File mImageDirectory;

    private File mPictureFile;
    private Uri mPictureUri;

    public Picture(Activity activity) {

        this.mGalleryDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + "novi");
//        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + "novi"));

        this.mImageDirectory = activity.getExternalFilesDir("images");

        if(!mGalleryDirectory.isDirectory()){
            mGalleryDirectory.mkdirs();
        }

        if(!mImageDirectory.isDirectory()){
            mImageDirectory.mkdirs();
        }
    }

    void createPictureFile() {

        try {
            this.mPictureFile = File.createTempFile(
                    this.mPictureName,
                    ".jpg",
                    this.mGalleryDirectory
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void fileToUri() {
        if (mPictureFile != null)
            this.mPictureUri = Uri.fromFile(this.mPictureFile);
    }

    public void bitmapToFile(Bitmap bitmap) {
        File mFile = null;
        newPictureName();

        try {

            mFile = File.createTempFile(this.mPictureName, ".jpg", this.mImageDirectory);

            FileOutputStream mFileOutputStream = new FileOutputStream(mFile);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, mFileOutputStream);

            mFileOutputStream.flush();
            mFileOutputStream.close();


        } catch (IOException e) {

            e.printStackTrace();
        }

        this.mPictureFile = mFile;
    }

    public void newPictureName() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

        this.mPictureName = "novi-" + timeStamp;
    }

    public void setPictureUri(Uri uri) {
        this.mPictureUri = uri;
    }

    public Uri getPictureUri() {
        return this.mPictureUri;
    }

    public File getPictureFile() {
        return this.mPictureFile;
    }

}

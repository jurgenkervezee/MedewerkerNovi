package nl.jurgen.medewerkernovi.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nl.jurgen.medewerkernovi.domain.Camera;
import nl.jurgen.medewerkernovi.domain.Gallery;
import nl.jurgen.medewerkernovi.domain.Picture;
import nl.jurgen.medewerkernovi.domain.RequestPermissions;
import nl.jurgen.medewerkernovi.R;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

    public class LandingActivity extends AppCompatActivity {

        public static final int TAKE_PICTURE = 1;
        public static final int CHOOSE_PICTURE = 2;

        private Button menuCameraBtn;
        private Button menuGalleryBtn;

        private RequestPermissions requestPermissions;
        private Boolean cameraPermission = false;

        private Gallery mGallery = new Gallery();
        private Picture mPicture;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_landing);

            requestCameraPermission();
            createButons();
        }

        private void createButons() {
            this.menuCameraBtn = findViewById(R.id.gotoCameraBtn );

            menuCameraBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cameraPermission) {

                         //Create Camera object
                        Camera camera = new Camera();
                        camera.takePicture(LandingActivity.this);

                        mPicture = new Picture(LandingActivity.this);

                        mPicture = camera.getPicture();
                    }
                }
            });

            this.menuGalleryBtn = (Button) findViewById(R.id.galleryBtn);
            menuGalleryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mGallery.choosePicture(LandingActivity.this, CHOOSE_PICTURE);
                }
            });
        }



        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent pictureReturnedIntent) {
            super.onActivityResult(requestCode, resultCode, pictureReturnedIntent);

            if (resultCode == RESULT_OK) {

                //When taking a picture
                if (requestCode == TAKE_PICTURE) {
                    if (mPicture != null) {

                        mPicture.fileToUri();

                        Intent editPictureIntent = new Intent(LandingActivity.this, PhotoEditorActivity.class);
                        editPictureIntent.putExtra("uri", mPicture.getPictureUri().toString());
                        startActivity(editPictureIntent);
                    }

                // after selecting a picture from gallery
                } else if (requestCode == CHOOSE_PICTURE) {

                    mPicture.setPictureUri(pictureReturnedIntent.getData());

                    if (mPicture.getPictureUri() != null) {

                        Intent editPictureIntent = new Intent(LandingActivity.this, PhotoEditorActivity.class);
                        editPictureIntent.putExtra("uri", mPicture.getPictureUri().toString());
                        startActivity(editPictureIntent);
                    }
                }
            }
        }

        public void requestCameraPermission(){
            requestPermissions = new RequestPermissions();

//            cameraPermission = this.requestPermissions.requestCameraPermission(LandingActivity.this);
            cameraPermission = this.requestPermissions.requestWriteExternalStoragePermission(LandingActivity.this, LandingActivity.this.getApplicationContext());
        }

    }
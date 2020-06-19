package nl.jurgen.medewerkernovi.controller;


import android.content.Intent;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.xiaopo.flying.sticker.StickerView;

import nl.jurgen.medewerkernovi.R;
import nl.jurgen.medewerkernovi.domain.getBitmapFromFile;
import nl.jurgen.medewerkernovi.domain.Picture;
import nl.jurgen.medewerkernovi.domain.StickerGadget;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class PhotoEditorActivity extends AppCompatActivity {

    private getBitmapFromFile mGetBitmapFromFile;
    private StickerGadget mStickerGadget;
    private Picture mPicture;

    private Button saveButton;
    private Button mvdmButton;
    private ImageView imageEditView;
    private Bitmap imageBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_editor);

        mGetBitmapFromFile = new getBitmapFromFile(PhotoEditorActivity.this);

        imageBitmap = mGetBitmapFromFile.writeToBitmap();

        imageEditView = findViewById(R.id.imagePhotoEditView);
        imageEditView.setImageBitmap(imageBitmap);

        mStickerGadget = new StickerGadget();
        mStickerGadget.setPhotoEditStickers(PhotoEditorActivity.this);
        setOnClickSaveListener();
        setOnClickEmployeeOfTheMonthListener();

    }

    public void setOnClickSaveListener(){
        saveButton = findViewById(R.id.saveImage);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mPicture = new Picture(PhotoEditorActivity.this);
                    mPicture.newPictureName();

                    StickerView stickerView = findViewById(R.id.stickerPhotoEditView);
                    mPicture.bitmapToFile(stickerView.createBitmap());

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(mPicture.getPictureFile().isFile()){
                    Intent shareActivityIntent = new Intent(PhotoEditorActivity.this, ShareActivity.class);

                    shareActivityIntent.putExtra("IMAGE_FILE", mPicture.getPictureFile().getAbsolutePath());
                    startActivity(shareActivityIntent);
                }
            }
        });
    }

    public void setOnClickEmployeeOfTheMonthListener(){

        mvdmButton = findViewById(R.id.MWVDM);

        mvdmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mStickerGadget.addEmployeeOfTheMonthStickers(PhotoEditorActivity.this);
            }
        });
    }




}


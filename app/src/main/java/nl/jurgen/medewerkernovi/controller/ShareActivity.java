package nl.jurgen.medewerkernovi.controller;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import nl.jurgen.medewerkernovi.R;
import nl.jurgen.medewerkernovi.domain.Picture;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator

public class ShareActivity extends AppCompatActivity {

    private Button shareBtn;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        mImageView = findViewById(R.id.shareImageView);
        String imagePath = getIntent().getStringExtra("IMAGE_FILE");
        mImageView.setImageURI(Uri.parse(imagePath));

        shareBtn = findViewById(R.id.shareBtn);
        setShareButton(Uri.parse(imagePath));

    }


    public void setShareButton(final Uri pictureUri){

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                shareIntent.setType("image/jpg");
                shareIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);

                startActivity(Intent.createChooser(shareIntent, "Share picture with"));
            }
        });
    }
}

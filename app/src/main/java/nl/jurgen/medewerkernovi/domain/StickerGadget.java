package nl.jurgen.medewerkernovi.domain;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import com.xiaopo.flying.sticker.BitmapStickerIcon;
import com.xiaopo.flying.sticker.StickerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nl.jurgen.medewerkernovi.R;

//Software Development Deel 1
//Auteur: Jurgen Kervezee
//Docent: Marco Dumont
//Tested using  Nexus 5 API 22 Emulator / also Pixel 2 XL API 22

public class StickerGadget {

    private StickerView stickerView;

    public void setPhotoEditStickers(final Activity activity) {

        ImageView tophatImageView;
        ImageView balloonImageView;
        ImageView sunglassesImageView;
        ImageView cakeImageView;
        ImageView balloonsImageView;
        ImageView flagsImageView;
        ImageView partyHatImageView;
        ImageView discoballImageView;

        stickerView = activity.findViewById(R.id.stickerPhotoEditView);

        tophatImageView = activity.findViewById(R.id.tophat);
        balloonImageView = activity.findViewById(R.id.balloon);
        sunglassesImageView = activity.findViewById(R.id.sunglasses);
        cakeImageView = activity.findViewById(R.id.cake);
        balloonsImageView = activity.findViewById(R.id.balloons);
        flagsImageView = activity.findViewById(R.id.flags);
        partyHatImageView = activity.findViewById(R.id.partyhat);
        discoballImageView = activity.findViewById(R.id.discoball);


        tophatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon tophat = new BitmapStickerIcon(ContextCompat.getDrawable(
                        activity,
                        R.mipmap.tophat),
                        BitmapStickerIcon.LEFT_BOTTOM);

                stickerView.addSticker(tophat);
            }
        });

        balloonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon balloon = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.balloon),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(balloon);
            }
        });

        sunglassesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon moustache = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.sunglasses),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(moustache);
            }
        });

        cakeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon cake = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.cake),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(cake);
            }
        });

        balloonsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon balloons = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.balloons),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(balloons);
            }
        });

        flagsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon flags = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.newyears_flag),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(flags);
            }
        });

        partyHatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon partyHat = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.newyears_hat),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(partyHat);
            }
        });

        discoballImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon discoball = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.party_newyears_disco_lamp),
                        BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(discoball);
            }
        });

    }

    public void addEmployeeOfTheMonthStickers(final Activity activity) {

        BitmapStickerIcon employeeOfTheMonth;
        DateFormat mDateFormat = new SimpleDateFormat("MM");
        Date mDate = new Date();

        switch (mDateFormat.format(mDate)) {
            case "01":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_januari),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "02":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_februari),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "03":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_maart),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "04":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_april),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "05":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_mei),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "06":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_juni),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "07":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_juli),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "08":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_augustus),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "09":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_september),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "10":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_oktober),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "11":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_november),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            case "12":
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.mwvdm_december),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;

            default:
                employeeOfTheMonth = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.penguin),
                        BitmapStickerIcon.RIGHT_TOP);
                stickerView.addSticker(employeeOfTheMonth);
                break;
        }
    }
}
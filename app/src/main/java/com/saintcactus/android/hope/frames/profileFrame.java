package com.saintcactus.android.hope.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.saintcactus.android.hope.R;
import com.saintcactus.android.hope.libraries.profile;

/**
 * Created by laker on 17.02.2017.
 */

public class profileFrame extends AppCompatActivity {

    public static final String APP_PREFERENCES = "HOPE setting";
    public static final String APP_PREFERENCES_NAME = "Nickname";
    public static final String APP_PREFERENCES_AGE = "Age";
    public static final String APP_PREFERENCES_COLOR = "Color";
    public final String APP_PREFERENCES_PROFILE_QUANTITY = "Zero";

    TextView profileQuantity;

    private SharedPreferences mSettings;

    //private int profile_quantity;
    public final String FIRST_PROFILE_AGE = "0", SECOND_PROFILE_AGE = "0", THIRD_PROFILE_AGE = "0", FOURTH_PROFILE_AGE = "0",
            FIVTH_PROFILE_AGE = "0", SIXTH_PROFILE_AGE = "0", SEVENTH_PROFILE_AGE = "0", EIGHTH_PROFILE_AGE = "0";

    final profile HRProfile = new profile();

    //region GET IMAGE TO DRAW

    private void getImageToDraw(int status, ImageButton imageButton)
    {
        switch (status) {
            case 0:
                imageButton.setImageResource(R.drawable.contact_add);
                imageButton.setBackgroundResource(R.drawable.contact_add);
                break;

            case 1:
                imageButton.setImageResource(R.drawable.contact_profile);
                imageButton.setBackgroundResource(R.drawable.contact_profile);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.contact_blue);
                imageButton.setBackgroundResource(R.drawable.contact_blue);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.contact_cyan);
                imageButton.setBackgroundResource(R.drawable.contact_cyan);
                break;
            case 4:
                imageButton.setImageResource(R.drawable.contact_green);
                imageButton.setBackgroundResource(R.drawable.contact_green);
                break;
            case 5:
                imageButton.setImageResource(R.drawable.contact_orange);
                imageButton.setBackgroundResource(R.drawable.contact_orange);
                break;
            case 6:
                imageButton.setImageResource(R.drawable.contact_purple);
                imageButton.setBackgroundResource(R.drawable.contact_purple);
                break;
            case 7:
                imageButton.setImageResource(R.drawable.contact_red);
                imageButton.setBackgroundResource(R.drawable.contact_red);
                break;
            case 8:
                imageButton.setImageResource(R.drawable.contact_yellow);
                imageButton.setBackgroundResource(R.drawable.contact_yellow);
                break;

        }

    }


    //endregion

    //region GET CURRENT PROFILE

    private void getCurrentProfile(String sCurrentProfile)
    {
        SharedPreferences.Editor editor = mSettings.edit();
        switch (sCurrentProfile){
            case "FIRST_PROFILE":
                editor.putInt("CURRENT_PROFILE", 1);
                editor.apply();
                break;
            case "SECOND_PROFILE":
                editor.putInt("CURRENT_PROFILE", 2);
                editor.apply();
                break;
            case "THIRD_PROFILE":
                editor.putInt("CURRENT_PROFILE", 3);
                editor.apply();
                break;
            case "FOURTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 4);
                editor.apply();
                break;
            case "FIVTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 5);
                editor.apply();
                break;
            case "SIXTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 6);
                editor.apply();
                break;
            case "SEVENTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 7);
                editor.apply();
                break;
            case "EIGHTH_PROFILE":
                editor.putInt("CURRENT_PROFILE", 8);
                editor.apply();
                break;
        }
    }

    //endregion

    //region GET VISIBLE CONTACTS

   private void getVisibleContacts(int profileQuantity,
                                    ImageButton contact_first, ImageButton contact_second ,ImageButton contact_third, ImageButton contact_fourth,
                                    ImageButton contact_fivth, ImageButton contact_sixth, ImageButton contact_seventh, ImageButton contact_eighth)
    {
        getImageToDraw(mSettings.getInt("FIRST_PROFILE", 0), contact_first);
        getImageToDraw(mSettings.getInt("SECOND_PROFILE", 0), contact_second);
        getImageToDraw(mSettings.getInt("THIRD_PROFILE", 0), contact_third);
        getImageToDraw(mSettings.getInt("FOURTH_PROFILE", 0), contact_fourth);
        getImageToDraw(mSettings.getInt("FIVTH_PROFILE", 0), contact_fivth);
        getImageToDraw(mSettings.getInt("SIXTH_PROFILE", 0), contact_sixth);
        getImageToDraw(mSettings.getInt("SEVENTH_PROFILE", 0), contact_seventh);
        getImageToDraw(mSettings.getInt("EIGHTH_PROFILE", 0), contact_eighth);
    }

    //endregion

    @Override
    protected void onResume()
    {
        super.onResume();
        profileQuantity = (TextView) findViewById(R.id.profileQuantity);
        profileQuantity.setText(mSettings.getInt("PROFILE_QUANTITY", 0) + "/8");
        Log.d("PROFILE:", HRProfile.getProfileQuantity() + "");
    }

    //region GET STATUS
    private boolean getStatus(String currentProfile)
    {
        boolean isExist = false;
        switch(currentProfile){
            case "FIRST_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "SECOND_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "THIRD_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "FOURTH_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "FIVTH_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "SIXTH_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "SEVENTH_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
            case "EIGHTH_PROFILE":
                if(mSettings.getInt(currentProfile, 0) > 0) isExist = true;
                else if(mSettings.getInt(currentProfile, 0) == 0) isExist = false;
                break;
        }
        return isExist;
    }
    //endregion

    //region DEBUGG

    private void debugg(String name, int number)
    {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(name, number);
        editor.apply();
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_profile);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        final ImageButton backward = (ImageButton) findViewById(R.id.backward);
        final ImageButton plus = (ImageButton) findViewById(R.id.plus);
        final ImageButton minus = (ImageButton) findViewById(R.id.minus);
        final ImageButton edit = (ImageButton) findViewById(R.id.accept);

        ImageButton contact_first = (ImageButton) findViewById(R.id.contact_first);
        ImageButton contact_second = (ImageButton) findViewById(R.id.contact_second);
        ImageButton contact_third = (ImageButton) findViewById(R.id.contact_third);
        ImageButton contact_fourth = (ImageButton) findViewById(R.id.contact_fourth);
        ImageButton contact_fivth = (ImageButton) findViewById(R.id.contact_fivth);
        ImageButton contact_sixth = (ImageButton) findViewById(R.id.contact_sixth);
        ImageButton contact_seventh = (ImageButton) findViewById(R.id.contact_seventh);
        ImageButton contact_eighth = (ImageButton) findViewById(R.id.contact_eighth);

        profileQuantity = (TextView) findViewById(R.id.profileQuantity);

        Log.d("DEBUGG:", mSettings.getInt("PROFILE_QUANTITY", 0) + "");

        getVisibleContacts(mSettings.getInt("PROFILE_QUANTITY", 0),
        contact_first, contact_second ,contact_third,contact_fourth,
                contact_fivth, contact_sixth,contact_seventh,contact_eighth);

        edit.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        Log.d("DEBUGG:", mSettings.getInt("PROFILE_QUANTITY", 0) + "");

                                        Intent intent = new Intent("android.intent.action.chooseprofile");
                                        startActivity(intent);
                                    }
                                }
        );

        plus.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            SharedPreferences.Editor editor = mSettings.edit();
                                            editor.putInt("PROFILE_QUANTITY", mSettings.getInt("PROFILE_QUANTITY", 0) + 1);
                                            editor.apply();
                                        }
                                    }
        );

        minus.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            SharedPreferences.Editor editor = mSettings.edit();
                                            editor.putInt("PROFILE_QUANTITY", mSettings.getInt("PROFILE_QUANTITY", 0) - 1);
                                            editor.apply();
                                        }
                                    }
        );

        contact_first.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            //debugg("FIRST_PROFILE", 0);
                                            getCurrentProfile("FIRST_PROFILE");
                                            if(mSettings.getInt("FIRST_PROFILE", 0) > 0) {
                                                /*Intent intent = new Intent("android.intent.action.editprofile");
                                                startActivity(intent);*/
                                            }
                                            else if(mSettings.getInt("FIRST_PROFILE", 0) == 0) {
                                                Intent intent = new Intent("android.intent.action.newprofile");
                                                startActivity(intent);
                                            }
                                        }
                                    }
        );

        contact_second.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("SECOND_PROFILE", 0);
                                                 getCurrentProfile("SECOND_PROFILE");
                                                 if(mSettings.getInt("SECOND_PROFILE", 0) > 0) {
                                                     /*Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("SECOND_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }
                                             }
                                         }
        );

        contact_third.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("THIRD_PROFILE", 0);
                                                 getCurrentProfile("THIRD_PROFILE");
                                                 if(mSettings.getInt("THIRD_PROFILE", 0) > 0) {
                                                     /*Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("THIRD_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }
                                             }
                                         }
        );

        contact_fourth.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("FOURTH_PROFILE", 0);
                                                 getCurrentProfile("FOURTH_PROFILE");
                                                 if(mSettings.getInt("FOURTH_PROFILE", 0) > 0) {
                                                    /* Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("FOURTH_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }

                                             }
                                         }
        );

        contact_fivth.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("FIVTH_PROFILE", 0);
                                                 getCurrentProfile("FIVTH_PROFILE");
                                                 if(mSettings.getInt("FIVTH_PROFILE", 0) > 0) {
                                                     /*Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("FIVTH_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }

                                             }
                                         }
        );

        contact_sixth.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("SIXTH_PROFILE", 0);
                                                 getCurrentProfile("SIXTH_PROFILE");
                                                 if(mSettings.getInt("SIXTH_PROFILE", 0) > 0) {
                                                     /*Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("SIXTH_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }

                                             }
                                         }
        );

        contact_seventh.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("SEVENTH_PROFILE", 0);
                                                 getCurrentProfile("SEVENTH_PROFILE");
                                                 if(mSettings.getInt("SEVENTH_PROFILE", 0) > 0) {
                                                     /*Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("SEVENTH_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }

                                             }
                                         }
        );

        contact_eighth.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("EIGHTH_PROFILE", 0);
                                                 getCurrentProfile("EIGHTH_PROFILE");
                                                 if(mSettings.getInt("EIGHTH_PROFILE", 0) > 0) {
                                                     /*Intent intent = new Intent("android.intent.action.editprofile");
                                                     startActivity(intent);*/
                                                 }
                                                 else if(mSettings.getInt("EIGHTH_PROFILE", 0) == 0) {
                                                     Intent intent = new Intent("android.intent.action.newprofile");
                                                     startActivity(intent);
                                                 }
                                             }
                                         }
        );


        backward.setOnClickListener(new View.OnClickListener(){
                                               public void onClick(View v) {
                                                   Intent intent = new Intent("android.intent.action.desktop");
                                                   startActivity(intent);
                                               }
                                           }
        );
    }
}

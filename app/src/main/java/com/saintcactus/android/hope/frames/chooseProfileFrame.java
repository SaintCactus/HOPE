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

/**
 * Created by laker on 19.02.2017.
 */

public class chooseProfileFrame extends AppCompatActivity {
    public static final String APP_PREFERENCES = "HOPE setting";
    private SharedPreferences mSettings;
    TextView profileQuantity;

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

    //region GET IMAGE TO DRAW

    private void getImageToDraw(int status, ImageButton imageButton)
    {
        switch (status) {
            case 0:
                imageButton.setVisibility(View.INVISIBLE);
                /*imageButton.setImageResource(R.drawable.contact_add);
                imageButton.setBackgroundResource(R.drawable.contact_add);*/
                break;

            case 1:
                imageButton.setImageResource(R.drawable.contact_accept);
                imageButton.setBackgroundResource(R.drawable.contact_accept);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.contact_accept_blue);
                imageButton.setBackgroundResource(R.drawable.contact_accept_blue);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.contact_accept_cyan);
                imageButton.setBackgroundResource(R.drawable.contact_accept_cyan);
                break;
            case 4:
                imageButton.setImageResource(R.drawable.contact_accept_green);
                imageButton.setBackgroundResource(R.drawable.contact_accept_green);
                break;
            case 5:
                imageButton.setImageResource(R.drawable.contact_accept_orange);
                imageButton.setBackgroundResource(R.drawable.contact_accept_orange);
                break;
            case 6:
                imageButton.setImageResource(R.drawable.contact_accept_purple);
                imageButton.setBackgroundResource(R.drawable.contact_accept_purple);
                break;
            case 7:
                imageButton.setImageResource(R.drawable.contact_accept_red);
                imageButton.setBackgroundResource(R.drawable.contact_accept_red);
                break;
            case 8:
                imageButton.setImageResource(R.drawable.contact_accept_yellow);
                imageButton.setBackgroundResource(R.drawable.contact_accept_yellow);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_chooseeditprofile);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ImageButton contact_first = (ImageButton) findViewById(R.id.contact_first);
        ImageButton contact_second = (ImageButton) findViewById(R.id.contact_second);
        ImageButton contact_third = (ImageButton) findViewById(R.id.contact_third);
        ImageButton contact_fourth = (ImageButton) findViewById(R.id.contact_fourth);
        ImageButton contact_fivth = (ImageButton) findViewById(R.id.contact_fivth);
        ImageButton contact_sixth = (ImageButton) findViewById(R.id.contact_sixth);
        ImageButton contact_seventh = (ImageButton) findViewById(R.id.contact_seventh);
        ImageButton contact_eighth = (ImageButton) findViewById(R.id.contact_eighth);

        final ImageButton backward = (ImageButton) findViewById(R.id.backward);

        Log.d("mSET:", mSettings.getInt("PROFILE_QUANTITY", 0) + "");

        profileQuantity = (TextView) findViewById(R.id.profileQuantity);

        Log.d("DEBUGG:", mSettings.getInt("PROFILE_QUANTITY", 0) + "");

        profileQuantity.setText(mSettings.getInt("PROFILE_QUANTITY", 0) + "/8");


        getVisibleContacts(mSettings.getInt("PROFILE_QUANTITY", 0),
                contact_first, contact_second ,contact_third,contact_fourth,
                contact_fivth, contact_sixth,contact_seventh,contact_eighth);

        backward.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            Intent intent = new Intent("android.intent.action.profile");
                                            startActivity(intent);
                                        }
                                    }
        );

        contact_first.setOnClickListener(new View.OnClickListener(){
                                             public void onClick(View v) {
                                                 //debugg("FIRST_PROFILE", 0);
                                                 getCurrentProfile("FIRST_PROFILE");
                                                 if(mSettings.getInt("FIRST_PROFILE", 0) > 0) {
                                                     Intent intent = new Intent("android.intent.action.editprofile");
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
                                                      Intent intent = new Intent("android.intent.action.editprofile");
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
                                                     Intent intent = new Intent("android.intent.action.editprofile");
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
                                                      Intent intent = new Intent("android.intent.action.editprofile");
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
                                                     Intent intent = new Intent("android.intent.action.editprofile");
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
                                                     Intent intent = new Intent("android.intent.action.editprofile");
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
                                                       Intent intent = new Intent("android.intent.action.editprofile");
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
                                                      Intent intent = new Intent("android.intent.action.editprofile");
                                                      startActivity(intent);
                                                  }
                                              }
                                          }
        );
    }
}

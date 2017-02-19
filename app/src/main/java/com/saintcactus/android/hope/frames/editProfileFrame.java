package com.saintcactus.android.hope.frames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.saintcactus.android.hope.R;
import com.saintcactus.android.hope.libraries.profile;

/**
 * Created by laker on 18.02.2017.
 */

public class editProfileFrame extends AppCompatActivity {

    private SharedPreferences mSettings;
    private int currentColor = 1;
    final String sPROFILE_QUANTITY = "0";
    private String FIRST_PROFILE_AGE, SECOND_PROFILE_AGE, THIRD_PROFILE_AGE, FOURTH_PROFILE_AGE,
    FIVTH_PROFILE_AGE, SIXTH_PROFILE_AGE, SEVENTH_PROFILE_AGE, EIGHTH_PROFILE_AGE;

    public static final String APP_PREFERENCES = "HOPE setting";
    public static final String APP_PREFERENCES_PROFILE_QUANTITY = "0";


    final profile HRProfile = new profile();

    //region SAVE NAME

    public void saveName(EditText getName)
    {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(editProfileFrame.getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "_NAME",getName.getText().toString());
        editor.apply();
    }

    //endregion

    //region SAVE AGE

    public void saveAge(EditText getAge)
    {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(editProfileFrame.getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "_AGE",
                Integer.parseInt(getAge.getText().toString()));
        editor.apply();

    }

    //endregion

    //region FILL THE FIELD

    private void fillTheField()
    {
        final ImageView ALT = (ImageView) findViewById(R.id.alterableColor);
        final EditText getAge = (EditText)findViewById(R.id.Age);
        final EditText getName = (EditText) findViewById(R.id.Name);

        currentColor = mSettings.getInt(getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)), 0);

        newProfileFrame.changeProfileColor(ALT, currentColor);

        getAge.setText(mSettings.getInt(getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "_AGE", 23) + "");
        getName.setText(mSettings.getString(getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "_NAME", "Hope") + "");
    }

    //endregion

    //region GET CURRENT PROFILE NAME

    public static String getCurrentProfileName(int currentProfile)
    {
        String sCurrentProfile = "";
        switch(currentProfile) {
            case 1:
                sCurrentProfile = "FIRST_PROFILE";
                break;
            case 2:
                sCurrentProfile = "SECOND_PROFILE";
                break;
            case 3:
                sCurrentProfile = "THIRD_PROFILE";
                break;
            case 4:
                sCurrentProfile = "FOURTH_PROFILE";
                break;
            case 5:
                sCurrentProfile = "FIVTH_PROFILE";
                break;
            case 6:
                sCurrentProfile = "SIXTH_PROFILE";
                break;
            case 7:
                sCurrentProfile = "SEVENTH_PROFILE";
                break;
            case 8:
                sCurrentProfile = "EIGHTH_PROFILE";
                break;
            case 0:
                sCurrentProfile = "FIRST_PROFILE";
                break;
            }
        Log.d("DEBUGG:", sCurrentProfile + "");
        return sCurrentProfile;
        }

        //endregion

    //region SUB

    private void sub(String name, int from)
    {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(name, from - 1);
        editor.apply();
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_editprofile);

        final EditText getAge = (EditText)findViewById(R.id.Age);
        final EditText getName = (EditText) findViewById(R.id.Name);

        final ImageButton backward = (ImageButton) findViewById(R.id.backward);
        final ImageButton accept = (ImageButton) findViewById(R.id.accept);
        final ImageButton delete = (ImageButton) findViewById(R.id.delete);

        final ImageButton next = (ImageButton) findViewById(R.id.btnNext);
        final ImageButton prev = (ImageButton) findViewById(R.id.btnPrev);

        final ImageView ALT = (ImageView) findViewById(R.id.alterableColor);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        fillTheField();

        next.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        if((currentColor >=1) && (currentColor <8)) currentColor++;
                                        newProfileFrame.changeProfileColor(ALT, currentColor);
                                    }
                                }
        );

        prev.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        if((currentColor >1) && (currentColor <=8)) currentColor--;
                                        newProfileFrame.changeProfileColor(ALT, currentColor);
                                    }
                                }
        );

        backward.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            Intent intent = new Intent("android.intent.action.profile");
                                            startActivity(intent);
                                        }
                                    }
        );

        accept.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            SharedPreferences.Editor editor = mSettings.edit();
                                            editor.putInt(editProfileFrame.getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)), newProfileFrame.getChoosenColor(currentColor));
                                            editor.apply();

                                            if (!getAge.getText().toString().equals(""))
                                            {
                                                saveAge(getAge);
                                            }

                                            if (!getName.getText().toString().equals(""))
                                            {
                                                saveName(getName);
                                            }

                                            Intent intent = new Intent("android.intent.action.profile");
                                            startActivity(intent);
                                        }
                                    }
        );

        delete.setOnClickListener(new View.OnClickListener(){
                                      public void onClick(View v) {
                                          sub("PROFILE_QUANTITY", mSettings.getInt("PROFILE_QUANTITY", 0));

                                          SharedPreferences.Editor editor = mSettings.edit();
                                          editor.putInt(getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)), 0);
                                          editor.apply();

                                          Intent intent = new Intent("android.intent.action.profile");
                                          startActivity(intent);
                                          Log.d("DELL:", getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "");
                                      }
                                  }
        );

        getAge.setOnKeyListener(new View.OnKeyListener()
                                {
                                    public boolean onKey(View v, int keyCode, KeyEvent event)
                                    {
                                        if(event.getAction() == KeyEvent.ACTION_DOWN &&
                                                (keyCode == KeyEvent.KEYCODE_ENTER))
                                        {
                                            if (!getAge.getText().toString().equals(""))
                                            {
                                                SharedPreferences.Editor editor = mSettings.edit();
                                                editor.putInt(editProfileFrame.getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "_AGE",
                                                        Integer.parseInt(getAge.getText().toString()));
                                                editor.apply();
                                                return true;
                                            }
                                            else
                                            {
                                                return false;
                                            }

                                        }
                                        return false;
                                    }
                                }
        );

        getName.setOnKeyListener(new View.OnKeyListener()
                                 {
                                     public boolean onKey(View v, int keyCode, KeyEvent event)
                                     {
                                         if(event.getAction() == KeyEvent.ACTION_DOWN &&
                                                 (keyCode == KeyEvent.KEYCODE_ENTER))
                                         {
                                             if (!getName.getText().toString().equals(""))
                                             {
                                                 SharedPreferences.Editor editor = mSettings.edit();
                                                 editor.putString(editProfileFrame.getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)) + "_NAME",getName.getText().toString());
                                                 editor.apply();
                                                 return true;
                                             }
                                             else
                                             {
                                                 return false;
                                             }

                                         }
                                         return false;
                                     }
                                 }
        );
    }

}

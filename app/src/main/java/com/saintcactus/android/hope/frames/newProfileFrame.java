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

public class newProfileFrame extends AppCompatActivity {

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

    //region CHANGE PROFILE COLOR

    public static void changeProfileColor(ImageView currentButton, int currentColor)
    {
        switch (currentColor) {
            case 0:
                currentButton.setImageResource(R.drawable.contact_add);
                break;

            case 1:
                currentButton.setImageResource(R.drawable.contact_profile);
                break;
            case 2:
                currentButton.setImageResource(R.drawable.contact_blue);
                break;
            case 3:
                currentButton.setImageResource(R.drawable.contact_cyan);
                break;
            case 4:
                currentButton.setImageResource(R.drawable.contact_green);
                break;
            case 5:
                currentButton.setImageResource(R.drawable.contact_orange);
                break;
            case 6:
                currentButton.setImageResource(R.drawable.contact_purple);
                break;
            case 7:
                currentButton.setImageResource(R.drawable.contact_red);
                break;
            case 8:
                currentButton.setImageResource(R.drawable.contact_yellow);
                break;

        }
    }

    //endregion

    //region GET CHOOSEN COLOR

    public static int getChoosenColor(int currentColor)
    {
        int color = 1;
        if((currentColor >=1) && (currentColor <=8))
        {
            switch (currentColor){
                case 1:
                    color = 1;
                    break;
                case 2:
                    color = 2;
                    break;
                case 3:
                    color = 3;
                    break;
                case 4:
                    color = 4;
                    break;
                case 5:
                    color = 5;
                    break;
                case 6:
                    color = 6;
                    break;
                case 7:
                    color = 7;
                    break;
                case 8:
                    color = 8;
                    break;
            }
        }
        return color;
    }

    //endregion

    //region ADD

    private void add(String name, int from)
    {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(name, from + 1);
        editor.apply();
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_newprofile);

        final EditText getAge = (EditText)findViewById(R.id.Age);
        final EditText getName = (EditText) findViewById(R.id.Name);

        final ImageButton backward = (ImageButton) findViewById(R.id.backward);
        final ImageButton accept = (ImageButton) findViewById(R.id.accept);
        final ImageButton next = (ImageButton) findViewById(R.id.btnNext);
        final ImageButton prev = (ImageButton) findViewById(R.id.btnPrev);

        final ImageView ALT = (ImageView) findViewById(R.id.alterableColor);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        backward.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            Intent intent = new Intent("android.intent.action.profile");
                                            startActivity(intent);
                                        }
                                    }
        );

        accept.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            add("PROFILE_QUANTITY", mSettings.getInt("PROFILE_QUANTITY", 0));

                                            SharedPreferences.Editor editor = mSettings.edit();
                                            editor.putInt(editProfileFrame.getCurrentProfileName(mSettings.getInt("CURRENT_PROFILE", 0)), getChoosenColor(currentColor));
                                            editor.apply();

                                            if (!getAge.getText().toString().equals(""))
                                            {
                                                saveAge(getAge);
                                            }

                                            if (!getName.getText().toString().equals(""))
                                            {
                                                saveName(getName);
                                            }

                                            Log.d("ACCEPT:", mSettings.getInt("CURRENT_PROFILE", 0) + "");

                                            Intent intent = new Intent("android.intent.action.profile");
                                            startActivity(intent);
                                        }
                                    }
        );

        next.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v) {
                                            if((currentColor >=1) && (currentColor <8)) currentColor++;
                                            changeProfileColor(ALT, currentColor);
                                        }
                                    }
        );

        prev.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View v) {
                                        if((currentColor >1) && (currentColor <=8)) currentColor--;
                                        changeProfileColor(ALT, currentColor);
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
                                                    saveAge(getAge);
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
                                                saveName(getName);
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

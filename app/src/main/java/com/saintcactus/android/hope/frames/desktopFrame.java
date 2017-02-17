package com.saintcactus.android.hope.frames;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.saintcactus.android.hope.R;
import com.saintcactus.android.hope.sensor.BleHeartRateSensor;

public class desktopFrame extends AppCompatActivity {

    TextView hr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_empty_desktop);

        final Button btnRoom = (Button) findViewById(R.id.dev_room);
        final Button btnSetting = (Button) findViewById(R.id.setting_button);
        final ImageButton drawButtonStart = (ImageButton) findViewById(R.id.start_training);

        btnSetting.setOnClickListener(new View.OnClickListener(){
                                          public void onClick(View v) {
                                              Intent intent = new Intent("android.intent.action.setting");
                                              startActivity(intent);
                                          }
                                      }
        );

        btnRoom.setOnClickListener(new View.OnClickListener(){
                                          public void onClick(View v) {
                                              Intent intent = new Intent("android.intent.action.devroom");
                                              startActivity(intent);
                                          }
                                      }
        );
        drawButtonStart.setOnClickListener(new View.OnClickListener(){
                                               public void onClick(View v) {
                                                   Intent intent = new Intent("android.intent.action.profile");
                                                   startActivity(intent);
                                               }
                                           }
        );
    }
}

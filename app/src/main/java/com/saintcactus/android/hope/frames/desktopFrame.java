package com.saintcactus.android.hope.frames;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.saintcactus.android.hope.R;
import com.saintcactus.android.hope.sensor.BleHeartRateSensor;

public class desktopFrame extends AppCompatActivity {

    TextView hr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_desktop);

        final Button btnRoom = (Button) findViewById(R.id.dev_room);
        final Button btnSetting = (Button) findViewById(R.id.setting_button);

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
    }
}
package com.saintcactus.android.hope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class settingFrame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final Button btnSensors = (Button) findViewById(R.id.sensors_button);

        btnSensors.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v) {
              Intent intent = new Intent("android.intent.action.setting");
              startActivity(intent);
          }
        }
        );
    }
}

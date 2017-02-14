package com.saintcactus.android.hope.frames;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.saintcactus.android.hope.R;

public class settingFrame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        final Button btnSetting = (Button) findViewById(R.id.sensors_button);

        btnSetting.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v) {
              Intent intent = new Intent("android.intent.action.scan");
              if (ContextCompat.checkSelfPermission(settingFrame.this,
                      Manifest.permission.ACCESS_COARSE_LOCATION)
                      != PackageManager.PERMISSION_GRANTED) {

                  if (ActivityCompat.shouldShowRequestPermissionRationale(settingFrame.this,
                          Manifest.permission.ACCESS_COARSE_LOCATION)) {
                      ActivityCompat.requestPermissions(settingFrame.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
                  }
              }
              else startActivity(intent);
          }
      }
        );
    }
}

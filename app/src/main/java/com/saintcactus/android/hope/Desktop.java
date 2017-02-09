package com.saintcactus.android.hope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.saintcactus.android.hope.R;

public class Desktop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);

        final Button btnSetting = (Button) findViewById(R.id.setting_button);

        btnSetting.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v) {
              Intent intent = new Intent("android.intent.action.setting");
              startActivity(intent);
          }
          }
        );
    }
}

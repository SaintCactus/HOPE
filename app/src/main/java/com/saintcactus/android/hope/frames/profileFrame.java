package com.saintcactus.android.hope.frames;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.saintcactus.android.hope.R;

/**
 * Created by laker on 17.02.2017.
 */

public class profileFrame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_profile);
        final ImageButton backward = (ImageButton) findViewById(R.id.backward);

        backward.setOnClickListener(new View.OnClickListener(){
                                               public void onClick(View v) {
                                                   Intent intent = new Intent("android.intent.action.desktop");
                                                   startActivity(intent);
                                               }
                                           }
        );
    }
}

package com.saintcactus.android.hope.debugs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.saintcactus.android.hope.R;
import com.saintcactus.android.hope.libraries.zonesLibrary;

import java.util.ArrayList;

/**
 * Created by laker on 10.02.2017.
 */

public class developmentRoom extends AppCompatActivity {

    EditText current_heart_rate;
    TextView warmup_test, fitness_test, endurance_test, perfomance_test, maximum_test;
    ImageView heart_rate_zones, invis;

    int age, pickHR, separators;
    double warmup, fitness, endurance, perfomance, maximum, step;
    double warmup_high, warmup_low, fitness_high, fitness_low, endurance_high, endurance_low, perfomance_high, perfomance_low, maximum_high, maximum_low;

    private ArrayList<Integer> progressBar = new ArrayList<Integer>();
    private ArrayList<String> progressBarCapacity = new ArrayList<>(10);

    public void drawVisualTimer(int currentTime,int totalTime){

        int startPoint = -90;
        int endPoint = (currentTime*360/totalTime)*2;
        ImageView tVisual = (ImageView) findViewById(R.id.sector_none);
        Bitmap bitmap = Bitmap.createBitmap(963,963, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, 39, 37, 46));
        canvas.drawPaint(paint);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawCircle(481, 481, 481, paint);
        RectF rectF = new RectF(0, 0, 963, 963);
        paint.setColor(Color.argb(255, 52, 152, 219));
        canvas.drawArc(rectF, -90, 72, true, paint);
        paint.setColor(Color.argb(255, 46, 204, 113));
        canvas.drawArc(rectF, -18, 72, true, paint);
        paint.setColor(Color.argb(255, 241, 196, 15));
        canvas.drawArc(rectF, 54, 72, true, paint);
        paint.setColor(Color.argb(255, 230, 126, 34));
        canvas.drawArc(rectF, 126, 72, true, paint);
        paint.setColor(Color.argb(255, 231, 76, 60));
        canvas.drawArc(rectF, 198, 72, true, paint);

        paint.setColor(Color.argb(192, 39, 37, 46));
        canvas.drawArc(rectF, -90, 288, true, paint);
        //canvas.drawArc(rectF, startPoint, endPoint, true, paint);
        tVisual.setImageBitmap(bitmap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_development);

        final zonesLibrary testZone = new zonesLibrary();

        heart_rate_zones = (ImageView) findViewById(R.id.sector_none);

        warmup_test = (TextView)findViewById(R.id.warmup_test);
        fitness_test = (TextView) findViewById(R.id.fitness_test);
        endurance_test = (TextView) findViewById(R.id.endurance_test);
        perfomance_test = (TextView) findViewById(R.id.perfomance_test);
        maximum_test = (TextView) findViewById(R.id.maximum_test);//

        heart_rate_zones.setImageResource(R.drawable.none_a);


        current_heart_rate = (EditText)findViewById(R.id.current_heart_rate);

        testZone.setAge(23);

        testZone.getBorderOfZones();

        warmup_low = testZone.blue_zone_low;
        warmup_high = testZone.blue_zone_high;

        fitness_low = testZone.green_zone_low;
        fitness_high = testZone.green_zone_high;

        endurance_low = testZone.yellow_zone_low;
        endurance_high = testZone.yellow_zone_high;

        perfomance_low = testZone.orange_zone_low;
        perfomance_high = testZone.orange_zone_high;

        maximum_low = testZone.red_zone_low;
        maximum_high = testZone.red_zone_high;

        warmup_test.setText("" + String.format("%.0f", warmup_low) + ", " + String.format("%.0f", warmup_high) );
        fitness_test.setText("" + String.format("%.0f", fitness_low) + ", " + String.format("%.0f", fitness_high) );
        endurance_test.setText("" + String.format("%.0f", endurance_low) + ", " + String.format("%.0f", endurance_high) );
        perfomance_test.setText("" + String.format("%.0f", perfomance_low) + ", " + String.format("%.0f", perfomance_high) );
        maximum_test.setText("" + String.format("%.0f", maximum_low) + ", " + String.format("%.0f", maximum_high) );

        testZone.createSeparatorsArray((int)warmup_low,(int)maximum_high);

        current_heart_rate.setOnKeyListener(new View.OnKeyListener()
          {
              public boolean onKey(View v, int keyCode, KeyEvent event)
              {
                  if(event.getAction() == KeyEvent.ACTION_DOWN &&
                          (keyCode == KeyEvent.KEYCODE_ENTER))
                  {
                      step = (warmup_high - warmup_low) / 10;
                      Log.d("DEBUGG STEP: ", "" + step);
                      testZone.getTargetZone(Double.parseDouble(current_heart_rate.getText().toString()));
                      testZone.fillSectors(heart_rate_zones, testZone.getSeparatorsArray().indexOf(Integer.parseInt(current_heart_rate.getText().toString())), (int) maximum_high);
                      //drawVisualTimer(testZone.getSeparatorsArray().indexOf(Integer.parseInt(current_heart_rate.getText().toString())), (int) maximum_high);
                      //testZone.rotatatePointer(invis, step, testZone.getSeparatorsArray().indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      //testZone.getFillableSeparator(heart_rate_zones, step, testZone.getSeparatorsArray().indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      /*testZone.zoneAlarm(developmentRoom.this, Double.parseDouble(current_heart_rate.getText().toString()), warmup_low, warmup_high, "warmup");
                      testZone.zoneAlarm(developmentRoom.this, Double.parseDouble(current_heart_rate.getText().toString()), fitness_low, fitness_high, "fitness");
                      testZone.zoneAlarm(developmentRoom.this, Double.parseDouble(current_heart_rate.getText().toString()), endurance_low, endurance_high, "endurance");
                      testZone.zoneAlarm(developmentRoom.this, Double.parseDouble(current_heart_rate.getText().toString()), perfomance_low, perfomance_high, "perfomance");
                      testZone.zoneAlarm(developmentRoom.this, Double.parseDouble(current_heart_rate.getText().toString()), maximum_low, maximum_high, "maximum");*/
                      /*getProgressBar((int)warmup_low,(int)maximum_high);
                      testZone.getFillableSeparator(heart_rate_zones, step, progressBar.indexOf(Integer.parseInt(current_heart_rate.getText().toString())));*/
                      //getSectorSeparatorsID(progressBar.indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      Log.d("DEBUGG: ", " " + testZone.getSeparatorsArray().indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      //sectorSeparators(progressBar.indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      return true;
                  }
                  return false;
              }
          }
        );
    }
}

package com.saintcactus.android.hope;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by laker on 10.02.2017.
 */

public class developmentRoom extends AppCompatActivity {

    EditText current_heart_rate;
    TextView warmup_test, fitness_test, endurance_test, perfomance_test, maximum_test;
    ImageView heart_rate_zones;

    int age, pickHR, separators;
    double warmup, fitness, endurance, perfomance, maximum, step;
    double warmup_high, warmup_low, fitness_high, fitness_low, endurance_high, endurance_low, perfomance_high, perfomance_low, maximum_high, maximum_low;

    private ArrayList<Integer> progressBar = new ArrayList<Integer>();
    private ArrayList<String> progressBarCapacity = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(117, 116, 127)));
        setContentView(R.layout.activity_development);

        heart_rate_zones = (ImageView) findViewById(R.id.sector_none);

        warmup_test = (TextView)findViewById(R.id.warmup_test);
        fitness_test = (TextView) findViewById(R.id.fitness_test);
        endurance_test = (TextView) findViewById(R.id.endurance_test);
        perfomance_test = (TextView) findViewById(R.id.perfomance_test);
        maximum_test = (TextView) findViewById(R.id.maximum_test);//

        heart_rate_zones.setImageResource(R.drawable.none_a);


        current_heart_rate = (EditText)findViewById(R.id.current_heart_rate);

        age = 23;
        pickHR = 220 - age;

        warmup_low = getPercent(pickHR, 50);
        warmup_high = getPercent(pickHR, 60);

        fitness_low = getPercent(pickHR, 60);
        fitness_high = getPercent(pickHR, 70);

        endurance_low = getPercent(pickHR, 70);
        endurance_high = getPercent(pickHR, 80);

        perfomance_low = getPercent(pickHR, 80);
        perfomance_high = getPercent(pickHR, 90);

        maximum_low = getPercent(pickHR, 90);
        maximum_high = getPercent(pickHR, 100);

        warmup_test.setText("" + String.format("%.0f", warmup_low) + ", " + String.format("%.0f", warmup_high) );
        fitness_test.setText("" + String.format("%.0f", fitness_low) + ", " + String.format("%.0f", fitness_high) );
        endurance_test.setText("" + String.format("%.0f", endurance_low) + ", " + String.format("%.0f", endurance_high) );
        perfomance_test.setText("" + String.format("%.0f", perfomance_low) + ", " + String.format("%.0f", perfomance_high) );
        maximum_test.setText("" + String.format("%.0f", maximum_low) + ", " + String.format("%.0f", maximum_high) );

        warmup = (pickHR / 100) * 60;
        fitness = (pickHR / 100) * 70;
        endurance = (pickHR / 100) * 80;
        perfomance = (pickHR / 100) * 90;
        maximum = (pickHR / 100) * 100;


        current_heart_rate.setOnKeyListener(new View.OnKeyListener()
          {
              public boolean onKey(View v, int keyCode, KeyEvent event)
              {
                  if(event.getAction() == KeyEvent.ACTION_DOWN &&
                          (keyCode == KeyEvent.KEYCODE_ENTER))
                  {
                      step = (warmup_high - warmup_low) / 10;
                      Log.d("DEBUGG STEP: ", "" + step);
                      getProgressBar((int)warmup_low,(int)maximum_high);
                      getSectorSeparatorsID(progressBar.indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      Log.d("DEBUGG: ", " " + progressBar.indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      //sectorSeparators(progressBar.indexOf(Integer.parseInt(current_heart_rate.getText().toString())));
                      return true;
                  }
                  return false;
              }
          }
        );
    }

    private int getPercent(double heartrate, int count)
    {
        double percent = (heartrate / 100) * count;
        //Log.d("DEBUGG: ", "" + heartrate % 10);
        return (int)percent;
    }

    private void InTheRange(double origin, double low, double high, int resource)
    {
        if(high == 0) if((origin > low)) heart_rate_zones.setImageResource(resource);
        if((origin >= low) && (origin <= high)) heart_rate_zones.setImageResource(resource);
    }

    private void countTheSeparators(double start, double end)
    {
        for(double i = start; i<=end; i++)
        {
            separators++;
            //Log.d("DEBUGG: ", "" + separators);
        }

    }

    private void getProgressBar(int start, int end)
    {
        for(int i = start; i<=end; i += 1)
        {
            progressBar.add(i);
        }
    }

    //region GET SEPARATORS ID
    private void getSectorSeparatorsID(int ID)
    {
        if(ID == 0*step) fillSeparators(0);
        if(ID >= 1*step) fillSeparators(1);
        if(ID >= 2*step) fillSeparators(2);
        if(ID >= 3*step) fillSeparators(3);
        if(ID >= 4*step) fillSeparators(4);
        if(ID >= 5*step) fillSeparators(5);
        if(ID >= 6*step) fillSeparators(6);
        if(ID >= 7*step) fillSeparators(7);
        if(ID >= 8*step) fillSeparators(8);
        if(ID >= 9*step) fillSeparators(9);
        if(ID >= 10*step) fillSeparators(10);

        if(ID >= 11*step) fillSeparators(11);
        if(ID >= 12*step) fillSeparators(12);
        if(ID >= 13*step) fillSeparators(13);
        if(ID >= 14*step) fillSeparators(14);
        if(ID >= 15*step) fillSeparators(15);
        if(ID >= 16*step) fillSeparators(16);
        if(ID >= 17*step) fillSeparators(17);
        if(ID >= 18*step) fillSeparators(18);
        if(ID >= 19*step) fillSeparators(19);

        if(ID >= 20*step) fillSeparators(20);
        if(ID >= 21*step) fillSeparators(21);
        if(ID >= 22*step) fillSeparators(22);
        if(ID >= 23*step) fillSeparators(23);
        if(ID >= 24*step) fillSeparators(24);
        if(ID >= 25*step) fillSeparators(25);
        if(ID >= 26*step) fillSeparators(26);
        if(ID >= 27*step) fillSeparators(27);
        if(ID >= 28*step) fillSeparators(28);
        if(ID >= 29*step) fillSeparators(29);

        if(ID >= 30*step) fillSeparators(30);
        if(ID >= 31*step) fillSeparators(31);
        if(ID >= 32*step) fillSeparators(32);
        if(ID >= 33*step) fillSeparators(33);
        if(ID >= 34*step) fillSeparators(34);
        if(ID >= 35*step) fillSeparators(35);
        if(ID >= 36*step) fillSeparators(36);
        if(ID >= 37*step) fillSeparators(37);
        if(ID >= 38*step) fillSeparators(38);
        if(ID >= 39*step) fillSeparators(39);

        if(ID >= 40*step) fillSeparators(40);
        if(ID >= 41*step) fillSeparators(41);
        if(ID >= 42*step) fillSeparators(42);
        if(ID >= 43*step) fillSeparators(43);
        if(ID >= 44*step) fillSeparators(44);
        if(ID >= 45*step) fillSeparators(45);
        if(ID >= 46*step) fillSeparators(46);
        if(ID >= 47*step) fillSeparators(47);
        if(ID >= 48*step) fillSeparators(48);
        if(ID >= 49*step) fillSeparators(49);
        if(ID >= 50*step) fillSeparators(50);

        // ID == currnet heart rate
        Log.d("DEBUGG SEP: ", "" + (ID));
    }
    //endregion

    //region FILL SEPARATORS
    private void fillSeparators(int ID)
    {
        switch(ID) {
            case 0:
                heart_rate_zones.setImageResource(R.drawable.none_a);
                break;
            case 1:
                heart_rate_zones.setImageResource(R.drawable.blue_a);
                break;
            case 2:
                heart_rate_zones.setImageResource(R.drawable.blue_b);
                break;
            case 3:
                heart_rate_zones.setImageResource(R.drawable.blue_c);
                break;
            case 4:
                heart_rate_zones.setImageResource(R.drawable.blue_d);
                break;
            case 5:
                heart_rate_zones.setImageResource(R.drawable.blue_e);
                break;
            case 6:
                heart_rate_zones.setImageResource(R.drawable.blue_f);
                break;
            case 7:
                heart_rate_zones.setImageResource(R.drawable.blue_g);
                break;
            case 8:
                heart_rate_zones.setImageResource(R.drawable.blue_h);
                break;
            case 9:
                heart_rate_zones.setImageResource(R.drawable.blue_i);
                break;
            case 10:
                heart_rate_zones.setImageResource(R.drawable.blue_j);
                break;
            case 11:
                heart_rate_zones.setImageResource(R.drawable.green_a);
                break;
            case 12:
                heart_rate_zones.setImageResource(R.drawable.green_b);
                break;
            case 13:
                heart_rate_zones.setImageResource(R.drawable.green_c);
                break;
            case 14:
                heart_rate_zones.setImageResource(R.drawable.green_d);
                break;
            case 15:
                heart_rate_zones.setImageResource(R.drawable.green_e);
                break;
            case 16:
                heart_rate_zones.setImageResource(R.drawable.green_f);
                break;
            case 17:
                heart_rate_zones.setImageResource(R.drawable.green_g);
                break;
            case 18:
                heart_rate_zones.setImageResource(R.drawable.green_h);
                break;
            case 19:
                heart_rate_zones.setImageResource(R.drawable.green_i);
                break;
            case 20:
                heart_rate_zones.setImageResource(R.drawable.green_j);
                break;
            case 21:
                heart_rate_zones.setImageResource(R.drawable.yellow_a);
                break;
            case 22:
                heart_rate_zones.setImageResource(R.drawable.yellow_b);
                break;
            case 23:
                heart_rate_zones.setImageResource(R.drawable.yellow_c);
                break;
            case 24:
                heart_rate_zones.setImageResource(R.drawable.yellow_d);
                break;
            case 25:
                heart_rate_zones.setImageResource(R.drawable.yellow_e);
                break;
            case 26:
                heart_rate_zones.setImageResource(R.drawable.yellow_f);
                break;
            case 27:
                heart_rate_zones.setImageResource(R.drawable.yellow_g);
                break;
            case 28:
                heart_rate_zones.setImageResource(R.drawable.yellow_h);
                break;
            case 29:
                heart_rate_zones.setImageResource(R.drawable.yellow_i);
                break;
            case 30:
                heart_rate_zones.setImageResource(R.drawable.yellow_j);
                break;
            case 31:
                heart_rate_zones.setImageResource(R.drawable.orange_a);
                break;
            case 32:
                heart_rate_zones.setImageResource(R.drawable.orange_b);
                break;
            case 33:
                heart_rate_zones.setImageResource(R.drawable.orange_c);
                break;
            case 34:
                heart_rate_zones.setImageResource(R.drawable.orange_d);
                break;
            case 35:
                heart_rate_zones.setImageResource(R.drawable.orange_e);
                break;
            case 36:
                heart_rate_zones.setImageResource(R.drawable.orange_f);
                break;
            case 37:
                heart_rate_zones.setImageResource(R.drawable.orange_g);
                break;
            case 38:
                heart_rate_zones.setImageResource(R.drawable.orange_h);
                break;
            case 39:
                heart_rate_zones.setImageResource(R.drawable.orange_i);
                break;
            case 40:
                heart_rate_zones.setImageResource(R.drawable.orange_j);
                break;
            case 41:
                heart_rate_zones.setImageResource(R.drawable.red_a);
                break;
            case 42:
                heart_rate_zones.setImageResource(R.drawable.red_b);
                break;
            case 43:
                heart_rate_zones.setImageResource(R.drawable.red_c);
                break;
            case 44:
                heart_rate_zones.setImageResource(R.drawable.red_d);
                break;
            case 45:
                heart_rate_zones.setImageResource(R.drawable.red_e);
                break;
            case 46:
                heart_rate_zones.setImageResource(R.drawable.red_f);
                break;
            case 47:
                heart_rate_zones.setImageResource(R.drawable.red_g);
                break;
            case 48:
                heart_rate_zones.setImageResource(R.drawable.red_h);
                break;
            case 49:
                heart_rate_zones.setImageResource(R.drawable.red_i);
                break;
            case 50:
                heart_rate_zones.setImageResource(R.drawable.red_j);
                break;
            default:
                heart_rate_zones.setImageResource(R.drawable.none_a);
                break;
        }
    }
    //endregion
}

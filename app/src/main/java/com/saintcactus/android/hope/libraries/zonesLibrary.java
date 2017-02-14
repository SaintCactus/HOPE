package com.saintcactus.android.hope.libraries;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageView;

import com.saintcactus.android.hope.R;

import java.util.ArrayList;

/**
 * Created by laker on 14.02.2017.
 */

public class zonesLibrary {
    private int age, pickHR, currentZone;
    private ArrayList<Integer> separatorsArray = new ArrayList<Integer>();

    public ArrayList<Integer> getSeparatorsArray() { return this.separatorsArray; }
    public void setAge(int age) { this.age = age; }

    //region FILL SEPARATORS
    private void fillSeparators(ImageView resource, int ID)
    {
        switch(ID) {
            case 0:
                resource.setImageResource(R.drawable.none_a);
                break;
            case 1:
                resource.setImageResource(R.drawable.blue_a);
                break;
            case 2:
                resource.setImageResource(R.drawable.blue_b);
                break;
            case 3:
                resource.setImageResource(R.drawable.blue_c);
                break;
            case 4:
                resource.setImageResource(R.drawable.blue_d);
                break;
            case 5:
                resource.setImageResource(R.drawable.blue_e);
                break;
            case 6:
                resource.setImageResource(R.drawable.blue_f);
                break;
            case 7:
                resource.setImageResource(R.drawable.blue_g);
                break;
            case 8:
                resource.setImageResource(R.drawable.blue_h);
                break;
            case 9:
                resource.setImageResource(R.drawable.blue_i);
                break;
            case 10:
                resource.setImageResource(R.drawable.blue_j);
                break;
            case 11:
                resource.setImageResource(R.drawable.green_a);
                break;
            case 12:
                resource.setImageResource(R.drawable.green_b);
                break;
            case 13:
                resource.setImageResource(R.drawable.green_c);
                break;
            case 14:
                resource.setImageResource(R.drawable.green_d);
                break;
            case 15:
                resource.setImageResource(R.drawable.green_e);
                break;
            case 16:
                resource.setImageResource(R.drawable.green_f);
                break;
            case 17:
                resource.setImageResource(R.drawable.green_g);
                break;
            case 18:
                resource.setImageResource(R.drawable.green_h);
                break;
            case 19:
                resource.setImageResource(R.drawable.green_i);
                break;
            case 20:
                resource.setImageResource(R.drawable.green_j);
                break;
            case 21:
                resource.setImageResource(R.drawable.yellow_a);
                break;
            case 22:
                resource.setImageResource(R.drawable.yellow_b);
                break;
            case 23:
                resource.setImageResource(R.drawable.yellow_c);
                break;
            case 24:
                resource.setImageResource(R.drawable.yellow_d);
                break;
            case 25:
                resource.setImageResource(R.drawable.yellow_e);
                break;
            case 26:
                resource.setImageResource(R.drawable.yellow_f);
                break;
            case 27:
                resource.setImageResource(R.drawable.yellow_g);
                break;
            case 28:
                resource.setImageResource(R.drawable.yellow_h);
                break;
            case 29:
                resource.setImageResource(R.drawable.yellow_i);
                break;
            case 30:
                resource.setImageResource(R.drawable.yellow_j);
                break;
            case 31:
                resource.setImageResource(R.drawable.orange_a);
                break;
            case 32:
                resource.setImageResource(R.drawable.orange_b);
                break;
            case 33:
                resource.setImageResource(R.drawable.orange_c);
                break;
            case 34:
                resource.setImageResource(R.drawable.orange_d);
                break;
            case 35:
                resource.setImageResource(R.drawable.orange_e);
                break;
            case 36:
                resource.setImageResource(R.drawable.orange_f);
                break;
            case 37:
                resource.setImageResource(R.drawable.orange_g);
                break;
            case 38:
                resource.setImageResource(R.drawable.orange_h);
                break;
            case 39:
                resource.setImageResource(R.drawable.orange_i);
                break;
            case 40:
                resource.setImageResource(R.drawable.orange_j);
                break;
            case 41:
                resource.setImageResource(R.drawable.red_a);
                break;
            case 42:
                resource.setImageResource(R.drawable.red_b);
                break;
            case 43:
                resource.setImageResource(R.drawable.red_c);
                break;
            case 44:
                resource.setImageResource(R.drawable.red_d);
                break;
            case 45:
                resource.setImageResource(R.drawable.red_e);
                break;
            case 46:
                resource.setImageResource(R.drawable.red_f);
                break;
            case 47:
                resource.setImageResource(R.drawable.red_g);
                break;
            case 48:
                resource.setImageResource(R.drawable.red_h);
                break;
            case 49:
                resource.setImageResource(R.drawable.red_i);
                break;
            case 50:
                resource.setImageResource(R.drawable.red_j);
                break;
            default:
                resource.setImageResource(R.drawable.none_a);
                break;
        }
    }
    //endregion

    //region GET FILLABLE SEPARATOR
    public void getFillableSeparator(ImageView resource, double step, int ID)
    {
        if(ID == 0*step) fillSeparators(resource, 0);
        if(ID >= 1*step) fillSeparators(resource, 1);
        if(ID >= 2*step) fillSeparators(resource, 2);
        if(ID >= 3*step) fillSeparators(resource, 3);
        if(ID >= 4*step) fillSeparators(resource, 4);
        if(ID >= 5*step) fillSeparators(resource, 5);
        if(ID >= 6*step) fillSeparators(resource, 6);
        if(ID >= 7*step) fillSeparators(resource, 7);
        if(ID >= 8*step) fillSeparators(resource, 8);
        if(ID >= 9*step) fillSeparators(resource, 9);
        if(ID >= 10*step) fillSeparators(resource, 10);

        if(ID >= 11*step) fillSeparators(resource, 11);
        if(ID >= 12*step) fillSeparators(resource, 12);
        if(ID >= 13*step) fillSeparators(resource, 13);
        if(ID >= 14*step) fillSeparators(resource, 14);
        if(ID >= 15*step) fillSeparators(resource, 15);
        if(ID >= 16*step) fillSeparators(resource, 16);
        if(ID >= 17*step) fillSeparators(resource, 17);
        if(ID >= 18*step) fillSeparators(resource, 18);
        if(ID >= 19*step) fillSeparators(resource, 19);

        if(ID >= 20*step) fillSeparators(resource, 20);
        if(ID >= 21*step) fillSeparators(resource, 21);
        if(ID >= 22*step) fillSeparators(resource, 22);
        if(ID >= 23*step) fillSeparators(resource, 23);
        if(ID >= 24*step) fillSeparators(resource, 24);
        if(ID >= 25*step) fillSeparators(resource, 25);
        if(ID >= 26*step) fillSeparators(resource, 26);
        if(ID >= 27*step) fillSeparators(resource, 27);
        if(ID >= 28*step) fillSeparators(resource, 28);
        if(ID >= 29*step) fillSeparators(resource, 29);

        if(ID >= 30*step) fillSeparators(resource, 30);
        if(ID >= 31*step) fillSeparators(resource, 31);
        if(ID >= 32*step) fillSeparators(resource, 32);
        if(ID >= 33*step) fillSeparators(resource, 33);
        if(ID >= 34*step) fillSeparators(resource, 34);
        if(ID >= 35*step) fillSeparators(resource, 35);
        if(ID >= 36*step) fillSeparators(resource, 36);
        if(ID >= 37*step) fillSeparators(resource, 37);
        if(ID >= 38*step) fillSeparators(resource, 38);
        if(ID >= 39*step) fillSeparators(resource, 39);

        if(ID >= 40*step) fillSeparators(resource, 40);
        if(ID >= 41*step) fillSeparators(resource, 41);
        if(ID >= 42*step) fillSeparators(resource, 42);
        if(ID >= 43*step) fillSeparators(resource, 43);
        if(ID >= 44*step) fillSeparators(resource, 44);
        if(ID >= 45*step) fillSeparators(resource, 45);
        if(ID >= 46*step) fillSeparators(resource, 46);
        if(ID >= 47*step) fillSeparators(resource, 47);
        if(ID >= 48*step) fillSeparators(resource, 48);
        if(ID >= 49*step) fillSeparators(resource, 49);
        if(ID >= 50*step) fillSeparators(resource, 50);
    }
    //endregion

    //region GET BORDER OF ZONES

    public double getBorderOfZones(String zoneName, boolean low, boolean high)
    {
        double lowBorder = 0, highBorder = 0, result = 0;
        pickHR = 220 - age;
        if(low) {
            switch (zoneName) {
                case "warmup":
                    lowBorder = getPercent(pickHR, 50);
                    Log.d("ZONE: ", "" + lowBorder);
                    break;
                case "fitness":
                    lowBorder = getPercent(pickHR, 60);
                    break;
                case "endurance":
                    lowBorder = getPercent(pickHR, 70);
                    break;
                case "perfomance":
                    lowBorder = getPercent(pickHR, 80);
                    break;
                case "maximum":
                    lowBorder = getPercent(pickHR, 90);
                    break;
                default:
                    break;
            }
            result = lowBorder;
        }
        if(high) {
            switch (zoneName) {
                case "warmup":
                    highBorder = getPercent(pickHR, 60);
                    Log.d("ZONE: ", "" + highBorder);
                    break;
                case "fitness":
                    highBorder = getPercent(pickHR, 70);
                    break;
                case "endurance":
                    highBorder = getPercent(pickHR, 80);
                    break;
                case "perfomance":
                    highBorder = getPercent(pickHR, 90);
                    break;
                case "maximum":
                    highBorder = getPercent(pickHR, 100);
                    break;
                default:
                    break;
            }
            result = highBorder;
        }
        return result;
    }

    //endregion

    //region GET AUDIO ZONES

    private void getAudioZones(Activity caller, String zoneName, MediaPlayer zoneAudio)
    {
        switch(zoneName) {
            case "warmup":
                zoneAudio = MediaPlayer.create(caller, R.raw.blue_zone);
                break;
            case "fitness":
                zoneAudio = MediaPlayer.create(caller, R.raw.green_zone);
                break;
            case "endurance":
                zoneAudio = MediaPlayer.create(caller, R.raw.yellow_zone);
                break;
            case "perfomance":
                zoneAudio = MediaPlayer.create(caller, R.raw.orange_zone);
                break;
            case "maximum":
                zoneAudio = MediaPlayer.create(caller, R.raw.red_zone);
                break;
            default:
                break;
        }
    }

    //endregion

    //region SUPPORT METHODS
    private int getPercent(double heartrate, int count)
    {
        double percent = (heartrate / 100) * count;
        return (int)percent;
    }

    public void createSeparatorsArray(int start, int end)
    {
        for(int i = start; i<=end; i += 1)
        {
            separatorsArray.add(i);
        }
    }


    private void zoneAlarm(Activity caller, double origin, double low, double high, String zoneName)
    {
        MediaPlayer zoneAudio = MediaPlayer.create(caller, R.raw.blue_zone);;
        if(getZone(zoneName) != currentZone) {
            if ((origin >= low) && (origin <= high)) {
                getAudioZones(caller, zoneName, zoneAudio);
                zoneAudio.start();
                currentZone = getZone(zoneName);
            }
        }
    }

    private int getZone(String zoneName)
    {
        int zone = 0;
        switch(zoneName) {
            case "warmup":
                zone = 1;
                break;
            case "fitness":
                zone = 2;
                break;
            case "endurance":
                zone = 3;
                break;
            case "perfomance":
                zone = 4;
                break;
            case "maximum":
                zone = 5;
                break;
            default:
                break;
        }
        return  zone;
    }

    //endregion

}


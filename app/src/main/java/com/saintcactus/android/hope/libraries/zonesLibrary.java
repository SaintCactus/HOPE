package com.saintcactus.android.hope.libraries;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageView;

import com.saintcactus.android.hope.R;

import java.util.ArrayList;

/**
 * Created by laker on 14.02.2017.
 */

public class zonesLibrary {
    private int age, pickHR, currentZone, targetZone;
    private ArrayList<Integer> separatorsArray = new ArrayList<Integer>();
    private MediaPlayer zoneAudio;

    public ArrayList<Integer> getSeparatorsArray() { return this.separatorsArray; }
    public void setAge(int age) { this.age = age; }
    public double blue_zone_low, blue_zone_high, green_zone_low, green_zone_high, yellow_zone_low, yellow_zone_high, orange_zone_low, orange_zone_high, red_zone_low, red_zone_high;

    //region DARK ZONE

    private void darkZone(Paint paint, Canvas canvas, RectF rectF, int endPoint)
    {
        switch (targetZone){
            case 2:
                paint.setColor(Color.argb(192, 39, 37, 46));
                canvas.drawArc(rectF, -90, 72*1, true, paint);
                break;
            case 3:
                paint.setColor(Color.argb(192, 39, 37, 46));
                canvas.drawArc(rectF, -90, 72*2, true, paint);
                break;
            case 4:
                paint.setColor(Color.argb(192, 39, 37, 46));
                canvas.drawArc(rectF, -90, 72*3, true, paint);
                break;
            case 5:
                paint.setColor(Color.argb(192, 39, 37, 46));
                canvas.drawArc(rectF, -90, 72*4, true, paint);
                break;
        }
    }


    //endregion

    //region FILL SECTOR

    public void fillSectors(ImageView tVisual, double currentHR,int totalHR)
    {
        int startPoint = -90;
        int endPoint = ((int)currentHR*360/totalHR)*2;
        Bitmap bitmap = Bitmap.createBitmap(963,963, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, 39, 37, 46));
        canvas.drawPaint(paint);
        paint.setAntiAlias(true);
        paint.setColor(Color.argb(255, 117, 116, 127));
        canvas.drawCircle(481, 481, 481, paint);
        RectF rectF = new RectF(0, 0, 963, 963);

        switch (targetZone){
            case 1:
                paint.setColor(getZoneColor(1));
                canvas.drawArc(rectF, -90, endPoint -72*0, true, paint);
                break;
            case 2:
                paint.setColor(getZoneColor(1));
                canvas.drawArc(rectF, -90, 72, true, paint);
                darkZone(paint, canvas, rectF, endPoint);
                paint.setColor(getZoneColor(2));
                canvas.drawArc(rectF, -18, endPoint -72*1, true, paint);
                break;
            case 3:
                paint.setColor(getZoneColor(1));
                canvas.drawArc(rectF, -90, 72, true, paint);
                paint.setColor(getZoneColor(2));
                canvas.drawArc(rectF, -18, 72, true, paint);
                darkZone(paint, canvas, rectF, endPoint);
                paint.setColor(getZoneColor(3));
                canvas.drawArc(rectF, 54, endPoint -72*2, true, paint);
                break;
            case 4:
                paint.setColor(getZoneColor(1));
                canvas.drawArc(rectF, -90, 72, true, paint);
                paint.setColor(getZoneColor(2));
                canvas.drawArc(rectF, -18, 72, true, paint);
                paint.setColor(getZoneColor(3));
                canvas.drawArc(rectF, 54, 72, true, paint);
                darkZone(paint, canvas, rectF, endPoint);
                paint.setColor(getZoneColor(4));
                canvas.drawArc(rectF, 126, endPoint -72*3, true, paint);
                break;
            case 5:
                paint.setColor(getZoneColor(1));
                canvas.drawArc(rectF, -90, 72, true, paint);
                paint.setColor(getZoneColor(2));
                canvas.drawArc(rectF, -18, 72, true, paint);
                paint.setColor(getZoneColor(3));
                canvas.drawArc(rectF, 54, 72, true, paint);
                paint.setColor(getZoneColor(4));
                canvas.drawArc(rectF, 126, 72, true, paint);
                darkZone(paint, canvas, rectF, endPoint);
                paint.setColor(getZoneColor(5));
                canvas.drawArc(rectF, 198, endPoint -72*4, true, paint);
                break;
        }
        tVisual.setImageBitmap(bitmap);
    }

    //endregion

    //region GET BORDER OF ZONES

    public void getBorderOfZones()
    {
        pickHR = 220 - age;

        blue_zone_low = getPercent(pickHR, 50);
        blue_zone_high = getPercent(pickHR, 60);

        green_zone_low = getPercent(pickHR, 60);
        green_zone_high = getPercent(pickHR, 70);

        yellow_zone_low = getPercent(pickHR, 70);
        yellow_zone_high = getPercent(pickHR, 80);

        orange_zone_low = getPercent(pickHR, 80);
        orange_zone_high = getPercent(pickHR, 90);

        red_zone_low = getPercent(pickHR, 90);
        red_zone_high = getPercent(pickHR, 100);

    }

    //endregion

    //region GET ZONE COLOR

    private int getZoneColor(int targetZone)
    {
        int targetColor = Color.WHITE;
        switch(targetZone){
            case 1:
                targetColor = Color.argb(255, 52, 152, 219);
                break;
            case 2:
                targetColor = Color.argb(255, 46, 204, 113);
                break;
            case 3:
                targetColor = Color.argb(255, 241, 196, 15);
                break;
            case 4:
                targetColor = Color.argb(255, 230, 126, 34);
                break;
            case 5:
                targetColor = Color.argb(255, 231, 76, 60);
                break;
        }
        return targetColor;
    }


    //endregion

    //region GET TARGET ZONE

    public int getTargetZone(double origin)
    {
        if ((origin >= blue_zone_low) && (origin <= blue_zone_high)) targetZone = 1;
        else if ((origin >= green_zone_low) && (origin <= green_zone_high)) targetZone = 2;
        else if ((origin >= yellow_zone_low) && (origin <= yellow_zone_high)) targetZone = 3;
        else if ((origin >= orange_zone_low) && (origin <= orange_zone_high)) targetZone = 4;
        else if ((origin >= red_zone_low) && (origin <= red_zone_high)) targetZone = 5;
        return targetZone;
    }

    //endregion

    //region GET AUDIO ZONES

    private MediaPlayer getAudioZones(Activity caller)
    {
        switch(targetZone) {
            case 1:
                zoneAudio = MediaPlayer.create(caller, R.raw.blue_zone);
                break;
            case 2:
                zoneAudio = MediaPlayer.create(caller, R.raw.green_zone);
                break;
            case 3:
                zoneAudio = MediaPlayer.create(caller, R.raw.yellow_zone);
                break;
            case 4:
                zoneAudio = MediaPlayer.create(caller, R.raw.orange_zone);
                break;
            case 5:
                zoneAudio = MediaPlayer.create(caller, R.raw.red_zone);
                break;
            default:
                break;
        }
        return zoneAudio;
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


    public void zoneAlarm(Activity caller, double origin)
    {
        if(getTargetZone(origin) != currentZone) {
            switch(targetZone) {
                case 1:
                    zoneAudio = MediaPlayer.create(caller, R.raw.blue_zone);
                    zoneAudio.start();
                    currentZone = getTargetZone(origin);
                    break;
                case 2:
                    zoneAudio = MediaPlayer.create(caller, R.raw.green_zone);
                    zoneAudio.start();
                    currentZone = getTargetZone(origin);
                    break;
                case 3:
                    zoneAudio = MediaPlayer.create(caller, R.raw.yellow_zone);
                    zoneAudio.start();
                    currentZone = getTargetZone(origin);
                    break;
                case 4:
                    zoneAudio = MediaPlayer.create(caller, R.raw.orange_zone);
                    zoneAudio.start();
                    currentZone = getTargetZone(origin);
                    break;
                case 5:
                    zoneAudio = MediaPlayer.create(caller, R.raw.red_zone);
                    zoneAudio.start();
                    currentZone = getTargetZone(origin);
                    break;
                default:
                    break;
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


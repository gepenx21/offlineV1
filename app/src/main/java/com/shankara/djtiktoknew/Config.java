package com.shankara.djtiktoknew;

import android.app.Activity;
import android.util.Log;

import com.appodeal.ads.Appodeal;

import java.util.Random;

public class Config {

    static String appId = "054116ee924a2628760e6522f4a6f523134b6dd1fe637cc7";
    static final String JSON_ID = "shankara.json";
    public static boolean isPlaying = false;

    private static int mCount = 0;
    private static int counter = 3;


    static void randomNum() {
        int number = 7;
        counter = new Random().nextInt(number);
    }

    public static void showIntersititial(Activity activity, boolean count) {
        if(count){
            mCount++;
            Log.d("mcount",Integer.toString(mCount));
            if(counter <= mCount) {
                if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
                    Appodeal.show(activity, Appodeal.INTERSTITIAL);
                    mCount=0;
                    randomNum();
                }else mCount--;
            }
        } else if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
            Appodeal.show(activity, Appodeal.INTERSTITIAL);
        }
    }
}

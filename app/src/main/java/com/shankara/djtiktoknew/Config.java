package com.shankara.djtiktoknew;

import java.util.Random;

public class Config {

    static final String JSON_ID = "shankara.json";
    public static boolean isPlaying = false;

    static void randomNum() {
        int number = 7;
        new Random().nextInt(number);
    }
}

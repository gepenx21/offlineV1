package com.shankara.djtiktoknew;

import com.shankara.djtiktoknew.Model.Song;

import java.util.ArrayList;

public interface ApiInterface {
    void onSuccess(ArrayList<Song> songs);
    void onError(String message);
}

package com.shankara.djtiktoknew.Model;


public class Song {

    private String artist;
    private String title;
    private String streamUrl;

    public Song(String artist, String title, String streamUrl) {
        this.artist = artist;
        this.title = title;
        this.streamUrl = streamUrl;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getStreamUrl() {
        return streamUrl;
    }
}

package com.example.practice1.model;

import java.io.Serializable;

public class TH2_Song implements Serializable {
    private int id;
    private String name, single, album, type;
    private String isFavorite;

    public TH2_Song() {
    }

    public TH2_Song(String name, String single, String album, String type, String isFavorite) {
        this.name = name;
        this.single = single;
        this.album = album;
        this.type = type;
        this.isFavorite = isFavorite;
    }

    public TH2_Song(int id, String name, String single, String album, String type, String isFavorite) {
        this.id = id;
        this.name = name;
        this.single = single;
        this.album = album;
        this.type = type;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
    }
}

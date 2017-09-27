package com.matrixxun.producttour;

/**
 * Created by swaggymiller on 2017/7/22.
 */

public class Medicine {

    private String name;
    private int imageID;

    public Medicine(String name, int imageID) {

        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {

        return name;
    }

    public int getImageID() {
        return imageID;
    }
}
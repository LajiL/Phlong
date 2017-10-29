package com.lajilao.phlong.utils;

/**
 * Created by Ricky on 2017/10/29.
 */

public class UserTools {

    private String name;

    private int imageId;

    public UserTools(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}

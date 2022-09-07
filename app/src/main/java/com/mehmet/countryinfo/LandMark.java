package com.mehmet.countryinfo;

import java.io.Serializable;

public class LandMark implements Serializable {


    String name;
    String Country;
    int image;

    public LandMark(String name , String Country , int image) {
        this.name = name;
        this.Country = Country;
        this.image = image;
    }


}

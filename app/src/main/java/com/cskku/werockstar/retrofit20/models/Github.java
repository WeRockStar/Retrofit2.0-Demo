package com.cskku.werockstar.retrofit20.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kotchaphan on 29/10/2558.
 */
public class Github {
    @SerializedName("name")
    private String name;

    @SerializedName("company")
    private String company;

    @SerializedName("location")
    private String location;

    @SerializedName("avatar_url")
    private String image;

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }
}

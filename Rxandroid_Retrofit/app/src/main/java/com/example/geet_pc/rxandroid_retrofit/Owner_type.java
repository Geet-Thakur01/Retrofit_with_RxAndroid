package com.example.geet_pc.rxandroid_retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aplitelinux1 on 3/2/17.
 */
public class Owner_type {
    @SerializedName("type")
    String type;
    @SerializedName("id")
    String id;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

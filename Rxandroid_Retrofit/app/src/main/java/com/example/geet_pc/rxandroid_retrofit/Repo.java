package com.example.geet_pc.rxandroid_retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aplitelinux1 on 3/2/17.
 */

public class Repo {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("owner")
    Owner_type ownertype;

    public Owner_type getOwnertype() {
        return ownertype;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

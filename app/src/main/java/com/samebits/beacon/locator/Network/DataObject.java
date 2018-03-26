package com.samebits.beacon.locator.Network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prachisingh on 20/03/18.
 */

public class DataObject {
    @SerializedName("beacon_id")
    @Expose
    public String beaconId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("link")
    @Expose
    public String link;

    public String getBeaconId() {
        return beaconId;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }
}

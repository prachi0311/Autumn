package com.samebits.beacon.locator.Network;


import butterknife.BindView;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by prachisingh on 20/03/18.
 */

public interface ApiInterface {

@GET("statue")
Call<statueResponse> getitemInfo(@Query("beacon_id") String beaconId);
}

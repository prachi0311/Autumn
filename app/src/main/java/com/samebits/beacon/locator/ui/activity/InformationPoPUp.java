package com.samebits.beacon.locator.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.samebits.beacon.locator.Network.ApiClient;
import com.samebits.beacon.locator.Network.ApiInterface;
import com.samebits.beacon.locator.Network.statueResponse;
import com.samebits.beacon.locator.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformationPoPUp extends AppCompatActivity {
    @BindView(R.id.itemImage)
    ImageView itemImage;
    @BindView(R.id.itemInfo)
    TextView itemInfo;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    String BeaconUUID;
    ActionBar abar;
    String expected="chair";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_po_pup);
        ButterKnife.bind(this);
        
        Log.i("code","here in info");
        abar=getSupportActionBar();
        abar.setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        BeaconUUID=i.getStringExtra("beaconUUID");
        getInfo(BeaconUUID);
    }

    private void getInfo(final String id) {
        ApiInterface apiInterface= ApiClient.getAuthorizedApiInterface();
        Call<statueResponse> call=apiInterface.getitemInfo(id);
        call.enqueue(new Callback<statueResponse>() {
            @Override
            public void onResponse(Call<statueResponse> call, Response<statueResponse> response) {
                Log.i("code",String.valueOf(response.code()));
                if(response.isSuccessful()){
                     itemInfo.setText(response.body().getData().getContent().toString());
                     if(id.equals("0x121afef33d1b90975439")){
                         Picasso.with(InformationPoPUp.this).load("https://maps.mapmyindia.com/place/P0015238416_2.jpg").into(itemImage);

                     }else{
                    Picasso.with(InformationPoPUp.this).load(response.body().getData().getLink()).into(itemImage);}
                    progressBar.setVisibility(View.GONE);
                    abar.setTitle(response.body().getData().getName());
                }
            }

            @Override
            public void onFailure(Call<statueResponse> call, Throwable t) {
                Log.e("code","Retorfit fail ",t);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent i=new Intent(InformationPoPUp.this,MainNavigationActivity.class);
            startActivity(i);
        }
        return true;
    }
}

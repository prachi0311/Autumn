package com.samebits.beacon.locator.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.samebits.beacon.locator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartingActivity extends AppCompatActivity {
    @BindView(R.id.enter_des)
    TextView startingImage;
    @BindView(R.id.destination)
    EditText destionation;
    @BindView(R.id.enter_button)
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        ButterKnife.bind(this);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartingActivity.this,MainNavigationActivity.class);
                i.putExtra("destination",destionation.getText().toString());
                startActivity(i);
            }
        });
    }
}

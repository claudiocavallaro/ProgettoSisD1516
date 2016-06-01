package com.teamdev.progettosisd.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamdev.progettosisd.R;

/**
 * Created by claud on 01/06/2016.
 */
public class ActivityListening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
    }

    //PROVA COMMIT

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}

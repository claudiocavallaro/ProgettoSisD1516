package com.teamdev.progettosisd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.teamdev.progettosisd.Persistenza.AsyncJoin;
import com.teamdev.progettosisd.Persistenza.AsyncStart;
import com.teamdev.progettosisd.R;

public class MainActivity extends AppCompatActivity {

    private AsyncStart asyncStart = new AsyncStart(this);
    private AsyncJoin asyncJoin = new AsyncJoin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AsyncStart.setContext(this);
        AsyncJoin.setContext(this);

        Button createButton = (Button) findViewById(R.id.buttonCreate);
        Button joinButton = (Button) findViewById(R.id.buttonJoin);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncStart.execute();
            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncJoin.execute();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            Intent i = new Intent(MainActivity.this, ActivityInfo.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}

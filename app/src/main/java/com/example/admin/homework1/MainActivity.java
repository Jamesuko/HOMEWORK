package com.example.admin.homework1;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer buttonPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( buttonPlayer.isPlaying() ) {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_play ) );
                    buttonPlayer.pause();
                }
                else {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
                    buttonPlayer.start();
                }
            }
        });


        Button btnchangefont = findViewById(R.id.buttonChangeFont);
        Button btnchangebackground = findViewById(R.id.buttonChangeBackground);
        Button btnchangebuttons = findViewById(R.id.buttonChangeButtons);

        btnchangebackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonintent;
                buttonintent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult( buttonintent, 1 );

            }
        });

        btnchangebuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonintent;
                buttonintent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult( buttonintent, 2 );

            }
        });
        btnchangefont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonintent;
                buttonintent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult( buttonintent, 3 );
            }
        });


    }




    @Override
    protected void onPause() {
        super.onPause();
        buttonPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        buttonPlayer = MediaPlayer.create( this, R.raw.mario2 );
        buttonPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }});
        ((FloatingActionButton)findViewById(R.id.fab)).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
    }

    @Override
    protected void onStop() {
        super.onStop();
        buttonPlayer.release();
    }




    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        if (resultCode == RESULT_OK) {
            // Make sure the request was successful
            String color = data.getStringExtra("color");



            switch (requestCode) {
                case 1:
                    (findViewById(R.id.mainbackground)).setBackgroundColor(Color.parseColor(color));
                    break;
                case 2:
                    (findViewById(R.id.buttonChangeFont)).setBackgroundColor(Color.parseColor(color));
                    (findViewById(R.id.buttonChangeBackground)).setBackgroundColor(Color.parseColor(color));
                    (findViewById(R.id.buttonChangeButtons)).setBackgroundColor(Color.parseColor(color));
                    break;
                case 3:
                    ((Button) (findViewById(R.id.buttonChangeFont))).setTextColor(Color.parseColor(color));
                    ((Button) (findViewById(R.id.buttonChangeBackground))).setTextColor(Color.parseColor(color));
                    ((Button) (findViewById(R.id.buttonChangeButtons))).setTextColor(Color.parseColor(color));
                    break;
            }
        }
        else if ( resultCode == RESULT_CANCELED );

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

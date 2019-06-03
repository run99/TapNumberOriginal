package com.example.tapnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button beginnerButton;
    Button masterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        beginnerButton = findViewById(R.id.beginnerButton);
        masterButton= findViewById(R.id.masterButton);
    }


    public void begin(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void master (View v){
        Intent intent = new Intent(this,MasterActivity.class);
        startActivity(intent);

    }
}

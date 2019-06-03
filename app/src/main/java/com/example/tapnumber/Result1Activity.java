package com.example.tapnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import static com.example.tapnumber.MainActivity.time;

public class Result1Activity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        result = findViewById(R.id.resultTextView);

        //timeの少数第二位を四捨五入
        BigDecimal time1 = new BigDecimal(time);
        BigDecimal time2 = time1.setScale(1, BigDecimal.ROUND_HALF_UP);

        result.setText(String.valueOf(time2) + "秒");
    }

    public void back(View v){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}

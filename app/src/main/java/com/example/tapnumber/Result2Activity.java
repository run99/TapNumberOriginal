package com.example.tapnumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.math.BigDecimal;

import static com.example.tapnumber.MasterActivity.time1;

public class Result2Activity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);


        result = findViewById(R.id.resultTextView);

        //timeの少数第二位を四捨五入
        BigDecimal time2 = new BigDecimal(MasterActivity.time1);
        BigDecimal time3 = time2.setScale(1, BigDecimal.ROUND_HALF_UP);

        result.setText(String.valueOf(time3) + "秒");
    }

    public void back(View v){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}

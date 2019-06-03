package com.example.tapnumber;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.graphics.Color.rgb;

public class MasterActivity extends AppCompatActivity {

    int[] hairetu;//配列
    String mondai;
    int seikai;//今の桁数を覚えておく変数
    int next = 0;
    TextView text, display;






    //モグラ参考
    static float time;
    Timer timer;
    TimerTask timerTask;
    Handler h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        text = findViewById(R.id.textView);
        display = findViewById(R.id.displayText);

        h = new Handler();

        time = 0.0f;//タイマーの初期化

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                time += 0.1d;

            }
        };
        timer.schedule(timerTask,100, 100);

        LinearLayout linear1 =findViewById(R.id.Linear1);
        LinearLayout linear2 = findViewById(R.id.Linear2);
        LinearLayout linear3 = findViewById(R.id.Linear3);


    }

    public void start(){

        //配列の準備
        hairetu = new int[9];
        Random rand = new Random();
        hairetu[0] = rand.nextInt(9) + 1; //それぞれに１を足すのは、スタートが０からだから
        hairetu[1] = rand.nextInt(9) + 1;
        hairetu[2] = rand.nextInt(9) + 1;
        hairetu[3] = rand.nextInt(9) + 1;
        hairetu[4] = rand.nextInt(9) + 1;
        hairetu[5] = rand.nextInt(9) + 1;
       /* hairetu[6] = rand.nextInt(9) + 1;
        hairetu[7] = rand.nextInt(9) + 1;
        hairetu[8] = rand.nextInt(9) + 1;*/


        //mondaiに表示されるのは、hairetu0～3を足し合わせたもので、String型
        mondai = Integer.toString(hairetu[0])
                +Integer.toString(hairetu[1])
                +Integer.toString(hairetu[2])
                +Integer.toString(hairetu[3])
                +Integer.toString(hairetu[4])
                +Integer.toString(hairetu[5]);

        text.setText(mondai);
        seikai = 0;



        display.setText(String.valueOf(next) + "/5");

        dynamic();


    }

    public void dynamic(){

        Button button1 = new Button(this);
        button1.setText("1");
        button1.setTextSize(60);
        button1.setBackgroundResource(R.color.yellow);


        Button button2 = new Button(this);
        button2.setText("2");
        button2.setTextSize(60);
        button2.setBackgroundResource(R.color.blue);

        Button button3 = new Button(this);
        button3.setText("3");
        button3.setTextSize(60);
        button3.setBackgroundResource(R.color.red);

        Button button4 = new Button(this);
        button4.setText("4");
        button4.setTextSize(60);
        button4.setBackgroundResource(R.color.red);

        Button button5 = new Button(this);
        button5.setText("5");
        button5.setTextSize(60);
        button5.setBackgroundResource(R.color.yellow);

        Button button6 = new Button(this);
        button6.setText("6");
        button6.setTextSize(60);
        button6.setBackgroundResource(R.color.blue);

        Button button7 = new Button(this);
        button7.setText("7");
        button7.setTextSize(60);
        button7.setBackgroundResource(R.color.blue);

        Button button8 = new Button(this);
        button8.setText("8");
        button8.setTextSize(60);
        button8.setBackgroundResource(R.color.red);

        Button button9 = new Button(this);
        button9.setText("9");
        button9.setTextSize(60);
        button9.setBackgroundResource(R.color.yellow);

        ArrayList<Button> list = new ArrayList<Button>();

        Collection.class(button1, button2,button3,button4,button5,button6,button7,button8, button9);

    }
}

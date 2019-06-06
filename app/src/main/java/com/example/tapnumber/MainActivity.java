package com.example.tapnumber;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);



        text = findViewById(R.id.textView);
        display = findViewById(R.id.displayText);
        start();


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

    }


    //start()メソッドの作成
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


    }


    public void f(){
        next = next + 1;
        display.setText(String.valueOf(next) + "/5");

        if (next == 5){
            timer.cancel();
            BigDecimal time1 = new BigDecimal(time);
            BigDecimal time2 = time1.setScale(1, BigDecimal.ROUND_HALF_UP);

            Intent intent = new Intent(this, Result1Activity.class);
            startActivity(intent);
        }

    }

    public void number1(View v){

        //もし配列の先頭が１だったら、一文字取り除く　
        if(hairetu[seikai]==1){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number2(View v){

        if(hairetu[seikai]==2){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }



    }

    public void number3(View v){

        if(hairetu[seikai]==3){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number4(View v){

        if(hairetu[seikai]==4){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number5(View v){

        if(hairetu[seikai]==5){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number6(View v){

        if(hairetu[seikai]==6){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number7(View v){

        if(hairetu[seikai]==7){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number8(View v){

        if(hairetu[seikai]==8){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }

    public void number9(View v){

        if(hairetu[seikai]==9){
            mondai = mondai.substring(1);
            text.setText(mondai);
            seikai = seikai + 1;

            if(seikai == 6){
                start();
                f();
            }
        }else{
            Toast.makeText(this, "数字が違うよ！！", Toast.LENGTH_SHORT).show();
        }

    }



}

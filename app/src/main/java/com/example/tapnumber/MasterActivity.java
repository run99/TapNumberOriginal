package com.example.tapnumber;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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

    Button button1, button2, button3, button4, button5, button6,button7, button8, button9;

    Button[] buttons;

    Button reloadButton;

    //モグラ参考
    static float time1;
    Timer timer1;
    TimerTask timerTask1;
    Handler h1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);



        text = findViewById(R.id.textView);
        display = findViewById(R.id.displayText);


        //buttonsで配列を管理
        buttons = new Button[]{
                button1, button2, button3, button4, button5,
                button6, button7, button8, button9
        };

        int[] resources = {
                R.id.button,R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9,
        };

        //resourcesでｘｍｌ内のボタンを管理したものを、紐づけした
        for(int i= 0; i < 9; i++){
            buttons[i] = findViewById(resources[i]);
        }

        start();


        h1 = new Handler();

        time1 = 0.0f;//タイマーの初期化

        timer1 = new Timer();
        timerTask1 = new TimerTask() {
            @Override
            public void run() {
                time1 += 0.1d;

            }
        };
        timer1.schedule(timerTask1,100, 100);
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


        //mondaiに表示されるのは、hairetu0～5を足し合わせたもので、String型
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

        //buttonsSetListener();

    }

    public void f(){
        next = next + 1;
        display.setText(String.valueOf(next) + "/5");

        if (next == 5){
            timer1.cancel();
            BigDecimal time2 = new BigDecimal(time1);
            BigDecimal time3 = time2.setScale(1, BigDecimal.ROUND_HALF_UP);

            Intent intent = new Intent(this, Result2Activity.class);
            startActivity(intent);
        }

    }

   /* private void buttonsSetListener(){

        for(Button button : buttons){
            // クリック処理の実装・ボタンクリックすることでタグの表示
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),"tag:" + v.getTag(), Toast.LENGTH_SHORT).show();
//                    Log.d("tag", String.valueOf(v.getTag()));
                }

            });
        }

        reloadButton = findViewById(R.id.reloadButton);
        //reloadButtonを押すことでdynamic()メソッドの呼び出し
        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dynamic();
            }

        });
    }*/



    public void dynamic() {

        //各ボタンにタグをセット
        for(int i = 0; i < 9; i++){
            buttons[i].setTag(i+1);
            //Log.d("はじめ:getTag()", String.valueOf(buttons[i].getTag()));
        }

        //ArrayListに１～１０までの数字を記述
        ArrayList<Integer> tagList = new ArrayList<>();
        for(int i = 1; i< 10; i++){
            tagList.add(i);
           // Log.d("tagList(前) ", String.valueOf(tagList.get(i-1)));
        }

        //タグリストの中身をシャッフル
        Collections.shuffle(tagList);

        //タグリストの中身をログで確認
        /*for(int i = 1; i < 10; i++){
            Log.d("tagList(後) ", String.valueOf(tagList.get(i-1)));
        }*/

        //ここのスタートがなぜ0～8でうまくいき、１～９だとうまくいかないのか説明できるか？
        for(int i = 0; i < 9; i++){
            //タグリストのシャッフル後の数字をボタン０～８にセット
            //buttons[0] = button1 のタグをtagListの0番目(ex. 6)に設置するみたいな意味だと思う
            buttons[i].setTag(tagList.get(i));
           // Log.d("さいご:getTag()", String.valueOf(buttons[i].getTag()));

            //最初のiは0～8の順番通りで、後のiはシャッフル後の０～８のいずれか
            setChangeButton(i,tagList.get(i));

        }

    }

    public void setChangeButton(int index, final int number){
        //色の変数を用意
        String color = null;

        //switch文で色の切り替え　//numberの数値によって、色を変えている
        switch (number){
            case 1:
            case 5:
            case 9:
                color = "#f0d311";//yellow
                break;

            case 2:
            case 6:
            case 7:
                color = "#11d4f0";//blue
                break;

            case 3:
            case 4:
            case 8:
                color = "#f03231";//red
                break;
        }


        if(color!=null) {
            //順番通りのボタンに、シャッフル後の数値に対応した背景色を設置
            buttons[index].setBackgroundColor(Color.parseColor(color));
            //順番通りのボタンに、シャッフル後の数字を配置
            buttons[index].setText(String.valueOf(number));

            buttons[index].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(hairetu[seikai]== number){
                        mondai = mondai.substring(1);
                        text.setText(mondai);
                        seikai = seikai + 1;

                        if(seikai == 6){
                            start();
                            f();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "数字が違うよ！！", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //この下の部分はあってもなくても、アプリは起動するのでどっちでもよさそうな気がする
        }/*else{
            buttons[index].setBackgroundResource(android.R.drawable.btn_default);
        }*/

    }




}

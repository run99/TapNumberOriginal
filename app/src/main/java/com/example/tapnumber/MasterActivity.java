package com.example.tapnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.rgb;

public class MasterActivity extends AppCompatActivity {

    int[] hairetu;//配列
    String mondai;
    int seikai;//今の桁数を覚えておく変数
    int next = 0;
    TextView text, display;

    Button button1, button2, button3, button4, button5, button6,button7, button8, button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        text = findViewById(R.id.textView);
        display = findViewById(R.id.displayText);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        start();

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

    public void dynamic() {

        button1.setTag(1);
        button2.setTag(2);
        button3.setTag(3);
        button4.setTag(4);
        button5.setTag(5);
        button6.setTag(6);
        button7.setTag(7);
        button8.setTag(8);
        button9.setTag(9);

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List list = Arrays.asList(array);

        Collections.shuffle(Collections.singletonList(list));


        button1.getTag((Integer) list.get(1));
        button2.getTag((Integer) list.get(2));
        button3.getTag((Integer) list.get(3));
        button4.getTag((Integer) list.get(4));
        button5.getTag((Integer) list.get(5));
        button6.getTag((Integer) list.get(6));
        button7.getTag((Integer) list.get(7));
        button8.getTag((Integer) list.get(8));
        button9.getTag((Integer) list.get(9));

    }


}

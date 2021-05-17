package com.tuomasjar.quickpointcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;


import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonEight,buttonReset;
    private TextView textCars,textPoints,inputsDone;
    private ImageView imageEurope,imageAmerica;
    private SwitchCompat europe;
    private int cars,points;
    private String syotetyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageEurope = findViewById(R.id.europe);
        imageAmerica = findViewById(R.id.america);
        inputsDone = findViewById(R.id.inputsDone);

        buttonOne = findViewById(R.id.button1);
        buttonTwo = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
        buttonFour = findViewById(R.id.button4);
        buttonFive = findViewById(R.id.button5);
        buttonSix = findViewById(R.id.button6);
        buttonEight = findViewById(R.id.button8);
        buttonReset = findViewById(R.id.resetButton);

        textCars = findViewById(R.id.textCars);
        textPoints = findViewById(R.id.textPoints);

        europe = findViewById(R.id.eurooppa);
        cars=45;
        points=0;
        buttonEight.setVisibility(View.GONE);
        Log.d("Hmm", "starting");

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cars=45;
                points=0;
                syotetyt = "";
                upDateTexts();
            }
        });
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>0) {
                    cars--;
                    points++;

                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "1";
                    }else {
                        syotetyt += "+";
                        syotetyt += "1";
                    }
                    upDateTexts();
                }
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>1) {
                    cars-=2;
                    points+=2;
                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "2";
                    }else{
                        syotetyt += "+";
                        syotetyt += "2";
                    }
                    upDateTexts();

                }
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>2) {
                    cars-=3;
                    points+=4;
                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "3";
                    }else{
                        syotetyt += "+";
                        syotetyt += "3";
                    }

                    upDateTexts();
                }
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>3) {
                    cars-=4;
                    points+=7;
                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "4";
                    }else{
                        syotetyt += "+";
                        syotetyt += "4";
                    }
                    upDateTexts();
                }
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>4) {
                    cars-=5;
                    points+=10;
                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "5";
                    }else{
                        syotetyt += "+";
                        syotetyt += "5";
                    }
                    upDateTexts();
                }
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>5) {
                    cars-=6;
                    points+=15;
                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "6";
                    }else{
                        syotetyt += "+";
                        syotetyt += "6";
                    }
                    upDateTexts();
                }
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cars>7) {
                    cars-=8;
                    points+=21;
                    if(TextUtils.isEmpty(syotetyt)){
                        syotetyt = "8";
                    }else{
                        syotetyt += "+";
                        syotetyt += "8";
                    }
                    upDateTexts();
                }
            }
        });
        imageAmerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEurope();
                buttonReset.callOnClick();
            }
        });
        imageEurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEurope();
                buttonReset.callOnClick();
            }
        });
        europe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(europe.isChecked()){
                    setEurope();
                }else{
                    clearEurope();
                }
            }
        });
        upDateTexts();
        inputsDone.setText("Starting");
    }

    public void setEurope(){
        europe.setChecked(true);
        buttonEight.setVisibility(View.VISIBLE);
        buttonFive.setVisibility(View.GONE);
    }

    public void clearEurope(){
        europe.setChecked(false);
        buttonEight.setVisibility(View.GONE);
        buttonFive.setVisibility(View.VISIBLE);
    }

    private void upDateTexts(){
        String tekstiVaunut = "Vaunut:"+String.valueOf(cars);
        String tekstiPisteet = "Pisteet:"+String.valueOf(points);
       inputsDone.setText(syotetyt);
        textCars.setText(tekstiVaunut);
        textPoints.setText(tekstiPisteet);
    }
}
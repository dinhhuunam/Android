package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_button);

        //Receiving the data from Main MainActivity
        Intent i = getIntent();
        String userName = i.getStringExtra("name"); //get the key

        //Generating Random Numbers
        int random_num = generateRandomNumber();
        luckyNumberTxt.setText(""+random_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);
            }
        });
    }
    private void shareData(String userName, int random_num) {
        //Implicit Inten
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional Info
        i.putExtra(Intent.EXTRA_SUBJECT,userName+"got lucky today");
        i.putExtra(Intent.EXTRA_SUBJECT,"His lucky number is"+ random_num);
        startActivity(Intent.createChooser(i,"Choose a Platform"));
    }
    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        //Random from 0 to upper_limit
        int randomNumberGenerate = random.nextInt(upper_limit);
        return randomNumberGenerate;
    }
}
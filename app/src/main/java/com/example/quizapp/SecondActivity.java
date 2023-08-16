package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvDescription;
    RatingBar ratingBar;
    Button btnNext;
    Button btnPlayAgain;
    int currentAnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        currentAnswerCount = getIntent().getIntExtra("key", 0);
        Toast.makeText(this, currentAnswerCount+"", Toast.LENGTH_SHORT).show();

        UI();
        displayData();

        btnNext.setOnClickListener(this);
        btnPlayAgain.setOnClickListener(this);
    }

    public void UI() {
        tvDescription = findViewById(R.id.tv_description);
        ratingBar = findViewById(R.id.rb_ratingAnswer);
        btnNext = findViewById(R.id.btn_next);
        btnPlayAgain = findViewById(R.id.btn_playAgain);
    }

    public void displayData() {
        ratingBar.setRating(currentAnswerCount);
        if (currentAnswerCount != 0 && currentAnswerCount != 1) {
            tvDescription.setText("Nice Work");
        } else {
            tvDescription.setText("Bad Work");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.btn_next){
            Toast.makeText(this, "No add next stage",Toast.LENGTH_LONG).show();
        } else if (id == R.id.btn_playAgain){
            currentAnswerCount = 0;
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
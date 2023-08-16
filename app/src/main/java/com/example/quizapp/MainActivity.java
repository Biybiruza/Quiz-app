package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.data.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    TextView tvQuestionTitle;
    ImageView img;
    RadioGroup radioGroup;
    RadioButton btnA;
    RadioButton btnB;
    RadioButton btnC;
    List<Question> question;
    int currentPosition = 0;
    Map<Integer, Integer> answersMap;
    RadioButton selectedButton;

    int questionCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answersMap = new HashMap<>();

        initUI();
        initClick();
        displayQuestions();

    }

    private void intent(int currentAnswer) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("key",currentAnswer);
        startActivity(intent);
        finish();
    }

    public void displayQuestions() {
        initQuestion();
        if (currentPosition <= question.size()-1){
            img.setImageResource(question.get(currentPosition).getImg());
            btnA.setText(question.get(currentPosition).getA());
            btnB.setText(question.get(currentPosition).getB());
            btnC.setText(question.get(currentPosition).getC());
            questionCount++;
            tvQuestionTitle.setText("Question: "+questionCount);
            radioGroup.check(0);
        } else {
            Toast.makeText(this,"Sorawlar tawsildi",Toast.LENGTH_SHORT).show();
            AtomicInteger currentAnswer = new AtomicInteger();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                answersMap.forEach((key, value) -> {
                    if (question.get(key).getTrueAnswer() == value) {
                        currentAnswer.getAndIncrement();
                    }
                });
                answersMap.clear();
            }
            intent(currentAnswer.getAndIncrement());
        }
    }

    public void initUI() {
        img = findViewById(R.id.im_question);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        radioGroup = findViewById(R.id.radioGroup);
        tvQuestionTitle = findViewById(R.id.tv_questionTitle);
    }

    private void initClick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedButton = findViewById(checkedId);

                if(checkedId == R.id.btn_a){
                    answersMap.put(currentPosition, getAnswerId(selectedButton.getId()));
                    currentPosition++;
                    displayQuestions();
                }
                if(checkedId == R.id.btn_b){
                    answersMap.put(currentPosition, getAnswerId(selectedButton.getId()));
                    currentPosition++;
                    displayQuestions();
                }
                if(checkedId == R.id.btn_c){
                    answersMap.put(currentPosition, getAnswerId(selectedButton.getId()));
                    currentPosition++;
                    displayQuestions();
                }
            }
        });
    }

    private int getAnswerId(int id) {
        int ans = 0;
        if (id == R.id.btn_a) ans = 1;
        else if (id == R.id.btn_b) ans = 2;
        else if (id == R.id.btn_c) ans = 3;

        return ans;
    }

    public void initQuestion(){
        question = new ArrayList<Question>();

        question.add(new Question(
                R.drawable.basketball_ball, "basketball ball", "football ball","cricket ball",1));
        question.add(new Question(
                R.drawable.pen, "pen", "marker","pencil",1));
        question.add(new Question(
                R.drawable.bycicle, "scooter", "motorbike","bycicle",3));
        question.add(new Question(
                R.drawable.pencil, "pen", "book","pencil",3));
        question.add(new Question(
                R.drawable.marker, "pen", "marker","pencil",2));
    }
}
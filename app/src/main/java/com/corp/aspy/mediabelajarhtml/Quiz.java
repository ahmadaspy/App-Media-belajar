package com.corp.aspy.mediabelajarhtml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.corp.aspy.mediabelajarhtml.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    Button option1, option2, option3, option4;
    TextView question_text;
    int total =-1;
    int bujur =0;
    int salah =0;

    DatabaseReference DBref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        option1 = (Button) findViewById(R.id.option1_btn);
        option2 = (Button) findViewById(R.id.option2_btn);
        option3 = (Button) findViewById(R.id.option3_btn);
        option4 = (Button) findViewById(R.id.option4_btn);
        question_text = (TextView) findViewById(R.id.question_txt);
        randnumber();
        upadetQuestion();
    }
    private int randomnumber;
    int[] soalnumber = {0,0,0,0,0};
    Random rand =new Random();
    int temp;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    private void randnumber() {

        Random randomGenerator = new Random();
        while (numbers.size() < 10) {

            int random = randomGenerator .nextInt(10);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
//        for (int i=0;i<5;){
//            if (i==0) {
//                randomnumber = rand.nextInt(5) + 1;
//                soalnumber[i]=randomnumber;
//                i++;
//            }else{
//                randomnumber = rand.nextInt(5) + 1;
//                for (int k=0;k<i;){
//                    if (randomnumber == soalnumber[k]){
//                        temp = 0;
//                        k=i;
//                    }else{
//                        temp = 1;
//                        k++;
//                    }
//                }
//                if (temp ==1){
//                    soalnumber[i] = randomnumber;
//                }
////                randomnumber = rand.nextInt(5) + 1;
////                if (randomnumber != soalnumber[i-1]) {
////                    soalnumber[i] = randomnumber;
////                    i++;
////                }
//            }
//        }
////        return soalnumber;
    }

    private void upadetQuestion() {
        total++;
        if (total > 9){
            Intent intent = new Intent(Quiz.this, ResultQuiz.class);
            intent.putExtra("bujur", String.valueOf(bujur));
            intent.putExtra("salah", String.valueOf(salah));
            startActivity(intent);
            finish();

        }
        else {

            DBref = FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(numbers.indexOf(total)));
            DBref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    question_text.setText(question.getQuestion());
                    option1.setText(question.getOption1());
                    option2.setText(question.getOption2());
                    option3.setText(question.getOption3());
                    option4.setText(question.getOption4());

                    option1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (option1.getText().toString().equals(question.getAnswer())){
                                option1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        bujur++;
                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();
                                    }
                                },2000);
                            } else {
                                salah++;
                                option1.setBackgroundColor(Color.RED);
                                if (option2.getText().toString().equals(question.getAnswer())){
                                    option2.setBackgroundColor(Color.GREEN);
                                } else if (option3.getText().toString().equals(question.getAnswer())){
                                    option3.setBackgroundColor(Color.GREEN);
                                } else if (option4.getText().toString().equals(question.getAnswer())){
                                    option4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();
                                    }
                                },2000);
                            }
                        }
                    });
                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (option2.getText().toString().equals(question.getAnswer())){
                                option2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        bujur++;
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();
                                    }
                                },2000);
                            } else {
                                salah++;
                                option2.setBackgroundColor(Color.RED);
                                if (option1.getText().toString().equals(question.getAnswer())){
                                    option1.setBackgroundColor(Color.GREEN);
                                } else if (option3.getText().toString().equals(question.getAnswer())){
                                    option3.setBackgroundColor(Color.GREEN);
                                } else if (option4.getText().toString().equals(question.getAnswer())){
                                    option4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();
                                    }
                                },2000);
                            }
                        }
                    });
                    option3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (option3.getText().toString().equals(question.getAnswer())){
                                option3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        bujur++;
                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();
                                    }
                                },2000);
                            } else {
                                salah++;
                                option3.setBackgroundColor(Color.RED);
                                if (option1.getText().toString().equals(question.getAnswer())){
                                    option1.setBackgroundColor(Color.GREEN);
                                } else if (option2.getText().toString().equals(question.getAnswer())){
                                    option2.setBackgroundColor(Color.GREEN);
                                } else if (option4.getText().toString().equals(question.getAnswer())){
                                    option4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();

                                    }
                                },2000);
                            }
                        }
                    });
                    option4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (option4.getText().toString().equals(question.getAnswer())){
                                option4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        bujur++;
                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();
                                    }
                                },2000);
                            } else {
                                salah++;
                                option4.setBackgroundColor(Color.RED);
                                if (option1.getText().toString().equals(question.getAnswer())){
                                    option1.setBackgroundColor(Color.GREEN);
                                } else if (option2.getText().toString().equals(question.getAnswer())){
                                    option2.setBackgroundColor(Color.GREEN);
                                } else if (option3.getText().toString().equals(question.getAnswer())){
                                    option3.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        upadetQuestion();

                                    }
                                },2000);
                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getBaseContext(), "Something Error, Please connect to internet", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void onBackPressed(){
        startActivity(new Intent(Quiz.this, MenuListView.class));
        finish();
    }

}


package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quizapp.QuizModel;
import com.example.quizapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity<questionAttempted> extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore=0, questionAttempted=1,currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV=findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModelArrayList=new ArrayList<>();
        random= new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos=random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;

                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }

        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;

                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;

                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;

                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });




    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(MainActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLscore));
        TextView ScoreTV=bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn =  bottomSheetView.findViewById(R.id.idBtnRestart);
        ScoreTV.setText("Your score is \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted=0;
                currentScore=0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();



    }

    private void setDataToViews(int currentPos)
    {
        questionNumberTV.setText("Questions Attempted: "+questionAttempted +"/10");
        if (questionAttempted==10)
        {
            showBottomSheet();
        }
        else
        {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }





    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList){

        quizModelArrayList.add(new QuizModel("Your Name","Muqarrin","Jamal","Malkani","Shahid","Muqarrin"));
        quizModelArrayList.add(new QuizModel("Your surname","Muqarrin","Jamal","Malkani","Shahid","Jamal"));
        quizModelArrayList.add(new QuizModel("Your lastName","Muqarrin","Jamal","Malkani","Shahid","Malkani"));
        quizModelArrayList.add(new QuizModel("Project Leader","Mujahid","TALHA","Malkani","Murshad","Murshad"));
        quizModelArrayList.add(new QuizModel("Your friendName","Mujahid","Saleem","skpura","Talha","Mujahid"));
        quizModelArrayList.add(new QuizModel("Your friend-surname","Mujahid","saleem","skpura","Shahid","saleem"));
        quizModelArrayList.add(new QuizModel("Your friend-lastName","Mujahid","saleem","skpura","Shahid","skpura"));
        quizModelArrayList.add(new QuizModel("Project member","Muqarrin","talha","Mubashir","mujahid","talha"));
        quizModelArrayList.add(new QuizModel("Your project title","blog on","blogs","executive blog","blogger","blog on"));
        quizModelArrayList.add(new QuizModel("Your university","FCIT","FAST","COMSATS","UCP","FCIT"));


    }
}
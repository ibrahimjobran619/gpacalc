package com.example.gpa_jobrani1_calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText grade1;
    private EditText grade2;
    private EditText grade3;
    private EditText grade4;
    private EditText grade5;

    private TextView gpa;

    private View parentView;

    private Button calculateButton;

    private boolean isCalculated;
    private double averageGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grade1 = findViewById(R.id.grade1_editText);
        grade2 = findViewById(R.id.grade2_editText);
        grade3 = findViewById(R.id.grade3_editText);
        grade4 = findViewById(R.id.grade4_editText);
        grade5 = findViewById(R.id.grade5_editText);
        gpa = findViewById(R.id.gpa_textView);
        parentView = findViewById(R.id.parent);

        gpa.setText("0");
        calculateButton = findViewById(R.id.calculate_button);
        clearFields();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isCalculated){
                    if(!isClear()){
                        double grade = 0;
                        grade += Integer.parseInt(grade1.getText().toString().trim());
                        grade += Integer.parseInt(grade2.getText().toString().trim());
                        grade += Integer.parseInt(grade3.getText().toString().trim());
                        grade += Integer.parseInt(grade4.getText().toString().trim());
                        grade += Integer.parseInt(grade5.getText().toString().trim());
                        //adding the numbers
                        //getting the average
                        averageGrade = grade/5.0;
                        String text = String.format("%.2f",averageGrade);
                        gpa.setText(text);
                        setBackGroundColor(averageGrade);
                        calculateButton.setText("Clear Inputs");
                        isCalculated = true;
                    }else{
                        //if any of the fields is empty
                        Toast.makeText(MainActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    //clearing the fields
                    clearFields();
                    parentView.setBackgroundColor(getColor(R.color.white));
                    gpa.setText("0");
                    calculateButton.setText("Compute Course GPA");
                    isCalculated = false;
                }
            }
        });
    }

    private void setBackGroundColor(double grade) {
        //setting the color according to the grade



    }

    private boolean isClear() {
        //returns if any of the editTexts is empty or not
        return grade1.getText().toString().trim().equals("")||grade2.getText().toString().trim().equals("")||
                grade3.getText().toString().trim().equals("")||grade4.getText().toString().trim().equals("")||
                grade5.getText().toString().trim().equals("");
    }

    private void clearFields() {
        //method to clear the editText views
        grade1.setText("");
        grade2.setText("");
        grade3.setText("");
        grade4.setText("");
        grade5.setText("");
    }
}






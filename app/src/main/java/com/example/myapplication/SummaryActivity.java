package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tv_summary);

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String program = getIntent().getStringExtra("program");
        boolean specialNeeds = getIntent().getBooleanExtra("specialNeeds", false);
        boolean scholarship = getIntent().getBooleanExtra("scholarship", false);

        String specialNeedsText = specialNeeds ? "Special Needs" : "";
        String scholarshipText = scholarship ? "Scholarship" : "";

        String summary = "The information has been saved:\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Program: " + program + "\n" +
                specialNeedsText + "/" + scholarshipText;

        tvSummary.setText(summary);
    }
}
package com.example.myapplication;
//Change 1
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    RadioGroup rgProgram;
    CheckBox cbSpecialNeeds, cbScholarship;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        rgProgram = findViewById(R.id.rg_program);
        cbSpecialNeeds = findViewById(R.id.cb_special_needs);
        cbScholarship = findViewById(R.id.cb_scholarship);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                int selectedProgramId = rgProgram.getCheckedRadioButtonId();
                RadioButton selectedProgram = findViewById(selectedProgramId);
                String program = selectedProgram.getText().toString();

                boolean specialNeeds = cbSpecialNeeds.isChecked();
                boolean scholarship = cbScholarship.isChecked();

                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("program", program);
                intent.putExtra("specialNeeds", specialNeeds);
                intent.putExtra("scholarship", scholarship);
                startActivity(intent);
            }
        });
    }
}
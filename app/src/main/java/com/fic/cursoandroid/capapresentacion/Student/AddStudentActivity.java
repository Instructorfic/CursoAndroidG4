package com.fic.cursoandroid.capapresentacion.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fic.cursoandroid.R;
import com.fic.cursoandroid.capaaplicacion.StudentController;
import com.fic.cursoandroid.capadatos.Student;
import com.fic.cursoandroid.utils.Constants;

public class AddStudentActivity extends AppCompatActivity {

    private Button btnAddStudent, btnCancel;
    private EditText etName, etPaternalSurname, etMaternalSurname, etEmail, etPhoneNumber,etGrade,etGroup;
    private StudentController studentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etName = findViewById(R.id.etStudentName);
        etPaternalSurname = findViewById(R.id.etPaternalSurname);
        etMaternalSurname = findViewById(R.id.etMaternalSurname);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etGrade = findViewById(R.id.etGrade);
        etGroup = findViewById(R.id.etGroup);

        studentController = new StudentController(AddStudentActivity.this);

        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAddStudent.setOnClickListener(saveStudentListener);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(buttonCancelListener);
    }

    private View.OnClickListener saveStudentListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = etName.getText().toString();
            String paternalSurname = etPaternalSurname.getText().toString();
            String maternalSurname = etMaternalSurname.getText().toString();
            String email = etEmail.getText().toString();
            String phoneNumber = etPhoneNumber.getText().toString();
            String grade = etGrade.getText().toString();
            String group = etGroup.getText().toString();

            if(validateEditText(etName,etPaternalSurname,etMaternalSurname,etEmail,etPhoneNumber,etGrade,etGroup) == false){
                Toast.makeText(getApplicationContext(), Constants.VALIDATE_EMPTY_TEXT,Toast.LENGTH_LONG).show();
                return;
            }

            Student student = new Student(0,name,paternalSurname,maternalSurname,email,phoneNumber,grade,group);

            long insertResult = studentController.saveStudent(student);

            if(insertResult == -1){
                Toast.makeText(AddStudentActivity.this, Constants.FAILED_DATABASE_INSERT,Toast.LENGTH_LONG).show();

            }else{
                finish();
            }
        }
    };

    private View.OnClickListener buttonCancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

    protected boolean validateEditText(EditText... editTexts) {
        boolean result = true;
        for (int i = 0; i < editTexts.length; i++) {
            if (editTexts[i].getText().toString().isEmpty()) {
                result = false;
                editTexts[i].setError(Constants.REQUIRED_FIELD);
            }
        }
        return result;
    }
}
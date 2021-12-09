package com.fic.cursoandroid.capapresentacion.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fic.cursoandroid.R;
import com.fic.cursoandroid.capapresentacion.MainActivity2;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String webPageURL = "http://www.google.com";
    final String MAIN_ACTIVITY_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLog("onCreate Called");
        setContentView(R.layout.activity_constraint_layout);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        /*Student student = new Student("Alexis", "Montaño","Araujo","alexis.montano@info.uas.edu.mx","6671000000","1","1");
        student.setName("Moises");
        setLog(student.toString());  Instancia de la clase student*/

        btnLogin.setOnClickListener(testOnClickListener); //Opción 2 para gestionar clic de un botón
        //btnLogin.setOnClickListener(new ClickedButton()); // Opción 3
        //btnLogin.setOnClickListener(this); //Opción 4 para gestionar clic de un botón
    }

    private void setLog(String text){
        Log.d(MAIN_ACTIVITY_TAG,text);
    }

    @Override
    protected void onStart(){
        super.onStart();
        setLog("onStart Called");
        //Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_LONG).show();
    }

    protected void onResume(){
        super.onResume();
        setLog("onResume Called");
    }

    protected void onPause(){
        super.onPause();
        setLog("onPause Called");
    }

    protected void onRestart(){
        super.onRestart();
        setLog("onRestart Called");
    }

    protected void onStop(){
        super.onStop();
        setLog("onStop Called");
    }

    protected void onDestroy(){
        super.onDestroy();
        setLog("onDestroy Called");
    }

    private View.OnClickListener testOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startTestActivity();
        }
    };

    private void startTestActivity(){
        Intent showActivity = new Intent(getApplicationContext(), MainActivity2.class);
        //showActivity.setData(Uri.parse(webPageURL));

        EditText etUsername = findViewById(R.id.etUsername);

        String message = "Hola, Actividad 2";
        int error = 0;
        String name = etUsername.getText().toString();


        Bundle bundle = new Bundle();
        bundle.putString("message",message);
        bundle.putInt("error",error);
        bundle.putString("name",name);

        showActivity.putExtras(bundle);

        //showActivity.putExtra("message",message);
        startActivity(showActivity);
    }

    class ClickedButton implements View.OnClickListener{
        @Override
        public void onClick(View v){
            startTestActivity();
        }
    }

    @Override
    public void onClick(View v){
        startTestActivity();
    }

}
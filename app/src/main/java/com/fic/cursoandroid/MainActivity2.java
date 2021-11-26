package com.fic.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnShowView = (Button) findViewById(R.id.btnShowView);
        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnSettings = (Button) findViewById(R.id.btnSettings);
        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        TextView txtError = (TextView) findViewById(R.id.txtError);
        TextView txtName = findViewById(R.id.txtName);

        /*Uri webSite = getIntent().getData();
        Toast.makeText(getApplicationContext(),webSite.toString(),Toast.LENGTH_LONG).show();*/

        /*String getStringMessage = getIntent().getStringExtra("message");
        Toast.makeText(getApplicationContext(),getStringMessage,Toast.LENGTH_LONG).show();*/

        Bundle extras = getIntent().getExtras();

        String message = extras.getString("message","El valor es incorrecto");
        int error = extras.getInt("error",-1);
        String name = extras.getString("name","Nombre de usuario no válido");

        txtMessage.setText(message);
        txtError.setText(String.valueOf(error));
        txtName.setText(name);





        btnShowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void showPage(MenuItem item){
        Uri uri = Uri.parse("http://www.google.com");
        Intent showWebPageIntent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(showWebPageIntent);
    }

    public void dialPhoneNumber(MenuItem item){
        Uri uri = Uri.parse("tel:6677000000");
        Intent dialIntent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(dialIntent);
    }

    public void showSettings(MenuItem item){
        Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(settingsIntent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuOption1:
                showPage(item);
                return true;
            case R.id.menuOption2:
                dialPhoneNumber(item);
                return true;
            case R.id.menuOption3:
                showSettings(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
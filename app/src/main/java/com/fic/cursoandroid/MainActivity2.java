package com.fic.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
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

        /*Uri webSite = getIntent().getData();
        Toast.makeText(getApplicationContext(),webSite.toString(),Toast.LENGTH_LONG).show();*/

        /*String getStringMessage = getIntent().getStringExtra("message");
        Toast.makeText(getApplicationContext(),getStringMessage,Toast.LENGTH_LONG).show();*/

        Bundle extras = getIntent().getExtras();

        String message = extras.getString("message","El valor es incorrecto");
        int error = extras.getInt("error",-1);

        txtMessage.setText(message);
        txtError.setText(String.valueOf(error));





        btnShowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent showWebPageIntent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(showWebPageIntent);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:6677000000");
                Intent dialIntent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(dialIntent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(settingsIntent);
            }
        });


    }
}
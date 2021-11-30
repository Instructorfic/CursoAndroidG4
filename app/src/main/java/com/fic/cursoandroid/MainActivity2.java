package com.fic.cursoandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton btnPopUpMenu;
    private ActionMode actionMode;
    private Button btnAlert;

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

        TextView txtMenuContext = findViewById(R.id.txtMenuContext);
        //registerForContextMenu(txtMenuContext);

        txtMenuContext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                actionMode = MainActivity2.this.startActionMode(actionModeCallback);
                txtMenuContext.setSelected(true);
                return true;
            }
        });

        btnPopUpMenu = findViewById(R.id.btnPopUpMenu);

        btnPopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity2.this,btnPopUpMenu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //return false;
                        switch (item.getItemId()){
                            case R.id.menuPopUptEdit:
                                Toast.makeText(getApplicationContext(), "Editar PopUp", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menuPopUpShare:
                                Toast.makeText(getApplicationContext(), "Compartir PopUp", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return true;
                        }
                    }
                });
                popupMenu.show();
            }
        });

        btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

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

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context,menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuContextEdit:
                Toast.makeText(getApplicationContext(), "Editar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuContextShare:
                Toast.makeText(getApplicationContext(), "Compartir", Toast.LENGTH_SHORT).show();
            default:
                return super.onContextItemSelected(item);
        }
    }

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_context,menu);
            mode.setTitle("Selecciona una opción");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.menuContextEdit:
                    Toast.makeText(getApplicationContext(), "Editar Action Mode", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.menuContextShare:
                    Toast.makeText(getApplicationContext(), "Compartir Action Mode", Toast.LENGTH_SHORT).show();
                    mode.finish();
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    public void showAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);
        alertDialog.setTitle(R.string.alert_title);
        alertDialog.setMessage(R.string.alert_message);
        alertDialog.show();
    }
}
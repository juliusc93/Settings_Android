package com.example.julio.settings_android;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class MainActivity extends ActionBarActivity {

    EditText name, age;
    RadioButton male, fem;
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.txtName);
        age = (EditText) findViewById(R.id.txtAge);
        male = (RadioButton) findViewById(R.id.rbtnMale);
        fem = (RadioButton) findViewById(R.id.rbtnFemale);

        loadSettings();
    }

    public void loadSettings(){

        settings = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        name.setText(settings.getString("name",""));
        age.setText(settings.getString("age", ""));
        male.setChecked(settings.getBoolean("male", false));
        fem.setChecked(settings.getBoolean("female", false));

    }

    public void saveSettings(View v){
        settings = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putString("name", name.getText().toString());
        editor.putString("age", age.getText().toString());
        editor.putBoolean("male", male.isChecked());
        editor.putBoolean("female", fem.isChecked());
        editor.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

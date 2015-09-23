package com.example.saketp.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    public void startGame(View v) {
        Intent is = new Intent(this, MainActivity.class);
        EditText et_p1 = (EditText) findViewById(R.id.editText3);
        EditText et_p2 = (EditText) findViewById(R.id.editText2);
        String name_p1 = et_p1.getText().toString();
        String name_p2 = et_p2.getText().toString();
        CheckBox easy = (CheckBox) findViewById(R.id.checkBox);
        boolean easy_val = easy.isChecked();
        is.putExtra("player1", name_p1);
        is.putExtra("player2", name_p2);
        is.putExtra("easy", easy_val);
        startActivity(is);
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

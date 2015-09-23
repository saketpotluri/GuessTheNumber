package com.example.saketp.maps;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Player p1;
    private Player p2;
    private Game game;
    private boolean active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent is = getIntent();
        String p1Name = is.getStringExtra("player1");
        String p2Name = is.getStringExtra("player2");
        active = is.getBooleanExtra("easy", false);
        p1 = new Player(p1Name);
        p2 = new Player(p2Name);
        game = new Game(); //start out with Player1
        Random rndm = new Random();
        int val = rndm.nextInt(2);

        if(val == 0) {
            game.setCurrentPlayer(p1);
        } else {
            game.setCurrentPlayer(p2);
        }
        game.setCurrentPlayer(p1);
        setContentView(R.layout.activity_main);
        TextView message = (TextView) findViewById(R.id.textView);
        message.setText(game.getCurrentPlayer().getName() + " pick a number between 1 and 100");

        if(active) {
            game.setMinGuess(1);
            game.setMaxGuess(100);
            TextView easy_mode = (TextView) findViewById(R.id.textView5);
            easy_mode.setText("The answer is between " + game.getMinGuess() + " and " + game.getMaxGuess());
        }
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

    public void guess(View v) {
        //get guess from TextBox
        int GUESS = game.getRandNum();
        EditText et = (EditText) findViewById(R.id.editText);
        TextView tv = (TextView) findViewById(R.id.textView2);
        final TextView easy_mode = (TextView) findViewById(R.id.textView5);
        int val = Integer.parseInt(et.getText().toString());
        Log.e("info", "Value: " + GUESS + " guess: " + val);
        if (val < GUESS) {
            tv.setText("Guess Higher");
            game.setMinGuess(val);
            switchPlayers();
            if(active) {
                easy_mode.setText("The answer is between " + game.getMinGuess() + " and " + game.getMaxGuess());
            }

        } else if (val > GUESS) {
            tv.setText("Guess Lower");
            switchPlayers();
            game.setMaxGuess(val);
            if(active) {
                easy_mode.setText("The answer is between " + game.getMinGuess() + " and " + game.getMaxGuess());
            }
        } else { //val = Guess, meaning game over
            tv.setText("You won!");
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("Player: " + game.getCurrentPlayer().getName() + " has won! Would you like to play again?");
            ad.setTitle("Game over!");
            ad.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            game.reset();
                            TextView tv1 = (TextView) findViewById(R.id.textView2);
                            EditText et = (EditText) findViewById(R.id.editText);
                            et.setText("");
                            tv1.setText("");
                            easy_mode.setText("");
                        }
                    });

            ad.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            AlertDialog alert11 = ad.create();
            alert11.show();

        }
    }

    private void switchPlayers() {
        if(p1.equals(game.getCurrentPlayer())) {
            game.setCurrentPlayer(p2);
        } else { //p2 is current
            game.setCurrentPlayer(p1);
        }
        TextView message = (TextView) findViewById(R.id.textView);
        message.setText(game.getCurrentPlayer().getName() + " pick a number between 1 and 100");
    }
}


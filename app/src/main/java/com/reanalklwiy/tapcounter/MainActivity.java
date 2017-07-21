package com.reanalklwiy.tapcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button clickMeButton;
    private TextView textMessage;
    private TextView warningMessage;
    private Button resetButton;
    private int counter = 0;
    private final int resetCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        clickMeButton = (Button) findViewById(R.id.button1);
        textMessage = (TextView) findViewById(R.id.text1);
        warningMessage = (TextView) findViewById(R.id.text2);
        resetButton = (Button) findViewById(R.id.resetButton);

        View.OnClickListener clickOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter = counter + 1;
                String totalCounter = Integer.toString(counter);

                if (counter == 1) {
                    textMessage.setText("The button got tapped " + totalCounter + " time.");
                    warningMessage.setText("(Don't tap too much!)");

                } else if (counter > 1 && counter < 4) {
                    textMessage.setText("The button got tapped " + totalCounter + " times.");

                } else if (counter >= 4 && counter < 10) {
                    textMessage.setText("It's not healthy, you've exceeded " + totalCounter + " taps! :|");

                } else if (counter >= 10) {
                    textMessage.setText("Seriously! (-_-)");
                    warningMessage.setText("Number of taps is " + totalCounter + " taps now.");

                }
            }
        };

        clickMeButton.setOnClickListener(clickOnClickListener);

        View.OnClickListener resetOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textMessage.setText("Taps-counter is reset. You tapped " + counter + " times.");
                counter = resetCounter;
                warningMessage.setText("(Tap again!)");
            }
        };

        resetButton.setOnClickListener(resetOnClickListener);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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
            Toast toastMessage = Toast.makeText(this, "The settings menu option got tapped! \n number of taps on button is " + counter + " taps.", Toast.LENGTH_LONG);
            toastMessage.show();

            Toast toastMessage1 = Toast.makeText(this, "Will Reset Now.", Toast.LENGTH_LONG);
            toastMessage1.show();

            counter = resetCounter;

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

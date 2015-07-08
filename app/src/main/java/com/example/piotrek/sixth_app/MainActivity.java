package com.example.piotrek.sixth_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    String msg = "Android : ";

    public final static String EXTRA_MESSAGE = "com.example.piotrek.third_app.poszlo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.piotrek.sixth_app.R.layout.activity_main);
        Log.d(msg, "The onCreate() event");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.piotrek.sixth_app.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.piotrek.sixth_app.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the send button */
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, Second_screen_activity.class);
        EditText editText = (EditText) findViewById(com.example.piotrek.sixth_app.R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);//message);
        startActivity(intent);
    }

    public void go_into_hideaway(View view)
    {
        Intent intent = new Intent(this, Hideaway.class);
        startActivity(intent);
    }
}

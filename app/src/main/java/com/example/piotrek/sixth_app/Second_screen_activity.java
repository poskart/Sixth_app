package com.example.piotrek.sixth_app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Second_screen_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(com.example.piotrek.sixth_app.R.layout.activity_second_screen_activity);

//        //Get the message form the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        LinearLayout lin_lay = (LinearLayout) findViewById(com.example.piotrek.sixth_app.R.id.sec_screen_lay);

        TextView dodany_tekst = new TextView(this);
        dodany_tekst.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        dodany_tekst.setText(message);
        dodany_tekst.setBackgroundColor(0x3910482c);
        dodany_tekst.setPadding(20, 20, 20, 20);
        lin_lay.addView(dodany_tekst);

        TextView inny = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.RIGHT;
        layoutParams.setMargins(10,10,10,10);
        inny.setLayoutParams(layoutParams);
        inny.setText("To jest inny string");
        inny.setTextSize(25);
        inny.setBackgroundColor(0x2849cba4);
        lin_lay.addView(inny);
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

    //Method to start the service
    public void startService(View view) {
        startService(new Intent(getBaseContext(), Second_screen_service.class));
    }

    //Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), Second_screen_service.class));
    }

}

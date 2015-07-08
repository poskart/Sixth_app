package com.example.piotrek.sixth_app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.piotrek.sixth_app.R;


public class Hideaway extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.piotrek.sixth_app.R.layout.activity_hideaway);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.piotrek.sixth_app.R.menu.menu_hideaway, menu);
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

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("jakis_nowy_intent");
        sendBroadcast(intent);
    }

    public void onClickAddName(View view){
        //Add a student record
        ContentValues values = new ContentValues();

        values.put(StudentsProvider.NAME, ((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(StudentsProvider.GRADE, ((EditText) findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view){
        //Retrieve students records
        String URL = "content://com.example.piotrek.provider.College/students";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if(c.moveToFirst()) {
            do {
                Toast.makeText(this, c.getString(c.getColumnIndex(StudentsProvider._ID)) + ", " +
                        c.getString(c.getColumnIndex(StudentsProvider.NAME)) + ", " + c.getString
                        (c.getColumnIndex(StudentsProvider.GRADE)), Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}

package com.richardlucasapps.testfragmenthide;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_layout, MainActivityFragment.newInstance(), "MAIN_FRAGMENT")
                .commit();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentByTag("MAIN_FRAGMENT");
                fragment.stopVideo();
                fragment.getView().setVisibility(View.GONE); // Setting the fragment root view to GONE does not fix the issue.

                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(fragment) // Hiding the fragment does not fix the issue.
                        .add(R.id.content_layout, NewFragment.newInstance())
                        .commit();
            }
        });
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

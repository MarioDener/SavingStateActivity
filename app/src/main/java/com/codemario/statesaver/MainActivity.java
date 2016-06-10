package com.codemario.statesaver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This part is about sotring persistent activity data
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        int defaultCounter = 0;
        mCounter = settings.getInt(KEY_COUNTER,defaultCounter);

    }

    static final String KEY_COUNTER = "COUNTER";
    static final String KEY_VALUE = "KEY_VALUE";
    private int mCounter = 0 ;
    private String valor;

    /***
     * Checking the value from editText
     * @param v
     */
    public void onClickCounter(View v){
        mCounter++;

        valor = ((TextView) findViewById(R.id.editText)).getText().toString();
        ((TextView)findViewById(R.id.textViewCounter)).setText("Counter"+ Integer.toString(mCounter));
        ((TextView)findViewById(R.id.textViewMessage)).setText(valor);
    }


    /***
     * Using onSaveInstanceStae method to save the activity's State
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER,mCounter);
        outState.putString(KEY_VALUE,valor);
    }

    /***
     * Using onRestoreInstanceState to getting the values
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter=savedInstanceState.getInt(KEY_COUNTER);
        valor = savedInstanceState.getString(KEY_VALUE);
    }

    // This part is about sotring persistent activity data

    /***
     *
     */
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(KEY_COUNTER,mCounter);
        editor.commit();

    }


}

package com.codemario.statesaver;

import android.content.Intent;
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
    }

    static final String KEY_COUNTER = "COUNTER";
    static final String KEY_VALUE = "KEY_VALUE";
    private int mCounter = 0 ;
    private String valor;

    public void onClickCounter(View v){
        mCounter++;

        valor = ((TextView) findViewById(R.id.editText)).getText().toString();
        ((TextView)findViewById(R.id.textViewCounter)).setText("Counter"+ Integer.toString(mCounter));
        ((TextView)findViewById(R.id.textViewMessage)).setText(valor);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER,mCounter);
        outState.putString(KEY_VALUE,valor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter=savedInstanceState.getInt(KEY_COUNTER);
        valor = savedInstanceState.getString(KEY_VALUE);
    }
}

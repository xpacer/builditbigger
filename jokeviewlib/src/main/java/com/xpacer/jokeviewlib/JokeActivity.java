package com.xpacer.jokeviewlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_INTENT_EXTRA = "joke_intent_extra";
    String passedJoke;
    TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        tvJoke = findViewById(R.id.tv_joke);
        if (getIntent() != null && getIntent().hasExtra(JOKE_INTENT_EXTRA)) {
            passedJoke = getIntent().getStringExtra(JOKE_INTENT_EXTRA);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (passedJoke != null) {
            tvJoke.setText(passedJoke);
        }

    }
}

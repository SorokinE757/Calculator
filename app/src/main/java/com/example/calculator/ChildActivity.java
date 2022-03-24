package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Style1;
    private Button Style2;
    int styleId;
    public static final String STYLE = "THEME_STYLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Style1 = findViewById(R.id.button_style1);
        Style2 = findViewById(R.id.button_style2);

        Style1.setOnClickListener(this);
        Style2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_style1:

                styleId = R.style.Theme_Calculator;
                Intent style1Intent = new Intent(this, MainActivity.class);
                style1Intent.putExtra(STYLE, styleId);

                startActivity(style1Intent);

                break;
            case R.id.button_style2:
                styleId = R.style.Theme_Calculator_TestStyle;
                Intent style2Intent = new Intent(this, MainActivity.class);
                style2Intent.putExtra(STYLE, styleId);

                startActivity(style2Intent);

                break;
        }

    }
}
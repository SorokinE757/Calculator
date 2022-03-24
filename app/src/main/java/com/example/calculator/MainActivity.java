package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SaveOnRotate saveOnRotate = new SaveOnRotate();
    private EditText screen;
    public static final String SAVE = "SAVE";
    static int themeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myIntent = getIntent();
        if (myIntent != null && myIntent.hasExtra(ChildActivity.STYLE)) {
            themeId = getIntent().getIntExtra(ChildActivity.STYLE, R.style.Theme_Calculator);
        }

        setTheme(themeId);

        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        screen = findViewById(R.id.textview_screen);
        initClickListener();

    }

    private void initClickListener() {

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonReset = findViewById(R.id.button_reset);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonReset.setOnClickListener(this);

    }


    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_0:
                screen.append("0");
                break;
            case R.id.button_1:
                screen.append("1");
                break;
            case R.id.button_2:
                screen.append("2");
                break;
            case R.id.button_3:
                screen.append("3");
                break;
            case R.id.button_4:
                screen.append("4");
                break;
            case R.id.button_5:
                screen.append("5");
                break;
            case R.id.button_6:
                screen.append("6");
                break;
            case R.id.button_7:
                screen.append("7");
                break;
            case R.id.button_8:
                screen.append("8");
                break;
            case R.id.button_9:
                screen.append("9");
                break;
            case R.id.button_multiply:
                if (screen.getText().length() != 0) {
                    saveOnRotate.setInput1(Float.parseFloat(screen.getText() + ""));
                    saveOnRotate.setMultiply(true);
                    screen.setText("");
                }
                break;
            case R.id.button_divide:
                if (screen.getText().length() != 0) {
                    saveOnRotate.setInput1(Float.parseFloat(screen.getText() + ""));
                    saveOnRotate.setDiv(true);
                    screen.setText("");
                }
            case R.id.button_plus:
                if (screen.getText().length() != 0) {
                    saveOnRotate.setInput1(Float.parseFloat(screen.getText() + ""));
                    saveOnRotate.setPlus(true);
                    screen.setText("");
                }
                break;
            case R.id.button_minus:
                if (screen.getText().length() != 0) {
                    saveOnRotate.setInput1(Float.parseFloat(screen.getText() + ""));
                    saveOnRotate.setMinus(true);
                    screen.setText("");
                }
                break;

            case R.id.button_reset:
                screen.setText("");
                saveOnRotate.setInput1(0);
                saveOnRotate.setInput2(0);
                break;

            case R.id.button_equals:
                if (saveOnRotate.isPlus() || saveOnRotate.isMinus() || saveOnRotate.isMultiply() || saveOnRotate.isDiv()) {
                    saveOnRotate.setInput2(Float.parseFloat(screen.getText() + ""));
                }

                if (saveOnRotate.isPlus()) {
                    screen.setText(saveOnRotate.getInput1() + saveOnRotate.getInput2() + "");
                    saveOnRotate.setPlus(false);
                }
                if (saveOnRotate.isMinus()) {
                    screen.setText(saveOnRotate.getInput1() - saveOnRotate.getInput2() + "");
                    saveOnRotate.setMinus(false);
                }
                if (saveOnRotate.isMultiply()) {
                    screen.setText(saveOnRotate.getInput1() * saveOnRotate.getInput2() + "");
                    saveOnRotate.setMultiply(false);
                }
                if (saveOnRotate.isDiv()) {
                    if (saveOnRotate.getInput2() == 0) {
                        Toast.makeText(getApplicationContext(), "На ноль делить нельзя", Toast.LENGTH_SHORT).show();
                        screen.setText("");
                    } else {
                        screen.setText(saveOnRotate.getInput1() / saveOnRotate.getInput2() + "");
                    }
                    saveOnRotate.setDiv(false);
                }
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVE, saveOnRotate);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        saveOnRotate = savedInstanceState.getParcelable(SAVE);
    }
}

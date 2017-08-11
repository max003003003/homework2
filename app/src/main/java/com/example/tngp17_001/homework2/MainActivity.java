package com.example.tngp17_001.homework2;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOperator, tvNumber;
    Button btnOne, btnThree, btnFive, btnSeven, btnNine, btnEleven, btnPlus, btnMinus, btnClear;
    int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InnitialInstance();
    }

    private void InnitialInstance() {
        total = 0;
        tvOperator = (TextView) findViewById(R.id.tvOperator);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(this);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);
        btnEleven = (Button) findViewById(R.id.btnEleven);
        btnEleven.setOnClickListener(this);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnOne:
                operate(btnOne);
                break;
            case R.id.btnThree:
                operate(btnThree);
                break;
            case R.id.btnFive:
                operate(btnFive);
                break;
            case R.id.btnSeven:
                operate(btnSeven);
                break;
            case R.id.btnNine:
                operate(btnNine);
                break;
            case R.id.btnEleven:
                operate(btnEleven);
                break;
            case R.id.btnPlus:
                operate(btnPlus);
                break;
            case R.id.btnMinus:
                operate(btnMinus);
                break;
            case R.id.btnClear:
                operate(btnClear);
                break;

        }
    }

    private String sum(int value) {
        int result = this.total += value;
        return result + "";
    }

    private String minus(int value) {
        int result = this.total -= value;
        return this.total - value < 0 ? "0" : result + "";
    }

    private void clear() {
        tvOperator.setText("");
        tvNumber.setText("");
        this.total = 0;
    }

    private void setTvopertor(String sign) {
        tvOperator.setText(sign);
    }

    private String getTvoperator() {
        return tvOperator.getText().toString();
    }



    private void operate(Button button) {
        int number = 0;
        if (button == btnPlus) {
            setTvopertor("+");
        } else if (button == btnMinus) {
            setTvopertor("-");
        } else if (button == btnClear) {
            clear();
        } else if (!getTvoperator().isEmpty()) {
            number = Integer.parseInt(button.getTag().toString());
            if (getTvoperator().equals("+")) {
                tvNumber.setText(sum(number));
            } else if (getTvoperator().equals("-")) {
                tvNumber.setText(minus(number));
            }
        } else return;
    }

}

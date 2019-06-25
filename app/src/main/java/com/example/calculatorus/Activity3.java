package com.example.calculatorus;

import android.content.Intent;
import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView typing, result;
    private Button add, subtract, divide, multiple, sum, clear, dot,
            zero, one, two, three, four, five, six, seven, eight, nine;
    private final char ADDITION = '+', SUBTRACTION = '-', MULTIPLICATION = '*', DIVISION = '/', EQU = 0;
    private double num1 = Double.NaN, num2;
    private char action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        setupUIViews();
        onClickList();
        mathematicalOps();
    }

    private void mathematicalOps(){

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = ADDITION;
                result.setText(num1 + "+");
                typing.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = SUBTRACTION;
                result.setText(num1 + "-");
                typing.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = DIVISION;
                result.setText(num1 + "/");
                typing.setText(null);
            }
        });
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = MULTIPLICATION;
                result.setText(num1 + "*");
                typing.setText(null);
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = EQU;
                result.setText(result.getText().toString() + num2 + "=" + num1);
                typing.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typing.getText().length()>0){
                    CharSequence name = typing.getText().toString();
                    typing.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    num1 = Double.NaN;
                    num2 = Double.NaN;
                    typing.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void onClickList(){
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+".");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typing.setText(typing.getText().toString()+"9");
            }
        });
    }
    private void compute(){
        if(!Double.isNaN(num1)){
            num2 = Double.parseDouble(typing.getText().toString());

            switch (action){
                case ADDITION:
                    num1 = num1 + num2;
                    break;
                case SUBTRACTION:
                    num1 = num1 - num2;
                    break;
                case DIVISION:
                    num1 = num1 / num2;
                    break;
                case MULTIPLICATION:
                    num1 = num1 * num2;
                    break;
                case EQU:
                    break;
            }
        }
        else{
            num1 = Double.parseDouble(typing.getText().toString());
        }
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.binary:
                if (checked){
                    openBinary();
                }
                break;
            case R.id.hexadecimal:
                if (checked)
                openHexadecimal();
                break;
        }
    }

    private void openBinary(){
        Intent intent = new Intent(this, binary.class);
        startActivity(intent);
    }

    private void openHexadecimal(){
        Intent intent = new Intent(this, Hexadecimal.class);
        startActivity(intent);
    }

    private void setupUIViews(){
        result = (TextView)findViewById(R.id.result);
        typing = (TextView)findViewById(R.id.typing);

        add = (Button)findViewById(R.id.add);
        subtract = (Button)findViewById(R.id.subtract);
        divide = (Button)findViewById(R.id.divide);
        multiple = (Button)findViewById(R.id.multiple);
        sum = (Button)findViewById(R.id.sum);
        clear = (Button)findViewById(R.id.clear);
        dot = (Button)findViewById(R.id.dot);
        zero = (Button)findViewById(R.id.zero);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
    }
}

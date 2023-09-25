package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void addClick(View view){
        int type = 1;
        goToActivity(type);
    }

    public void subtractClick(View view){
        int type = 2;
        goToActivity(type);
    }

    public void multiplyClick(View view){
        int type = 3;
        goToActivity(type);
    }

    public void divideClick(View view){
        int type = 4;
        goToActivity(type);
    }

    public void goToActivity(int type){

        EditText param1 = (EditText) findViewById(R.id.editTextNumber); //Gets text object by ID.
        EditText param2 = (EditText) findViewById(R.id.editTextNumber2); //Gets text object by ID.

        int x = 0;
        int y = 0;

        try {

            x = Integer.parseInt(param1.getText().toString()); //First operand.
            y = Integer.parseInt(param2.getText().toString()); //Second operand.

        } catch (Exception e) {

            Intent intent = new Intent(this, calcResult.class);
            intent.putExtra("message", "You can only input integers!");
            startActivity(intent);
            return;
        }

        double z = 0; //Result
        String finalResult = "Something went Wrong";
        boolean goAhead = true;

        //Add
        if(type == 1){
            z = x + y;
            finalResult = "Those numbers added is " + String.valueOf(z);
        }

        //Subtract
        if(type == 2) {
            z = x - y;
            finalResult = "Those numbers subtracted is " + String.valueOf(z);
        }

        //Multiply
        if(type == 3) {
            z = x * y;
            finalResult = "Those numbers multiplied is " + String.valueOf(z);
        }

        //Divide
        if(type == 4) {
            if(y == 0) {
                finalResult = "Error: You cannot divide by 0.";
                goAhead = false;
            }

            if(goAhead) {
                z = (x / y);
                finalResult = "Those numbers divided is " + String.valueOf(z);
            }
        }

        Intent intent = new Intent(this, calcResult.class);
        intent.putExtra("message", finalResult);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
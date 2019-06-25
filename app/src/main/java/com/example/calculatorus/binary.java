package com.example.calculatorus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class binary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.hexadecimal:
                if (checked){
                    openHexadecimal();
                }
                break;
            case R.id.decimal:
                if (checked)
                    openDecimal();
                break;
        }
    }
    private void openHexadecimal(){
        Intent intent = new Intent(this, Hexadecimal.class);
        startActivity(intent);
    }

    private void openDecimal(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}

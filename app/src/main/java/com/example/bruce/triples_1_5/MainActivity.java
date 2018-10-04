package com.example.bruce.triples_1_5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mLevel;
    private String mSelectedButton = "Newbie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenToButtons();
    }

    private void listenToButtons() {
        Button begin = findViewById(R.id.button_begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLevel >= 1 && mLevel <= 5) {
                    showToast();
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    intent.putExtra("Level", mLevel);
                    startActivity(intent);
                }
            }
        });
    }

    protected void radioButtonClick(View view){
        RadioGroup rg = findViewById(R.id.radioGroup);
        int radioButtonID = rg.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonID);
        mSelectedButton = (String) radioButton.getText();
        if(mSelectedButton.equals("Newbie")) mLevel = 1;
        if(mSelectedButton.equals("Beginner")) mLevel = 2;
        if(mSelectedButton.equals("Seasoned")) mLevel = 3;
        if(mSelectedButton.equals("Experienced")) mLevel = 4;
        if(mSelectedButton.equals("Expert")) mLevel = 5;
    }

    private void showToast(){
        String toast = "Starting " + mSelectedButton + " Level";
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }
}

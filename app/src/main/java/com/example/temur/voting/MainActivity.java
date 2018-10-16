package com.example.temur.voting;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    private Spinner drinkSpinner;
    private Spinner foodSpinner;
    private EditText firstname;
    private EditText lastname;
    private EditText vote;
    private Button voteButton;
    private RadioButton agreeRadio;
    private RadioButton disagreeRadio;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSpinner();

        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.agree_radio:
                        String food, drink;
                        drink = drinkSpinner.getSelectedItem().toString();
                        food = foodSpinner.getSelectedItem().toString();
                        vote.append("-> "+firstname.getText().toString()+" " + lastname.getText().toString()
                                +" will come to the party and wants "+drink+" and "+food+"\n\n");

                        break;
                    case R.id.disagree_radio:
                        vote.append("-> "+firstname.getText().toString()+ " " + lastname.getText().toString()
                                + " will not come to the party\n\n");
                        break;
                }
            }
        });
    }




    public void init(){
        drinkSpinner = (Spinner) findViewById(R.id.drink);
        foodSpinner = (Spinner) findViewById(R.id.food);

        firstname = (EditText)findViewById(R.id.firstname_EditText);
        lastname = (EditText)findViewById(R.id.lastname_EditText);
        vote = (EditText)findViewById(R.id.vote_text);
        voteButton = (Button)findViewById(R.id.vote_button);

        agreeRadio = (RadioButton) findViewById(R.id.agree_radio);
        disagreeRadio = (RadioButton) findViewById(R.id.disagree_radio);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void setSpinner(){
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.drink_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinkSpinner.setAdapter(adapter1);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.food_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpinner.setAdapter(adapter);
    }
}

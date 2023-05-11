package com.example.norman_lee.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class SubActivity extends AppCompatActivity {

    Button buttonBackToCalculator;
    EditText editTextSubValueOfA;
    EditText editTextSubValueOfB;
    public final static String INTENT_EXCH_RATE = "Exchange Rate";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.subsharedprefs";
    public final static String A_KEY = "A_KEY";
    public final static String B_KEY = "B_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        //4.9 Implement saving to shared preferences for the contents of the EditText widget
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String fetchA = mPreferences.getString(A_KEY, "null");
        String fetchB = mPreferences.getString(B_KEY, "null");

        //3.5 Get references to the editText widgets
        editTextSubValueOfA = findViewById(R.id.editTextSubValueA);
        if (!fetchA.equals("null")) { editTextSubValueOfA.setText(fetchA); }
        editTextSubValueOfB = findViewById(R.id.editTextSubValueB);
        if (!fetchB.equals("null")) { editTextSubValueOfB.setText(fetchB); }

        //3.6 Get a reference to the Back To Calculator Button
        buttonBackToCalculator = findViewById(R.id.buttonBackToCalculator);

        //3.7 Set up setOnClickListener
        buttonBackToCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3.8 Obtain the values stored in the editTextWidgets
                String textA = editTextSubValueOfA.getText().toString();
                String textB = editTextSubValueOfB.getText().toString();

                //3.9 Check that these values are valid --> See the Utils class
                try {
                    Utils.checkInvalidInputs(textA, true);
                    Utils.checkInvalidInputs(textB, false);
                    double valueA = Double.parseDouble(textA);
                    double valueB = Double.parseDouble(textB);

                    //3.10 Set up an explicit intent and pass the exchange rate back to MainActivity
                    Intent intent = new Intent(SubActivity.this, MainActivity.class);
                    intent.putExtra(A_KEY, valueA);
                    intent.putExtra(B_KEY, valueB);
                    startActivity(intent);
                }
                catch (NumberFormatException e1) {
                    //3.12 Decide how you are going to handle a situation when the editText widgets are empty
                    Toast.makeText(SubActivity.this, R.string.nfe, Toast.LENGTH_LONG).show();
                }
                catch (IllegalArgumentException e2) {
                    //3.11 Decide how you are going to handle a divide-by-zero situation or when negative numbers are entered
                    Toast.makeText(SubActivity.this, R.string.iae, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //4.10 Don't forget to override onPause()
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(A_KEY, editTextSubValueOfA.getText().toString());
        preferencesEditor.putString(B_KEY, editTextSubValueOfB.getText().toString());
        preferencesEditor.apply();
    }

}

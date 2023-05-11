package com.example.norman_lee.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    Button buttonConvert;
    Button buttonSetExchangeRate;
    EditText editTextValue;
    TextView textViewResult;
    TextView textViewExchangeRate;
    double exchangeRate;
    public final String TAG = "Logcat";
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.mainsharedprefs";
    public static final String RATE_KEY = "Rate_Key";
    ExchangeRate exRate;
    Boolean exRateCreated;
    public static final String TEXT_KEY = "Text_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //4.5 Get a reference to the sharedPreferences object
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        //4.6 Retrieve the value using the key, and set a default when there is none
        String rateText = mPreferences.getString(RATE_KEY, "null");
        exRateCreated = false;
        if (!rateText.equals("null")) {
            exRate = new ExchangeRate(rateText);
            exRateCreated = true;
            Log.i(TAG, "call1");
        }
        String inputText = mPreferences.getString(TEXT_KEY, "null");

        //3.13 Get the intent, retrieve the values passed to it, and instantiate the ExchangeRate class
        Intent subIntent = getIntent();
        double home = subIntent.getDoubleExtra(SubActivity.A_KEY, 0.0);
        double foreign = subIntent.getDoubleExtra(SubActivity.B_KEY, 0.0);
         if (foreign != 0.0f) {
            exRate = new ExchangeRate(String.valueOf(home), String.valueOf(foreign));
            Log.i(TAG, "call2");
        } else if (!exRateCreated) {
            exRate = new ExchangeRate();
            Log.i(TAG, "call3");
        }
        //3.13a See ExchangeRate class --->

        //2.1 Use findViewById to get references to the widgets in the layout
        editTextValue = findViewById(R.id.editTextValue);
        if (!inputText.equals("null")) { editTextValue.setText(inputText); }
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewExchangeRate = findViewById(R.id.textViewExchangeRate);
        textViewResult = findViewById(R.id.textViewResult);

        //2.2 Assign a default exchange rate of 2.95 to the textView
        exchangeRate = exRate.getExchangeRate().doubleValue();
        textViewExchangeRate.setText(String.valueOf(exchangeRate));

        //2.3 Set up setOnClickListener for the Convert Button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextValue.getText().toString();
                //2.5 If not, calculate the units of B with the exchange rate and display it
                try {
                    BigDecimal result = exRate.calculateAmount(text);
                    textViewResult.setText(result.toString());
                }
                //2.4 Display a Toast & Logcat message if the editTextValue widget contains an empty string
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, R.string.nfe, Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Empty string");
                }
                //2.5a See ExchangeRate class --->
            }
        });

        //3.1 Modify the Android Manifest to specify that the parent of SubActivity is MainActivity
        //3.2 Get a reference to the Set Exchange Rate Button
        buttonSetExchangeRate = findViewById(R.id.buttonSetExchangeRate);

        //3.3 Set up setOnClickListener for this
        buttonSetExchangeRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3.4 Write an Explicit Intent to get to SubActivity
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //4.1 Go to res/menu/menu_main.xml and add a menu item Set Exchange Rate
    //4.2 In onOptionsItemSelected, add a new if-statement and code accordingly

    //5.1 Go to res/menu/menu_main.xml and add a menu item Open Map App
    //5.2 In onOptionsItemSelected, add a new if-statement
    //5.3 code the Uri object and set up the intent

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.set_exchange_rate) {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.map) {
            String location = getString(R.string.default_location);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("geo").opaquePart("0.0").appendQueryParameter("q", location);
            Uri geolocation = builder.build();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geolocation);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //4.3 override the methods in the Android Activity Lifecycle here
    //4.4 for each of them, write a suitable string to display in the Logcat
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activity started.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity resumed.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity paused.");

        //4.7 In onPause, get a reference to the SharedPreferences.Editor object
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();

        //4.8 store the exchange rate using the putString method with a key
        preferencesEditor.putString(RATE_KEY, String.valueOf(exchangeRate));
        preferencesEditor.putString(TEXT_KEY, editTextValue.getText().toString());
        preferencesEditor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Activity stopped.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity destroyed.");
    }

}

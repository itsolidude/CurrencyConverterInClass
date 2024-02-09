package com.college.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
import com.college.converter.databinding.ActivityMainBinding; // Import generated binding class

/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Declare a binding variable
    static private final Float CONVERSION_RATE = 0.80F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inflate the binding
        setContentView(binding.getRoot()); // Set content view to the root of the binding

        // Add log message to indicate the start of the onCreate method
        Log.i("MainActivity", "onCreate method started");

        Button buttonConvert = findViewById(R.id.convertButton);

//        Button buttonConvert = findViewById(R.id.convertButton); // don't need findViewById anymore

        binding.convertButton.setOnClickListener( view ->  {
            convertCurrency(view);
        } );
    }

    public void convertCurrency(View view) {
        // Add log message to indicate the start of the convertCurrency method
        Log.i("MainActivity", "convertCurrency method started");

//        EditText inputView = findViewById(R.id.entryId); // no need of findViewById

        String inputAmount = binding.entryId.getText().toString(); // Use binding to access views

//        TextView resultView = findViewById(R.id.resultId); // no need of findViewById

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);

            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;

            binding.resultId.setText( resultFloat + " Euros" ); // Use binding to set text
        }
        // Add log message to indicate the end of the convertCurrency method
        Log.i("MainActivity", "convertCurrency method finished");
    }
}
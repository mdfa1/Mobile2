package com.example.mealrater;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText dishEditText, restaurantEditText;
    TextView ratingTextView;
    Button rateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dishEditText = findViewById(R.id.editTextText);
        restaurantEditText = findViewById(R.id.editTextText2);
        ratingTextView = findViewById(R.id.textView5);
        rateButton = findViewById(R.id.button);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build dialog for rating the meal
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Rate the Meal");
                final String[] ratings = {"1", "2", "3", "4", "5"};
                builder.setSingleChoiceItems(ratings, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Set the rating in the TextView
                        ratingTextView.setText(ratings[which]);
                        dialog.dismiss(); // Dismiss the dialog
                    }
                });
                builder.show(); // Show the dialog
            }
        });
    }
}

package io.github.algtan.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // Create a constant for the LOG_TAG variable
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    // Create a key for the Intent extra to return information to MainActivity
    public static final String EXTRA_REPLY = "io.github.algtan.twoactivities.extra.REPLY";

    // Create an EditText variable to hold the EditText information (information to be gathered later)
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Log the start of the onCreate() method
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // Link the EditText variable to the reference item in the XML file
        mReply = findViewById(R.id.editText_second);

        // Get the Intent that activated this Activity
        Intent intent = getIntent();

        // Get the String containing the message (pair) from the Intent extras using the MainActivity.EXTRA_MESSAGE static variable as a key
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create a TextView variable to reference the TextView from the XML layout
        TextView textView = findViewById(R.id.text_message);

        // Set the text of the TextView to the string from the Intent extra
        textView.setText(message);
    }

    // Create an override for the onStart() callback to create log items
    @Override
    public void onStart() {
        // Run the superclass' onStart() callback
        super.onStart();
        // Add log item to note when onStart is working
        Log.d(LOG_TAG, "onStart");
    }

    // Create an override for the onPause() callback to create log items
    @Override
    public void onPause() {
        // Run the superclass' onPause() callback
        super.onPause();
        // Add log item to note when onStart is working
        Log.d(LOG_TAG, "onPause");
    }

    // Create an override for the onRestart() callback to create log items
    @Override
    public void onRestart() {
        // Run the superclass' onRestart() callback
        super.onRestart();
        // Add log item to note when onStart is working
        Log.d(LOG_TAG, "onRestart");
    }

    // Create an override for the onResume() callback to create log items
    @Override
    public void onResume() {
        // Run the superclass' onResume() callback
        super.onResume();
        // Add log item to note when onStart is working
        Log.d(LOG_TAG, "onResume");
    }

    // Create an override for the onStop() callback to create log items
    @Override
    public void onStop() {
        // Run the superclass' onStop() callback
        super.onStop();
        // Add log item to note when onStart is working
        Log.d(LOG_TAG, "onStop");
    }

    // Create an override for the onDestroy() callback to create log items
    @Override
    public void onDestroy() {
        // Run the superclass' onDestroy() callback
        super.onDestroy();
        // Add log item to note when onStart is working
        Log.d(LOG_TAG, "onDestroy");
    }

    // Method when the 'Reply' button is pressed
    public void returnReply(View view) {
        // Get the text of the EditText 'mReply' as a string
        String reply = mReply.getText().toString();

        // Create a new Intent object that will pass the reply back to the MainActivity
        Intent replyIntent = new Intent();

        // Add the reply string from the EditText to the new intent as an extra using 'EXTRA_REPLY' as the key
        replyIntent.putExtra(EXTRA_REPLY, reply);

        // Set the result to 'RESULT_OK' to indicate that the response was successful
        setResult(RESULT_OK, replyIntent);

        // Log statement to keep track of when SecondActivity is finished
        Log.d(LOG_TAG, "End SecondActivity");

        // Close this Activity (SecondActivity) and return to MainActivity
        finish();
    }
}
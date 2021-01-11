package io.github.algtan.twoactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Create a public constant to define the key for the response you're interested in
    public static final int TEXT_REQUEST = 1;

    // Create private variables to hold the reply header and reply TextView elements
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    // Create a log tag with the activity (MainActivity) name
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Create an EditText variable for the MainActivity class
    private EditText mMessagedEditText;

    // Create the key (EXTRA_MESSAGE) for the Intent extras key/value pair
    public static final String EXTRA_MESSAGE = "io.github.algtan.twoactivities.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // Get the reference to EditText in the XML file and assign it to the EditText mMessageEditText
        mMessagedEditText = findViewById(R.id.editText_main);

        // Get references from the layout to the reply header and reply TextView elements
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        // Test to see if the savedInstanceState exists
        if (savedInstanceState != null) {
            // If an existing state exists, store the information about the visibility of the TextView items
            boolean isVisible =  savedInstanceState.getBoolean("reply_visible");

            // If the isVisible variable is true (1)
            if (isVisible) {
                // Restore the visibility state of the reply header (text_header_reply) TextView
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                // Set the reply from SecondActivity and show it in the reply message (text_message_reply) TextView item
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                // Make this TextView visible
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
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

    // Override the onSaveInstanceState method()
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Check if the header is currently visible, and if so put the visibility state into the state Bundle
        // Otherwise, the visibility states of the TextView items will disappear when the Activity is destroyed (e.g. screen is rotated)
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            // Key/value pair of the boolean 'reply_visible' and its value
            outState.putBoolean("reply_visible", true);
            // Key/value pair of the string 'reply_text' and its value
            outState.putString("reply_text", mReplyTextView.getText().toString());
        }
    }

    public void launchSecondActivity(View view) {
        // Create a log item that checks if the button (Send) is clicked
        Log.d(LOG_TAG, "Button clicked!");

        // Create a new Intent with the arguments of an application Context (MainActivity) and the specific component that will receive that Intent (SecondActivity)
        Intent intent = new Intent(this, SecondActivity.class);

        // Get the text from the EditText and convert it to a String 'message'
        String message = mMessagedEditText.getText().toString();

        // Add the String to the intent as an Extra pair with the key 'EXTRA_MESSAGE'
        intent.putExtra(EXTRA_MESSAGE, message);

        // Start the new activity hoping to get the result 'TEXT_REQUEST' with the parameters in 'intent'
        startActivityForResult(intent, TEXT_REQUEST);
    }

    // Override the onActivityResult() callback method
    @Override
    // requestCode is set when the Activity was launched to help identify the Activity
    // resultCode is set in the launched Activity (SecondActivity) with either RESULT_OK or RESULT_CANCELED
    // Intent data contains the data returned from the launch Activity (SecondActivity)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Run the Superclass method for onActivityResult()
        super.onActivityResult(requestCode, resultCode, data);

        // Clear EditText
        mMessagedEditText.getText().clear();

        // Test for 'TEXT_REQUEST to make sure we process the right Intent result (Check if the request came from MainActivity, which is 'TEXT_REQUEST')
        if (requestCode == TEXT_REQUEST) {
            // Test for 'RESULT_OK' to make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the Intent extra from the response Intent (data) using the key 'EXTRA_REPLY' from SecondActivity
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                // Set the visibility of the reply header to true
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                // Set the reply TextView text to what was in the reply in SecondActivity, and set the TextView visibility to true
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }
}
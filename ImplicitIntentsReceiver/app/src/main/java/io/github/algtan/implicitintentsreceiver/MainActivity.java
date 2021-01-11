package io.github.algtan.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the incoming Intent that was used to activate the Activity
        Intent intent = getIntent();
        // Get the Intent data. Intent data is always a URI object
        Uri uri = intent.getData();
        // Check to make sure the 'uri' variable is not null. If that check passes, create a string from that URI object
        if (uri != null) {
            String uri_string = getString(R.string.uri_label) + uri.toString();
            // Get the TextView for the message
            TextView textView = findViewById(R.id.text_uri_message);
            // Set the text of that TextView to the URI
            textView.setText(uri_string);
        }
    }
}
package io.github.algtan.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Create a variable to hold the EditText object for the website URI
    private EditText mWebsiteEditText;
    // Create a variable to hold the EditText object for the location URI
    private EditText mLocationEditText;
    // Create a variable to hold the EditText object for the string
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference the EditText variable in MainActivity to the EditText object in the XML Layout
        mWebsiteEditText = findViewById(R.id.website_edittext);
        // Reference the EditText variable in MainActivity to the EditText object in the XML Layout
        mLocationEditText = findViewById(R.id.location_edittext);
        // Reference the EditText variable in MainActivity to the EditText object in the XML Layout
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    // Click handler for the "Open Website" button (in other words, this action takes place when the "Open Website" button is clicked)
    public void openWebsite(View view) {
        // Get the string value of the website EditText object
        String url = mWebsiteEditText.getText().toString();

        // Encode and parse the string into a URI object
        Uri webpage = Uri.parse(url);
        // Create a new Intent with Intent.ACTION_VIEW as the action and the URI as the data
        // ACTION_VIEW is used to view the given data, and we want to display the web page specified in the URI in the 'webpage' variable
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an Activity that can handle the implicit Intent and start that activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    // Click handler for the "Open Location" button
    public void openLocation(View view) {
        // Get the string value of the location EditText object
        String loc = mLocationEditText.getText().toString();

        // Parse that string into a URI object with a geo search query
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        // Create a new Intent with Intent.ACTION_VIEW as the action and 'loc' as the data
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an Activity that can handle the implicit Intent and start that activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void shareText(View view) {
        // Get the string value of the text EditText object
        String txt = mShareTextEditText.getText().toString();
        // Define the MIME type of the text to share
        String mimeType = "text/plain";
        // Call ShareCompat.IntentBuilder
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
    }
}
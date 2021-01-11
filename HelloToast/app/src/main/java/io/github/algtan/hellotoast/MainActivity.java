package io.github.algtan.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// Create a 'MainActivity' class that extends the class 'AppCompatActivity'
// 'AppCompatActivity' class allows backwards compatibility with older versions of Android
public class MainActivity extends AppCompatActivity {

    // Create a parameter mCount for the MainActivity class to hold the number of counts
    private int mCount = 0;
    // Create a TextView object named 'mShowCount' that displays the counts
    private TextView mShowCount;

    @Override
    // onCreate() method is used to inflate the layout, which means to set the content view of the screen to the XML layout
    protected void onCreate(Bundle savedInstanceState) {
        // Abstraction of Android code that initializes prior to running the rest of this app
        // MainActivity inherits AppCompatActivity, but we are overriding onCreate
        // AppCompatActivity is therefore the super class, and we want to use the super class' existing functionality to initialize this app
        super.onCreate(savedInstanceState);
        // Points to the XML file with the layout information
        setContentView(R.layout.activity_main);
        // Correlate the TextView parameter 'mShowCount' to the TextView in 'activity_main.xml'
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    // Action that takes place when the 'Toast' button is pressed
    public void showToast(View view) {
        // Initialize an object named 'toast' using the 'Toast' class
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);

        // Use the method 'show()' under the 'Toast' class to show a message
        toast.show();
    }

    // Action that takes place when the 'Count' button is pressed
    public void countUp(View view) {
        // Increment the number of counts when pressed
        mCount++;
        // If the TextView object isn't null, update the TextView object 'mShowCount' to a string containing the number of counts
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}
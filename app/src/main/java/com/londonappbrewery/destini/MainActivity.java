package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    protected Button mAnswer1;
    protected Button mAnswer2;
    protected TextView mStoryText;
    protected int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mAnswer1 = (Button) findViewById(R.id.buttonTop);
        mAnswer2 = (Button) findViewById(R.id.buttonBottom);
        mStoryText = (TextView) findViewById(R.id.storyTextView);
        mStoryIndex = 1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"TEKST1",Toast.LENGTH_SHORT).show();
                Log.d("TAG2","TAG2");
                nextStory(true);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"TEKST2",Toast.LENGTH_SHORT).show();
                Log.d("TAG1","MSG1");
                nextStory(false);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        mStoryIndex = 1;

    }

    private void nextStory(boolean topButton) {
        if (topButton == true && mStoryIndex == 1) {
            mStoryIndex = 3;
            mAnswer1.setText(R.string.T3_Ans1);
            mAnswer2.setText(R.string.T3_Ans2);
            mStoryText.setText(R.string.T3_Story);

        } else if(topButton == true && mStoryIndex == 2) {
            mStoryIndex = 3;
            mAnswer1.setText(R.string.T3_Ans1);
            mAnswer2.setText(R.string.T3_Ans2);
            mStoryText.setText(R.string.T3_Story);
        } else if (topButton == true && mStoryIndex == 3 ) {
            mStoryIndex = 6;
            setAnswersToInvisible();
            mStoryText.setText(R.string.T6_End);

        } else if (topButton == false && mStoryIndex == 1 ) {
            //Toast.makeText(getApplicationContext(),"topButton = false i mStoryIndex = 1",Toast.LENGTH_SHORT).show();
            mStoryIndex = 2;
            mAnswer1.setText(R.string.T2_Ans1);
            mAnswer2.setText(R.string.T2_Ans2);
            mStoryText.setText(R.string.T2_Story);
        } else if (topButton == false && mStoryIndex == 2 ) {
            mStoryIndex = 4;
            setAnswersToInvisible();
            mStoryText.setText(R.string.T4_End);
        } else if (topButton == false && mStoryIndex == 3 ) {
            mStoryIndex = 5;
            setAnswersToInvisible();
            mStoryText.setText(R.string.T5_End);
        }
    }

    private void setAnswersToInvisible() {
        mAnswer1.setVisibility(View.INVISIBLE);
        mAnswer2.setVisibility(View.INVISIBLE);
    }
}

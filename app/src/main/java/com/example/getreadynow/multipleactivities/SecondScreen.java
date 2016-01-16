package com.example.getreadynow.multipleactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AlHassaneAgne on 1/16/16.
 */
public class SecondScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Use layout_number2 for this activity
        setContentView(R.layout.layout_number2);

        //Get the intent from the calling activity
        Intent activityThatCalled = getIntent ();

        //Get the name saved  in the intent (context) from the calling activity
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        //Retrieve the calling activity textbox
        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_text_view);

        //Append the name to the textbox
        callingActivityMessage.append(" " + previousActivity);
    }


    public void onSendUsersName(View view) {

        //Read the users name from the edit text

        EditText usersNameEntry = (EditText) findViewById(R.id.users_name_edit_text);

        //Get the name typed into the edit box
        String usersName =  String.valueOf(usersNameEntry.getText());

        //We are going back to the main activity
        //define the intent
        Intent backToMain = new Intent();

        //Save the user name into the context
        backToMain.putExtra("usersName", usersName);

        //Set the result to OK
        setResult(RESULT_OK, backToMain);

        finish();

    }

}

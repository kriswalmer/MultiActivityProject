package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ActivityC extends Activity {
    Button openActivityButton;
    Button openActivityButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_c);

        openActivityButton = (Button) findViewById(R.id.button1);
        View.OnClickListener oc1 = new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityA.class);

                String dataString = "String data from Activity A";

                launchActivityIntent.putExtra(KeyStringHelper.DATA_FROM_C_TO_A_KEY, dataString);

                //  Launch the activity using the created intent. Fire and Forget method.
                startActivity(launchActivityIntent);
            }
        };

        openActivityButton.setOnClickListener(oc1);


        openActivityButton2 = (Button) findViewById(R.id.button2);
        View.OnClickListener oc2 = new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityB.class);

                String dataString = "String data from Activity A";

                launchActivityIntent.putExtra(KeyStringHelper.DATA_FROM_C_TO_B_KEY, dataString);

                //  Launch the activity using the created intent. Fire and Forget method.
                startActivity(launchActivityIntent);
            }
        };

        openActivityButton2.setOnClickListener(oc2);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_c, menu);
        return true;
    }

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

        return super.onOptionsItemSelected(item);
    }
}

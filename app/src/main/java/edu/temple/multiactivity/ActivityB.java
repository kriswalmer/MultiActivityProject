package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityB extends Activity {

    Button openActivityButton;
    Button openActivityButton2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);

        tv = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();

        String dataString = intent.getStringExtra("data_from_A_to_B");



        dataString = intent.getStringExtra("data_from_C_to_B");


        tv.setText(" " + dataString );




      // String MessageFromA = getIntent().getExtras().getString().

        openActivityButton = (Button) findViewById(R.id.button1);
        View.OnClickListener oc1 = new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent launchActivityIntent = new Intent(ActivityB.this, ActivityA.class);

                String dataString = "String data from Activity A";

                launchActivityIntent.putExtra(KeyStringHelper.DATA_FROM_B_TO_A_KEY, dataString);

                //  Launch the activity using the created intent. Fire and Forget method.
                startActivity(launchActivityIntent);
            }
        };

        openActivityButton.setOnClickListener(oc1);


        openActivityButton2 = (Button) findViewById(R.id.button2);
        View.OnClickListener oc2 = new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent launchActivityIntent = new Intent(ActivityB.this, ActivityC.class);

                String dataString = "String data from Activity A";

                launchActivityIntent.putExtra(KeyStringHelper.DATA_FROM_B_TO_C_KEY, dataString);

                //  Launch the activity using the created intent. Fire and Forget method.
                startActivity(launchActivityIntent);
            }
        };

        openActivityButton2.setOnClickListener(oc2);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_b, menu);
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

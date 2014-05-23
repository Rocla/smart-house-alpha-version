package ch.he.arc.romain.claret.p1.g5.alpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;



public class MainActivity extends Activity {




    Button bLogin;
    TextView dStatus, dUsername, dPassword;
    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent testIntent = new Intent (MainActivity.this, Home.class);
        startActivity(testIntent);

        setContentView(R.layout.activity_main);


        bLogin = (Button) findViewById(R.id.bLogin);
        dStatus = (TextView) findViewById(R.id.dStatus);
        dUsername = (TextView) findViewById(R.id.dUsername);
        dPassword = (TextView) findViewById(R.id.dPassword);
        mProgress = (ProgressBar) findViewById(R.id.progressBarLogin);

        mProgress.setVisibility(View.INVISIBLE);


        bLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                //SystemClock.sleep(2000);
                String sUsername = "TEST";
                String sPassword = "TEST";
                dUsername.setText("" + sUsername);
                dPassword.setText("" + sPassword);

                dStatus.setText("Connection in Progress");

                mProgress.setVisibility(View.VISIBLE);

                bLogin.setEnabled(false);


                // Create Inner Thread Class
                new Thread(new Runnable() {
                    public void run() {

                        SystemClock.sleep(1000);

                        mProgress.post(new Runnable() {
                            public void run() {
                                mProgress.setVisibility(View.INVISIBLE);
                            }
                        });

                        dStatus.post(new Runnable() {
                            public void run() {
                                dStatus.setText("Connected!");
                            }
                        });

                        SystemClock.sleep(500);

                        runOnUiThread(new Runnable() {
                            public void run() {
                                // some code that needs to be ran in UI thread
                                Intent myIntent = new Intent (MainActivity.this, Home.class);
                                //Bundle bundle = new Bundle();
                                //bundle.putInt("VAL", 1);
                                //myIntent.putExtras(bundle);

                                //myIntent.putExtra("firstKeyName","FirstKeyValue");

                                startActivity(myIntent);

                                finish();


                            }
                        });


                    }
                }).start();




/*
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Connection...");
                alertDialog.setMessage("You are are now connected");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });
                alertDialog.show();

*/
            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

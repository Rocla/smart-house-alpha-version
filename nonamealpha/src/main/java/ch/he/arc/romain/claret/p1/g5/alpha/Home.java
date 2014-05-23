package ch.he.arc.romain.claret.p1.g5.alpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.plus.model.people.Person;

import org.w3c.dom.Text;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class Home extends Activity {

    //Call Menus
    ImageButton bDeployCompleteMenu, bDeployQuickMenu, bHideQuickMenu;

    //Quick Menus items
    ImageButton bQHome, bQUsers, bQDevices, bQNotes, bQSettings;

    //Post-its items
    Button bClosePostIt1, bClosePostIt2, bClosePostIt3;
    ImageView iPostIt1, iPostIt2, iPostIt3;
    TextView tPostItDate1, tPostItDate2, tPostItDate3;
    TextView tPostItTime1, tPostItTime2, tPostItTime3;
    TextView tPostItFrom1, tPostItFrom2, tPostItFrom3;
    TextView tPostItMessage1, tPostItMessage2, tPostItMessage3;
    TextView tNumberMorePostIts, tStringMorePostIts;

    boolean postIt1 = true;
    boolean postIt2 = true;
    boolean postIt3 = true;

    int numberMorePostIts = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();

        //Boolean yourBool = getIntent().getExtras().getBoolean("postIt1");

        /*
        if(bundle.getBoolean("postIt1")== false)
        {
            Toast.makeText(Home.this,
                    "YOUR ARE AT HOME!", Toast.LENGTH_SHORT).show();
        }
        */


        setMenus();

        setPostIts();


    }

    public void setPostIts() {

        bClosePostIt1 = (Button) findViewById(R.id.bClosePostIt1);
        bClosePostIt2 = (Button) findViewById(R.id.bClosePostIt2);
        bClosePostIt3 = (Button) findViewById(R.id.bClosePostIt3);
        bClosePostIt1.setVisibility(View.INVISIBLE);
        bClosePostIt2.setVisibility(View.INVISIBLE);
        bClosePostIt3.setVisibility(View.INVISIBLE);

        iPostIt1 = (ImageView) findViewById(R.id.iPostIt1);
        iPostIt2 = (ImageView) findViewById(R.id.iPostIt2);
        iPostIt3 = (ImageView) findViewById(R.id.iPostIt3);
        iPostIt1.setVisibility(View.INVISIBLE);
        iPostIt2.setVisibility(View.INVISIBLE);
        iPostIt3.setVisibility(View.INVISIBLE);

        tPostItDate1 = (TextView) findViewById(R.id.tPostItDate1);
        tPostItDate2 = (TextView) findViewById(R.id.tPostItDate2);
        tPostItDate3 = (TextView) findViewById(R.id.tPostItDate3);
        tPostItDate1.setVisibility(View.INVISIBLE);
        tPostItDate2.setVisibility(View.INVISIBLE);
        tPostItDate3.setVisibility(View.INVISIBLE);

        tPostItTime1 = (TextView) findViewById(R.id.tPostItTime1);
        tPostItTime2 = (TextView) findViewById(R.id.tPostItTime2);
        tPostItTime3 = (TextView) findViewById(R.id.tPostItTime3);
        tPostItTime1.setVisibility(View.INVISIBLE);
        tPostItTime2.setVisibility(View.INVISIBLE);
        tPostItTime3.setVisibility(View.INVISIBLE);

        tPostItMessage1 = (TextView) findViewById(R.id.tPostItMessage1);
        tPostItMessage2 = (TextView) findViewById(R.id.tPostItMessage2);
        tPostItMessage3 = (TextView) findViewById(R.id.tPostItMessage3);
        tPostItMessage1.setVisibility(View.INVISIBLE);
        tPostItMessage2.setVisibility(View.INVISIBLE);
        tPostItMessage3.setVisibility(View.INVISIBLE);

        tPostItFrom1 = (TextView) findViewById(R.id.tPostItFrom1);
        tPostItFrom2 = (TextView) findViewById(R.id.tPostItFrom2);
        tPostItFrom3 = (TextView) findViewById(R.id.tPostItFrom3);
        tPostItFrom1.setVisibility(View.INVISIBLE);
        tPostItFrom2.setVisibility(View.INVISIBLE);
        tPostItFrom3.setVisibility(View.INVISIBLE);

        tNumberMorePostIts = (TextView) findViewById(R.id.tNumberMorePostIts);
        tStringMorePostIts = (TextView) findViewById(R.id.tStringMorePostIts);
        tNumberMorePostIts.setVisibility(View.INVISIBLE);
        tStringMorePostIts.setVisibility(View.INVISIBLE);


        checkPostIts();


    }

    public void checkPostIts() {


        final String postItMessage1 = "Message from Post It 1";
        final String postItMessage2 = "Message from Post It 2";
        final String postItMessage3 = "Message from Post It 3";

        final String postItDate1 = "Day 1";
        final String postItDate2 = "Day 2";
        final String postItDate3 = "Day 3";

        final String postItTime1 = "01:00";
        final String postItTime2 = "02:00";
        final String postItTime3 = "03:00";

        final String postItFrom1 = "User 1";
        final String postItFrom2 = "User 2";
        final String postItFrom3 = "User 3";

        bClosePostIt1 = (Button) findViewById(R.id.bClosePostIt1);
        tPostItDate1 = (TextView) findViewById(R.id.tPostItDate1);
        tPostItTime1 = (TextView) findViewById(R.id.tPostItTime1);
        tPostItFrom1 = (TextView) findViewById(R.id.tPostItFrom1);
        tPostItMessage1 = (TextView) findViewById(R.id.tPostItMessage1);

        tNumberMorePostIts.setText(String.valueOf(numberMorePostIts));


        switch (numberMorePostIts) {
            case 0:
                break;
            case 1:
                tStringMorePostIts.setText("Post-It is waiting");

                tNumberMorePostIts.setVisibility(View.VISIBLE);
                tStringMorePostIts.setVisibility(View.VISIBLE);
                break;
            default:
                tStringMorePostIts.setText("Post-Its are waiting");
                tNumberMorePostIts.setVisibility(View.VISIBLE);
                tStringMorePostIts.setVisibility(View.VISIBLE);
                break;
        }


        if (postIt1 == true) {

            iPostIt1.setVisibility(View.VISIBLE);
            bClosePostIt1.setVisibility(View.VISIBLE);
            tPostItDate1.setVisibility(View.VISIBLE);
            tPostItDate1.setText(postItDate1);
            tPostItTime1.setVisibility(View.VISIBLE);
            tPostItTime1.setText(postItTime1);
            tPostItFrom1.setVisibility(View.VISIBLE);
            tPostItFrom1.setText(postItFrom1);
            tPostItMessage1.setVisibility(View.VISIBLE);
            tPostItMessage1.setText(postItMessage1);

        }

        if (postIt1 == true && postIt2 == true) {



            iPostIt2.setVisibility(View.VISIBLE);
            bClosePostIt2.setVisibility(View.VISIBLE);
            tPostItDate2.setVisibility(View.VISIBLE);
            tPostItDate2.setText(postItDate2);
            tPostItTime2.setVisibility(View.VISIBLE);
            tPostItTime2.setText(postItTime2);
            tPostItFrom2.setVisibility(View.VISIBLE);
            tPostItFrom2.setText(postItFrom2);
            tPostItMessage2.setVisibility(View.VISIBLE);
            tPostItMessage2.setText(postItMessage2);




        }

        if (postIt1 == true && postIt2 == true && postIt3 == true) {

            iPostIt3.setVisibility(View.VISIBLE);
            bClosePostIt3.setVisibility(View.VISIBLE);
            tPostItDate3.setVisibility(View.VISIBLE);
            tPostItDate3.setText(postItDate3);
            tPostItTime3.setVisibility(View.VISIBLE);
            tPostItTime3.setText(postItTime3);
            tPostItFrom3.setVisibility(View.VISIBLE);
            tPostItFrom3.setText(postItFrom3);
            tPostItMessage3.setVisibility(View.VISIBLE);
            tPostItMessage3.setText(postItMessage3);

        }

        if (postIt1 == true && postIt2 == true && postIt3 == true) {

            iPostIt3.setVisibility(View.VISIBLE);
            bClosePostIt3.setVisibility(View.VISIBLE);
            tPostItDate3.setVisibility(View.VISIBLE);
            tPostItDate3.setText(postItDate3);
            tPostItTime3.setVisibility(View.VISIBLE);
            tPostItTime3.setText(postItTime3);
            tPostItFrom3.setVisibility(View.VISIBLE);
            tPostItFrom3.setText(postItFrom3);
            tPostItMessage3.setVisibility(View.VISIBLE);
            tPostItMessage3.setText(postItMessage3);

        }

        bClosePostIt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (postIt2 == false) {

                    if (postIt3==true){

                    }else {
                        iPostIt1.setVisibility(View.INVISIBLE);
                        bClosePostIt1.setVisibility(View.INVISIBLE);
                        tPostItDate1.setVisibility(View.INVISIBLE);
                        tPostItTime1.setVisibility(View.INVISIBLE);
                        tPostItFrom1.setVisibility(View.INVISIBLE);
                        tPostItMessage1.setVisibility(View.INVISIBLE);
                        postIt1 = false;
                    }

                } else {
                    tPostItDate1.setText(tPostItDate2.getText());
                    tPostItTime1.setText(tPostItTime2.getText());
                    tPostItFrom1.setText(tPostItFrom2.getText());
                    tPostItMessage1.setText(tPostItMessage2.getText());

                    if (postIt3 == false) {
                        iPostIt2.setVisibility(View.INVISIBLE);
                        bClosePostIt2.setVisibility(View.INVISIBLE);
                        tPostItDate2.setVisibility(View.INVISIBLE);
                        tPostItTime2.setVisibility(View.INVISIBLE);
                        tPostItFrom2.setVisibility(View.INVISIBLE);
                        tPostItMessage2.setVisibility(View.INVISIBLE);
                        postIt2 = false;
                    } else {
                        tPostItDate2.setText(tPostItDate3.getText());
                        tPostItTime2.setText(tPostItTime3.getText());
                        tPostItFrom2.setText(tPostItFrom3.getText());
                        tPostItMessage2.setText(tPostItMessage3.getText());
                        iPostIt3.setVisibility(View.INVISIBLE);
                        bClosePostIt3.setVisibility(View.INVISIBLE);
                        tPostItDate3.setVisibility(View.INVISIBLE);
                        tPostItTime3.setVisibility(View.INVISIBLE);
                        tPostItFrom3.setVisibility(View.INVISIBLE);
                        tPostItMessage3.setVisibility(View.INVISIBLE);
                        postIt3 = false;

                    }

                }

            }
        });

        bClosePostIt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (postIt3 == false) {
                    iPostIt2.setVisibility(View.INVISIBLE);
                    bClosePostIt2.setVisibility(View.INVISIBLE);
                    tPostItDate2.setVisibility(View.INVISIBLE);
                    tPostItTime2.setVisibility(View.INVISIBLE);
                    tPostItFrom2.setVisibility(View.INVISIBLE);
                    tPostItMessage2.setVisibility(View.INVISIBLE);
                    postIt2 = false;
                }else {
                    tPostItDate2.setText(tPostItDate3.getText());
                    tPostItTime2.setText(tPostItTime3.getText());
                    tPostItFrom2.setText(tPostItFrom3.getText());
                    tPostItMessage2.setText(tPostItMessage3.getText());
                    iPostIt3.setVisibility(View.INVISIBLE);
                    bClosePostIt3.setVisibility(View.INVISIBLE);
                    tPostItDate3.setVisibility(View.INVISIBLE);
                    tPostItTime3.setVisibility(View.INVISIBLE);
                    tPostItFrom3.setVisibility(View.INVISIBLE);
                    tPostItMessage3.setVisibility(View.INVISIBLE);
                    postIt3 = false;
                }

            }
        });

        bClosePostIt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    iPostIt3.setVisibility(View.INVISIBLE);
                    bClosePostIt3.setVisibility(View.INVISIBLE);
                    tPostItDate3.setVisibility(View.INVISIBLE);
                    tPostItTime3.setVisibility(View.INVISIBLE);
                    tPostItFrom3.setVisibility(View.INVISIBLE);
                    tPostItMessage3.setVisibility(View.INVISIBLE);
                    postIt3 = false;

                /*
                    Intent i = new Intent(Home.this, Home.class);
                    i.putExtra("postIt1", true);
                    i.putExtra("postIt2", true);
                    i.putExtra("postIt3", false);
                //startIn();

*/
            }
        });


    }


    public void setMenus() {

        bDeployCompleteMenu = (ImageButton) findViewById(R.id.bDeployCompleteMenu);

        bDeployCompleteMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent testIntent = new Intent(Home.this, MenuAdvanced.class);
                startActivity(testIntent);


            }
        });

        bDeployQuickMenu = (ImageButton) findViewById(R.id.idbDeployQuickMenu);
        bHideQuickMenu = (ImageButton) findViewById(R.id.idbHideQuickMenu);

        bQHome = (ImageButton) findViewById(R.id.bHome);
        bQUsers = (ImageButton) findViewById(R.id.bUsers);
        bQDevices = (ImageButton) findViewById(R.id.bDevices);
        bQNotes = (ImageButton) findViewById(R.id.bNotes);
        bQSettings = (ImageButton) findViewById(R.id.bSettings);

        bQHome.setVisibility(View.INVISIBLE);
        bQUsers.setVisibility(View.INVISIBLE);
        bQDevices.setVisibility(View.INVISIBLE);
        bQNotes.setVisibility(View.INVISIBLE);
        bQSettings.setVisibility(View.INVISIBLE);

        bDeployQuickMenu.setVisibility(View.VISIBLE);
        bHideQuickMenu.setVisibility(View.INVISIBLE);


        bQHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(Home.this,
                        "YOUR ARE AT HOME!", Toast.LENGTH_SHORT).show();

            }


        });


        bDeployQuickMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {

                        int delay = 30;

                        bQSettings.post(new Runnable() {
                            public void run() {
                                bQSettings.setVisibility(View.VISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQNotes.post(new Runnable() {
                            public void run() {
                                bQNotes.setVisibility(View.VISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQDevices.post(new Runnable() {
                            public void run() {
                                bQDevices.setVisibility(View.VISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQUsers.post(new Runnable() {
                            public void run() {
                                bQUsers.setVisibility(View.VISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQHome.post(new Runnable() {
                            public void run() {
                                bQHome.setVisibility(View.VISIBLE);
                            }
                        });


                    }
                }).start();

                bDeployQuickMenu.setVisibility(View.INVISIBLE);

                bHideQuickMenu.setVisibility(View.VISIBLE);

            }


        });


        bHideQuickMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {

                        int delay = 30;

                        bQHome.post(new Runnable() {
                            public void run() {
                                bQHome.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQUsers.post(new Runnable() {
                            public void run() {
                                bQUsers.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQDevices.post(new Runnable() {
                            public void run() {
                                bQDevices.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQNotes.post(new Runnable() {
                            public void run() {
                                bQNotes.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bQSettings.post(new Runnable() {
                            public void run() {
                                bQSettings.setVisibility(View.INVISIBLE);
                            }
                        });


                    }
                }).start();

                bHideQuickMenu.setVisibility(View.INVISIBLE);

                bDeployQuickMenu.setVisibility(View.VISIBLE);

            }

        });

    }


    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(Home.this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    */

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

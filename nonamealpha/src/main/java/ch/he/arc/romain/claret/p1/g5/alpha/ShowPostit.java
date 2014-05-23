package ch.he.arc.romain.claret.p1.g5.alpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class ShowPostit extends Activity {


    //Call Menus
    ImageButton bDeployCompleteMenu, bDeployQuickMenu, bHideQuickMenu;

    //Quick Menus items
    ImageButton bQHome, bQUsers, bQDevices, bQNotes, bQSettings;

    //Buttons
    Button bUnread, bDelete,bReturn;

    int status, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_postit);
        setMenus();
        setButtons();
        status = 1;

        id = getIntent().getExtras().getInt("id");

    }

    public void setButtons(){

        bUnread = (Button) findViewById(R.id.bUnread);
        bDelete = (Button) findViewById(R.id.bDelete);
        bReturn = (Button) findViewById(R.id.bReturn);

        bReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ShowPostItIntent = new Intent(ShowPostit.this, PostIts.class);
                ShowPostItIntent.putExtra("read", status);
                ShowPostItIntent.putExtra("id", id);
                startActivity(ShowPostItIntent);
                finish();
            }
        });

        bUnread.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                status = 0;
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                status = 3;
                Intent ShowPostItIntent = new Intent(ShowPostit.this, PostIts.class);
                ShowPostItIntent.putExtra("read", status);
                ShowPostItIntent.putExtra("id", id);
                startActivity(ShowPostItIntent);
                finish();
            }
        });




    }

    public void setMenus() {

        bDeployCompleteMenu = (ImageButton) findViewById(R.id.bDeployCompleteMenu);

        bDeployCompleteMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent advancedMenuIntent = new Intent(ShowPostit.this, MenuAdvanced.class);

                advancedMenuIntent.putExtra("qMenu1", 1);
                advancedMenuIntent.putExtra("qMenu2", 2);
                advancedMenuIntent.putExtra("qMenu3", 3);
                advancedMenuIntent.putExtra("qMenu4", 4);
                advancedMenuIntent.putExtra("qMenu5", 5);

                startActivity(advancedMenuIntent);


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

                Toast.makeText(ShowPostit.this,
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_postit, menu);
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

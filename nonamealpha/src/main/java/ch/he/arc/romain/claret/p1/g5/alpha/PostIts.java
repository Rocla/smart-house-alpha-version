package ch.he.arc.romain.claret.p1.g5.alpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


public class PostIts extends Activity {

    ListView PostItList;

    //Call Menus
    ImageButton bDeployCompleteMenu, bDeployQuickMenu, bHideQuickMenu;

    //Quick Menus items
    ImageButton bQHome, bQUsers, bQDevices, bQNotes, bQSettings;

    int id, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_its);

        //id = getIntent().getExtras().getInt("id");
        //status = getIntent().getExtras().getInt("status");

        setMenus();

        setList();


    }

    public void setList(){
        // Get ListView object from xml
        PostItList = (ListView) findViewById(R.id.PostItList);

        // Defined Array values to show in ListView
        String[] values = new String[]{
                "From Romain on 23th May 2014 00:00\n\n" +
                        "Hello, don't forget milk!",
                "From Bastien on 21th May 2014 00:00\n\n" +
                        "The fridge!!!!",
                "From Remy on 20th May 2014 00:00\n\n" +
                        "kfjdsahlkadshdkfjksafhlkasdhkfhaskldfhkjlasdhshakd...",
                "From Remy on 19th May 2014 00:00\n\n" +
                        "kfjdsahlkadshdkfjksafhlkasdhkfhaskldfhkjlasdhshakd...",
                "From Remy on 18th May 2014 00:00\n\n" +
                        "kfjdsahlkadshdkfjksafhlkasdhkfhaskldfhkjlasdhshakd...",
                "From Remy on 17th May 2014 00:00\n\n" +
                        "kfjdsahlkadshdkfjksafhlkasdhkfhaskldfhkjlasdhshakd...",
                "From Remy on 16th May 2014 00:00\n\n" +
                        "kfjdsahlkadshdkfjksafhlkasdhkfhaskldfhkjlasdhshakd..."
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        PostItList.setAdapter(adapter);

        // ListView Item Click Listener
        PostItList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent ShowPostItIntent = new Intent(PostIts.this, ShowPostit.class);
                ShowPostItIntent.putExtra("id", id);
                startActivity(ShowPostItIntent);




                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) PostItList.getItemAtPosition(position);

                // Show Alert

                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();




            }

        });
    }

    public void setMenus() {

        bDeployCompleteMenu = (ImageButton) findViewById(R.id.bDeployCompleteMenu);

        bDeployCompleteMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent advancedMenuIntent = new Intent(PostIts.this, MenuAdvanced.class);

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

                Toast.makeText(PostIts.this,
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
        getMenuInflater().inflate(R.menu.post_its, menu);
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

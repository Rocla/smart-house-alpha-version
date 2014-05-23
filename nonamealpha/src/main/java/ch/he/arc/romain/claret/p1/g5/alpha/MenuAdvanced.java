package ch.he.arc.romain.claret.p1.g5.alpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;


public class MenuAdvanced extends Activity {


    //Call Menus
    ImageButton bDeployCompleteMenu, bHideCompleteMenu, bDeployQuickMenu, bHideQuickMenu;

    //Quick Menus items
    ImageButton bQHome, bQUsers, bQDevices, bQNotes, bQSettings;

    //Advanced Menus items
    Button bAHome, bAUsers, bADevices, bANotes, bASettings, bAmenu6, bAmenu7, bAmenu8, bAmenu9;
    Switch sEdit;
    ImageView iMenu1, iMenu2, iMenu3, iMenu4, iMenu5, iMenu6, iMenu7, iMenu8, iMenu9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_advanced);

        //Bundle qMenuSetup = getIntent().getExtras();

        int qMenu1 = getIntent().getExtras().getInt("qMenu1");
        int qMenu2 = getIntent().getExtras().getInt("qMenu2");
        int qMenu3 = getIntent().getExtras().getInt("qMenu3");
        int qMenu4 = getIntent().getExtras().getInt("qMenu4");
        int qMenu5 = getIntent().getExtras().getInt("qMenu5");

        setSwitch();
        completeMenu();


    }

    public void setSwitch() {

        bQHome = (ImageButton) findViewById(R.id.bHome);
        bQUsers = (ImageButton) findViewById(R.id.bUsers);
        bQDevices = (ImageButton) findViewById(R.id.bDevices);
        bQNotes = (ImageButton) findViewById(R.id.bNotes);
        bQSettings = (ImageButton) findViewById(R.id.bSettings);

        sEdit = (Switch) findViewById(R.id.sEdit);
        sEdit.setVisibility(View.VISIBLE);
        sEdit.setChecked(false);

        sEdit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    //the switch is on
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

                } else {

                    //The switch is off
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
                }

            }
        });
    }

    public void completeMenu() {

        bQHome = (ImageButton) findViewById(R.id.bQHome);
        bQUsers = (ImageButton) findViewById(R.id.bQUsers);
        bQDevices = (ImageButton) findViewById(R.id.bQDevices);
        bQNotes = (ImageButton) findViewById(R.id.bQNotes);
        bQSettings = (ImageButton) findViewById(R.id.bQSettings);

        bAHome = (Button) findViewById(R.id.bAHome);
        bAUsers = (Button) findViewById(R.id.bAUsers);
        bADevices = (Button) findViewById(R.id.bADevices);
        bANotes = (Button) findViewById(R.id.bANotes);
        bASettings = (Button) findViewById(R.id.bASettings);
        bAmenu6 = (Button) findViewById(R.id.bAmenu6);
        bAmenu7 = (Button) findViewById(R.id.bAmenu7);
        bAmenu8 = (Button) findViewById(R.id.bAmenu8);
        bAmenu9 = (Button) findViewById(R.id.bAmenu9);

        bAHome.setVisibility(View.VISIBLE);
        bAUsers.setVisibility(View.VISIBLE);
        bADevices.setVisibility(View.VISIBLE);
        bANotes.setVisibility(View.VISIBLE);
        bASettings.setVisibility(View.VISIBLE);
        bAmenu6.setVisibility(View.VISIBLE);
        bAmenu7.setVisibility(View.VISIBLE);
        bAmenu8.setVisibility(View.VISIBLE);
        bAmenu9.setVisibility(View.VISIBLE);

        iMenu1 = (ImageView) findViewById(R.id.iMenu1);
        iMenu2 = (ImageView) findViewById(R.id.iMenu2);
        iMenu3 = (ImageView) findViewById(R.id.iMenu3);
        iMenu4 = (ImageView) findViewById(R.id.iMenu4);
        iMenu5 = (ImageView) findViewById(R.id.iMenu5);
        iMenu6 = (ImageView) findViewById(R.id.iMenu6);
        iMenu7 = (ImageView) findViewById(R.id.iMenu7);
        iMenu8 = (ImageView) findViewById(R.id.iMenu8);
        iMenu9 = (ImageView) findViewById(R.id.iMenu9);

        iMenu1.setVisibility(View.VISIBLE);
        iMenu2.setVisibility(View.VISIBLE);
        iMenu3.setVisibility(View.VISIBLE);
        iMenu4.setVisibility(View.VISIBLE);
        iMenu5.setVisibility(View.VISIBLE);
        iMenu6.setVisibility(View.VISIBLE);
        iMenu7.setVisibility(View.VISIBLE);
        iMenu8.setVisibility(View.VISIBLE);
        iMenu9.setVisibility(View.VISIBLE);

        bHideCompleteMenu = (ImageButton) findViewById(R.id.bHideCompleteMenu);

        sEdit = (Switch) findViewById(R.id.sEdit);


        bHideCompleteMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {

                        int delay = 35;

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


                new Thread(new Runnable() {
                    public void run() {

                        int delay = 30;

                        sEdit.post(new Runnable() {
                            public void run() {
                                sEdit.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bAHome.post(new Runnable() {
                            public void run() {
                                bAHome.setVisibility(View.INVISIBLE);
                                iMenu1.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bAUsers.post(new Runnable() {
                            public void run() {
                                bAUsers.setVisibility(View.INVISIBLE);
                                iMenu2.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bADevices.post(new Runnable() {
                            public void run() {
                                bADevices.setVisibility(View.INVISIBLE);
                                iMenu3.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bANotes.post(new Runnable() {
                            public void run() {
                                bANotes.setVisibility(View.INVISIBLE);
                                iMenu4.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bASettings.post(new Runnable() {
                            public void run() {
                                bASettings.setVisibility(View.INVISIBLE);
                                iMenu5.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bAmenu6.post(new Runnable() {
                            public void run() {
                                bAmenu6.setVisibility(View.INVISIBLE);
                                iMenu6.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bAmenu7.post(new Runnable() {
                            public void run() {
                                bAmenu7.setVisibility(View.INVISIBLE);
                                iMenu7.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bAmenu8.post(new Runnable() {
                            public void run() {
                                bAmenu8.setVisibility(View.INVISIBLE);
                                iMenu8.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        bAmenu9.post(new Runnable() {
                            public void run() {
                                bAmenu9.setVisibility(View.INVISIBLE);
                                iMenu9.setVisibility(View.INVISIBLE);
                            }
                        });

                        SystemClock.sleep(delay);

                        finish();

                    }
                }).start();

            }


        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_advanced, menu);
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

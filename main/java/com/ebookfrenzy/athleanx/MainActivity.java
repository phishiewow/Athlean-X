package com.ebookfrenzy.athleanx;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;





public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    com.ebookfrenzy.athleanx.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private VideoView mVideoView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //to indentify buttons
        Button one = (Button) findViewById(R.id.ax1);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.max_size);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.max_shred);
        three.setOnClickListener(this);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //to start video for tablet layout

        mVideoView = (VideoView)

                findViewById(R.id.videoview);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.train_like_athlete_video);

        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);

            }
        });

        //for expandable list view in navigation drawer
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new com.ebookfrenzy.athleanx.ExpandableListAdapter(this, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                        int childPosition, long id) {

                if (id == 0) {
                    Intent myIntent = new Intent(expListView.getContext(), ax1.class);
                    startActivityForResult(myIntent, 0);
                }

                return true;
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //for array data source
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Add header data
        listDataHeader.add("TRAINING");
        listDataHeader.add("SUPPLEMENTS");
        listDataHeader.add("GEAR");
        listDataHeader.add("BLOG");
        listDataHeader.add("VIDEOS");
        listDataHeader.add("RESULTS");
        listDataHeader.add("COACH");
        listDataHeader.add("LIVE EVENT");

        // Adding child data
        List<String> training = new ArrayList<String>();
        training.add("BEST SELLERS");
        training.add("MUSCLE GROWTH");
        training.add("FAT BURNING");
        training.add("BUILD MUSCLE & BURN FAT");
        training.add("ALL PROGRAMS");

        List<String> supplements = new ArrayList<String>();
        supplements.add("PRE WORKOUT");
        supplements.add("POST WORKOUT");
        supplements.add("RECOVERY");
        supplements.add("BASE STACK");
        supplements.add("MUSCLE STACK");
        supplements.add("RECOVERY STACK");
        supplements.add("WOMEN'S STACK");

        List<String> gear = new ArrayList<String>();
        gear.add("APPAREL");
        gear.add("ELAST-X BANDS");
        gear.add("ATHLEAN BLOX");

        List<String> blog = new ArrayList<String>();
        blog.add("FOR MEN");
        blog.add("FOR WOMEN");

        List<String> videos = new ArrayList<String>();
        videos.add("FOR MEN");
        videos.add("FOR WOMEN");

        List<String> results = new ArrayList<String>();
        results.add("FOR MEN");
        results.add("FOR WOMEN");

        List<String> coach = new ArrayList<String>();
        coach.add("ABOUT JEFF");
        coach.add("MEDIA REQUESTS");

        List<String> event = new ArrayList<String>();
        event.add("DETAILS");
        event.add("TICKETS");


        listDataChild.put(listDataHeader.get(0), training); // Header, Child data
        listDataChild.put(listDataHeader.get(1), supplements);
        listDataChild.put(listDataHeader.get(2), gear);
        listDataChild.put(listDataHeader.get(3), blog);
        listDataChild.put(listDataHeader.get(4), videos);
        listDataChild.put(listDataHeader.get(5), results);
        listDataChild.put(listDataHeader.get(6), coach);
        listDataChild.put(listDataHeader.get(7), event);
    }

    //set button click listeners
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ax1:
                Intent ax1 = new Intent(this,ScreenSlidePagerActivity.class);
                startActivity(ax1);

                break;

            case R.id.max_size:
                // do your code
                break;

            case R.id.max_shred:
                // do your code
                break;

            default:
                break;
        } //TODO: posle napravi da se povezuje još buttons na nove activities

    }


}

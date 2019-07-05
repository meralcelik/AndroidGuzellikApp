package com.example.guzellikappp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guzellikappp.fragmentler.FragmentAyak;
import com.example.guzellikappp.fragmentler.FragmentEl;
import com.example.guzellikappp.fragmentler.FragmentSac;
import com.example.guzellikappp.fragmentler.FragmentYuz;


public class Bakim extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakim);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        manager = getFragmentManager();
      
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
        getMenuInflater().inflate(R.menu.bakim, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.

        int id = item.getItemId();


        if (id == R.id.nav_yuz) {

            FragmentYuz fragmentYuz = new FragmentYuz();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.contentBakim, fragmentYuz, "FragmentYuz");

            manager.popBackStack("AddFragmentAyak", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentEl", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentYuz", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentSac", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            transaction.addToBackStack("AddFragmentYuz");
            transaction.commit();


            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            FragmentEl el = new FragmentEl();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.contentBakim, el, "FragmentEl");

            manager.popBackStack("AddFragmentAyak", FragmentManager.POP_BACK_STACK_INCLUSIVE);

            manager.popBackStack("AddFragmentYuz", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentEl", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentSac", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            transaction.addToBackStack("AddFragmentEl");
            transaction.commit();


        } else if (id == R.id.nav_slideshow) {
            FragmentSac sac = new FragmentSac();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.contentBakim, sac, "FragmentSac");

            manager.popBackStack("AddFragmentAyak", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentEl", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentYuz", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentSac", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            transaction.addToBackStack("AddFragmentSac");

            transaction.commit();
        } else if (id == R.id.nav_manage) {
            FragmentAyak ayak = new FragmentAyak();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.contentBakim, ayak, "FragmentAyak");

            manager.popBackStack("AddFragmentAyak", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentEl", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentYuz", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.popBackStack("AddFragmentSac", FragmentManager.POP_BACK_STACK_INCLUSIVE);

            transaction.addToBackStack("AddFragmentAyak");
            transaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

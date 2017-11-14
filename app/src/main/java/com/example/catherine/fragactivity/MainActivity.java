package com.example.catherine.fragactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */

    HashMap<Integer, GeoPoint> locations = new HashMap<Integer, GeoPoint>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locations.put(R.id.london, new GeoPoint(51.51, -0.1));
        locations.put(R.id.paris, new GeoPoint(48.85, 2.34));
        locations.put(R.id.new_york, new GeoPoint(40.75, -74));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        GeoPoint point = locations.get(item.getItemId());
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.setLocation(point);

        return true;
    }


}


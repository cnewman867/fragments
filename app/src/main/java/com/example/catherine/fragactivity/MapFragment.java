package com.example.catherine.fragactivity;
/**
 * Created by catherine on 14/11/17.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;


public class MapFragment extends Fragment{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    MapView mv;

    /*
    public void onAttach (Activity a) {
        super.onAttach(a);
        mv = new MapView(a);
    }

    */

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();


        mv = (MapView)activity.findViewById(R.id.map1);
        mv.setTileSource(TileSourceFactory.MAPNIK);
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));

    }

    public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fraglayout, parent);

        return v;
    }

    public void setLocation(GeoPoint geoPoint) {
        mv.getController().setCenter(geoPoint);
    }
}

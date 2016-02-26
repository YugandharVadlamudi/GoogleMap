package com.example.kiran.googlemap.GoogleMapActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.example.kiran.googlemap.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by Kiran on 16-12-2015.
 */
public class googleMapActivity extends Activity
{
    GoogleMap googleMap;
    LatLng latLng,latLng_1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        googleWithCursor();
        setLongLat();
        putMapMarker();
        setTwoMarkers();
        animatingMarkers();
        addingLineMarkers();
        camarMoving();
    }

    private void camarMoving() {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
    }

    private void addingLineMarkers() {
        ArrayList<LatLng> latLngs=new ArrayList<>();
        LatLng latLng2=new LatLng(40.21843892856462, 40.41662287712097);
        LatLng latLng3=new LatLng(100.21843892856462, 10.41662287712097);
        latLngs.add(latLng2);
        latLngs.add(latLng3);
        PolylineOptions polylineOptions=new PolylineOptions();
        polylineOptions.color(Color.RED);
        polylineOptions.width(5);
        polylineOptions.addAll(latLngs);
        googleMap.addPolyline(polylineOptions);

    }

    private void animatingMarkers() {
    }

    private void setTwoMarkers() {

    }

    private void putMapMarker() {
        /*Custom marker*/
        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(latLng).title("Done"));
        googleMap.addMarker(new MarkerOptions().position(latLng_1).title("Done secound marker"));
    }

    private void setLongLat() {
        latLng=new LatLng(35.21843892856462, 33.41662287712097);
        latLng_1=new LatLng(40.21843892856462, 40.41662287712097);
    }

    private void googleWithCursor() {
        googleMap=((MapFragment)getFragmentManager().findFragmentById(R.id.the_map)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setMyLocationEnabled(true);
//        googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(latLng));
    }
}

package com.example.cookin;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.cookin.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("DONDE COMPRAR LOS INGREDIENTES");

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //BOGOTA DC.
        LatLng bogota = new LatLng(4.6324835, -74.1540527);
        mMap
                .addMarker(new MarkerOptions()
                .position(bogota)
                .title("CORABASTOS")
                .snippet("BOGOTÁ, D.C")
                .icon(bitmapDescriptorFromVector(this, R.mipmap.ic_car))
                .anchor(0.0f,0.3f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota,10));


        // MADRID
        LatLng madrid = new LatLng(4.731063, -74.260078);
        mMap
                .addMarker(new MarkerOptions()
                .title("EL MERCADEO")
                .snippet("MADRID-CUNDINAMARCA")
                .icon(bitmapDescriptorFromVector(this, R.mipmap.ic_car))
                .anchor(0.0f,0.3f)
                .position(madrid));


        // MOSQUERA
        LatLng mosquera = new LatLng(4.7130404, -74.2192511);
        mMap
               .addMarker(new MarkerOptions()
               .position(mosquera)
               .title("MERCADOS ZAPATOCA")
               .snippet("MOSQUERA-CUNDINAMARCA")
               .icon(bitmapDescriptorFromVector(this,R.mipmap.ic_car))
               .anchor(0.0f,0.3f));



        //FUNZA
       LatLng funza = new LatLng(4.7146257, -74.2152997);
       mMap
               .addMarker(new MarkerOptions()
               .position(funza)
               .title("MERCADO ZAPATOCA")
               .snippet("FUNZA-CUNDINAMARCA")
               .icon(bitmapDescriptorFromVector(this, R.mipmap.ic_car))
               .anchor(0.0f,0.3f));

    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
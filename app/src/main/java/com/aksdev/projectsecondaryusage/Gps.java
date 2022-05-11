package com.aksdev.projectsecondaryusage;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.aksdev.projectsecondaryusage.databinding.ActivityGpsBinding;

public class Gps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGpsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGpsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(39.864366227750565, 32.8813005328064);
        mMap.addMarker(new MarkerOptions().position(location).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

        LatLng location1 = new LatLng(40.025832057446074, 32.77150763019826);
        mMap.addMarker(new MarkerOptions().position(location1).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location1));

        LatLng location2 = new LatLng( 39.99644654944115, 32.767988570968036);
        mMap.addMarker(new MarkerOptions().position(location2).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location2));

        LatLng location3 = new LatLng(39.88017310898009, 32.8401396142383);
        mMap.addMarker(new MarkerOptions().position(location3).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location3));

        LatLng location4 = new LatLng(40.023940146001365, 32.76491675971366);
        mMap.addMarker(new MarkerOptions().position(location4).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location4));

        LatLng location5 = new LatLng(39.98047502483553, 32.74432805286946);
        mMap.addMarker(new MarkerOptions().position(location5).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location5));

        LatLng location6 = new LatLng(40.01742715873304, 32.76818898313816);
        mMap.addMarker(new MarkerOptions().position(location6).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location6));

        LatLng location7 = new LatLng(40.021371044965896, 32.77076390367075);
        mMap.addMarker(new MarkerOptions().position(location7).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location7));

        LatLng location8 = new LatLng(40.01821915133444,  32.76385621407715);
        mMap.addMarker(new MarkerOptions().position(location8).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location8));

        LatLng location9 = new LatLng(39.91597080556138, 32.76945670628757);
        mMap.addMarker(new MarkerOptions().position(location9).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location9));

        LatLng location10 = new LatLng(39.953284604949935, 32.89746066310717);
        mMap.addMarker(new MarkerOptions().position(location10).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location10));

        LatLng location11 = new LatLng(39.97123456665953,   33.004662899896104);
        mMap.addMarker(new MarkerOptions().position(location11).title("Marker in Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location11));





    }
}
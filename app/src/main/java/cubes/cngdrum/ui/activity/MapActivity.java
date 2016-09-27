package cubes.cngdrum.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cubes.cngdrum.R;

/**
 * Created by markodragonjic on 6/24/16.
 */
public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private IconText mItBack;
    private MapFragment mMapFragment;
    private static final LatLng myPosition = new LatLng(45, 21);
    private static final LatLng Autokomanda = new LatLng(44.787455, 20.466005);
    private static final LatLng Nis = new LatLng(43.320672, 21.895419);
    private static final LatLng Uzice = new LatLng(43.855192, 19.843797);
    private static final LatLng NoviSad = new LatLng(45.267806, 19.831929);
    private static final LatLng Subotica = new LatLng(46.101196, 19.665871);
    private static final LatLng Kragujevac = new LatLng(44.012040, 20.905456);
    private static final LatLng Cacak = new LatLng(43.891693, 20.349941);
    private static final LatLng Skoplje = new LatLng(41.999069, 21.425574);
    private static final LatLng BanjaLuka = new LatLng(44.771991, 17.191402);
    private static final LatLng Cetinje = new LatLng(42.393564, 18.910839);
    private static final LatLng Temisvar = new LatLng(45.748470, 21.207661);
    private static final LatLng Sofija = new LatLng(42.697365, 23.322563);


    private GoogleMap mgoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_page);


        inicMap();
        inicComponent();
        addListener();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            mgoogleMap.setMyLocationEnabled(true);
            return;
        }
        setUpMapIfNeeded();


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mgoogleMap = googleMap;
        mgoogleMap.addMarker(new MarkerOptions().position(myPosition).title("Marker in Belgrade"));

        mgoogleMap.addMarker(new MarkerOptions().position(Autokomanda).title("Autokomanda").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(Nis).title("Nis").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(NoviSad).title("Novi Sad").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(Subotica).title("Subotica").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(Uzice).title("Uzice").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(Cacak).title("Cacak").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(BanjaLuka).title("Banja Luka").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));
        mgoogleMap.addMarker(new MarkerOptions().position(Cetinje).title("Cetinje").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.servicesicon)));
        mgoogleMap.addMarker(new MarkerOptions().position(Skoplje).title("Skoplje").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.servicesicon)));
        mgoogleMap.addMarker(new MarkerOptions().position(Kragujevac).title("Kragujevac").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.servicesicon)));
        mgoogleMap.addMarker(new MarkerOptions().position(Temisvar).title("Temisvar").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.servicesicon)));
        mgoogleMap.addMarker(new MarkerOptions().position(Sofija).title("Sofija").snippet("Pumpa i Servisi").icon(BitmapDescriptorFactory.fromResource(R.drawable.gas_station)));


        mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
        mgoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        UiSettings uiSettings = mgoogleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setRotateGesturesEnabled(true);
        uiSettings.setZoomGesturesEnabled(true);
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setAllGesturesEnabled(true);

        CameraUpdateFactory.zoomTo(15);

    }

    private void addListener() {
        mItBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inicMap() {

    }

    private void inicComponent() {

        mItBack = (IconText) findViewById(R.id.back);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mgoogleMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mgoogleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mgoogleMap.setMyLocationEnabled(true);
            // Check if we were successful in obtaining the map.
            if (mgoogleMap != null) {


                mgoogleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                    @Override
                    public void onMyLocationChange(Location arg0) {
                        // TODO Auto-generated method stub

                        mgoogleMap.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("It's Me!"));
                    }
                });

            }
        }
    }


}

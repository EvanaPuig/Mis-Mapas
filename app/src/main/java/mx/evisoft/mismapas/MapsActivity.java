package mx.evisoft.mismapas;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng place;
    private String placeName;
    int asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        //LatLng sydney = new LatLng(-34, 151);
        Intent intent = getIntent();

       choosePlace(intent.getStringExtra("placeName"));

        mMap.addMarker(new MarkerOptions()
                .position(place)
                .title("Marker in " + placeName)
                .icon(BitmapDescriptorFactory.fromResource(asset))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place,15));
    }

    public void choosePlace(String placeName){
        switch (placeName){
            case "angelIndependencia":
                place = new LatLng(19.427020605600777, -99.16759934999999);
                asset = R.drawable.marker1;
                placeName = "Ángel de la Independencia";
                break;
            case "alamedaCentral":
                place = new LatLng(19.435761905603474, -99.14411919999998);
                asset = R.drawable.marker2;
                placeName = "Alameda Central";
                break;
            case "antropologia":
                place = new LatLng(19.42600320560044, -99.18627860000004);
                asset = R.drawable.marker3;
                placeName = "Museo de Antropología";
                break;
            case "zocalo":
                place = new LatLng(19.4326018056025, -99.13320490000001);
                asset = R.drawable.marker4;
                placeName = "Zócalo";
                break;
            default:
                place = new LatLng(19.39085896142664, -99.14361265000002);
                placeName = "Mexico City";
                asset = R.drawable.marker1;
                break;
        }

    }
}

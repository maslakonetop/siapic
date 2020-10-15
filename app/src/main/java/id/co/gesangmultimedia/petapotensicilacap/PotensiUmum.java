package id.co.gesangmultimedia.petapotensicilacap;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;

public class PotensiUmum extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener {
    private GoogleMap mMap;
    private GeoJsonLayer geoJsonLayer;
    private static final LatLng CILACAP = new LatLng(-7.481717, 108.838529);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potensi_umum);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        //mMap = mapFragment.getMap();

    }

    private void showCilacap(View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        GeoJsonLayer cilacap;
        cilacap = new GeoJsonLayer(mMap, R.raw.cilacap, getApplicationContext());
        GeoJsonPolygonStyle geoJsonPolygonStyle = cilacap.getDefaultPolygonStyle();
        geoJsonPolygonStyle.setStrokeColor(ContextCompat.getColor(this, R.color.indigo));
        geoJsonPolygonStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        geoJsonPolygonStyle.setStrokeWidth(3f);

        cilacap.addLayerToMap();
    }

    private void airpanascipari() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.430953, 108.7662454))
                .anchor(0.5f, 0.5f)
                .title("Pemandian Air Panas Cipari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata)));
    }

    private void kelapaWanareja() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.4056531, 108.8025372))
                .anchor(0.5f, 0.5f)
                .title("Serat Sabut Kelapa Wanareja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void sapiDayeuhluhur() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.261911, 108.601007))
                .title("Peternakan Sapi Potong Dayeuhluhur")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void palaDayeuhluhur() {
        mMap.addMarker(new MarkerOptions()
                .title("Industri Terpadu Pengolahan Buah Pala")
                .position(new LatLng(-7.259467, 108.607142))
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void sapiMajenang() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.258226, 108.683353))
                .title("Peternakan Sapi Potong Majenang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void sapiWanareja() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.312470, 108.673625))
                .title("Peternakan Sapi Potong Wanareja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void kelapaKedungreja() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.5015207, 108.7848592))
                .title("Industri Pengolahan Kelapa Terpadu Kedungreja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void kambingKrpucung() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.5537295, 108.8129129))
                .title("Peternakan Terpadu Kambing Karangpucung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void gulaJeruklegi() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.654652, 109.041271))
                .title("Pabrik Gula Semut Super Jeruklegi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void hutanpayau() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.668021, 109.0270623))
                .title("Pengembangan Hutan Payau")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata)));
    }

    private void sidat() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.666796, 109.003658))
                .title("Budidaya Ikan Sidat")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan)));
    }

    private void sleko() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.727495, 108.996744))
                .title("Pengembangan Wisata Bahari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata)));
    }

    private void udang() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.662435, 109.260374))
                .title("Industri Terpadu Udang Vaname")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan)));
    }

    private void momongan() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.712007, 109.387234))
                .title("Pengembangan Wisata Pulau Momongan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata)));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAP, 10f));

        try {
            showCilacap(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        momongan();
        udang();
        sleko();
        sidat();
        hutanpayau();
        gulaJeruklegi();
        kambingKrpucung();
        kelapaKedungreja();
        kelapaWanareja();
        sapiMajenang();
        sapiWanareja();
        sapiDayeuhluhur();
        palaDayeuhluhur();
        airpanascipari();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        MarkerInfoWindowAdapter markerInfoWindowAdapter = new MarkerInfoWindowAdapter(getApplicationContext());
        mMap.setInfoWindowAdapter(markerInfoWindowAdapter);
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng arg0) {
                mMap.clear();
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(arg0);
                mMap.animateCamera(CameraUpdateFactory.newLatLng(arg0));
                Marker marker = mMap.addMarker(markerOptions);
                marker.showInfoWindow();
            }
        });
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Lokasi Saat Ini:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Toast.makeText(this, "Lokasi saya di klik", Toast.LENGTH_SHORT).show();
    }

}
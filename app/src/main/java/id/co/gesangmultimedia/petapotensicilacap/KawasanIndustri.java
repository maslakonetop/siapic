package id.co.gesangmultimedia.petapotensicilacap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;

public class KawasanIndustri extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private GeoJsonLayer geoJsonLayer;
    private Spinner spKpi;
    private static final LatLng WARUNGBATOK = new LatLng(-7.330868, 108.587047);
    private static final LatLng CILACAPTIMUR = new LatLng(-7.691819, 109.220713);
    private static final LatLng TinggarJaya = new LatLng(-7.482692,108.774660);
    private static final LatLng Lainnya = new LatLng(-7.746594,109.016154);
    private static final LatLng Lainnya1 = new LatLng(-7.731508,108.993339);
    private static final LatLng Lainnya2 = new LatLng(-7.6322241,109.1485624);
    private static final LatLng Lainnya3 = new LatLng(-7.6229780,109.1445658);
    private static final LatLng Lainnya4 = new LatLng(-7.6178920,109.1443216);
    private static final LatLng Lainnya5 = new LatLng(-7.6144114,109.1482057);
    private static final LatLng Lainnya6 = new LatLng(-7.6111156,109.2590018);
    private static final LatLng Lainnya7 = new LatLng(-7.6081426,109.2546909);
    private static final LatLng Lainnya8 = new LatLng(-7.6080322,109.2459842);
    private static final LatLng BengawanDonan = new LatLng(-7.64335,108.96218);
    private static final LatLng BengawanDonan1 = new LatLng(-7.66112,108.97968);
    private static final LatLng BengawanDonan2 = new LatLng(-7.68449,108.98267);
    private static final LatLng Bunton = new LatLng(-7.681504,109.132982);
    private static final LatLng KPICILACAP = new LatLng(-7.689523,109.006654);
    private static final LatLng KarangKandri = new LatLng(-7.682489,109.086195);
    private static final LatLng Provinsi = new LatLng(-7.59374,109.09496);
    private static final LatLng CILACAP = new LatLng(-7.481717, 108.838529);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kawasan_industri);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        final Spinner spKpi = findViewById(R.id.spPilihKpi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PilihKpi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKpi.setAdapter(adapter);
        spKpi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                //((TextView) parent.getChildAt(0)).setTextSize(5);
                String spinSelection =spKpi.getSelectedItem().toString();
                if(spinSelection.equals("KPI Cilacap Timur")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPTIMUR, 12f));
                    mMap.clear();
                    markerCilacapTimur();
                }
                else if (spinSelection.equals("KPI Cilacap")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KPICILACAP, 12f));
                    mMap.clear();
                    markerKpiCilacap();
                }
                else if (spinSelection.equals("Semua Wilayah")){
                    mMap.clear();
                    showCilacap(null);
                    try {
                        showKPI(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else if (spinSelection.equals("KPI Bengawan Donan")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BengawanDonan, 12f));
                    mMap.clear();
                    markerBengawanDonan();
                }
                else if (spinSelection.equals("KPI Provinsi")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Provinsi, 12f));
                    mMap.clear();
                    markerKpiProvinsi();
                }
                else if (spinSelection.equals("KPI Karang Kandri")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KarangKandri, 12f));
                    mMap.clear();
                    markerKarangkandri();
                }
                else if (spinSelection.equals("KPI Bunton")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bunton, 12f));
                    mMap.clear();
                    markerBunton();
                }
                else if (spinSelection.equals("KPI Warung Batok")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WARUNGBATOK, 12f));
                    mMap.clear();
                    markerWarungBatok();
                }
                else if (spinSelection.equals("KPI Tinggar Jaya")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TinggarJaya, 12f));
                    mMap.clear();
                    markerTinggarjaya();
                }
                else if (spinSelection.equals("KPI Lainnya")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Lainnya, 10f));
                    mMap.clear();
                    markerLainny();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void showCilacap(View v){
        if (mMap == null) {
            return;
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAP, 10f));

        GeoJsonLayer geoJsonLayer = null;
        try {
            geoJsonLayer = new GeoJsonLayer(mMap, R.raw.cilacap,
                    getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle cilacapstyle = geoJsonLayer.getDefaultPolygonStyle();
        cilacapstyle.setStrokeWidth(3f);
        cilacapstyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        cilacapstyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        geoJsonLayer.addLayerToMap();
    }
    public void showKPI(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerKPI;
        layerKPI = new GeoJsonLayer(mMap, R.raw.cilacapkpi, getApplicationContext());
        GeoJsonPolygonStyle geoJsonPolygonStyle = layerKPI.getDefaultPolygonStyle();
        geoJsonPolygonStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        geoJsonPolygonStyle.setFillColor(ContextCompat.getColor(this, R.color.hotpink));
        geoJsonPolygonStyle.setStrokeWidth(5f);
        layerKPI.addLayerToMap();
    }
    private void markerWarungBatok() {
        GeoJsonLayer layerWarung = null;
        try {
            layerWarung = new GeoJsonLayer(mMap, R.raw.warungbatok, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle stylewarung = layerWarung.getDefaultPolygonStyle();
        stylewarung.setStrokeWidth(3f);
        stylewarung.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        stylewarung.setFillColor(ContextCompat.getColor(this, R.color.transparentblue));
        layerWarung.addLayerToMap();

        mMap.addMarker(new MarkerOptions()
                .position(WARUNGBATOK)
                .title("KPI Warung Bathok")
                .snippet("Luas: 40,76Ha")
                //.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.factory))
        );
    }
    private void markerCilacapTimur(){
        GeoJsonLayer layerCiptim = null;
        try {
            layerCiptim = new GeoJsonLayer(mMap, R.raw.cilacaptimur, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerCiptim.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.forestgreen));
        styleciptim.setStrokeWidth(3f);
        layerCiptim.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPTIMUR)
                .title("KPI Cilacap Timur")
                .snippet("Luas 1119,76 Ha")
        );
    }
    private void markerKpiCilacap(){
        GeoJsonLayer layerkpi = null;
        try {
            layerkpi = new GeoJsonLayer(mMap, R.raw.kpicilacap, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerkpi.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.mediumaquamarine));
        styleciptim.setStrokeWidth(3f);
        layerkpi.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(KPICILACAP)
                .title("KPI Cilacap")
                .snippet("Luas 565,94 Ha")
        );
    }
    private void markerBengawanDonan(){
        GeoJsonLayer layerdonan = null;
        try {
            layerdonan = new GeoJsonLayer(mMap, R.raw.bengawandonan, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assert layerdonan != null;
        GeoJsonPolygonStyle styleciptim = layerdonan.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.teal));
        styleciptim.setStrokeWidth(3f);
        layerdonan.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(BengawanDonan)
                .title("KPI Bengawan Donan")
                .snippet("Total Luas 816,49 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .position(BengawanDonan1)
                .title("KPI Bengawan Donan")
                .snippet("Total Luas 816,49 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .position(BengawanDonan2)
                .title("Kpi Bengawan Donan")
        );
    }
    private void markerKpiProvinsi(){
        GeoJsonLayer layerkpi = null;
        try {
            layerkpi = new GeoJsonLayer(mMap, R.raw.provinsi, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerkpi.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.steelblue));
        styleciptim.setStrokeWidth(3f);
        layerkpi.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(Provinsi)
                .title("KPI Provinsi")
                .snippet("Total Luas 1618,22 Ha")
        );
    }
    private void markerKarangkandri(){
        GeoJsonLayer layerkpi = null;
        try {
            layerkpi = new GeoJsonLayer(mMap, R.raw.karangkandri, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerkpi.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.mediumaquamarine));
        styleciptim.setStrokeWidth(3f);
        layerkpi.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(KarangKandri)
                .title("KPI Karangkandri")
                .snippet("Total Luas 512,37 Ha")
        );
    }
    private void markerBunton(){
        GeoJsonLayer layerkpi = null;
        try {
            layerkpi = new GeoJsonLayer(mMap, R.raw.bunton, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerkpi.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.indigo));
        styleciptim.setStrokeWidth(3f);
        layerkpi.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(Bunton)
                .title("KPI Bunton")
                .snippet("Total Luas 556,39 Ha")
        );
    }
    private void markerTinggarjaya(){
        GeoJsonLayer layerkpi = null;
        try {
            layerkpi = new GeoJsonLayer(mMap, R.raw.tinggarjati, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerkpi.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.mediumVioletred));
        styleciptim.setStrokeWidth(3f);
        layerkpi.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(TinggarJaya)
                .title("KPI Tinggar Jaya")
                .snippet("Total Luas 5,38 Ha")
        );
    }
    private void markerLainny(){
        GeoJsonLayer layerkpi = null;
        try {
            layerkpi = new GeoJsonLayer(mMap, R.raw.lainnya, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleciptim = layerkpi.getDefaultPolygonStyle();
        styleciptim.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        styleciptim.setFillColor(ContextCompat.getColor(this, R.color.darkturquoise));
        styleciptim.setStrokeWidth(3f);
        layerkpi.addLayerToMap();
        mMap.addMarker(new MarkerOptions()
                .position(Lainnya)
                .title("KPI Lainnya")
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya1)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya2)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya3)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya4)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya5)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya6)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya7)
                .snippet("Total Luas 50,44 Ha")
        );
        mMap.addMarker(new MarkerOptions()
                .title("KPI Lainnya")
                .position(Lainnya8)
                .snippet("Total Luas 50,44 Ha")
        );
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        showCilacap(null);
        try {
            showKPI(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
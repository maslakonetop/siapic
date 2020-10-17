package id.co.gesangmultimedia.siapic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlLayer;

import org.json.JSONException;

import java.io.IOException;


public class DataKecamatan extends AppCompatActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {
    private GoogleMap mMap;
    private GeoJsonLayer geoJsonLayer;
    private Spinner spKecamatan;
    private Spinner spPotensi;
    private KmlLayer kmlLayer;
    private String strKecamatan = "";
    private String strPotensi = "";

    private static final LatLng CILACAP = new LatLng(-7.727989, 109.005913);

    private static final LatLng ADIPALA = new LatLng(-7.668273, 109.166703);

    private static final LatLng BANTARSARI = new LatLng(-7.525600, 108.895921);

    private static final LatLng BINANGUN = new LatLng(-7.673221, 109.270858);

    private static final LatLng CILACAPSELATAN= new LatLng(-7.739772, 108.992824);

    private static final LatLng CILACAPTENGAH = new LatLng(-7.694550, 108.994872);

    private static final LatLng CILACAPUTARA = new LatLng(-7.672497, 109.032616);

    private static final LatLng CIMANGGU = new LatLng(-7.303910, 108.836918);

    private static final LatLng CIPARI = new LatLng(-7.406070, 108.772876);

    private static final LatLng DAYEUHLUHUR = new LatLng(-7.214345, 108.609593);

    private static final LatLng GANDRUNGMANGU = new LatLng(-7.506601, 108.845807);

    private static final LatLng JERUKLEGI = new LatLng(-7.579301, 109.015862);

    private static final LatLng KAMPUNGLAUT = new LatLng(-7.695562, 108.878765);

    private static final LatLng KARANGPUCUNG = new LatLng(-7.380644, 108.907435);

    private static final LatLng KAWUNGANTEN = new LatLng(-7.601898, 108.936824);

    private static final LatLng KEDUNGREJA = new LatLng(-7.518092, 108.766808);

    private static final LatLng KESUGIHAN = new LatLng(-7.623022, 109.089806);

    private static final LatLng KROYA = new LatLng(-7.626639, 109.236504);

    private static final LatLng MAJENANG = new LatLng(-7.262512, 108.754843);

    private static final LatLng MAOS = new LatLng(-7.604238, 109.155220);

    private static final LatLng NUSAWUNGU = new LatLng(-7.668230, 109.348896);

    private static final LatLng PATIMUAN = new LatLng(-7.609393, 108.786575);

    private static final LatLng SAMPANG = new LatLng(-7.581237, 109.199190);

    private static final LatLng SIDAREJA = new LatLng(-7.469769, 108.797734);

    private static final LatLng WANAREJA = new LatLng(-7.320754, 108.683676);

    private static final LatLng AIRPANASCIPARI = new LatLng(-7.430953, 108.7662454);

    private static final LatLng KELAPAWANAREJA = new LatLng(-7.4056531, 108.8025372);

    private static final LatLng SAPIDAYEUHLUHUR = new LatLng(-7.261911, 108.601007);

    private static final LatLng PALADAYEUHLUHUR = new LatLng(-7.259467, 108.607142);

    private static final LatLng SAPIMAJENANG = new LatLng(-7.258226, 108.683353);

    private static final LatLng SAPIWANAREJA = new LatLng(-7.312470, 108.673625);

    private static final LatLng KAMBINGKRPUCUNG = new LatLng(-7.5537295, 108.8129129);

    private static final LatLng GULAJERUKLEGI = new LatLng(-7.654652, 109.041271);

    private static final LatLng HUTANPAYAU = new LatLng(-7.668021, 109.0270623);

    private static final LatLng SIDATCILACAP = new LatLng(-7.666796, 109.003658);

    private static final LatLng WISATASLEKO = new LatLng(-7.727495, 108.996744);

    private static final LatLng UDANGVANAME = new LatLng(-7.662435, 109.260374);

    private static final LatLng WISATAMOMONGAN = new LatLng(-7.430953, 108.7662454);

    private static final LatLng KELAPAKEDUNGREJA = new LatLng(-7.5015207, 108.7848592);

    private static final LatLng BUNTON = new LatLng(-7.684692, 109.137513);

    private static final LatLng JIPANGADIPALA = new LatLng(-7.651058, 109.127968);
    private static final LatLng GITARADIPALA = new LatLng(-7.632131, 109.146367);
    private static final LatLng PASARADIPALA = new LatLng(-7.660389, 109.151568);
    private static final LatLng GULAKELAPAADIPALA = new LatLng(-7.670830, 109.111700);
    private static final LatLng GULAKRISTALADIPALA = new LatLng( -7.636690, 109.138904);
    private static final LatLng SALEPISANGADIPALA = new LatLng(-7.670583, 109.160941);
    private static final LatLng SERIPINGPISANGADIPALA = new LatLng(-7.662127, 109.175154);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kecamatan);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        Spinner spinkecamatan = findViewById(R.id.spKecamatan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.namakecamatan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinkecamatan.setAdapter(adapter);
        spinkecamatan.setOnItemSelectedListener(this);

        Spinner spinpotensi = findViewById(R.id.spPotensi);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.potensi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinpotensi.setAdapter(adapter1);
        spinpotensi.setOnItemSelectedListener(this);

        Button btnMap = findViewById(R.id.btnPeta);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strKecamatan.equals("Kecamatan Adipala") && strPotensi.equals("Industri")){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    markerAdipala();
                    showIndustriAdipala();
                    showPertanianAdipala();
                }
                if(strKecamatan.equals("Kecamatan Adipala") && strPotensi.equals("Pariwisata")){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Button btnPdf = findViewById(R.id.btnPdf);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pdf = new Intent(DataKecamatan.this, ShowPdf.class);
                pdf.putExtra("judul", strKecamatan);
                startActivity(pdf);

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
        geoJsonLayer.addLayerToMap();
        markerAdipala();
        markerBantarsari();
        markerBinangun();
        markerCimanggu();
        markerCipari();
        markerClpSelatan();
        markerClpTengah();
        markerClpUtara();
        markerDayeuhluhur();
        markerGandrungmangu();
        markerJeruklegi();
        markerKawunganteng();
        markerKdreja();
        markerKesugihan();
        markerKroya();
        markerKrPucung();
        markerMajenang();
        markerMaos();
        markerNusawungu();
        markerKpLaut();
        markerPatimuan();
        markerSampang();
        markerSidareja();
        markerWanareja();
    }

    public void showAdipala (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ADIPALA, 12f));
        GeoJsonLayer layerAdipala;
        layerAdipala = new GeoJsonLayer(mMap, R.raw.adipala, getApplicationContext());
        GeoJsonPolygonStyle layerAdipalaStyle = layerAdipala.getDefaultPolygonStyle();
        layerAdipalaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerAdipalaStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerAdipala.addLayerToMap();
        markerAdipala();
    }

    public void showBantarsari (View v)throws IOException, JSONException{
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BANTARSARI, 13f));
        GeoJsonLayer layerBantarsari;
        layerBantarsari =new GeoJsonLayer(mMap, R.raw.bantarsari, getApplicationContext());
        GeoJsonPolygonStyle layerBantarsariStyle = layerBantarsari.getDefaultPolygonStyle();
        layerBantarsariStyle.setFillColor(ContextCompat.getColor(this, R.color.black));
        layerBantarsariStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerBantarsari.addLayerToMap();
        markerBantarsari();
    }

    public void showMaos (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAOS, 13f));
        GeoJsonLayer layerMaos;
        layerMaos = new GeoJsonLayer(mMap, R.raw.maos, getApplicationContext());
        GeoJsonPolygonStyle layerMaosStyle = layerMaos.getDefaultPolygonStyle();
        layerMaosStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMaosStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerMaos.addLayerToMap();
        markerMaos();
    }
    public void showBinangun (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BINANGUN, 13f));
        GeoJsonLayer layerBinangun;
        layerBinangun = new GeoJsonLayer(mMap, R.raw.binagun, getApplicationContext());
        GeoJsonPolygonStyle layerBinangunStyle = layerBinangun.getDefaultPolygonStyle();
        layerBinangunStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerBinangunStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerBinangun.addLayerToMap();
        markerBinangun();
    }
    public void showClpselatan (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPSELATAN, 13f));
        GeoJsonLayer layerSelatan;
        layerSelatan = new GeoJsonLayer(mMap, R.raw.cilacapselatan, getApplicationContext());
        GeoJsonPolygonStyle layerSelatanStyle = layerSelatan.getDefaultPolygonStyle();
        layerSelatanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerSelatanStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerSelatan.addLayerToMap();
        markerClpSelatan();
    }
    public void showClptengah (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPTENGAH, 13f));
        GeoJsonLayer layerTengah;
        layerTengah = new GeoJsonLayer(mMap, R.raw.cilacaptengah, getApplicationContext());
        GeoJsonPolygonStyle layerTengahStyle = layerTengah.getDefaultPolygonStyle();
        layerTengahStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerTengahStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerTengah.addLayerToMap();
        markerClpTengah();
    }
    public void showClputara (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPUTARA, 13f));
        GeoJsonLayer layerUtara;
        layerUtara = new GeoJsonLayer(mMap, R.raw.cilacaputara, getApplicationContext());
        GeoJsonPolygonStyle layerUtaraStyle = layerUtara.getDefaultPolygonStyle();
        layerUtaraStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerUtaraStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerUtara.addLayerToMap();
        markerClpUtara();
    }
    public void showNusawungu (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NUSAWUNGU, 13f));
        GeoJsonLayer layerNusawungu;
        layerNusawungu = new GeoJsonLayer(mMap, R.raw.nusawungu, getApplicationContext());
        GeoJsonPolygonStyle layerNusawunguStyle = layerNusawungu.getDefaultPolygonStyle();
        layerNusawunguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerNusawunguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerNusawungu.addLayerToMap();
        markerNusawungu();
    }
    public void showCimanggu (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CIMANGGU, 13f));
        GeoJsonLayer layerCimanggu;
        layerCimanggu = new GeoJsonLayer(mMap, R.raw.cimanggu, getApplicationContext());
        GeoJsonPolygonStyle layerCimangguStyle = layerCimanggu.getDefaultPolygonStyle();
        layerCimangguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerCimangguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerCimanggu.addLayerToMap();
        markerCimanggu();
    }
    public void showPatimuan (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAOS, 13f));
        GeoJsonLayer layerPatimuan;
        layerPatimuan = new GeoJsonLayer(mMap, R.raw.patimuan, getApplicationContext());
        GeoJsonPolygonStyle layerPatimuanStyle = layerPatimuan.getDefaultPolygonStyle();
        layerPatimuanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerPatimuanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerPatimuan.addLayerToMap();
        markerPatimuan();
    }
    public void showCipari (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAOS, 13f));
        GeoJsonLayer layerMaos;
        layerMaos = new GeoJsonLayer(mMap, R.raw.maos, getApplicationContext());
        GeoJsonPolygonStyle layerMaosStyle = layerMaos.getDefaultPolygonStyle();
        layerMaosStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMaosStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerMaos.addLayerToMap();
        markerCipari();
    }
    public void showSampang (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAMPANG, 13f));
        GeoJsonLayer layerSampang;
        layerSampang = new GeoJsonLayer(mMap, R.raw.sampang, getApplicationContext());
        GeoJsonPolygonStyle layerSampangStyle = layerSampang.getDefaultPolygonStyle();
        layerSampangStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerSampangStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerSampang.addLayerToMap();
        markerSampang();
    }
    public void showDayeuhluhur (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DAYEUHLUHUR, 13f));
        GeoJsonLayer layerDayeuhluhur;
        layerDayeuhluhur = new GeoJsonLayer(mMap, R.raw.dayeuhluhur, getApplicationContext());
        GeoJsonPolygonStyle layerDayeuhluhurStyle = layerDayeuhluhur.getDefaultPolygonStyle();
        layerDayeuhluhurStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerDayeuhluhurStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerDayeuhluhur.addLayerToMap();
        markerDayeuhluhur();
    }
    public void showGandrungmangu (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GANDRUNGMANGU, 13f));
        GeoJsonLayer layerGandrungmangu;
        layerGandrungmangu = new GeoJsonLayer(mMap, R.raw.gandrungmangu, getApplicationContext());
        GeoJsonPolygonStyle layerGandrungmanguStyle = layerGandrungmangu.getDefaultPolygonStyle();
        layerGandrungmanguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerGandrungmanguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerGandrungmangu.addLayerToMap();
        markerGandrungmangu();
    }
    public void showJeruklegi (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JERUKLEGI, 13f));
        GeoJsonLayer layerJeruklegi;
        layerJeruklegi = new GeoJsonLayer(mMap, R.raw.jeruklegi, getApplicationContext());
        GeoJsonPolygonStyle layerJeruklegiStyle = layerJeruklegi.getDefaultPolygonStyle();
        layerJeruklegiStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerJeruklegiStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerJeruklegi.addLayerToMap();
        markerJeruklegi();
    }
    public void showKplaut (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KAMPUNGLAUT, 13f));
        GeoJsonLayer layerKpLaut;
        layerKpLaut = new GeoJsonLayer(mMap, R.raw.kampunglaut, getApplicationContext());
        GeoJsonPolygonStyle layerKpLautStyle = layerKpLaut.getDefaultPolygonStyle();
        layerKpLautStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKpLautStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKpLaut.addLayerToMap();
        //markerDayeuhluhur();
        markerKpLaut();
    }
    public void showKrpucung (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KARANGPUCUNG, 13f));
        GeoJsonLayer layerKrPucung;
        layerKrPucung = new GeoJsonLayer(mMap, R.raw.karangpucung, getApplicationContext());
        GeoJsonPolygonStyle layerKrPucungStyle = layerKrPucung.getDefaultPolygonStyle();
        layerKrPucungStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKrPucungStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKrPucung.addLayerToMap();
        //markerDayeuhluhur();
        markerKrPucung();
    }
    public void showKawunganten (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KAWUNGANTEN, 13f));
        GeoJsonLayer layerKawunganten;
        layerKawunganten = new GeoJsonLayer(mMap, R.raw.kawunganten, getApplicationContext());
        GeoJsonPolygonStyle layerKawungantenStyle = layerKawunganten.getDefaultPolygonStyle();
        layerKawungantenStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKawungantenStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKawunganten.addLayerToMap();
        //markerDayeuhluhur();
        markerKawunganteng();
    }
    public void showKdreja (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KEDUNGREJA, 13f));
        GeoJsonLayer layerKdreja;
        layerKdreja = new GeoJsonLayer(mMap, R.raw.kedungreja, getApplicationContext());
        GeoJsonPolygonStyle layerKdrejaStyle = layerKdreja.getDefaultPolygonStyle();
        layerKdrejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKdrejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKdreja.addLayerToMap();
        //markerDayeuhluhur();
        markerKdreja();
    }
    public void showKesugihan (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KESUGIHAN, 13f));
        GeoJsonLayer layerKesugihan;
        layerKesugihan = new GeoJsonLayer(mMap, R.raw.kesugihan, getApplicationContext());
        GeoJsonPolygonStyle layerKesugihanStyle = layerKesugihan.getDefaultPolygonStyle();
        layerKesugihanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKesugihanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKesugihan.addLayerToMap();
        //markerDayeuhluhur();
        //layerKesugihan.addLayerToMap();
        markerKesugihan();
    }
    public void showKroya (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KROYA, 13f));
        GeoJsonLayer layerKroya;
        layerKroya = new GeoJsonLayer(mMap, R.raw.kroya, getApplicationContext());
        GeoJsonPolygonStyle layerKroyaStyle = layerKroya.getDefaultPolygonStyle();
        layerKroyaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKroyaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKroya.addLayerToMap();
        //markerDayeuhluhur();
        markerKroya();
    }
    public void showMajenang (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAJENANG, 13f));
        GeoJsonLayer layerMajenang;
        layerMajenang = new GeoJsonLayer(mMap, R.raw.majenang, getApplicationContext());
        GeoJsonPolygonStyle layerMajenangluhurStyle = layerMajenang.getDefaultPolygonStyle();
        layerMajenangluhurStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMajenangluhurStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerMajenang.addLayerToMap();
        //markerDayeuhluhur();
        markerMajenang();
    }
    public void showSidareja (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SIDAREJA, 13f));
        GeoJsonLayer layerSidareja;
        layerSidareja = new GeoJsonLayer(mMap, R.raw.sidareja, getApplicationContext());
        GeoJsonPolygonStyle layerSidarejaStyle = layerSidareja.getDefaultPolygonStyle();
        layerSidarejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerSidarejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerSidareja.addLayerToMap();
        //markerDayeuhluhur();
        markerSidareja();
    }
    public void showWanareja (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WANAREJA, 13f));
        GeoJsonLayer layerWanareja;
        layerWanareja = new GeoJsonLayer(mMap, R.raw.wanareja, getApplicationContext());
        GeoJsonPolygonStyle layerWanarejaStyle = layerWanareja.getDefaultPolygonStyle();
        layerWanarejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerWanarejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerWanareja.addLayerToMap();
        markerDayeuhluhur();
        markerWanareja();
    }

    public void tampilIndustri(View v){
        palaDayeuhluhur();
        kelapaWanareja();
        kelapaKedungreja();
        gulaJeruklegi();
        //udang();
    }
    public void tampilPariwisata(View v){
        airpanascipari();
        hutanpayau();
        sleko();
        momongan();
    }
    public void tampilIkan(View v){
        sidat();
        udang();
    }
    public void tampilTernak(View v){
        sapiDayeuhluhur();
        sapiMajenang();
        sapiWanareja();
        kambingKrpucung();
    }
    private void markerBantarsari() {
        mMap.addMarker(new MarkerOptions()
                .position(BANTARSARI)
                .title("Kecamatan Bantarsari")
                .snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerBinangun() {
        mMap.addMarker(new MarkerOptions()
                .position(BINANGUN)
                .title("Kecamatan Binangun")
                .snippet("Jumlah Penduduk 66.522 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerClpSelatan() {
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPSELATAN)
                .title("Kecamatan Cilacap Selatan")
                .snippet("Jumlah Penduduk 89.709 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerClpTengah() {
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPTENGAH)
                .title("Kecamatan Cilacap Tengah")
                .snippet("Jumlah Penduduk 89.709 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerClpUtara() {
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPUTARA)
                .title("Kecamatan Cilaap Utara")
                .snippet("Jumlah Penduduk 81.524 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerCimanggu() {
        mMap.addMarker(new MarkerOptions()
                .position(CIMANGGU)
                .title("Kecamatan Cimanggu")
                .snippet("Jumlah Penduduk 102.219 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerCipari() {
        mMap.addMarker(new MarkerOptions()
                .position(CIPARI)
                .title("Kecamatan Cipari")
                .snippet("Jumlah Penduduk 64.379 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerDayeuhluhur() {
        mMap.addMarker(new MarkerOptions()
                .position(DAYEUHLUHUR)
                .title("Kecamatan Dayeuhluhur")
                .snippet("Jumlah Penduduk 48.809 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerGandrungmangu() {
        mMap.addMarker(new MarkerOptions()
                .position(GANDRUNGMANGU)
                .title("Kecamatan Gandrungmangu")
                .snippet("Jumlah Penduduk 107.169 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerJeruklegi() {
        mMap.addMarker(new MarkerOptions()
                .position(JERUKLEGI)
                .title("Kecamatan Jeruklegi")
                .snippet("Jumlah Penduduk 7.705 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerKpLaut() {
        mMap.addMarker(new MarkerOptions()
                .position(KAMPUNGLAUT)
                .title("Kecamatan Kampung Laut")
                .snippet("Jumlah Penduduk 15.043 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerKrPucung() {
        mMap.addMarker(new MarkerOptions()
                .position(KARANGPUCUNG)
                .title("Kecamatan Karang Pucung")
                .snippet("Jumlah Penduduk 73.825 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerKawunganteng() {
        mMap.addMarker(new MarkerOptions()
                .position(KAWUNGANTEN)
                .title("Kecamatan Kawunganten")
                .snippet("Jumlah Penduduk 83.753 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerKdreja() {
        mMap.addMarker(new MarkerOptions()
                .position(KEDUNGREJA)
                .title("Kecamatan Kedungreja")
                .snippet("Jumlah Penduduk 84.557 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerKesugihan() {
        mMap.addMarker(new MarkerOptions()
                .position(KESUGIHAN)
                .title("Kecamatan Kesugihan")
                .snippet("Jumlah Penduduk 129.580 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerKroya() {
        mMap.addMarker(new MarkerOptions()
                .position(KROYA)
                .title("Kecamatan Kroya")
                .snippet("Jumlah Penduduk 113.211 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerMajenang() {
        mMap.addMarker(new MarkerOptions()
                .position(MAJENANG)
                .title("Kecamatan Majenang")
                .snippet("Jumlah Penduduk 135.392 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerMaos() {
        mMap.addMarker(new MarkerOptions()
                .position(MAOS)
                .title("Kecamatan Maos")
                .snippet("Jumlah Penduduk 47.006 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerNusawungu() {
        mMap.addMarker(new MarkerOptions()
                .position(NUSAWUNGU)
                .title("Kecamatan Nusawungu")
                .snippet("Jumlah Penduduk 83.184 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerPatimuan() {
        mMap.addMarker(new MarkerOptions()
                .position(PATIMUAN)
                .title("Kecamatan Patimuan")
                .snippet("Jumlah Penduduk 48.728 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerSampang() {
        mMap.addMarker(new MarkerOptions()
                .position(SAMPANG)
                .title("Kecamatan Sampang")
                .snippet("Jumlah Penduduk 42.372 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerSidareja() {
        mMap.addMarker(new MarkerOptions()
                .position(SIDAREJA)
                .title("Kecamatan Sidareja")
                .snippet("Jumlah Penduduk 61.972 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
    }
    private void markerWanareja(){
        mMap.addMarker(new MarkerOptions()
                .position(WANAREJA)
                .title("Kecamatan Wanareja")
                .snippet("Jumlah Penduduk 102.857 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.location))
        );
    }
    private void markerAdipala(){
        mMap.addMarker(new MarkerOptions()
                .position(ADIPALA)
                .title("Kecamatan Adipala")
                .snippet("Jumlah Penduduk 91.069 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.location))
        );
    }
    private void airpanascipari(){
        mMap.addMarker(new MarkerOptions()
                .position(AIRPANASCIPARI)
                .anchor(0.5f, 0.5f)
                .title("Pemandian Air Panas Cipari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpariwisata)));
    }
    private void kelapaWanareja(){
        mMap.addMarker(new MarkerOptions()
                .position(KELAPAWANAREJA)
                .anchor(0.5f, 0.5f)
                .title("Serat Sabut Kelapa Wanareja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconindusti)));
    }
    private void sapiDayeuhluhur(){
        mMap.addMarker(new MarkerOptions()
                .position(SAPIDAYEUHLUHUR)
                .anchor(0.5f, 0.5f)
                .title("Peternakan Sapi Potong Dayeuhluhur")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpeternakan)));
    }
    private void palaDayeuhluhur(){
        mMap.addMarker(new MarkerOptions()
                .title("Industri Terpadu Pengolahan Buah Pala")
                .anchor(0.5f, 0.5f)
                .position(PALADAYEUHLUHUR)
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconindusti)));
    }
    private void sapiMajenang(){
        mMap.addMarker(new MarkerOptions()
                .position(SAPIMAJENANG)
                .anchor(0.5f, 0.5f)
                .title("Peternakan Sapi Potong Majenang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpeternakan)));
    }
    private void sapiWanareja(){
        mMap.addMarker(new MarkerOptions()
                .position(SAPIWANAREJA)
                .anchor(0.5f, 0.5f)
                .title("Peternakan Sapi Potong Wanareja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpeternakan)));
    }
    private void kelapaKedungreja(){
        mMap.addMarker(new MarkerOptions()
                .position(KELAPAWANAREJA)
                .anchor(0.5f, 0.5f)
                .title("Industri Pengolahan Kelapa Terpadu Kedungreja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconindusti)));
    }
    private void kambingKrpucung(){
        mMap.addMarker(new MarkerOptions()
                .position(KAMBINGKRPUCUNG)
                .anchor(0.5f, 0.5f)
                .title("Peternakan Terpadu Kambing Karangpucung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpeternakan)));
    }
    private void gulaJeruklegi(){
        mMap.addMarker(new MarkerOptions()
                .position(GULAJERUKLEGI)
                .anchor(0.5f, 0.5f)
                .title("Pabrik Gula Semut Super Jeruklegi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconindusti)));
    }
    private void hutanpayau(){
        mMap.addMarker(new MarkerOptions()
                .position(HUTANPAYAU)
                .anchor(0.5f, 0.5f)
                .title("Pengembangan Hutan Payau")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpariwisata)));
    }
    private void sidat(){
        mMap.addMarker(new MarkerOptions()
                .position(SIDATCILACAP)
                .anchor(0.5f, 0.5f)
                .title("Budidaya Ikan Sidat Kutawaru")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconperikanan)));
    }
    private void sleko(){
        mMap.addMarker(new MarkerOptions()
                .position(WISATASLEKO)
                .anchor(0.5f, 0.5f)
                .title("Pengembangan Wisata Bahari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpariwisata)));
    }
    private void udang(){
        mMap.addMarker(new MarkerOptions()
                .position(UDANGVANAME)
                .anchor(0.5f, 0.5f)
                .title("Industri Terpadu Udang Vaname")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconindusti)));
    }
    private void momongan(){
        mMap.addMarker(new MarkerOptions()
                .position(WISATAMOMONGAN)
                .anchor(0.5f, 0.5f)
                .title("Pengembangan Wisata Pulau Momongan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.iconpariwisata)));
    }
    private void kelapakedungreja(){
        mMap.addMarker(new MarkerOptions()
                .position(KELAPAKEDUNGREJA)
                .title("Industri Pengolahan Kelapa Terpadu Kedungreja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }
    private void showIndustriAdipala() {
        mMap.addMarker(new MarkerOptions()
                .position(GITARADIPALA)
                .title("Produsen Gitar Suwanto")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(GULAKELAPAADIPALA)
                .title("Gula Kelapa Adipala")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(GULAKRISTALADIPALA)
                .title("Gula Kristal Adipala")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(JIPANGADIPALA)
                .title("Sentra Produksi Jipang Adipala")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(PASARADIPALA)
                .title("Pasar Adipala")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(SALEPISANGADIPALA)
                .title("Pusat Sale Pisang")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(SERIPINGPISANGADIPALA)
                .title("Seriping Pisang Adipala")
                //.snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void  showPertanianAdipala(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.631108, 109.181676))
                .title("Sawah Doplang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.638443, 109.159880))
                .title("Sawah Kalikudi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.645099, 109.155220))
                .title("Sawah Adireja Kulon")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.648369, 109.168641))
                .title("Sawah Adireja Wetan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.654115, 109.185428))
                .title("Sawah Adiraja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.647984, 109.134128))
                .title("Sawah Penggalang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.673058, 109.125714))
                .title("Sawah Kali Wahar")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.673682, 109.113465))
                .title("Sawah Gombolharjo")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.667896, 109.188677))
                .title("Sawah Pedasong")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.690201, 109.228912))
                .title("Sawah Welahan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.687672, 109.201396))
                .title("Sawah Glempang Pasir")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.689791, 109.164633))
                .title("Sawah Bunton")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.682061, 109.171330))
                .title("Sawah Karang Benda")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.676915, 109.166429))
                .title("Sawah Karanganyar")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.654856, 109.149118))
                .title("Sawah Adipal")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.645757, 109.123881))
                .title("Kebun Pepaya Adipala")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
    }
    private void showTernakAdipala(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.654856, 109.149118))
                .title("Peternakan Ayam Randu Alas")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.675991, 109.163003))
                .title("Peternakan Ayam Pesapen")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
            );
    }
    private void showIwakAdipala(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.630546, 109.158209))
                .title("Tambak Lele Adipala")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
            );
    }
    private void showPariwisataAdipala(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.630546, 109.158209))
                .title("Tambak Lele Adipala")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showIndustriBantarsari(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.597413, 108.871285))
                .title("Gula Semut Bantarsari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.529588, 108.854723))
                .title("GPenyamakan Kulit Bantarsari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
    }
    private void showIndustriBinangun(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.672740, 109.239180))
                .title("Gula Merah Binangun")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.682145, 109.260631))
                .title("Kesed Binangun")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
    }
    private void showTaniBinangun(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.684476, 109.255827))
                .title("Budidaya Cabai Binangun")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
    }
    private void showTernakBinangun(){
         mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.686931, 109.267629))
                .title("Peternakan Sapi Mazda Widarapayung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
            );
    }
    private void showIndustriCilsel(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.686931, 109.267629))
                .title("Industri Ikan Asin")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.731097, 109.006004))
                .title("Kerupuk Tengiri")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.733935, 109.020087))
                .title("Sentra Kerajinan Kerang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.714879, 109.009123))
                .title("Industri Terasi Tabita")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.696139, 109.052625))
                .title("Industri Jamur")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
            );
    }
    private void showWisataCilsel(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.733861, 109.021380))
                .title("Wisata Pantai Teluk Penyu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
            );
    }
    private void showIndustriCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.683402, 109.050139))
                .title("Industri Tahu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showTaniCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.676100, 109.0575529))
                .title("Tanaman Pangan lestari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showKebunCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.668063, 109.029229))
                .title("Hutan Mangrove")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showIkanCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.670139, 109.050888))
                .title("Tambak ikan Rawa Bendungan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private  void showWisataCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.667904, 109.029157))
                .title("Wisata Hutan Payau")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIndustriCimanggu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.346965, 108.801338))
                .title("Industri Batu Bata Karangreja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.355175, 108.867509))
                .title("Industri Batu Bata Panimbang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.368371, 108.860414))
                .title("Industri Batu Bata Bantarpanjang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.354891, 108.886535))
                .title("Grosir Sale Pisang Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.326820, 108.800967))
                .title("Industri Sale Pisang Panimbang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.346965, 108.801338))
                .title("Industri Batu Bata Karangreja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.279137, 108.827246))
                .title("Sentral Industri Sale Pisang Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.344123, 108.834561))
                .title("Industri Mebel Cilempuyang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.354742, 108.864315))
                .title("Industri Mebel Bantarpanjang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.364563, 108.860560))
                .title("Industri Mebel Panimbang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.321004, 108.803978))
                .title("Industri Sapu Rejodadi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showTernakCimanggu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.343207, 108.841677))
                .title("Peternakan Sapi Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
    }
    private void showPertanianCimanggu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.278261, 108.884804))
                .title("Perkebuunan Karet Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.276629, 108.892005))
                .title("Perkebuunan Pala Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.248097, 108.808053))
                .title("Perkebuunan Pala Sujati")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.323323, 108.815224))
                .title("Perkebuunan Kelapa Cilempuyang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.311007, 108.831596))
                .title("Perkebuunan Hutan Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showIkanCimanggu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.342256, 108.838223))
                .title("Budidaya Ikan Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        //LatLng cilacap = new LatLng(-7.481717, 108.838529);
        //mMap.addMarker(new MarkerOptions().position(cilacap).title("Cilacap").snippet("Cilacap Bercahaya"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(cilacap));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 1000, null);
        showCilacap(null);

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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        Spinner spinner = (Spinner)parent;
        Spinner spinner1 = (Spinner)parent;
        if (spinner.getId() == R.id.spKecamatan){
            strKecamatan = parent.getSelectedItem().toString();
        }
        else if (spinner1.getId() == R.id.spPotensi){
            strPotensi = parent.getSelectedItem().toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
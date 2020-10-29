package id.co.gesangmultimedia.siapic;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.FloatingWindow;

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
    private FloatingWindow fabBack;
    private int markerclicked;

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

    private static final LatLng MOMONGAN = new LatLng(-7.712007, 109.387234);

    private static final LatLng KELAPAKEDUNGREJA = new LatLng(-7.5015207, 108.7848592);

    private static final LatLng BUNTON = new LatLng(-7.684692, 109.137513);

    private static final LatLng JIPANGADIPALA = new LatLng(-7.651058, 109.127968);
    private static final LatLng GITARADIPALA = new LatLng(-7.632131, 109.146367);
    private static final LatLng PASARADIPALA = new LatLng(-7.660389, 109.151568);
    private static final LatLng GULAKELAPAADIPALA = new LatLng(-7.670830, 109.111700);
    private static final LatLng GULAKRISTALADIPALA = new LatLng( -7.636690, 109.138904);
    private static final LatLng SALEPISANGADIPALA = new LatLng(-7.670583, 109.160941);
    private static final LatLng SERIPINGPISANGADIPALA = new LatLng(-7.662127, 109.175154);

    private static final LatLng BANDARA = new LatLng(-7.642588, 109.034757);
    private static final LatLng PELABUHANTJINTAN = new LatLng(-7.731252, 108.993437);
    private static final LatLng PELABUHANSLEKO = new LatLng(-7.727498, 108.996773);
    private static final LatLng PELABUHANSODONG = new LatLng(-7.681547, 108.979904);
    private static final LatLng TERMINALCILACAP = new LatLng(-7.702289, 109.025086);
    private static final LatLng TERMINALKRPUCUNG = new LatLng(-7.410340, 108.900194);
    private static final LatLng TERMINALSDREJA = new LatLng( -7.485017, 108.791376);
    private static final LatLng STASIUNCILACAP = new LatLng(-7.736042, 109.007054);
    private static final LatLng STASIUNMAOS = new LatLng(-7.619082, 109.139459);
    private static final LatLng STASIUNSDREJA = new LatLng(-7.486329, 108.807540);
    private static final LatLng STASIUNKROYA = new LatLng(-7.630117, 109.253514);
    private static final LatLng STASIUNGDMANGU = new LatLng(-7.528495, 108.859040);
    private static final LatLng TERMINALMAJENANG = new LatLng(-7.303478, 108.771364);

    private static final LatLng SIDATPATIMUAN = new LatLng(-7.596817, 108.799754);
    private static final LatLng UDANGCILSEL = new LatLng(-7.717121, 109.029973);
    private static final LatLng UDANGMERTASINGA = new LatLng(-7.689760, 109.067748);
    private static final LatLng WISATASEGARAANAKAN = new LatLng(-7.676732, 108.831381);
    private static final LatLng WISATAUJUNGALANG = new LatLng(-7.681276, 108.813512);
    private static final LatLng UDANGBINANGUN = new LatLng(-7.692737, 109.293375);
    private static final LatLng WEDUSGNTELU = new LatLng(-7.417377, 108.869263);
    private static final LatLng KELAPATINGGARJAYA = new LatLng(-7.482692,108.774660);




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kecamatan);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        final ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.blinking_anim);


        Spinner spinkecamatan = findViewById(R.id.spKecamatan);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.namakecamatan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinkecamatan.setAdapter(adapter);
        spinkecamatan.setOnItemSelectedListener(this);

        Spinner spinpotensi = findViewById(R.id.spPotensi);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.potensi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinpotensi.setAdapter(adapter1);
        spinpotensi.setOnItemSelectedListener(this);
        Button btnPdf = findViewById(R.id.btnPdf);
        animator.setTarget(btnPdf);

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
                }
                if(strKecamatan.equals("Kecamatan Adipala") && strPotensi.equals("Pariwisata")){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showPariwisataAdipala();
                }
                if(strKecamatan.equals("Kecamatan Adipala") && (strPotensi.equals("Perikanan"))){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIwakAdipala();
                }
                if(strKecamatan.equals("Kecamatan Adipala") && (strPotensi.equals("Pertanian"))){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showPertanianAdipala();
                }
                if(strKecamatan.equals("Kecamatan Adipala") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunAdipala();
                    animator.start();
                }
                if (strKecamatan.equals("Kecamatan Adipala") && (strPotensi.equals("Peternakan"))){
                    try {
                        showAdipala(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakAdipala();
                }
                if(strKecamatan.equals("Kecamatan Bantarsari") && (strPotensi.equals("Industri"))){
                    try {
                        showBantarsari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriBantarsari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Bantarsari") && (strPotensi.equals("Perikaanan"))){
                    try {
                        showBantarsari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanBantarsari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Bantarsari") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showBantarsari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataBantarsari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Bantarsari") && (strPotensi.equals("Pertanian"))){
                    try {
                        showBantarsari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniBantarsari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Bantarsari") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showBantarsari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunAdipala();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Bantarsari") && (strPotensi.equals("Peternakan"))){
                    try {
                        showBantarsari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriBantarsari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Binangun") && (strPotensi.equals("Industri"))){
                    try {
                        showBinangun(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriBinangun();
                }
                if(strKecamatan.equals("Kecamatan Binangun") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showBinangun(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataBinangun();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Binangun") && (strPotensi.equals("Perikanan"))){
                    try {
                        showBinangun(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanBinangun();
                }
                if(strKecamatan.equals("Kecamatan Binangun") && (strPotensi.equals("Pertanian"))){
                    try {
                        showBinangun(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniBinangun();
                }
                if(strKecamatan.equals("Kecamatan Binangun") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showBinangun(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunBinangun();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Binangun") && (strPotensi.equals("Peternakan"))){
                    try {
                        showBinangun(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakBinangun();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Selatan") && (strPotensi.equals("Industri"))){
                    try {
                        showClpselatan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriCilsel();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Selatan") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showClpselatan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataCilsel();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Selatan") && (strPotensi.equals("Perikanan"))){
                    try {
                        showClpselatan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanCilsel();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Selatan") && (strPotensi.equals("Pertanian"))){
                    try {
                        showClpselatan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniCilsel();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Selatan") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showClpselatan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunCilsel();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Selatan") && (strPotensi.equals("Peternakan"))){
                    try {
                        showClpselatan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakCilsel();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Tengah") && (strPotensi.equals("Industri"))){
                    try {
                        showClptengah(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriCilteng();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Tengah") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showClptengah(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataCilteng();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Tengah") && (strPotensi.equals("Perikanan"))){
                    try {
                        showClptengah(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanCilteng();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Tengah") && (strPotensi.equals("Pertanian"))){
                    try {
                        showClptengah(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniCilteng();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Tengah") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showClptengah(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunCilteng();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Tengah") && (strPotensi.equals("Peternakan"))){
                    try {
                        showClptengah(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakCilteng();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Utara") && (strPotensi.equals("Industri"))){
                    try {
                        showClputara(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriCilut();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Utara") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showClputara(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataCilut();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Utara") && (strPotensi.equals("Perikanan"))){
                    try {
                        showClputara(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanCilut();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Utara") && (strPotensi.equals("Pertanian"))){
                    try {
                        showClputara(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniCilut();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Utara") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showClputara(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunCilut();
                }
                if(strKecamatan.equals("Kecamatan Cilacap Utara") && (strPotensi.equals("Peternakan"))){
                    try {
                        showClputara(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakCilut();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cimanggu") && (strPotensi.equals("Industri"))){
                    try {
                        showCimanggu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriCimanggu();
                }
                if(strKecamatan.equals("Kecamatan Cimanggu") && (strPotensi.equals("Industri"))){
                    try {
                        showCimanggu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataCimanggu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cimanggu") && (strPotensi.equals("Perikanan"))){
                    try {
                        showCimanggu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunCimanggu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cimanggu") && (strPotensi.equals("Pertanian"))){
                    try {
                        showCimanggu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showPertanianCimanggu();
                }
                if(strKecamatan.equals("Kecamatan Cimanggu") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showCimanggu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunCimanggu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cimanggu") && (strPotensi.equals("Peternakan"))){
                    try {
                        showCimanggu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakCimanggu();
                }
                if(strKecamatan.equals("Kecamatan Cipari") && (strPotensi.equals("Industri"))){
                    try {
                        showCipari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriCipari();
                }
                if(strKecamatan.equals("Kecamatan Cipari") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showCipari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showPariwisataCipari();
                }
                if(strKecamatan.equals("Kecamatan Cipari") && (strPotensi.equals("Perikanan"))){
                    try {
                        showCipari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanCipari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cipari") && (strPotensi.equals("Pertanian"))){
                    try {
                        showCipari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniCipari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cipari") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showCipari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunCipari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Cipari") && (strPotensi.equals("Peternakan"))){
                    try {
                        showCipari(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakCipari();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Dayeuhluhur") && (strPotensi.equals("Industri"))){
                    try {
                        showDayeuhluhur(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriDayeuhluhur();
                }
                if(strKecamatan.equals("Kecamatan Dayeuhluhur") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showDayeuhluhur(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataDayeuhluhur();
                }
                if(strKecamatan.equals("Kecamatan Dayeuhluhur") && (strPotensi.equals("Perikanan"))){
                    try {
                        showDayeuhluhur(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanDayeuhluhur();
                }
                if(strKecamatan.equals("Kecamatan Dayeuhluhur") && (strPotensi.equals("Pertanian"))){
                    try {
                        showDayeuhluhur(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniDayeuhluhur();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Dayeuhluhur") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showDayeuhluhur(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunDayeuhluhur();
                }
                if(strKecamatan.equals("Kecamatan Dayeuhluhur") && (strPotensi.equals("Peternakan"))){
                    try {
                        showDayeuhluhur(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakDayeuhluhur();
                }
                if(strKecamatan.equals("Kecamatan Gandrungmangu") && (strPotensi.equals("Industri"))){
                    try {
                        showGandrungmangu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriGandrungmangu();
                }
                if(strKecamatan.equals("Kecamatan Gandrungmangu") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showGandrungmangu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataGandrungmangu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Gandrungmangu") && (strPotensi.equals("Perikanan"))){
                    try {
                        showGandrungmangu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanGandrungmangu();
                }
                if(strKecamatan.equals("Kecamatan Gandrungmangu") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showGandrungmangu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunGandrungmangu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Gandrungmangu") && (strPotensi.equals("Pertanian"))){
                    try {
                        showGandrungmangu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniGandrungmangu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Gandrungmangu") && (strPotensi.equals("Peternakan"))){
                    try {
                        showGandrungmangu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakGandrungmangu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Jeruklegi") && (strPotensi.equals("Industri"))){
                    try {
                        showJeruklegi(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriJeruklegi();
                }
                if(strKecamatan.equals("Kecamatan Jeruklegi") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showJeruklegi(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataJeruklegi();
                }
                if(strKecamatan.equals("Kecamatan Jeruklegi") && (strPotensi.equals("Perikanan"))){
                    try {
                        showJeruklegi(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanJerukLego();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Jeruklegi") && (strPotensi.equals("Pertanian"))){
                    try {
                        showJeruklegi(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniJeruklegi();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Jeruklegi") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showJeruklegi(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showPerkebunanJeruklegi();
                }
                if(strKecamatan.equals("Kecamatan Jeruklegi") && (strPotensi.equals("Peternakan"))){
                    try {
                        showJeruklegi(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakJeruklegi();
                }
                if(strKecamatan.equals("Kecamatan Kampung Laut") && (strPotensi.equals("Industri"))){
                    try {
                        showKplaut(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriKpLaut();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kampung Laut") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showKplaut(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataKpLaut();
                }
                if(strKecamatan.equals("Kecamatan Kampung Laut") && (strPotensi.equals("Perikanan"))){
                    try {
                        showKplaut(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanKpLaut();
                }
                if(strKecamatan.equals("Kecamatan Kampung Laut") && (strPotensi.equals("Pertanian"))){
                    try {
                        showKplaut(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniKpLaut();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kampung Laut") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showKplaut(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunKpLaut();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kampung Laut") && (strPotensi.equals("Peternakan"))){
                    try {
                        showKplaut(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakKpLaut();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Karangpucung") && (strPotensi.equals("Industri"))){
                    try {
                        showKrpucung(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriKrPucung();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Karangpucung") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showKrpucung(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataKrpucung();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Karangpucung") && (strPotensi.equals("Perikanan"))){
                    try {
                        showKrpucung(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanKrPucung();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Karangpucung") && (strPotensi.equals("Pertanian"))){
                    try {
                        showKrpucung(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniKrPucung();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Karangpucung") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showKrpucung(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunKrPucung();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Karangpucung") && (strPotensi.equals("Peternakan"))){
                    try {
                        showKrpucung(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakKrPucung();
                }
                if(strKecamatan.equals("Kecamatan Kawunganten") && (strPotensi.equals("Industri"))){
                    try {
                        showKawunganten(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriKawunganten();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kawunganten") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showKawunganten(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataKawunganten();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kawunganten") && (strPotensi.equals("Perikanan"))){
                    try {
                        showKawunganten(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanKawunganten();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kawunganten") && (strPotensi.equals("Pertanian"))){
                    try {
                        showKawunganten(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniKawunganten();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kawunganten") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showKawunganten(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunKawunganten();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kawunganten") && (strPotensi.equals("Peternakan"))){
                    try {
                        showKawunganten(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakKawunganten();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kedungreja") && (strPotensi.equals("Industri"))){
                    try {
                        showKdreja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriKdReja();
                }
                if(strKecamatan.equals("Kecamatan Kedungreja") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showKdreja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataKdReja();
                }
                if(strKecamatan.equals("Kecamatan Kedungreja") && (strPotensi.equals("Perikanan"))){
                    try {
                        showKdreja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanKdReja();
                }
                if(strKecamatan.equals("Kecamatan Kedungreja") && (strPotensi.equals("Pertanian"))){
                    try {
                        showKdreja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniKdReja();
                }
                if(strKecamatan.equals("Kecamatan Kedungreja") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showKdreja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunKdreja();
                }
                if(strKecamatan.equals("Kecamatan Kedungreja") && (strPotensi.equals("Ternak"))){
                    try {
                        showKdreja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakKdReja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kesugihan") && (strPotensi.equals("Industri"))){
                    try {
                        showKesugihan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriKesugiihan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kesugihan") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showKesugihan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataKesugihan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kesugihan") && (strPotensi.equals("Perikanan"))){
                    try {
                        showKesugihan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanKesugihan();
                }
                if(strKecamatan.equals("Kecamatan Kesugihan") && (strPotensi.equals("Pertanian"))){
                    try {
                        showKesugihan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniKesugihan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kesugihan") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showKesugihan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunKEsugihan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kesugihan") && (strPotensi.equals("Peternakan"))){
                    try {
                        showKesugihan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakKesugihan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kroya") && (strPotensi.equals("Industri"))){
                    try {
                        showKroya(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriKroya();
                }
                if(strKecamatan.equals("Kecamatan Kroya") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showKroya(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataKroya();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kroya") && (strPotensi.equals("Perikanan"))){
                    try {
                        showKroya(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanKroya();
                }
                if(strKecamatan.equals("Kecamatan Kroya") && (strPotensi.equals("Pertanian"))){
                    try {
                        showKroya(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniKroya();
                }
                if(strKecamatan.equals("Kecamatan Kroya") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showKroya(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunKroya();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Kroya") && (strPotensi.equals("Peternakan"))){
                    try {
                        showKroya(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakKroya();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Majenang") && (strPotensi.equals("Industri"))){
                    try {
                        showMajenang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriMajenang();
                }
                if(strKecamatan.equals("Kecamatan Majenang") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showMajenang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataMajenang();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Majenang") && (strPotensi.equals("Perikanan"))){
                    try {
                        showMajenang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanMajenang();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Majenang") && (strPotensi.equals("Pertanian"))){
                    try {
                        showMajenang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniMajenang();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Majenang") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showMajenang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunMajenang();
                }
                if(strKecamatan.equals("Kecamatan Majenang") && (strPotensi.equals("Peternakan"))){
                    try {
                        showMajenang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakMajenang();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Peternakan"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriMaos();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Industri"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriMaos();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataMaos();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Perikanan"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanMaos();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Pertanian"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniMaos();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunMaos();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Maos") && (strPotensi.equals("Peternakan"))){
                    try {
                        showMaos(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakMaos();
                }
                if(strKecamatan.equals("Kecamatan Nusawungu") && (strPotensi.equals("Industri"))){
                    try {
                        showNusawungu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriNusawungu();
                }
                if(strKecamatan.equals("Kecamatan Nusawungu") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showNusawungu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataNusawungu();
                }
                if(strKecamatan.equals("Kecamatan Nusawungu") && (strPotensi.equals("Perikanan"))){
                    try {
                        showNusawungu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanNusawungu();
                }
                if(strKecamatan.equals("Kecamatan Nusawungu") && (strPotensi.equals("Pertanian"))){
                    try {
                        showNusawungu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniNusawungu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Nusawungu") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showNusawungu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunNusawungu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Nusawungu") && (strPotensi.equals("Peternakan"))){
                    try {
                        showNusawungu(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakNusawungu();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Patimuan") && (strPotensi.equals("Industri"))){
                    try {
                        showPatimuan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriPatimuan();
                }
                if(strKecamatan.equals("Kecamatan Patimuan") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showPatimuan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataPatimuan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Patimuan") && (strPotensi.equals("Perikanan"))){
                    try {
                        showPatimuan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanPatimuan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Patimuan") && (strPotensi.equals("Pertanian"))){
                    try {
                        showPatimuan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniPatimuan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Patimuan") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showPatimuan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunPatimuan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Patimuan") && (strPotensi.equals("Peternakan"))){
                    try {
                        showPatimuan(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakPatimuan();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sampang") && (strPotensi.equals("Industri"))){
                    try {
                        showSampang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriSampang();
                }
                if(strKecamatan.equals("Kecamatan Sampang") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showSampang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataSampang();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sampang") && (strPotensi.equals("Perikanan"))){
                    try {
                        showSampang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanSampang();
                }
                if(strKecamatan.equals("Kecamatan Sampang") && (strPotensi.equals("Pertanian"))){
                    try {
                        showSampang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniSampang();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sampang") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showSampang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunSampang();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sampang") && (strPotensi.equals("Peternakan"))){
                    try {
                        showSampang(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakSampang();
                }
                if(strKecamatan.equals("Kecamatan Sidareja") && (strPotensi.equals("Industri"))){
                    try {
                        showSidareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriSidareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sidareja") && (strPotensi.equals("Wisata"))){
                    try {
                        showSidareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataSidareja();
                }
                if(strKecamatan.equals("Kecamatan Sidareja") && (strPotensi.equals("Pertanian"))){
                    try {
                        showSidareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniSidareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sidareja") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showSidareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunSidareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sidareja") && (strPotensi.equals("Perikanan"))){
                    try {
                        showSidareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanSidareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Sidareja") && (strPotensi.equals("Peternakan"))){
                    try {
                        showSidareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakSidareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Wanareja") && (strPotensi.equals("Industri"))){
                    try {
                        showWanareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIndustriWanareja();
                }
                if(strKecamatan.equals("Kecamatan Wanareja") && (strPotensi.equals("Pariwisata"))){
                    try {
                        showWanareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showWisataWanareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Wanareja") && (strPotensi.equals("Perikanan"))){
                    try {
                        showWanareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showIkanWanareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Wanareja") && (strPotensi.equals("Pertanian"))){
                    try {
                        showWanareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTaniWanareja();
                    animator.start();
                }
                if(strKecamatan.equals("Kecamatan Wanareja") && (strPotensi.equals("Perkebunan"))){
                    try {
                        showWanareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showKebunWanareja();
                }
                if(strKecamatan.equals("Kecamatan Wanareja") && (strPotensi.equals("Peternakan"))){
                    try {
                        showWanareja(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    showTernakWanareja();
                }
            }
        });
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.end();
                animator.cancel();
                Intent pdf = new Intent(DataKecamatan.this, ShowPdf.class);
                pdf.putExtra("judul", strKecamatan);
                startActivity(pdf);
            }
        });

    }

    private void showTernakKdReja() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }

    private void showWisataKawunganten() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanKawunganten (){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniKawunganten(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunKawunganten(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakKawunganten(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriKawunganten() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }

    private void showIkanWanareja() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }

    private void showKebunSidareja() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }

    private void showIkanPatimuan() {
        mMap.addMarker(new MarkerOptions()
                .position(SIDATPATIMUAN)
                .title("Keris Jateng: Sidat Patimuan")
                .snippet("Nilai Investasi Rp. 3.555.952.133,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }

    private void showIkanMajenang() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }

    private void showIkanJerukLego() {
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }

    public void showCilacap(View v){
        if (mMap == null) {
            return;
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAP, 9f));

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
        showallmarker();
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BANTARSARI, 12f));
        GeoJsonLayer layerBantarsari;
        layerBantarsari =new GeoJsonLayer(mMap, R.raw.bantarsari, getApplicationContext());
        GeoJsonPolygonStyle layerBantarsariStyle = layerBantarsari.getDefaultPolygonStyle();
        layerBantarsariStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerBantarsariStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerBantarsari.addLayerToMap();
        markerBantarsari();
    }

    public void showMaos (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAOS, 12f));
        GeoJsonLayer layerMaos;
        layerMaos = new GeoJsonLayer(mMap, R.raw.maos, getApplicationContext());
        GeoJsonPolygonStyle layerMaosStyle = layerMaos.getDefaultPolygonStyle();
        layerMaosStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMaosStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerMaos.addLayerToMap();
        markerMaos();
    }
    public void showBinangun (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BINANGUN, 12f));
        GeoJsonLayer layerBinangun;
        layerBinangun = new GeoJsonLayer(mMap, R.raw.binagun, getApplicationContext());
        GeoJsonPolygonStyle layerBinangunStyle = layerBinangun.getDefaultPolygonStyle();
        layerBinangunStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerBinangunStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerBinangun.addLayerToMap();
        markerBinangun();
    }
    public void showClpselatan (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPSELATAN, 12f));
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPTENGAH, 12f));
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAPUTARA, 12f));
        GeoJsonLayer layerUtara;
        layerUtara = new GeoJsonLayer(mMap, R.raw.cilacaputara, getApplicationContext());
        GeoJsonPolygonStyle layerUtaraStyle = layerUtara.getDefaultPolygonStyle();
        layerUtaraStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerUtaraStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerUtara.addLayerToMap();
        markerClpUtara();
    }
    public void showNusawungu (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NUSAWUNGU, 12f));
        GeoJsonLayer layerNusawungu;
        layerNusawungu = new GeoJsonLayer(mMap, R.raw.nusawungu, getApplicationContext());
        GeoJsonPolygonStyle layerNusawunguStyle = layerNusawungu.getDefaultPolygonStyle();
        layerNusawunguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerNusawunguStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerNusawungu.addLayerToMap();
        markerNusawungu();
    }
    public void showCimanggu (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CIMANGGU, 12f));
        GeoJsonLayer layerCimanggu;
        layerCimanggu = new GeoJsonLayer(mMap, R.raw.cimanggu, getApplicationContext());
        GeoJsonPolygonStyle layerCimangguStyle = layerCimanggu.getDefaultPolygonStyle();
        layerCimangguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerCimangguStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerCimanggu.addLayerToMap();
        markerCimanggu();
    }
    public void showPatimuan (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PATIMUAN, 12f));
        GeoJsonLayer layerPatimuan;
        layerPatimuan = new GeoJsonLayer(mMap, R.raw.patimuan, getApplicationContext());
        GeoJsonPolygonStyle layerPatimuanStyle = layerPatimuan.getDefaultPolygonStyle();
        layerPatimuanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerPatimuanStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerPatimuan.addLayerToMap();
        markerPatimuan();
    }
    public void showCipari (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CIPARI, 12f));
        GeoJsonLayer layerMaos;
        layerMaos = new GeoJsonLayer(mMap, R.raw.cipari, getApplicationContext());
        GeoJsonPolygonStyle layerMaosStyle = layerMaos.getDefaultPolygonStyle();
        layerMaosStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMaosStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerMaos.addLayerToMap();
        markerCipari();
    }
    public void showSampang (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAMPANG, 12f));
        GeoJsonLayer layerSampang;
        layerSampang = new GeoJsonLayer(mMap, R.raw.sampang, getApplicationContext());
        GeoJsonPolygonStyle layerSampangStyle = layerSampang.getDefaultPolygonStyle();
        layerSampangStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerSampangStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerSampang.addLayerToMap();
        markerSampang();
    }
    public void showDayeuhluhur (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DAYEUHLUHUR, 12f));
        GeoJsonLayer layerDayeuhluhur;
        layerDayeuhluhur = new GeoJsonLayer(mMap, R.raw.dayeuhluhur, getApplicationContext());
        GeoJsonPolygonStyle layerDayeuhluhurStyle = layerDayeuhluhur.getDefaultPolygonStyle();
        layerDayeuhluhurStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerDayeuhluhurStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerDayeuhluhur.addLayerToMap();
        markerDayeuhluhur();
    }
    public void showGandrungmangu (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GANDRUNGMANGU, 12f));
        GeoJsonLayer layerGandrungmangu;
        layerGandrungmangu = new GeoJsonLayer(mMap, R.raw.gandrungmangu, getApplicationContext());
        GeoJsonPolygonStyle layerGandrungmanguStyle = layerGandrungmangu.getDefaultPolygonStyle();
        layerGandrungmanguStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerGandrungmanguStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerGandrungmangu.addLayerToMap();
        markerGandrungmangu();
    }
    public void showJeruklegi (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JERUKLEGI, 12f));
        GeoJsonLayer layerJeruklegi;
        layerJeruklegi = new GeoJsonLayer(mMap, R.raw.jeruklegi, getApplicationContext());
        GeoJsonPolygonStyle layerJeruklegiStyle = layerJeruklegi.getDefaultPolygonStyle();
        layerJeruklegiStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerJeruklegiStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerJeruklegi.addLayerToMap();
        markerJeruklegi();
    }
    public void showKplaut (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KAMPUNGLAUT, 11f));
        GeoJsonLayer layerKpLaut;
        layerKpLaut = new GeoJsonLayer(mMap, R.raw.kampunglaut, getApplicationContext());
        GeoJsonPolygonStyle layerKpLautStyle = layerKpLaut.getDefaultPolygonStyle();
        layerKpLautStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKpLautStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKpLaut.addLayerToMap();
        //markerDayeuhluhur();
        markerKpLaut();
    }
    public void showKrpucung (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KARANGPUCUNG, 11f));
        GeoJsonLayer layerKrPucung;
        layerKrPucung = new GeoJsonLayer(mMap, R.raw.karangpucung, getApplicationContext());
        GeoJsonPolygonStyle layerKrPucungStyle = layerKrPucung.getDefaultPolygonStyle();
        layerKrPucungStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKrPucungStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKrPucung.addLayerToMap();
        //markerDayeuhluhur();
        markerKrPucung();
    }
    public void showKawunganten (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KAWUNGANTEN, 11f));
        GeoJsonLayer layerKawunganten;
        layerKawunganten = new GeoJsonLayer(mMap, R.raw.kawunganten, getApplicationContext());
        GeoJsonPolygonStyle layerKawungantenStyle = layerKawunganten.getDefaultPolygonStyle();
        layerKawungantenStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKawungantenStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKawunganten.addLayerToMap();
        //markerDayeuhluhur();
        markerKawunganteng();
    }
    public void showKdreja (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KEDUNGREJA, 11f));
        GeoJsonLayer layerKdreja;
        layerKdreja = new GeoJsonLayer(mMap, R.raw.kedungreja, getApplicationContext());
        GeoJsonPolygonStyle layerKdrejaStyle = layerKdreja.getDefaultPolygonStyle();
        layerKdrejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKdrejaStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKdreja.addLayerToMap();
        //markerDayeuhluhur();
        markerKdreja();
    }
    public void showKesugihan (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KESUGIHAN, 11f));
        GeoJsonLayer layerKesugihan;
        layerKesugihan = new GeoJsonLayer(mMap, R.raw.kesugihan, getApplicationContext());
        GeoJsonPolygonStyle layerKesugihanStyle = layerKesugihan.getDefaultPolygonStyle();
        layerKesugihanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKesugihanStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KROYA, 11f));
        GeoJsonLayer layerKroya;
        layerKroya = new GeoJsonLayer(mMap, R.raw.kroya, getApplicationContext());
        GeoJsonPolygonStyle layerKroyaStyle = layerKroya.getDefaultPolygonStyle();
        layerKroyaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKroyaStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerKroya.addLayerToMap();
        //markerDayeuhluhur();
        markerKroya();
    }
    public void showMajenang (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAJENANG, 11f));
        GeoJsonLayer layerMajenang;
        layerMajenang = new GeoJsonLayer(mMap, R.raw.majenang, getApplicationContext());
        GeoJsonPolygonStyle layerMajenangluhurStyle = layerMajenang.getDefaultPolygonStyle();
        layerMajenangluhurStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMajenangluhurStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerMajenang.addLayerToMap();
        //markerDayeuhluhur();
        markerMajenang();
    }
    public void showSidareja (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SIDAREJA, 11f));
        GeoJsonLayer layerSidareja;
        layerSidareja = new GeoJsonLayer(mMap, R.raw.sidareja, getApplicationContext());
        GeoJsonPolygonStyle layerSidarejaStyle = layerSidareja.getDefaultPolygonStyle();
        layerSidarejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerSidarejaStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerSidareja.addLayerToMap();
        //markerDayeuhluhur();
        markerSidareja();
    }
    public void showWanareja (View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.clear();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WANAREJA, 11f));
        GeoJsonLayer layerWanareja;
        layerWanareja = new GeoJsonLayer(mMap, R.raw.wanareja, getApplicationContext());
        GeoJsonPolygonStyle layerWanarejaStyle = layerWanareja.getDefaultPolygonStyle();
        layerWanarejaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerWanarejaStyle.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        layerWanareja.addLayerToMap();
        markerDayeuhluhur();
        markerWanareja();
    }
    private void markerBantarsari() {
        mMap.addMarker(new MarkerOptions()
                .position(BANTARSARI)
                .title("Kecamatan Bantarsari")
                .snippet("Luas wilayah :95,54 km2, Jumlah angkatan kerja : 44.173 orang")
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
    private void showallmarker (){
        mMap.addMarker(new MarkerOptions()
                .position(BANTARSARI)
                .title("Kecamatan Bantarsari")
                .snippet("Jumlah Penduduk 71.383 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(BINANGUN)
                .title("Kecamatan Binangun")
                .snippet("Jumlah Penduduk 66.522 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPSELATAN)
                .title("Kecamatan Cilacap Selatan")
                .snippet("Jumlah Penduduk 89.709 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPTENGAH)
                .title("Kecamatan Cilacap Tengah")
                .snippet("Jumlah Penduduk 89.709 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(CILACAPUTARA)
                .title("Kecamatan Cilaap Utara")
                .snippet("Jumlah Penduduk 81.524 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(CIMANGGU)
                .title("Kecamatan Cimanggu")
                .snippet("Jumlah Penduduk 102.219 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(CIPARI)
                .title("Kecamatan Cipari")
                .snippet("Jumlah Penduduk 64.379 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(DAYEUHLUHUR)
                .title("Kecamatan Dayeuhluhur")
                .snippet("Jumlah Penduduk 48.809 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(GANDRUNGMANGU)
                .title("Kecamatan Gandrungmangu")
                .snippet("Jumlah Penduduk 107.169 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(JERUKLEGI)
                .title("Kecamatan Jeruklegi")
                .snippet("Jumlah Penduduk 7.705 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KAMPUNGLAUT)
                .title("Kecamatan Kampung Laut")
                .snippet("Jumlah Penduduk 15.043 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KARANGPUCUNG)
                .title("Kecamatan Karang Pucung")
                .snippet("Jumlah Penduduk 73.825 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KAWUNGANTEN)
                .title("Kecamatan Kawunganten")
                .snippet("Jumlah Penduduk 83.753 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KEDUNGREJA)
                .title("Kecamatan Kedungreja")
                .snippet("Jumlah Penduduk 84.557 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KESUGIHAN)
                .title("Kecamatan Kesugihan")
                .snippet("Jumlah Penduduk 129.580 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KROYA)
                .title("Kecamatan Kroya")
                .snippet("Jumlah Penduduk 113.211 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(MAJENANG)
                .title("Kecamatan Majenang")
                .snippet("Jumlah Penduduk 135.392 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(MAOS)
                .title("Kecamatan Maos")
                .snippet("Jumlah Penduduk 47.006 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(NUSAWUNGU)
                .title("Kecamatan Nusawungu")
                .snippet("Jumlah Penduduk 83.184 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(PATIMUAN)
                .title("Kecamatan Patimuan")
                .snippet("Jumlah Penduduk 48.728 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(SAMPANG)
                .title("Kecamatan Sampang")
                .snippet("Jumlah Penduduk 42.372 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(SIDAREJA)
                .title("Kecamatan Sidareja")
                .snippet("Jumlah Penduduk 61.972 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WANAREJA)
                .title("Kecamatan Wanareja")
                .snippet("Jumlah Penduduk 102.857 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.location))
        );
        mMap.addMarker(new MarkerOptions()
                .position(ADIPALA)
                .title("Kecamatan Adipala")
                .snippet("Jumlah Penduduk 91.069 orang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.location))
        );
    }
    private void showIndustriAdipala() {
        mMap.addMarker(new MarkerOptions()
                .position(GITARADIPALA)
                .title("Produsen Gitar Suwanto")
                .snippet("Kemungkinan Pengembangan Investasi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(GULAKELAPAADIPALA)
                .title("Gula Kelapa Adipala")
                .snippet("Pengembangan Industri dengan memperluas pasar")
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
                .snippet("Perluasan Industri dengan Teknologi Tepat Guna")
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
                .snippet("Kemungkinan Pengembangan dengan menambah pasar")
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
                .position(new LatLng(-7.682109, 109.178511))
                .title("Wisata Gunung Selok")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void  showKebunAdipala(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
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
    private void showWisataBantarsari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanBantarsari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniBantarsari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunBantarsari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakBantarsari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
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
    private void showWisataBinangun(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanBinangun(){
        mMap.addMarker(new MarkerOptions()
                .position(UDANGVANAME)
                .title("Udang Vaname Binangun")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(UDANGBINANGUN)
                .title("Keris Jateng: Tambak Udang Binangun")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showTaniBinangun(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.684476, 109.255827))
                .title("Budidaya Cabai Binangun")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
            );
    }
    private void showKebunBinangun(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
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
        mMap.addMarker(new MarkerOptions()
                .position(UDANGCILSEL)
                .title("Industri Udang Tegal Kamulyan")
                .snippet("Industri Udang Tegal Kamulyan Cilacap Selatan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showWisataCilsel(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.733861, 109.021380))
                .title("Wisata Pantai Teluk Penyu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
            );
        mMap.addMarker(new MarkerOptions()
                .position(WISATASLEKO)
                .title("Wisata Bahari Sleko")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIkanCilsel(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniCilsel(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunCilsel(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakCilsel(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.683402, 109.050139))
                .title("Industri Tahu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(UDANGMERTASINGA)
                .title("Keris Jateng: Industri Udang Vaname Mertasinga")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showIndustriCilteng(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showWisataCilteng(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniCilteng(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanCilteng(){
        mMap.addMarker(new MarkerOptions()
                .position(SIDATCILACAP)
                .title("Sidat Kutawaru")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showKebunCilteng(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakCilteng(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private  void showWisataCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(HUTANPAYAU)
                .title("Wisata Hutan Payau")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIkanCilut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.670139, 109.050888))
                .title("Tambak ikan Rawa Bendungan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
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
    private void showTernakCilut(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
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
    private void showWisataCimanggu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanCimanggu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.342256, 108.838223))
                .title("Budidaya Ikan Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
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
    private void showKebunCimanggu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakCimanggu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.343207, 108.841677))
                .title("Peternakan Sapi Cimanggu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
    }
    private void showIndustriCipari(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.427304, 108.742122))
                .title("Industri Gula Semut Cipari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showPariwisataCipari(){
        mMap.addMarker(new MarkerOptions()
                .position(AIRPANASCIPARI)
                .title("Keris Jateng : Wisata Air Panas Cipari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showIkanCipari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniCipari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunCipari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakCipari(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void  showIndustriDayeuhluhur(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.304704, 108.573783))
                .title("Industri Air Isi Ulang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.223771, 108.610048))
                .title("Industri Penggergajian Kayu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.223501, 108.598648))
                .title("Industri Penggilingan Padi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.334622, 108.584097))
                .title("Industri Sale Pisang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private  void showWisataDayeuhluhur(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.180636, 108.631447))
                .title("Wisata Curug Kembar")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.170381, 108.635385))
                .title("Wisata Gua Basma")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.217759, 108.608415))
                .title("Wisata Curug Cimandaway")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.332060, 108.585592))
                .title("Wisata Air Panas Ki Jantara")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIkanDayeuhluhur(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniDayeuhluhur(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunDayeuhluhur(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.260279, 108.613382))
                .title("Sentra Benih Tanaman Sayur")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.286643, 108.591685))
                .title("Sentra Benih Tanaman Buah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.186024, 108.624332))
                .title("Perkebunan Kopi Cilumping")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.332060, 108.585592))
                .title("Wisata Air Panas Ki Jantara")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.227821, 108.631962))
                .title("Perkebunan Lada")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(PALADAYEUHLUHUR)
                .title("Perkebunan Pala")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showTernakDayeuhluhur(){
        mMap.addMarker(new MarkerOptions()
                .position(SAPIDAYEUHLUHUR)
                .title("Peternakan Sapi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.283310, 108.599943))
                .title("Peternakan Kambing Domba")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.306029, 108.585687))
                .title("Peternakan Kerbau")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
    }
    private void showIndustriGandrungmangu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.482759, 108.826076))
                .title("Industri Knalpot Wringinharjo")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataGandrungmangu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanGandrungmangu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(
                        -7.575065, 108.814021))
                .title("Tambak Sidat Tumpangsari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniGandrungmangu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunGandrungmangu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakGandrungmangu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.505771, 108.774712))
                .title("Keris Jateng: Peternakan Sapi Gandrungmangu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
                );
    }
    private void showIndustriJeruklegi(){
      mMap.addMarker(new MarkerOptions()
                .position(GULAJERUKLEGI)
                .title("Industri Gula Semut Jeruklegi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.654630, 109.041193))
                .title("Industri Gula Semut Jeruklegi")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.543621, 108.993917))
                .title("Industri Gula Kristal")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.564782, 109.003718))
                .title("Industri Rumahan Tempe Prapagan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.569980, 108.997351))
                .title("Industri Rumahan Tempe Tanjungsari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.591727, 109.016444))
                .title("Industri Kayu Mebel")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataJeruklegi(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.558968, 109.031758))
                .title("Bumi Perkemahan Jambusari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.590507, 109.054299))
                .title("Wisata Curug Mandala")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.538315, 108.993718))
                .title("Wisata Curug Citepus")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showTaniJeruklegi(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showPerkebunanJeruklegi(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.633597, 108.998359))
                .title("Perkebunan Jeruk")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.634558, 108.998600))
                .title("Perkebunan Sawo")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.629888, 109.053143))
                .title("Perkebunan Lesung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.579571, 109.044565))
                .title("Perkebunan Karangkemiri")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.593318, 109.064807))
                .title("Perkebunan Planjar")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.627391, 109.027713))
                .title("Hutan Rakyat")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.583410, 108.987832))
                .title("Bukit Hutan Sawangan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.548878, 109.007167))
                .title("Hutan Prapagan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.539031, 108.986200))
                .title("Hutan Citepus")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showTernakJeruklegi(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriKpLaut(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showWisataKpLaut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(7.708564, 108.880613))
                .title("Wisata Tanjung Mina")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.705821, 108.870592))
                .title("Wisata Jembatan Apung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WISATASEGARAANAKAN)
                .title("Keris Jateng: Wisata Bahari Segara ANakan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WISATAUJUNGALANG)
                .title("Keris Jateng: Wisata Bahari Ujung Alang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showIkanKpLaut(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.670176, 108.895601))
                .title("Tambak Ikan dan Bandeng")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniKpLaut(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunKpLaut(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakKpLaut(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriKdReja() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.494068, 108.768923))
                .title("Industri Batu Bata Bangunreja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.436891, 108.833404))
                .title("Industri Batu Bata Penyarang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.514792, 108.740005))
                .title("Industri Gula Merah Sidasari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.524076, 108.777396))
                .title("Industri Gula Merah Tambak Reja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.495867, 108.803682))
                .title("Sentra Industri Lanting")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.515856, 108.743889))
                .title("Industri Sale Pisang Klepusari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataKdReja(){
        mMap.addMarker(new MarkerOptions()
              .position(new LatLng(-7.466981, 108.719991 ))
              .title("Wisata Kuliner Rowo Bojongrongga")
              .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIkanKdReja(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.522648, 108.776925 ))
                .title("Budi daya Ikan Gurami")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.504546, 108.767192 ))
                .title("Budi Daya Ikan Lele")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );

    }
    private void showTaniKdReja(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.515330, 108.766025 ))
                .title("Area Persawahan Pengghasil Beras")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.520681, 108.791272))
                .title("Area Persawahan Jatisari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.503945, 108.798762))
                .title("Area Persawahan Ciklapa")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.548795, 108.768992))
                .title("Area Persawahan Tambak Reja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }

    private void showKebunKdreja(){
        mMap.addMarker(new MarkerOptions()
                .position(KELAPAKEDUNGREJA)
                .title("Industri Kerupuk")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showIndustriKrPucung(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.385429, 108.906612))
                .title("Industri Kerupuk")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataKrpucung(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanKrPucung(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniKrPucung(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunKrPucung(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakKrPucung(){
        mMap.addMarker(new MarkerOptions()
                .position(KAMBINGKRPUCUNG)
                .title("Peternakan Terpadu Kambing")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WEDUSGNTELU)
                .title("Keris Jateng: Peternakan Kambing Gunung Telu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showIndustriKesugiihan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showWisataKesugihan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanKesugihan(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.595133, 109.119762))
                .title("Sentra Sidat Kesugihan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniKesugihan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunKEsugihan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakKesugihan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriKroya(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.607361, 109.256437))
                .title("Industri Soun Kroya")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.632651, 109.237758))
                .title("Industri Pembuatan Rambut Palsu (Wig)")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.600073, 109.213938))
                .title("Industri Jamu Herbal Kroya")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.627877, 109.280442))
                .title("Home Industri Kesed")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataKroya(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanKroya(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.597723, 109.221049))
                .title("Industri Sidat Kroya")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniKroya(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.644214, 109.285212))
                .title("Persawahan Mengawati")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.608628, 109.219415))
                .title("Persawahan Gentasari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showKebunKroya(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakKroya(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriMajenang(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.296695, 108.762990))
                .title("Sale Pisang Majenang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.254484, 108.784616))
                .title("Sale Pisang Walahir")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.332473, 108.790746))
                .title("Sale Pisang Gulung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.300765, 108.756782))
                .title("Industri Kripik Pisang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.279084, 108.742295))
                .title("Industri Gula Aren")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.331750, 108.791683))
                .title("Industri Gula Merah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataMajenang(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniMajenang(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunMajenang(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.346774, 108.799284))
                .title("PTPN Kawung Majenang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.268492, 108.782754))
                .title("Hutan Boja Majenang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showTernakMajenang(){
        mMap.addMarker(new MarkerOptions()
                .position(SAPIMAJENANG)
                .title("Peternakan Sapi Majenang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showIndustriMaos(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.598569, 109.150286))
                .title("Industri Jenang Maos")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.606937, 109.148704))
                .title("Industri Batik Maos")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataMaos(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.599192, 109.135667))
                .title("Wisata Panembahan Ragil Kuning")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIkanMaos(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.593554, 109.146601))
                .title("Sentra Bibit Sidat Maos")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniMaos(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunMaos(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakMaos(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.607214, 109.179588))
                .title("Sentra Bibit Sidat Maos")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
    }
    private void showIndustriNusawungu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.662427, 109.359306))
                .title("Industri Anyaman Bambu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.702557, 109.335367))
                .title("Industri Gula Karangpakis")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataNusawungu(){
        mMap.addMarker(new MarkerOptions()
                .position(MOMONGAN)
                .title("Pengembangan Wisata Pulau Momongan")
                .snippet("Nilai Investasi Rp. 115.734.150.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showIkanNusawungu(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.713110, 109.386963))
                .title("Budidaya Ikan Gurami")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.646221, 109.344756))
                .title("Budidaya Ikan Sidat")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniNusawungu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunNusawungu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakNusawungu(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriPatimuan(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.597056, 108.779647))
                .title("Industri Gula Merah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.575906, 108.766392))
                .title("Industri Marning Jagung")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataPatimuan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void IkanPatimuan(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.667056, 108.791778))
                .title("Budidaya Sidat Patimuan")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniPatimuan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunPatimuan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakPatimuan(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriSampang(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.565295, 109.190459))
                .title("Industri Pupuk Sampang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.557146, 109.176776))
                .title("Industri Bata Merah Sampang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataSampang(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIkanSampang(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.557146, 109.176776))
                .title("Tambak Ikan Darat")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.589602, 109.204262))
                .title("Budidaya Sidat")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan))
        );
    }
    private void showTaniSampang(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunSampang(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakSampang(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.565051, 109.175867))
                .title("Peternakan Sapi Sampang")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan))
        );
    }
    private void showIndustriSidareja(){
        mMap.addMarker(new MarkerOptions()
                .position(KELAPATINGGARJAYA)
                .title("Keris Jateng: Industri Kelapa Tinggarjaya")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.mapkeris))
        );
    }
    private void showWisataSidareja(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.440434, 108.825462))
                .title("Panembahan Cisagu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.467147, 108.840548))
                .title("Wana Wisata Kemit Forest")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata))
        );
    }
    private void showIkanSidareja(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniSidareja(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTernakSidareja(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showIndustriWanareja(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.300501, 108.645039))
                .title("Industri Penggergajian Kayu")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti))
        );
    }
    private void showWisataWanareja(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showTaniWanareja(){
        Toast.makeText(DataKecamatan.this, "Data Tidak Ditemukan, Silahkan buka Data Detail",
                Toast.LENGTH_SHORT).show();
    }
    private void showKebunWanareja(){
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.285676, 108.680878))
                .title("Hutan Penghasil Kayu Malabar")
                .snippet("Ini adalah test buat Snipetpet")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.299240, 108.664671))
                .title("Hutan Penghasil Kayu Majingklak")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.312811, 108.626569))
                .title("Hutan Penghasil Kayu Madusari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.328453, 108.632548))
                .title("Hutan Penghasil Kayu Madura")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.364203, 108.719419))
                .title("Hutan Penghasil Kayu Bantar")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.278094, 108.639034))
                .title("Hutan Penghasil Kayu Tambaksari")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-7.340460, 108.712741))
                .title("Hutan Penghasil Kayu Adimulya")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    private void showTernakWanareja(){
        mMap.addMarker(new MarkerOptions()
                .position(SAPIWANAREJA)
                .title("Peternakan Sapi Wanareja")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpertanian))
        );
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_content, null);
                LatLng latLng = marker.getPosition();
                TextView tvLat = (TextView) v.findViewById(R.id.tvLat);
                TextView tvLng = (TextView) v.findViewById(R.id.tvLng);
                TextView tv1 = findViewById(R.id.tvTitleMap);
                TextView tv2 = findViewById(R.id.tvSnipetMap);
                ImageView iv = findViewById(R.id.ivGambarMap);

                String strTitle = marker.getTitle();
                String strSniper = marker.getSnippet();

                tv1.setText(strTitle);
                tv2.setText(strSniper);
                tvLat.setText("Latitude:" + latLng.latitude);
                tvLng.setText("Longitude:"+ latLng.longitude);

                if(onMarkerClick(marker)==true && markerclicked==1){
                    iv.setImageResource(R.drawable.tanjungintan);
                }

                return v;
            }
        });
        //LatLng cilacap = new LatLng(-7.481717, 108.838529);
        //mMap.addMarker(new MarkerOptions().position(cilacap).title("Cilacap").snippet("Cilacap Bercahaya"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(cilacap));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 1000, null);
        showCilacap(null);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION
                        , android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            } else {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            mMap.setMyLocationEnabled(true);
        }
        //mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);

    }

    private boolean onMarkerClick(final Marker marker) {
        if (marker.equals(BANDARA))
        {
            markerclicked=1;
            return true;
        }
        else if (marker.equals(PELABUHANTJINTAN)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(PELABUHANSLEKO)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(PELABUHANSODONG)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(STASIUNCILACAP)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(STASIUNGDMANGU)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(STASIUNKROYA)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(STASIUNMAOS)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(STASIUNSDREJA)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(TERMINALCILACAP)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(TERMINALKRPUCUNG)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(TERMINALMAJENANG)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(TERMINALSDREJA)){
            markerclicked=1;
            return true;
        }
        else if (marker.equals(AIRPANASCIPARI)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(KELAPAKEDUNGREJA)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(KELAPATINGGARJAYA)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(KELAPAWANAREJA)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(PALADAYEUHLUHUR)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(SAPIDAYEUHLUHUR)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(SAPIMAJENANG)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(SAPIWANAREJA)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(KAMBINGKRPUCUNG)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(HUTANPAYAU)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(GULAJERUKLEGI)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(SIDATPATIMUAN)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(WISATASLEKO)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(UDANGVANAME)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(MOMONGAN)) {
            markerclicked = 1;
            return true;
        }
        return false;

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

    public void utama(View view) {
        Intent utama = new Intent(DataKecamatan.this, MainActivity.class);
        startActivity(utama);
    }
}
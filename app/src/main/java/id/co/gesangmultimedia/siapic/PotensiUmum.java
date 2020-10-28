package id.co.gesangmultimedia.siapic;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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
    private Spinner spModa;
    private Spinner spTranport;
    private String strModa = "";
    private String strTransport = "";

    private int markerclicked;
    private Marker mabur;

    private static final LatLng CILACAP = new LatLng(-7.481717, 108.838529);

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
    private static final LatLng SAPIGDMANGU = new LatLng(-7.505771, 108.774712);

    private static final LatLng AIRPANASCIPARI = new LatLng(-7.430953, 108.7662454);
    private static final LatLng KELAPAWANAREJA = new LatLng(-7.4056531, 108.8025372);
    private static final LatLng SAPIDAYEUHLUHUR = new LatLng(-7.261911, 108.601007);
    private static final LatLng PALADAYEUHLUHUR = new LatLng(-7.259467, 108.607142);
    private static final LatLng SAPIMAJENANG = new LatLng(-7.258226, 108.683353);
    private static final LatLng SAPIWANAREJA = new LatLng(-7.312470, 108.673625);
    private static final LatLng KELAPAKDREJA = new LatLng(-7.5015207, 108.7848592);
    private static final LatLng WEDUSKRPUCUNG = new LatLng(-7.5537295, 108.8129129);
    private static final LatLng GULASEMUTJRLEGI = new LatLng(-7.654652, 109.041271);
    private static final LatLng HUTANPAYAU = new LatLng(-7.668021, 109.0270623);
    private static final LatLng SIDAT = new LatLng(-7.666796, 109.003658);
    private static final LatLng SLEKO = new LatLng(-7.727495, 108.996744);
    private static final LatLng UDANGVANAME = new LatLng(-7.662435, 109.260374);
    private static final LatLng MOMONGAN = new LatLng(-7.712007, 109.387234);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potensi_umum);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);


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
    private void mabur(){
        mMap.addMarker(new MarkerOptions()
                .position(BANDARA)
                .title("Bandara Tunggul Wulung Cilacap")
                .snippet("Jl. Tritih - Wangon, Tritih Lor. Jeruklegi Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconairport))
        );
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
        else if (marker.equals(KELAPAKDREJA)) {
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
        else if (marker.equals(WEDUSKRPUCUNG)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(HUTANPAYAU)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(GULASEMUTJRLEGI)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(SIDAT)) {
            markerclicked = 1;
            return true;
        }
        else if (marker.equals(SLEKO)) {
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

    private void renang(){
        mMap.addMarker(new MarkerOptions()
                .position(PELABUHANTJINTAN)
                .title("Pelabuhan Utama Tanjung Intan")
                .snippet("Klega, Tambakreja, Kec. Cilacap Selatan Kabupaten Cilacap, Jawa Tengah 53213")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconkapal))
        );
        mMap.addMarker(new MarkerOptions()
                .position(PELABUHANSLEKO)
                .title("Pelabuhan Penyeberangan Sleko")
                .snippet(" JL. Seleko , Tambakreja , Cilacap Selatan Cilacap , Jawa Tengah 53213")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconkapal))
        );
        mMap.addMarker(new MarkerOptions()
                .position(PELABUHANSODONG)
                .title("Pelabuhan Penyeberangan Dermaga Sodong")
                .snippet("Tambakreja, Kec. Cilacap Selatan Kabupaten Cilacap, Jawa Tengah 53263")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconkapal))
        );
    }
    private void ngebis(){
        mMap.addMarker(new MarkerOptions()
                .position(TERMINALCILACAP)
                .title("Terminal Bis Cilacap")
                .snippet("Jl. Gatot Subroto No.268, Karang Lor Gunungsimping, Kec. Cilacap Tengah Kabupaten Cilacap, Jawa Tengah 53211")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconbus))
        );
        mMap.addMarker(new MarkerOptions()
                .position(TERMINALKRPUCUNG)
                .title("Terminal Bis Karangpucung")
                .snippet("Kecamatan Karangpucung, Kabupaten Cilacap, Jawa Tengah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconbus))
        );
        mMap.addMarker(new MarkerOptions()
                .position(TERMINALMAJENANG)
                .title("Terminal Bus Majenang ")
                .snippet("Kecamatan Majenang, Kabupaten Cilacap, Jawa Tengah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconbus))
        );
        mMap.addMarker(new MarkerOptions()
                .position(TERMINALSDREJA)
                .title("Terminal Bus Sidareja")
                .snippet("Kecamatan Sidareja, Kabupaten Cilacap, Jawa Tengah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconbus))
        );
    }
    private void nyepur(){
        mMap.addMarker(new MarkerOptions()
                .position(STASIUNCILACAP)
                .title("Stasiun Besar Cilacap")
                .snippet("Gg. Surya V, Tambakreja, Kec. Cilacap Sel., Kabupaten Cilacap, Jawa Tengah 53211")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.train))
        );
        mMap.addMarker(new MarkerOptions()
                .position(STASIUNKROYA)
                .title("Stasiun Besar Kroya")
                .snippet("Semingkir, Pucung Kidul, Kec. Kroya, Kabupaten Cilacap, Jawa Tengah 53282")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.train))
        );
        mMap.addMarker(new MarkerOptions()
                .position(STASIUNMAOS)
                .title("Stasiun Maos")
                .snippet("JL. Raya Kesugihan, Klapagada, 53272 Cilacap, Jawa Tengah 53271")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.train))
        );
        mMap.addMarker(new MarkerOptions()
                .position(STASIUNSDREJA)
                .title("Stasiun Sidareja")
                .snippet("Jenggalan, Sidamulya, Kec. Sidareja, Kabupaten Cilacap, Jawa Tengah 53261")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.train))
        );
        mMap.addMarker(new MarkerOptions()
                .position(STASIUNGDMANGU)
                .title("Stasiun Gandrungmangu")
                .snippet("Kecamatan Gandrungmangu, Kab. Cilacap, Jawa Tengah")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.train))
        );
    }
    private void airpanascipari() {
        mMap.addMarker(new MarkerOptions()
                .position(AIRPANASCIPARI)
                .anchor(0.5f, 0.5f)
                .title("Pemandian Air Panas Cipari")
                .snippet("Nilai Investasi Rp. 2.000.000.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap)));
    }

    private void kelapaWanareja() {
        mMap.addMarker(new MarkerOptions()
                .position(KELAPAWANAREJA)
                .anchor(0.5f, 0.5f)
                .title("Serat Sabut Kelapa Wanareja")
                .snippet("Nilai Investasi Rp. 1.000.000.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void sapiDayeuhluhur() {
        mMap.addMarker(new MarkerOptions()
                .position(SAPIDAYEUHLUHUR)
                .title("Peternakan Sapi Potong Dayeuhluhur")
                .snippet("Nilai Investasi Rp. 623.396.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void palaDayeuhluhur() {
        mMap.addMarker(new MarkerOptions()
                .title("Industri Terpadu Pengolahan Buah Pala")
                .snippet("Nilai Investasi Rp. 6.605.555.985.000,00")
                .position(PALADAYEUHLUHUR)
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void sapiMajenang() {
        mMap.addMarker(new MarkerOptions()
                .position(SAPIMAJENANG)
                .title("Peternakan Sapi Potong Majenang")
                .snippet("Nilai Investasi Rp. 623.396.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void sapiWanareja() {
        mMap.addMarker(new MarkerOptions()
                .position(SAPIWANAREJA)
                .title("Peternakan Sapi Potong Wanareja")
                .snippet("Nilai Investasi Rp. 623.396.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpeternakan)));
    }

    private void kelapaKedungreja() {
        mMap.addMarker(new MarkerOptions()
                .position(KELAPAKDREJA)
                .title("Industri Pengolahan Kelapa Terpadu Kedungreja")
                .snippet("Nilai Investasi Rp. 2.399.000.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void kambingKrpucung() {
        mMap.addMarker(new MarkerOptions()
                .position(WEDUSKRPUCUNG)
                .title("Peternakan Terpadu Kambing Karangpucung")
                .snippet("Nilai Investasi Rp. 97.213.602.800,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap)));
    }

    private void gulaJeruklegi() {
        mMap.addMarker(new MarkerOptions()
                .position(GULASEMUTJRLEGI)
                .title("Pabrik Gula Semut Super Jeruklegi")
                .snippet("Nilai Investasi Rp. 5.787.746.429,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void hutanpayau() {
        mMap.addMarker(new MarkerOptions()
                .position(HUTANPAYAU)
                .title("Pengembangan Hutan Payau")
                .snippet("Nilai Investasi Rp. 11.600.000.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata)));
    }

    private void sidat() {
        mMap.addMarker(new MarkerOptions()
                .position(SIDAT)
                .title("Budidaya Ikan Sidat")
                .snippet("Nilai Investasi Rp. 2.045.635.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconperikanan)));
    }

    private void sleko() {
        mMap.addMarker(new MarkerOptions()
                .position(SLEKO)
                .title("Pengembangan Wisata Bahari")
                .snippet("Nilai Investasi Rp. 1.754.274.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconpariwisata)));
    }

    private void udang() {
        mMap.addMarker(new MarkerOptions()
                .position(UDANGVANAME)
                .title("Industri Terpadu Udang Vaname")
                .snippet("Nilai Investasi Rp. 16.010.900.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.iconindusti)));
    }

    private void momongan() {
        mMap.addMarker(new MarkerOptions()
                .position(MOMONGAN)
                .title("Pengembangan Wisata Pulau Momongan")
                .snippet("Nilai Investasi Rp. 10.658.908.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap)));
    }

    private void kerismap(){
        mMap.addMarker(new MarkerOptions()
                .position(SIDATPATIMUAN)
                .title("Keris Jateng: Sidat Bulupayung")
                .snippet("Nilai Investasi Rp. 3.555.952.133,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(UDANGCILSEL)
                .title("Keris Jateng: Udang Tegal Kamulyan")
                .snippet("Nilai Investasi Rp. 20.736.165.550,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(UDANGMERTASINGA)
                .title("Keris Jateng: Udang Vaname Mertasinga")
                .snippet("Nilai Investasi Rp. 20.736.165.550,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(SAPIGDMANGU)
                .title("Keris Jateng: Peternakan Sapi Gandrungmangu")
                .snippet("Nilai Investasi Rp. 4,541,500,000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WISATASEGARAANAKAN)
                .title("Keris Jateng: Wisata Bahari Segara ANakan")
                .snippet("Nilai Investasi Rp. 114.550.825.868,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WISATAUJUNGALANG)
                .title("Keris Jateng: Wisata Bahari Ujung Alang")
                .snippet("Nilai Investasi Rp.  116,437,089,393,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(UDANGBINANGUN)
                .title("Keris Jateng: Tambak Udang Binangun")
                .snippet("Nilai Investasi Rp.  Rp255,387,100,000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(WEDUSGNTELU)
                .title("Keris Jateng: Peternakan Kambing Gunung Telu")
                .snippet("Nilai Investasi Rp. 95.144.085.000,00")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KELAPATINGGARJAYA)
                .title("Keris Jateng: Industri Kelapa Tinggarjaya")
                .snippet("Nilai Investasi Rp. 58,602,850,000")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.kerismap))
        );
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAP, 10f));
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

        try {
            showCilacap(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        mabur();
        ngebis();
        renang();
        kerismap();
        nyepur();
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

    public void rumah(View view) {
        Intent balik = new Intent(PotensiUmum.this, MainActivity.class);
        startActivity(balik);
    }
}
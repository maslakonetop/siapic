package id.co.gesangmultimedia.siapic;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlLayer;

import org.json.JSONException;

import java.io.IOException;

public class RtrwCilacap extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private GeoJsonLayer geoJsonLayer;
    private KmlLayer kmlLayer;
    FloatingActionButton fabMenu;
    Toolbar toolbar;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    private static final LatLng CILACAP = new LatLng(-7.481717, 108.838529);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtrw_cilacap);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
        FloatingActionButton fabMenu = findViewById(R.id.fabmenu);
        fabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMapLegend();
            }
        });
    }

    private void showMapLegend() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupmenu = inflater.inflate(R.layout.menu_legend, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupmenu, width, height, focusable);

        popupWindow.showAtLocation(popupmenu, Gravity.CENTER, 0, 0);

        popupmenu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void showCilacap(View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAP, 10f));

        GeoJsonLayer layerCilacap;
        layerCilacap = new GeoJsonLayer(mMap, R.raw.cilacap, getApplicationContext());
        GeoJsonPolygonStyle layerCilacapStyle = layerCilacap.getDefaultPolygonStyle();
        layerCilacapStyle.setStrokeWidth(3f);
        layerCilacap.addLayerToMap();
    }
    public void showCagaralam(View v) throws IOException, JSONException {
        if (mMap == null) {
            return;
        }
        GeoJsonLayer layerCagar;
        layerCagar = new GeoJsonLayer(mMap, R.raw.cagaralam, getApplicationContext());
        GeoJsonPolygonStyle layerCagarStyle = layerCagar.getDefaultPolygonStyle();
        layerCagarStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerCagarStyle.setFillColor(ContextCompat.getColor(this, R.color.burlywood));
        layerCagarStyle.setStrokeWidth(1f);
        layerCagar.addLayerToMap();
    }
    public void showHutanProduksi(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerHutanProd;
        layerHutanProd = new GeoJsonLayer(mMap, R.raw.hutanproduksi, getApplicationContext());
        GeoJsonPolygonStyle layarHutanProdStyle = layerHutanProd.getDefaultPolygonStyle();
        layarHutanProdStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layarHutanProdStyle.setFillColor(ContextCompat.getColor(this, R.color.grey));
        layarHutanProdStyle.setStrokeWidth(1f);
        layerHutanProd.addLayerToMap();
    }
    public void showSegaraAnakan(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerAnakan;
        layerAnakan = new GeoJsonLayer(mMap, R.raw.kawkonservasisegaraanakan, getApplicationContext());
        GeoJsonPolygonStyle layerSegaraStyle = layerAnakan.getDefaultPolygonStyle();
        layerSegaraStyle.setStrokeColor(ContextCompat.getColor(this,R.color.black));
        layerSegaraStyle.setFillColor(ContextCompat.getColor(this, R.color.hotpink));
        layerSegaraStyle.setStrokeWidth(1f);
        layerAnakan.addLayerToMap();
    }
    public void showMangrove(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerMangrove;
        layerMangrove=new GeoJsonLayer(mMap, R.raw.kawperlindunganmangrove, getApplicationContext());
        GeoJsonPolygonStyle layerMangroveStyle = layerMangrove.getDefaultPolygonStyle();
        layerMangroveStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMangroveStyle.setFillColor(ContextCompat.getColor(this, R.color.gold));
        layerMangroveStyle.setStrokeWidth(1f);
        layerMangrove.addLayerToMap();
    }
    public void showResapanAir(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerResapan;
        layerResapan = new GeoJsonLayer(mMap, R.raw.kawresapanair, getApplicationContext());
        GeoJsonPolygonStyle layerResapanStyle = layerResapan.getDefaultPolygonStyle();
        layerResapanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerResapanStyle.setFillColor(ContextCompat.getColor(this, R.color.deepskyblue));
        layerResapanStyle.setStrokeWidth(1f);
        layerResapan.addLayerToMap();
    }
    public void showKawasanIndustri(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerIndustri;
        layerIndustri = new GeoJsonLayer(mMap, R.raw.kawperuntukanindustri, getApplicationContext());
        GeoJsonPolygonStyle layerIndustriGaya = layerIndustri.getDefaultPolygonStyle();
        layerIndustriGaya.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerIndustriGaya.setFillColor(ContextCompat.getColor(this, R.color.maroon));
        layerIndustriGaya.setStrokeWidth(1f);
        layerIndustri.addLayerToMap();
    }
    public void showMataAir(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerMataAir;
        layerMataAir=new GeoJsonLayer(mMap, R.raw.kawperlindunganmataair, getApplicationContext());
        GeoJsonPolygonStyle layerMataGaya = layerMataAir.getDefaultPolygonStyle();
        layerMataGaya.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerMataGaya.setFillColor(ContextCompat.getColor(this, R.color.mediumorchid));
        layerMataGaya.setStrokeWidth(1f);
        layerMataAir.addLayerToMap();
    }
    public void showNonHutan(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerNonHutan;
        layerNonHutan = new GeoJsonLayer(mMap, R.raw.kawasannonhutan, getApplicationContext());
        GeoJsonPolygonStyle layerNonGaya = layerNonHutan.getDefaultPolygonStyle();
        layerNonGaya.setFillColor(ContextCompat.getColor(this, R.color.black));
        layerNonGaya.setStrokeColor(ContextCompat.getColor(this, R.color.olive));
        layerNonGaya.setStrokeWidth(1f);
        layerNonHutan.addLayerToMap();
    }
    public void showLongsor(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerLongsor;
        layerLongsor = new GeoJsonLayer(mMap, R.raw.longsor, getApplicationContext());
        GeoJsonPolygonStyle layerLongsorStyle = layerLongsor.getDefaultPolygonStyle();
        layerLongsorStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerLongsorStyle.setFillColor(ContextCompat.getColor(this, R.color.lightcoral));
        layerLongsorStyle.setStrokeWidth(1f);
        layerLongsor.addLayerToMap();
    }
    public void showNdesoo(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerNdeso;
        layerNdeso = new GeoJsonLayer(mMap, R.raw.pedesaan, getApplicationContext());
        GeoJsonPolygonStyle layerNdesoNggaya = layerNdeso.getDefaultPolygonStyle();
        layerNdesoNggaya.setFillColor(ContextCompat.getColor(this, R.color.black));
        layerNdesoNggaya.setStrokeColor(ContextCompat.getColor(this, R.color.orange));
        layerNdesoNggaya.setStrokeWidth(1f);
        layerNdeso.addLayerToMap();
    }
    public void showKebonan(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerKebon;
        layerKebon = new GeoJsonLayer(mMap, R.raw.perkebunan, getApplicationContext());
        GeoJsonPolygonStyle layerKebonStyle = layerKebon.getDefaultPolygonStyle();
        layerKebonStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKebonStyle.setFillColor(ContextCompat.getColor(this, R.color.forestgreen));
        layerKebonStyle.setStrokeWidth(1f);
        layerKebon.addLayerToMap();
    }
    public void showKota(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerKota;
        layerKota = new GeoJsonLayer(mMap, R.raw.perkotaan, getApplicationContext());
        GeoJsonPolygonStyle layerKotaStyle = layerKota.getDefaultPolygonStyle();
        layerKotaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKotaStyle.setFillColor(ContextCompat.getColor(this, R.color.mediumviolet));
        layerKotaStyle.setStrokeWidth(1f);
        layerKota.addLayerToMap();
    }
    public void showIbukota(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerIbukota;
        layerIbukota = new GeoJsonLayer(mMap, R.raw.perkotaanibukota, getApplicationContext());
        GeoJsonPolygonStyle layerIbukotaStyle = layerIbukota.getDefaultPolygonStyle();
        layerIbukotaStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerIbukotaStyle.setFillColor(ContextCompat.getColor(this, R.color.darkturquoise));
        layerIbukotaStyle.setStrokeWidth(1f);
        layerIbukota.addLayerToMap();
    }
    public void showLahanbasah(View v) throws IOException, JSONException {
        if (mMap == null){
            return;
        }
        GeoJsonLayer layerLahanBasah;
        layerLahanBasah = new GeoJsonLayer(mMap,R.raw.pertanianlahanbasah, getApplicationContext());
        GeoJsonPolygonStyle layerBasahStyle = layerLahanBasah.getDefaultPolygonStyle();
        layerBasahStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerBasahStyle.setFillColor(ContextCompat.getColor(this, R.color.tan));
        layerBasahStyle.setStrokeWidth(1f);
        layerLahanBasah.addLayerToMap();
    }
    public void showLahanKering(View v) throws IOException, JSONException {
        if(mMap==null){
            return;
        }
        GeoJsonLayer layerKering;
        layerKering = new GeoJsonLayer(mMap, R.raw.pertanianlahankering, getApplicationContext());
        GeoJsonPolygonStyle layerKeringStyle = layerKering.getDefaultPolygonStyle();
        layerKeringStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerKeringStyle.setFillColor(ContextCompat.getColor(this, R.color.mediumaquamarine));
        layerKeringStyle.setStrokeWidth(1f);
        layerKering.addLayerToMap();
    }
    public void showRawan(View v) throws IOException, JSONException {
        if(mMap==null){
            return;
        }
        GeoJsonLayer layerRawan;
        layerRawan = new GeoJsonLayer(mMap, R.raw.rawan,getApplicationContext());
        GeoJsonPolygonStyle layerRawanStyle = layerRawan.getDefaultPolygonStyle();
        layerRawanStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerRawanStyle.setFillColor(ContextCompat.getColor(this, R.color.crimson));
        layerRawanStyle.setStrokeWidth(1f);
        layerRawan.addLayerToMap();
    }
    public void showPantai(View v) throws IOException, JSONException {
        if(mMap == null){
            return;
        }
        GeoJsonLayer layerPantai;
        layerPantai = new GeoJsonLayer(mMap, R.raw.sempadanpantai, getApplicationContext());
        GeoJsonPolygonStyle layerAnakPantai = layerPantai.getDefaultPolygonStyle();
        layerAnakPantai.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerAnakPantai.setFillColor(ContextCompat.getColor(this, R.color.blanchedalmond));
        layerAnakPantai.setStrokeWidth(1f);
        layerPantai.addLayerToMap();
    }
    public void showSungaiInduk(View v) throws IOException, JSONException {
        if(mMap==null){
            return;
        }
        GeoJsonLayer layerInduk;
        layerInduk = new GeoJsonLayer(mMap, R.raw.sempadansungaiinduk, getApplicationContext());
        GeoJsonPolygonStyle layerIndukStyle = layerInduk.getDefaultPolygonStyle();
        layerIndukStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerIndukStyle.setFillColor(ContextCompat.getColor(this, R.color.steelblue));
        layerIndukStyle.setStrokeWidth(1f);
    }
    public void showSungaiKecil(View v) throws IOException, JSONException {
        if(mMap == null){
            return;
        }
        GeoJsonLayer layerAnak;
        layerAnak = new GeoJsonLayer(mMap, R.raw.sempadansungikecil, getApplicationContext());
        GeoJsonPolygonStyle layerAnakStyle = layerAnak.getDefaultPolygonStyle();
        layerAnakStyle.setStrokeColor(ContextCompat.getColor(this,R.color.black));
        layerAnakStyle.setFillColor(ContextCompat.getColor(this, R.color.peru));
        layerAnakStyle.setStrokeWidth(1f);
        layerAnak.addLayerToMap();
    }
    public void showSelok(View v) throws IOException, JSONException {
        if(mMap==null){
            return;
        }
        GeoJsonLayer layerSelok;
        layerSelok = new GeoJsonLayer(mMap, R.raw.wisatagnselok, getApplicationContext());
        GeoJsonPolygonStyle layerSelokStyle = layerSelok.getDefaultPolygonStyle();
        layerSelokStyle.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        layerSelokStyle.setFillColor(ContextCompat.getColor(this, R.color.fuchsia));
        layerSelokStyle.setStrokeWidth(1f);
        layerSelok.addLayerToMap();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        try {
            showCilacap(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showCagaralam(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showHutanProduksi(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showSegaraAnakan(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showMangrove(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showMataAir(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showKawasanIndustri(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showResapanAir(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showNonHutan(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showLongsor(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showNdesoo(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showKebonan(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showKota(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showIbukota(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showLahanbasah(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showLahanKering(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showRawan(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showPantai(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showSungaiInduk(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showSungaiKecil(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            showSelok(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
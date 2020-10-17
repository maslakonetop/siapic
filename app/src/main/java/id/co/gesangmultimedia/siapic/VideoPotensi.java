package id.co.gesangmultimedia.siapic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class VideoPotensi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_potensi);
        ImageButton imb_popupMenu = findViewById(R.id.popup);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        imb_popupMenu = findViewById(R.id.search);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        imb_popupMenu = findViewById(R.id.search);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideoPotensi(v);
            }
        });
        imb_popupMenu = findViewById(R.id.home);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBeranda(v);
            }
        });
        WebView webView = (WebView) findViewById(R.id.webview);
    }

    private void showBeranda(View v) {
        Intent beranda = new Intent(VideoPotensi.this, MainActivity.class);
        startActivity(beranda);
    }

    private void showVideoPotensi(View v) {
        Intent video = new Intent(VideoPotensi.this, VideoPotensi.class);
        startActivity(video);
    }

    @SuppressLint("ResourceType")
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        //menampilkan layout menu_popup.xml
        popupMenu.inflate(R.layout.menu_popup);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_profile:
                        Intent about = new Intent(VideoPotensi.this, About.class);
                        startActivity(about);
                        break;
                    case R.id.menu_bug:
                        Intent bug = new Intent(VideoPotensi.this, LaporanBug.class);
                        startActivity(bug);
                    case R.id.menu_pengaturan:
                        Intent atur = new Intent(VideoPotensi.this, Pengaturan.class);
                        startActivity(atur);
                        break;
                    case R.id.menu_keluar:
                        finish();
                        System.exit(0);
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void kecamatan(View view) {
        Intent datakecamatan = new Intent(VideoPotensi.this, DataKecamatan.class);
        startActivity(datakecamatan);
    }

    public void potensi(View view) {
        Intent potensiumum = new Intent(VideoPotensi.this, PotensiUmum.class);
        startActivity(potensiumum);
    }

    public void kawasan(View view) {
        Intent kip = new Intent(VideoPotensi.this, KawasanIndustri.class);
        startActivity(kip);
    }

    public void rtrw(View view) {
        Intent rtrw = new Intent(VideoPotensi.this, RtrwCilacap.class);
        startActivity(rtrw);
    }

    public void profil(View view) {
        Intent profil = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText edtJudul = (EditText) findViewById(R.id.editTextTextMultiLine);
        TextView txtVideoId = (TextView) findViewById(R.id.txtVideoProfil);
        txtVideoId.setText("5tVJMbPcHjs");
        profil.putExtra("judul", edtJudul.getText().toString());
        profil.putExtra("videoid", txtVideoId.getText().toString());
        startActivity(profil);
    }

    public void booklet(View view) {
        Intent booklet = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editJudul = (EditText)findViewById(R.id.editTextTextMultiLine2);
        TextView txtVideoId = (TextView) findViewById(R.id.txtVideoProfil);
        txtVideoId.setText("SljK2csUe34");
        booklet.putExtra("judul", editJudul.getText().toString());
        booklet.putExtra("videoid", txtVideoId.getText().toString());
        startActivity(booklet);
    }

    public void inggris(View view) {
        Intent inggris = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editJudul = (EditText)findViewById(R.id.editTextTextMultiLine3);
        TextView txtVideoId = (TextView) findViewById(R.id.txtVideoProfil);
        txtVideoId.setText("MGhGbxtIORs");
        inggris.putExtra("judul", editJudul.getText().toString());
        inggris.putExtra("videoid", txtVideoId.getText().toString());
        startActivity(inggris);
    }

    public void sidat(View view) {
        Intent sidat = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = (EditText)findViewById(R.id.editTextTextMultiLine4);
        TextView textView = (TextView)findViewById(R.id.txtVideoProfil);
        textView.setText("e0n7sE0FKTk");
        sidat.putExtra("judul", editText.getText().toString());
        sidat.putExtra("videoid", textView.getText().toString());
        startActivity(sidat);
    }

    public void pameran(View view) {
        Intent pamer = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = (EditText)findViewById(R.id.editTextTextMultiLine6);
        TextView textView = (TextView)findViewById(R.id.txtVideoProfil);
        textView.setText("etZGDuHzyBs");
        pamer.putExtra("judul", editText.getText().toString());
        pamer.putExtra("videoid", textView.getText().toString());
        startActivity(pamer);
    }

    public void gula(View view) {
        Intent manis = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.editTextTextMultiLine7);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("4zqsNGnbklo");
        manis.putExtra("judu", editText.getText().toString());
        manis.putExtra("videoid", textView.getText().toString());
        startActivity(manis);
    }

    public void tas(View view) {
        Intent lenjeh = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.editTextTextMultiLine8);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("z3L_Tl12bcI");
        lenjeh.putExtra("judul", editText.getText().toString());
        lenjeh.putExtra("videoid", textView.getText().toString());
        startActivity(lenjeh);
    }

    public void asin(View view) {
        Intent asin = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.editTextTextMultiLine9);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("5_XExjGdrXc");
        asin.putExtra("judul", editText.getText().toString());
        asin.putExtra("videoid", textView.getText().toString());
        startActivity(asin);
    }

    public void stik(View view) {
        Intent sukun = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.editTextTextMultiLine10);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("y0N2MgNd01o");
        sukun.putExtra("judul", editText.getText().toString());
        sukun.putExtra("videoid", textView.getText().toString());
        startActivity(sukun);
    }

    public void nata(View view) {
        Intent nata = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.editTextTextMultiLine11);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("bxG_EgjuOWM");
        nata.putExtra("judul", editText.getText().toString());
        nata.putExtra("videoid", textView.getText().toString());
        startActivity(nata);
    }

    public void batik(View view) {
        Intent batik = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtBatik);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("48o57pjQJjA");
        batik.putExtra("judul", editText.getText().toString());
        batik.putExtra("videoid", textView.getText().toString());
        startActivity(batik);
    }

    public void sale(View view) {
        Intent sale = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtSale);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("L9Nlo8lz_nY");
        sale.putExtra("judul", editText.getText().toString());
        sale.putExtra("videoid", textView.getText().toString());
        startActivity(sale);
    }

    public void tengiri(View view) {
        Intent iwak = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtTengiri);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("cX_XVN_3WuE");
        iwak.putExtra("judul", editText.getText().toString());
        iwak.putExtra("videoid", textView.getText().toString());
        startActivity(iwak);
    }

    public void kerang(View view) {
        Intent kerang = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtKerang);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("Pgeh6qSU2r0");
        kerang.putExtra("judul", editText.getText().toString());
        kerang.putExtra("videoid", textView.getText().toString());
        startActivity(kerang);
    }

    public void rawa(View view) {
        Intent raben = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtRawaBendungan);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("Wl1379ANFVw");
        raben.putExtra("judul", editText.getText().toString());
        raben.putExtra("videoid", textView.getText().toString());
        startActivity(raben);
    }

    public void wedus(View view) {
        Intent wedus = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtWedusKrPucung);
        TextView textView= findViewById(R.id.txtVideoProfil);
        textView.setText("brm2O505hcA");
        wedus.putExtra("judul", editText.getText().toString());
        wedus.putExtra("videoid", textView.getText().toString());
        startActivity(wedus);
    }

    public void semut(View view) {
        Intent semut = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtIndusGulaSemut);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("wIbiOKd6j-Y");
        semut.putExtra("judul", editText.getText().toString());
        semut.putExtra("videoid", textView.getText().toString());
        startActivity(semut);
    }

    public void sapi(View view) {
        Intent sapi = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtSapi);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("Tb7uYhYomCU");
        sapi.putExtra("judul", editText.getText().toString());
        sapi.putExtra("videoid", textView.getText().toString());
        startActivity(sapi);
    }

    public void payau(View view) {
        Intent payau = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtHutanPayau);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("8Y-_Fg4JweM");
        payau.putExtra("judul", editText.getText().toString());
        payau.putExtra("videoid", textView.getText().toString());
        startActivity(payau);
    }

    public void gurame(View view) {
        Intent gurami = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtGurame);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("5O5x9EqmjJM");
        gurami.putExtra("judul", editText.getText().toString());
        gurami.putExtra("videoid", textView.getText().toString());
        startActivity(gurami);
    }

    public void sebutret(View view) {
        Intent sebutret = new Intent( VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtSebutret);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("Gtkzq6rBlh0");
        sebutret.putExtra("judul", editText.getText().toString());
        sebutret.putExtra("videoid", textView.getText().toString());
        startActivity(sebutret);
    }

    public void hotspring(View view) {
        Intent panas = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtHotSpring3);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("sGq971RteWE");
        panas.putExtra("judul", editText.getText().toString());
        panas.putExtra("videoid", textView.getText().toString());
        startActivity(panas);
    }

    public void bahari(View view) {
        Intent bahari =new  Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtBahari);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("B4LPlczyPuU");
        bahari.putExtra("judul", editText.getText().toString());
        bahari.putExtra("videoid", textView.getText().toString());
        startActivity(bahari);
    }

    public void pantai(View view) {
        Intent pantai = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtPantaiWidarapayung);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("eKGo27Yd8c0");
        pantai.putExtra("judul", editText.getText().toString());
        pantai.putExtra("videoid", textView.getText().toString());
        startActivity(pantai);
    }

    public void oss(View view) {
        Intent ijin = new Intent(VideoPotensi.this, TampilkanVideo.class);
        EditText editText = findViewById(R.id.edtTxtOss);
        TextView textView = findViewById(R.id.txtVideoProfil);
        textView.setText("xkh8UyUgVP4");
        ijin.putExtra("judul", editText.getText().toString());
        ijin.putExtra("videoid", textView.getText().toString());
        startActivity(ijin);
    }
}
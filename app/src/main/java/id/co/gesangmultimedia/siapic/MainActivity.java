package id.co.gesangmultimedia.siapic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private Object showVideoPotensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imb_popupMenu = findViewById(R.id.popup);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        imb_popupMenu = findViewById(R.id.popup);
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

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION
                        , android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            } else {

                //Toast.makeText(MainActivity.this, "Alokasi GPS sudah diaktifkan", Toast.LENGTH_LONG).show();
            }
        } else {
            //Toast.makeText(MainActivity.this, "Aplikasi GPS dinon-aktifkan", Toast.LENGTH_LONG).show();
        }
    }
    private void showBeranda(View v) {
        Intent beranda = new Intent(MainActivity.this, MainActivity.class);
        startActivity(beranda);
    }

    private void showVideoPotensi(View v) {
        Intent video = new Intent(MainActivity.this, VideoPotensi.class);
        startActivity(video);
    }

    @SuppressLint("ResourceType")
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        //menampilkan layout menu_popup.xml
        popupMenu.inflate(R.layout.menu_popup);
        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_profile:
                        Intent about = new Intent(MainActivity.this, About.class);
                        startActivity(about);
                        break;
                    case R.id.menu_bug:
                        Intent bug = new Intent(MainActivity.this, LaporanBug.class);
                        startActivity(bug);
                    case R.id.menu_pengaturan:
                        Intent atur = new Intent(MainActivity.this, Pengaturan.class);
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
        Intent datakecamatan = new Intent(MainActivity.this, DataKecamatan.class);
        startActivity(datakecamatan);
    }

    public void potensi(View view) {
        Intent potensiumum = new Intent(MainActivity.this, PotensiUmum.class);
        startActivity(potensiumum);
    }

    public void kawasan(View view) {
        Intent kip = new Intent(MainActivity.this, KawasanIndustri.class);
        startActivity(kip);
    }

    public void rtrw(View view) {
        Intent rtrw = new Intent(MainActivity.this, RtrwCilacap.class);
        startActivity(rtrw);
    }

    public void pdfgo(View view) {
        Intent pdf = new Intent(MainActivity.this, BerandaSop.class);
        startActivity(pdf);
    }
}
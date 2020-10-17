package id.co.gesangmultimedia.petapotensicilacap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class ShowPdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdf);
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
    }
    private void showBeranda(View v) {
        Intent beranda = new Intent(ShowPdf.this, MainActivity.class);
        startActivity(beranda);
    }

    private void showVideoPotensi(View v) {
        Intent video = new Intent(ShowPdf.this, VideoPotensi.class);
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
                                Intent about = new Intent(ShowPdf.this, About.class);
                                startActivity(about);
                                break;
                            case R.id.menu_bug:
                                Intent bug = new Intent(ShowPdf.this, LaporanBug.class);
                                startActivity(bug);
                            case R.id.menu_pengaturan:
                                Intent atur = new Intent(ShowPdf.this, Pengaturan.class);
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

        TextView txtpdf = findViewById(R.id.txtPdf);
        String judulpdf = super.getIntent().getExtras().getString("judul");
        txtpdf.setText(judulpdf);

        PDFView pdfKecamatan = findViewById(R.id.pdfView);
        if (txtpdf.getText().equals("Kecamatan Adipala")){
            pdfKecamatan.fromAsset("pdfadipala.pdf").load();
            pdfKecamatan.setBackgroundColor(Color.LTGRAY);
        }
        else if (txtpdf.getText().equals("Kecamatan Binangun")){
            pdfKecamatan.fromAsset("pdfbinangun.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Cilacap Selaan")){
            pdfKecamatan.fromAsset("pdfcilacapselatan.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Cilacap Tengah")){
            pdfKecamatan.fromAsset("pdfcilacaptengah.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Cilacap Utara")){
            pdfKecamatan.fromAsset("pdfcilacaputara.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Cimanggu")){
            pdfKecamatan.fromAsset("pdfcimanggu.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Cipari")){
            pdfKecamatan.fromAsset("pdfcipari.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Dayeuhluhur")){
            pdfKecamatan.fromAsset("pdfdayeuhluhur.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Jeruklegi")){
            pdfKecamatan.fromAsset("pdfjeruklegi.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Kampunglaut")){
            pdfKecamatan.fromAsset("pdfkampunglaut.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Karangpucung")){
            pdfKecamatan.fromAsset("pdfkarangpucung.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Kawunganten")){
            pdfKecamatan.fromAsset("pdfkawunganten.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Kedungreja")){
            pdfKecamatan.fromAsset("pdfkedungreja.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Kesugihan")){
            pdfKecamatan.fromAsset("pdfkesugihan.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Kroya")){
            pdfKecamatan.fromAsset("pdfkroya.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Majenang")){
            pdfKecamatan.fromAsset("pdfmajenang.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Maos")){
            pdfKecamatan.fromAsset("pdfmaos.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Nusawungu")){
            pdfKecamatan.fromAsset("pdfnusawungu.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Patimuan")){
            pdfKecamatan.fromAsset("pdfpatimuan.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Sampang")){
            pdfKecamatan.fromAsset("pdfsampang.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan Sidareja")){
            pdfKecamatan.fromAsset("pdfsidareja.pdf").load();
        }
        else if (txtpdf.getText().equals("Kecamatan wanareja")){
            pdfKecamatan.fromAsset("pdfwanareja.pdf").load();
        }
    }

    public void kembali(View view) {
        Intent balik = new Intent(ShowPdf.this, DataKecamatan.class);
        startActivity(balik);
    }
}
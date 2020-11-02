package id.co.gesangmultimedia.siapic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class ShowPdf extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdf);

        TextView txtpdf = findViewById(R.id.txtPdf);
        String judulpdf = super.getIntent().getExtras().getString("judul");
        txtpdf.setText("Kecamatan " + judulpdf);

        //PDFView pdfView = findViewById(R.id.pdfView);
        if (txtpdf.getText().equals("Kecamatan Adipala")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfadipala.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Bantarsari")) {
            PDFView pdfview = findViewById(R.id.pdfView);
            pdfview.fromAsset("pdfbantarsari.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Binangun")) {
            PDFView pdfview = findViewById(R.id.pdfView);
            pdfview.fromAsset("pdfbinangun.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Cilacap Selatan")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfcilacapselatan.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Cilacap Tengah")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfcilacaptengah.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Cilacap Utara")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfcilacaputara.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Cimanggu")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfcimanggu.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Cipari")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfcipari.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Dayeuhluhur")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfdayeuhluhur.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Gandrungmangu")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfgandrungmangu.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Jeruklegi")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfjeruklegi.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Kampung Laut")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfkampunglaut.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Karangpucung")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfkarangpucung.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Kawunganten")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfkawunganten.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Kedungreja")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfkedungreja.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Kesugihan")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfkesugihan.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Kroya")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfkroya.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Majenang")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfmajenang.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Maos")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfmaos.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Nusawungu")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfnusawungu.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Patimuan")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfpatimuan.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Sampang")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfsampang.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Sidareja")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfsidareja.pdf").load();
        } else if (txtpdf.getText().equals("Kecamatan Wanareja")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfwanareja.pdf").load();
        }
    }

    public void kembali(View view) {
        Intent balik = new Intent(ShowPdf.this, DataKecamatan.class);
        startActivity(balik);
    }
}
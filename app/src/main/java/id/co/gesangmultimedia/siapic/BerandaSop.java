package id.co.gesangmultimedia.siapic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class BerandaSop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_sop);
    }

    public void gasik(View view) {
        Intent bali = new Intent(BerandaSop.this, MainActivity.class);
        startActivity(bali);
    }

    public void showOss(View view) {
        PDFView pdfOss = findViewById(R.id.pdfViewSop);
        pdfOss.fromAsset("sopijinoss.pdf").load();
        pdfOss.fitToWidth();
        pdfOss.setMinZoom(60);
        pdfOss.setMidZoom(80);
        pdfOss.setMaxZoom(100);
        pdfOss.setLayerType(View.LAYER_TYPE_HARDWARE,null);
    }

    public void clear(View view) {
        Toast.makeText(BerandaSop.this, "Silahkan pilih tombol OSS atau Sijempol untuk membaca SOP", Toast.LENGTH_SHORT).show();
    }

    public void jempol(View view) {
        PDFView pdfJempol = findViewById(R.id.pdfViewSop);
        pdfJempol.fromAsset("sopijinjempol.pdf");
        pdfJempol.fitToWidth();
        pdfJempol.setMinZoom(60);
        pdfJempol.setMidZoom(80);
        pdfJempol.setMaxZoom(100);
        pdfJempol.setLayerType(View.LAYER_TYPE_HARDWARE,null);
    }

    public void gooss(View view) {
        String url = "https://oss.go.id/portal/";
        Intent weboss = new Intent(Intent.ACTION_VIEW);
        weboss.setData(Uri.parse(url));
        startActivity(weboss);
    }

    public void gojempol(View view) {
        String url = "https://sijempol.cilacapkab.go.id/";
        Intent webjempol = new Intent(Intent.ACTION_VIEW);
        webjempol.setData(Uri.parse(url));
        startActivity(webjempol);
    }
}
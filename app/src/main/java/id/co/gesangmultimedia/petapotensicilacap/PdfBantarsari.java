package id.co.gesangmultimedia.petapotensicilacap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfBantarsari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_bantarsari);
        TextView txtPdf = findViewById(R.id.txtPdf);
        String ambiljudul =  super.getIntent().getExtras().getString("judul");
        txtPdf.setText(ambiljudul);
        PDFView pdfKecamatan = findViewById(R.id.pdfView);
        pdfKecamatan.fromAsset("pdfbantarsari.pdf").load();
    }
}
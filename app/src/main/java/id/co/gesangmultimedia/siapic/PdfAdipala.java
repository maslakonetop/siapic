package id.co.gesangmultimedia.siapic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfAdipala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_adipala);

        TextView txtPdf = findViewById(R.id.txtPdf);
        String ambiljudul =  super.getIntent().getExtras().getString("judul");
        txtPdf.setText(ambiljudul);
        //PDFView pdfView = findViewById(R.id.pdfView);
        if(txtPdf.getText().equals("Kecamatan Adipala")) {
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("pdfadipala.pdf").load();
        }
    }
}
package id.co.gesangmultimedia.siapic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pengaturan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
    }

    public void balik(View view) {
        Intent balik = new Intent(Pengaturan.this, MainActivity.class);
        startActivity(balik);
    }

    public void simpan(View view) {
        Toast.makeText(Pengaturan.this, "Setingan Aplikasi Anda Telah disimpan", Toast.LENGTH_LONG).show();
    }
}
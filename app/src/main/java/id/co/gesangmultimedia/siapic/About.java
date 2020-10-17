package id.co.gesangmultimedia.siapic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class About<isiAbout> extends AppCompatActivity {
    private isiAbout txtAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }
}
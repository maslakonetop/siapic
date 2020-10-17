package id.co.gesangmultimedia.siapic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LaporanBug extends AppCompatActivity {
private ProgressBar pbar;
private Button ShowProgressBarr, HideProgressbar;
private TextView teksnama;
private TextView teksemail;
private Spinner spJenisBug;
private TextView nomreTelpon;
private TextView teksdeskripsi;
private TextView ambilData;
private TextView persentasi1;
    private int Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_bug);
        final Spinner spinner = (Spinner) findViewById(R.id.spBug);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bug, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinSelection =spinner.getSelectedItem().toString();
                if (spinSelection.equals("Aplikasi Melambat")){
                    Toast.makeText(getApplicationContext(), "Anda Memilih Error Aplikasi Melambat", Toast.LENGTH_SHORT).show();
                }
                else if(spinSelection.equals("Aplikasi Error")){
                    Toast.makeText(getApplicationContext(), "Anda Memilih Aplikasi Error", Toast.LENGTH_SHORT).show();
                }
                else if(spinSelection.equals("Map Tidak Tampil")){
                    Toast.makeText(getApplicationContext(), "Anda Memilih Error Map Tidak Tampil", Toast.LENGTH_SHORT).show();
                }
                else if(spinSelection.equals("Error Lain")){
                    Toast.makeText(getApplicationContext(), "Error Lain: Silahkan Tulis di Deskripsi", Toast.LENGTH_SHORT).show();
                }
                else if(spinSelection.equals("Pilih Bug")){
                    Toast.makeText(getApplicationContext(), "Anda Belum Memilih Jenis Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                 }
            });
        pbar = (ProgressBar) findViewById(R.id.progressBar2);
        pbar.setVisibility(View.GONE);
        ShowProgressBarr = (Button) findViewById(R.id.btnSubmit);
        teksnama = (EditText) findViewById(R.id.edTxtNama);
        teksemail = (EditText) findViewById(R.id.edtTxtEmail);
        spJenisBug = (Spinner) findViewById(R.id.spBug);
        nomreTelpon= (EditText) findViewById(R.id.editTextPhone);
        teksdeskripsi = (EditText) findViewById(R.id.edtTxtDesc);
        ambilData= (TextView) findViewById(R.id.txtAmbilData);
        ambilData.setVisibility(View.GONE);
        persentasi1 = (TextView) findViewById(R.id.persentasi1);
        persentasi1.setVisibility(View.GONE);
        ShowProgressBarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbar.setVisibility(View.VISIBLE);
                pbar.setProgress(0);
                teksnama.setEnabled(false);
                teksemail.setEnabled(false);
                teksdeskripsi.setEnabled(false);
                ambilData.setVisibility(View.VISIBLE);
                persentasi1.setVisibility(View.VISIBLE);
                final Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        // Menampung semua data yang ingin diproses oleh thread
                        persentasi1.setText(String.valueOf(Value)+"%");
                        if(Value == pbar.getMax()){
                            Toast.makeText(getApplicationContext(), "GIS Termuat 10 detik!", Toast.LENGTH_SHORT).show();
                            teksdeskripsi.setEnabled(true);
                            teksemail.setEnabled(true);
                            teksdeskripsi.setEnabled(true);
                            ambilData.setVisibility(View.GONE);
                            persentasi1.setVisibility(View.GONE);
                            finish();
                        }
                        Value++;
                    }
                };
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            for(int w=0; w<=pbar.getMax(); w++){
                                pbar.setProgress(w); // Memasukan Value pada ProgressBar
                                // Mengirim pesan dari handler, untuk diproses didalam thread
                                handler.sendMessage(handler.obtainMessage());
                                Thread.sleep(50); // Waktu Pending 100ms/0.1 detik
                            }
                        }catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
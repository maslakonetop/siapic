package id.co.gesangmultimedia.siapic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class TampilkanVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_video);
        final EditText editText = (EditText)findViewById(R.id.etDeskripsi);
        String isiVideo =super.getIntent().getExtras().getString("judul");
        editText.setText(isiVideo);
        final TextView judulvideo = (TextView)findViewById(R.id.txtStringFilm);
        String idvideo = super.getIntent().getExtras().getString("videoid");
        judulvideo.setText(idvideo);

        final YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = (String) judulvideo.getText();
                youTubePlayer.loadVideo(videoId, 0);
                youTubePlayerView.getPlayerUiController();
            }
        });
    }

    public void balik(View view) {
        Intent balik = new Intent(TampilkanVideo.this, VideoPotensi.class);
        startActivity(balik);
    }
}
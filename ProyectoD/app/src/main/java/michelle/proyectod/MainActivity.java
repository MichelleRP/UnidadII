package michelle.proyectod;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void Gato(View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.AudioGato);
        mp.start();
    }

    public void Leon (View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.AudioLeon);
        mp.start();
    }
}
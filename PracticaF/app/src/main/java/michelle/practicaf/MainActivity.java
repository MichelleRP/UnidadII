package michelle.practicaf;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends ActionBarActivity implements MediaPlayer.OnCompletionListener {
    TextView txtProgre;
    MediaRecorder recordr;
    MediaPlayer playr;
    File archivo;
    Button btnGrabar, btnDetener, btnReproducir;

    public void onCompletion(MediaPlayer mp) {
        btnGrabar.setEnabled(true);
        btnDetener.setEnabled(true);
        btnReproducir.setEnabled(true);
        txtProgre.setText("Listo");
    }

    public void Grabar(View v) {
        recordr = new MediaRecorder();
        recordr.setAudioSource(MediaRecorder.AudioSource.MIC);
        recordr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recordr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory()
                .getPath());
        try {
            archivo = File.createTempFile("temporal", ".3gp", path);
        } catch (IOException e) {
        }
        recordr.setOutputFile(archivo.getAbsolutePath());
        try {
            recordr.prepare();
        } catch (IOException e) {
        }
        recordr.start();
        txtProgre.setText("Grabando");
        btnGrabar.setEnabled(false);
        btnDetener.setEnabled(true);
    }

    public void Detener(View v) {
        recordr.stop();
        recordr.release();
        playr = new MediaPlayer();
        playr.setOnCompletionListener(this);
        try {
            playr.setDataSource(archivo.getAbsolutePath());
        } catch (IOException e) {
        }
        try {
            playr.prepare();
        } catch (IOException e) {
        }
        btnGrabar.setEnabled(true);
        btnDetener.setEnabled(false);
        btnReproducir.setEnabled(true);
        txtProgre.setText("Listo para reproducir");
    }

    public void Reproducir(View v) {
        playr.start();
        btnGrabar.setEnabled(false);
        btnDetener.setEnabled(false);
        btnReproducir.setEnabled(false);
        txtProgre.setText("Reproduciendo");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtProgre=(TextView)findViewById(R.id.txt_Prog);
        btnGrabar = (Button)findViewById(R.id.btn_Grabar);
        btnDetener = (Button)findViewById(R.id.btn_Detener);
        btnReproducir = (Button)findViewById(R.id.btn_Reproducir);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

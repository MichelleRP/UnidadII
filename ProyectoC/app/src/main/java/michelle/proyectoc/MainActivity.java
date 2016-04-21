package michelle.proyectoc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imviImagen;
    Button btnGirar, btnTrasladar, btnAmpliar, btnTransparencia;

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnGirar:

                Animation giro;
                giro = AnimationUtils.loadAnimation(this, R.anim.girar);
                giro.reset();
                imviImagen.startAnimation(giro);

                break;

            case R.id.btnTrasladar:

                Animation trasladar;
                trasladar = AnimationUtils.loadAnimation(this, R.anim.trasladar);
                trasladar.reset();
                imviImagen.startAnimation(trasladar);
                break;

            case R.id.btnAmpliar:

                Animation ampliar;
                ampliar=AnimationUtils.loadAnimation(this, R.anim.ampliar);
                ampliar.reset();
                imviImagen.startAnimation(ampliar);
                break;

            case R.id.btnTransparencia:

                Animation trans;
                trans = AnimationUtils.loadAnimation(this, R.anim.transparencia);
                trans.reset();
                imviImagen.startAnimation(trans);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imviImagen=(ImageView)findViewById(R.id.imviImagen);
        btnGirar=(Button)findViewById(R.id.btnGirar);
        btnTrasladar=(Button)findViewById(R.id.btnTrasladar);
        btnAmpliar=(Button)findViewById(R.id.btnAmpliar);
        btnTransparencia=(Button)findViewById(R.id.btnTransparencia);

        btnGirar.setOnClickListener(this);
        btnTrasladar.setOnClickListener(this);
        btnAmpliar.setOnClickListener(this);
        btnTransparencia.setOnClickListener(this);

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

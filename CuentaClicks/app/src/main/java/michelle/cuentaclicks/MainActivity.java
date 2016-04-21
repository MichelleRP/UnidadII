package michelle.cuentaclicks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int clic=0,clong=0,touch=0,focus=0,key=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button onClic=(Button)findViewById(R.id.btn_onclic);
        final TextView c_onclic=(TextView)findViewById(R.id.lbl_onClic);
        onClic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic++;
                c_onclic.setText(""+clic);
            }
        });

        Button onLong=(Button)findViewById(R.id.btn_onlong);
        final TextView c_onlong=(TextView)findViewById(R.id.lbl_onLong);
        onLong.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clong++;
                c_onlong.setText(""+clong);
                return true;
            }
        });

        Button onTouch=(Button)findViewById(R.id.btn_ontouch);
        final TextView c_onTouch=(TextView)findViewById(R.id.lbl_onTouch);
        onTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    touch++;
                    c_onTouch.setText(""+touch);
                    return true;
                }
                return false;
            }
        });

        EditText onKey= (EditText)findViewById(R.id.txt_onkey);
        final TextView c_onKey=(TextView)findViewById(R.id.lbl_onKey);
        onKey.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode == KeyEvent.KEYCODE_1)){
                    key++;
                    c_onKey.setText(""+key);
                    return true;
                }
                return true;
            }
        });


        EditText onFocus=(EditText)findViewById(R.id.txt_onfocus);
        //Button onFocus=(Button)findViewById(R.id.btn_onfocus);
        final TextView c_onFocus=(TextView)findViewById(R.id.lbl_onFocus);
        onFocus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    focus++;
                    c_onFocus.setText(""+focus);
                }
            }
        });

    }


}
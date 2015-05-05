package be.howest.nmct.explicitintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ExplicitActivity extends Activity {

    public static final String EXTRA_INFO = "be.howest.nmct.explicitintents.EXTRA_INFO";
    public static final int MY_RESULT_CODE = 3;
    private TextView txtTekst;
    private Button btnOk;
    private Button btnCancel;
    private Button btnEigenResultCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        txtTekst = (TextView) findViewById(R.id.txtTekst);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnEigenResultCode = (Button) findViewById(R.id.btnEigenResultCode);

        String value = getIntent().getStringExtra(ExplicitActivity.EXTRA_INFO);
        txtTekst.setText(value.toString());

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnEigenResultCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_INFO_BACK_LASTNAME,"Balcaen");
                intent.putExtra(MainActivity.EXTRA_INFO_BACK_AGE, 20);
                setResult(MY_RESULT_CODE, intent);
                finish();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explicit, menu);
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

package launching.nmct.howest.be.week4oef3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button btnNMCT;
    private Button btnCall;
    private Button btnDial;
    private Button btnGeo;
    private Button btnContacts;
    private Button btnEFC;
    private Button btnBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNMCT = (Button) findViewById(R.id.btnNMCT);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnDial = (Button) findViewById(R.id.btnDial);
        btnGeo = (Button) findViewById(R.id.btnGeo);
        btnContacts = (Button) findViewById(R.id.btnContacts);
        btnEFC = (Button) findViewById(R.id.btnEFC);
        btnBMI = (Button) findViewById(R.id.btnBMI);

        btnNMCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW);
                browse.setData(Uri.parse("http://www.nmct.be"));
                startActivity(browse);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:0477916572"));
                startActivity(call);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:0477916572"));
                startActivity(dial);
            }
        });

        btnGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent geo = new Intent(MainActivity.this,GeoActivity.class);

                startActivity(geo);
            }
        });

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contacts = new Intent(Intent.ACTION_VIEW);
                contacts.setData(Uri.parse("content://contacts/people"));
                startActivity(contacts);
            }
        });

        btnEFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EFC = new Intent(Intent.ACTION_VIEW);
                EFC.setData(Uri.parse("content://contacts/people/1"));
                startActivity(EFC);
            }
        });

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("be.howest.bmi");
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {

                }
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

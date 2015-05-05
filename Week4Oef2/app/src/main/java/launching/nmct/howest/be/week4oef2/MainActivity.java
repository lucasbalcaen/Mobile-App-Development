package launching.nmct.howest.be.week4oef2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends Activity {

    private Button btnLaunch;
    private Button btnOnderzoek4;



    public void launchWithAction(View v)
    {
        //Intent intent = new Intent(Constants.ACTION_IMPLy);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_CAR_DOCK); //activity zal enkel runnen als phone in een car dock gestoken wordt //maar als ik in manifest dat erbij doe werkt et wel
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if(isIntentSafe == true)
        {
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainActivity.this,"Intent bestaat niet",Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLaunch = (Button) findViewById(R.id.btnLaunchWithAction);
        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWithAction(v);
            }
        });

        btnOnderzoek4 = (Button) findViewById(R.id.btnOnderzoek4);
        btnOnderzoek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onderzoek4();
            }
        });
    }

    private void onderzoek4()
    {
        Intent intent = new Intent(Constants.ACTION_IMPLy, Uri.parse("xtp:///somedata")); //als je een data tagt hebt in je manifest moet je hem meegeven of tmarcheert nie peisk
        startActivity(intent);
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

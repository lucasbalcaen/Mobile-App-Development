package be.howest.nmct.explicitintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    public static final int REQUEST_CODE_EXPLICIT = 1;
    public static final String EXTRA_INFO_BACK_LASTNAME = "be.howest.nmct.explicitintents.EXTRA_INFO_BACK_LASTNAME";
    public static final String EXTRA_INFO_BACK_AGE = "be.howest.nmct.explicitintents.EXTRA_INFO_BACK_AGE";

    private Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity(v);
            }
        });
    }

    public void startSecondActivity(View v)
    {
        Intent intent = new Intent(MainActivity.this,ExplicitActivity.class);
        intent.putExtra(ExplicitActivity.EXTRA_INFO,"2NMCT");
        startActivityForResult(intent, REQUEST_CODE_EXPLICIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CODE_EXPLICIT:
                //wat was het antwoord?
                switch(resultCode){
                    case RESULT_CANCELED:
                        Toast.makeText(MainActivity.this,"User selects CANCEL", Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_OK:
                        Toast.makeText(MainActivity.this,"User selects OK", Toast.LENGTH_SHORT).show();
                        break;
                    case ExplicitActivity.MY_RESULT_CODE:

                        String value = data.getStringExtra(EXTRA_INFO_BACK_LASTNAME);
                        int age = data.getIntExtra(EXTRA_INFO_BACK_AGE,0);
                        Toast.makeText(MainActivity.this,"Last name "+value + " Age "+age, Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            default:super.onActivityResult(requestCode, resultCode, data);
        }

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

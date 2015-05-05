package nmct.howest.be.horoscoop;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText txtUwGegevens;
    private EditText txtNaam;
    private EditText txtVoornaam;
    private TextView txbGeboortejaar;
    private TextView txtGeboortejaar;
    private Button btnGeboortejaar;
    private Button btnHoroscoop;
    private ImageView imgHoroscoop;

    public static final String EXTRA_BIRTHYEAR = "be.howest.nmct.week5oef1.BIRTHYEAR";
    public static final int REQUEST_BIRTHDAY = 0;
    public static final int REQUEST_HOROSCOOP = 0;
    public static final String IMAGE_HOROSCOOP = "be.howest.nmct.week5oef1.HOROSCOPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUwGegevens = (EditText) findViewById(R.id.txUwGegevens);
        txtNaam = (EditText) findViewById(R.id.txtNaam);
        txtVoornaam = (EditText) findViewById(R.id.txtVoornaam);
        txbGeboortejaar = (TextView) findViewById(R.id.txbGeboortejaar);
        txtGeboortejaar = (TextView) findViewById(R.id.txtGeboortejaar);
        btnGeboortejaar = (Button) findViewById(R.id.btnGeboortejaar);
        btnHoroscoop = (Button) findViewById(R.id.btnHoroscoop);
        imgHoroscoop = (ImageView) findViewById(R.id.imgHoroscoop);

        btnGeboortejaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecteerGeboortejaar(v);
            }
        });

        btnHoroscoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecteerHoroscoop(v);
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

    public void selecteerGeboortejaar(View v)
    {
        Intent intent = new Intent(MainActivity.this,SelectGeboortejaarActivity.class);
        startActivityForResult(intent, REQUEST_BIRTHDAY); //request code meegegeven zodat hij weet van welke gestarte activity hij komt. De infrastructuur houdt dat bij en weet dan naar waar hij moet terugsturen
    }

    public void selecteerHoroscoop(View v)
    {
        Intent intent = new Intent(MainActivity.this,Horoscoop.class);
        startActivityForResult(intent, REQUEST_HOROSCOOP); //request code meegegeven zodat hij weet van welke gestarte activity hij komt. De infrastructuur houdt dat bij en weet dan naar waar hij moet terugsturen
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            Bundle geboortejaarBundle = data.getExtras();
            int foto = Integer.parseInt(geboortejaarBundle.get(IMAGE_HOROSCOOP).toString());
            if(foto > 1899) {
                txtGeboortejaar.setText(""+foto);
            }else
            {
                String ding = Data.Horoscoop.values()[foto].getNaamHoroscoop();

                imgHoroscoop.setImageResource(getResourceId(ding));
            }

        }
    }

    private int getResourceId(String horoscoop)
    {
        switch(horoscoop)
        {
            case "Waterman":
                return R.drawable.waterman;
            case "Vissen":
                return R.drawable.vissen;
            case "Schorpioen":
                return R.drawable.schorpioen;
            case "Boogschutter":
                return R.drawable.boogschutter;
            case "Steenbok":
                return R.drawable.steenbok;
            case "Kreeft":
                return R.drawable.kreeft;
            case "Weegschaal":
                return R.drawable.weegschaal;
            case "Tweeling":
                return R.drawable.tweeling;
            case "Leeuw":
                return R.drawable.leeuw;
            case "Maagd":
                return R.drawable.maagd;
            case "Stier":
                return R.drawable.stier;
            case "Ram":
                return R.drawable.ram;
            default:
                return 0;
        }

    }
}

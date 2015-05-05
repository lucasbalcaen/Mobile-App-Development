package balcaen.lucas.be.mediamarktbelgium;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class MainActivity extends Activity implements OverzichtFragment.OverzichtFragmentListener {

    public static final String EXTRA_NAAM = "balcaen.lucas.be.mediamarktbelgium.EXTRA_NAAM";
    public static final String EXTRA_ADRES = "balcaen.lucas.be.mediamarktbelgium.EXTRA_ADRES";
    public static final String EXTRA_HUISNR = "balcaen.lucas.be.mediamarktbelgium.EXTRA_HUISNR";
    public static final String EXTRA_POSTCODE = "balcaen.lucas.be.mediamarktbelgium.EXTRA_POSTCODE";
    public static final String EXTRA_GEMEENTE = "balcaen.lucas.be.mediamarktbelgium.EXTRA_GEMEENTE";
    boolean meneerBoolean = false;
    OverzichtFragment frag = new OverzichtFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meneerBoolean = false;
        if(savedInstanceState == null && meneerBoolean == false)
        {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, frag,"fraggie")
                    .addToBackStack(null).commit();

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

    @Override
    public void showDetails(String naam, String adres, String huisnr, String postcode, String gemeente) {
        meneerBoolean = true;


        if(meneerBoolean == true){
            if (frag.getTag().equals("fraggie")) {
                getFragmentManager().beginTransaction().remove(frag).commit();
            }
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DetailFragment detailFragment = DetailFragment.newInstance(naam, adres, huisnr, postcode,gemeente);
        fragmentTransaction.replace(R.id.My_Container_1_ID,detailFragment).addToBackStack(null);

        KaartFragment kaartFragment = KaartFragment.newInstance(naam, adres, huisnr, postcode,gemeente);
        fragmentTransaction.replace(R.id.My_Container_2_ID,kaartFragment).addToBackStack(null);

        fragmentTransaction.commit();

    }


}

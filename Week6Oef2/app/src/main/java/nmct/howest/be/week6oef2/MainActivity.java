package nmct.howest.be.week6oef2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MainFragment.MainFragmentListener,SelectGeboortejaarFragment.SelectGeboortejaarFragmentListener {
    public String year = "1900";
    public static final String EXTRA_BIRTHYEAR = "nmct.howest.be.week6oef2.EXTRA_BIRTHYEAR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container, MainFragment.newInstance(year))
                    .commit();
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
    public void showBirthYearFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SelectGeboortejaarFragment geboortejaarFragment =  SelectGeboortejaarFragment.newInstance();
        fragmentTransaction.replace(R.id.container, geboortejaarFragment).addToBackStack(null).commit();
    }

    @Override
    public void showMainFragment(String year) {
        this.year = year;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment mainFragment = MainFragment.newInstance(this.year);
        fragmentTransaction.replace(R.id.container,mainFragment).addToBackStack(null).commit();
    }

    public void showHoroscopeFragment()
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HoroscoopFragment horoscoopFragment = HoroscoopFragment.newInstance();
        fragmentTransaction.replace(R.id.container,horoscoopFragment).addToBackStack(null).commit();
    }
}

package nmct.howest.be.scoresstudenten;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class StudentsActivity extends Activity implements StudentsFragment.StudentsFragmentListener{

    public static final String EXTRA_EMAIL = "nmct.howest.be.scoresstudenten.EXTRA_EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container,new StudentsFragment()).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_students, menu);
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
    public void showStudentDetails(String email) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentDetailsFragment studentDetailsFragment = StudentDetailsFragment.newInstance(email);
        fragmentTransaction.replace(R.id.container,studentDetailsFragment).addToBackStack(null).commit();
    }
}

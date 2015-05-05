package nmct.howest.be.week6oef2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Lucas on 2/05/2015.
 */
public class MainFragment extends Fragment {
    private EditText editTextFirstname;
    private EditText editTextName;
    private TextView textViewYear;
    private Button buttonYear;
    private Button buttonHoroscoop;
    private MainFragmentListener mainFragmentListener;
    public String year;

    public MainFragment()
    {

    }

    public static MainFragment newInstance(String year)
    {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXTRA_BIRTHYEAR,year);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getActivity() !=null)
        {
            this.year = getArguments().getString(MainActivity.EXTRA_BIRTHYEAR,"1900");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        editTextFirstname = (EditText) v.findViewById(R.id.editTextFirstname);
        editTextName = (EditText)v.findViewById(R.id.editTextName);
        textViewYear = (TextView) v.findViewById(R.id.textViewYear);
        buttonYear = (Button) v.findViewById(R.id.buttonYear);
        buttonHoroscoop = (Button) v.findViewById(R.id.buttonHoroscope);

        buttonYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFragmentListener.showBirthYearFragment();
            }
        });

        buttonHoroscoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFragmentListener.showHoroscopeFragment();
            }
        });

        showBirthYear();

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            this.mainFragmentListener = (MainFragmentListener) activity;
        }catch(ClassCastException ex){
            throw new ClassCastException(activity.toString() + " must implement MainFragmentListener");
        }

    }

    public void showBirthYear()
    {
        this.textViewYear.setText("Uw geboortejaar: "+ this.year);
    }

    public interface MainFragmentListener
    {
        public void showBirthYearFragment();
        public void showHoroscopeFragment();

    }
}

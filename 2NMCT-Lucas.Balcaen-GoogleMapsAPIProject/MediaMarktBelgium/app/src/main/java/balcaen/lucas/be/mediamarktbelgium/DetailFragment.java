package balcaen.lucas.be.mediamarktbelgium;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Lucas on 3/05/2015.
 */
public class DetailFragment extends Fragment {

    private String naam;
    private String adres;
    private String huisnr;
    private String postcode;
    private String gemeente;

    private EditText editTextWinkel;
    private TextView textViewStraat;
    private TextView textViewHuisNr;
    private TextView textViewStad;
    private TextView textViewPostcode;
    private Button btnOverzicht;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment,container,false);

        this.editTextWinkel = (EditText) v.findViewById(R.id.editTextWinkel);
        this.textViewStraat = (TextView) v.findViewById(R.id.textViewStraat);
        this.textViewHuisNr = (TextView) v.findViewById(R.id.textViewHuisNr);
        this.textViewStad = (TextView) v.findViewById(R.id.textViewStad);
        this.textViewPostcode = (TextView) v.findViewById(R.id.textViewPostcode);
        this.btnOverzicht = (Button) v.findViewById(R.id.btnOverzicht);

        btnOverzicht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailFragment.this.getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        showWinkelDetails();

        return v;
    }

    private void showWinkelDetails()
    {
        this.editTextWinkel.setText(naam);
        this.textViewStraat.setText(adres);
        this.textViewHuisNr.setText(huisnr);
        this.textViewStad.setText(gemeente);
        this.textViewPostcode.setText(postcode);
    }

    public DetailFragment()
    {

    }

    public static DetailFragment newInstance(String naam, String adres, String huisnr, String postcode, String gemeente)
    {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXTRA_NAAM,naam);
        bundle.putString(MainActivity.EXTRA_ADRES,adres);
        bundle.putString(MainActivity.EXTRA_HUISNR,huisnr);
        bundle.putString(MainActivity.EXTRA_POSTCODE,postcode);
        bundle.putString(MainActivity.EXTRA_GEMEENTE,gemeente);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getActivity() != null){
            Bundle bundle = getArguments();
            this.naam = bundle.getString(MainActivity.EXTRA_NAAM);
            this.adres = bundle.getString(MainActivity.EXTRA_ADRES);
            this.huisnr = bundle.getString(MainActivity.EXTRA_HUISNR);
            this.postcode = bundle.getString(MainActivity.EXTRA_POSTCODE);
            this.gemeente = bundle.getString(MainActivity.EXTRA_GEMEENTE);
        }
    }


}

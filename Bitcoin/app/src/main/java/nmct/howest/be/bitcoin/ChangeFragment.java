package nmct.howest.be.bitcoin;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lucas on 1/05/2015.
 */
public class ChangeFragment extends Fragment {
    private EditText txtBedragInEuro;
    private Button btnNaarBitcoin;
    private Button btnNaarEuro;
    private EditText txtBedragInBitcoin;
    private EditText txtWaardeKoers;
    private Button btnWijzigKoers;
    private float amountEuro = 1;
    private float amountBitcoin = 1;
    public static final String BITCOIN_RATE = "be.howest.nmct.bitcoin.NEW_BITCOIN_RATE";
    private float currentRateBitcoinInEuro = 100;
    public ChangeFragmentListener changeFragmentListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getActivity() != null)
        {
            currentRateBitcoinInEuro = getArguments().getFloat(BITCOIN_RATE, 100f);
        }

    }
    public static ChangeFragment newInstance(float bitcoinrate)
    {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putFloat(BITCOIN_RATE,bitcoinrate);
        fragment.setArguments(args);
        return fragment;
    }
    public ChangeFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_change,container,false);

        txtBedragInEuro = (EditText) v.findViewById(R.id.txtBedragInEuro);
        btnNaarBitcoin =(Button) v.findViewById(R.id.btnNaarBitcoin);
        btnNaarEuro = (Button) v.findViewById(R.id.btnNaarEuro);
        txtBedragInBitcoin = (EditText) v.findViewById(R.id.txtBedragInBitcoin);
        txtWaardeKoers = (EditText) v.findViewById(R.id.txtWaardeKoers);
        btnWijzigKoers = (Button) v.findViewById(R.id.btnWijzigKoers);

        btnNaarEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToEuro();
            }
        });

        btnNaarBitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToBitcoin();
            }
        });

        btnWijzigKoers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragmentListener.showFragmentBitcoinRate(currentRateBitcoinInEuro);
            }
        });

        showRate();

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            changeFragmentListener = (ChangeFragmentListener) activity;
        }

        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+ " must implement ChangeFragmentListener");
        }
    }

    private void showRate()
    {
        txtWaardeKoers.setText("1 euro = " + currentRateBitcoinInEuro + " bitcoin");
    }

    private void changeToEuro()
    {
        amountBitcoin = Float.parseFloat(txtBedragInBitcoin.getText().toString());
        float tempAmountEuro = amountBitcoin * currentRateBitcoinInEuro;
        txtBedragInEuro.setText(tempAmountEuro+"");
    }

    private void changeToBitcoin()
    {
        amountEuro = Float.parseFloat(txtBedragInEuro.getText().toString());
        float tempAmountBitcoin = amountEuro/currentRateBitcoinInEuro;
        txtBedragInBitcoin.setText(""+tempAmountBitcoin);
    }

    public interface ChangeFragmentListener{
        public void showFragmentBitcoinRate(float rate);
    }
}

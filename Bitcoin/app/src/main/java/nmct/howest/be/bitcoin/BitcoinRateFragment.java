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
public class BitcoinRateFragment extends Fragment {
    private EditText txtEuro;
    private Button btnWijzigen;
    private float rate1BitcoinInEuros;
    static final String BITCOIN_RATE = "be.howest.nmct.bitcoin.NEW_BITCOIN_RATE";
    public BitcoinRateFragmentListener bitcoinRateFragmentListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            rate1BitcoinInEuros = getArguments().getFloat(BITCOIN_RATE);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            bitcoinRateFragmentListener = (BitcoinRateFragmentListener) activity;
        }catch(ClassCastException ex)
        {
            throw new ClassCastException(activity.toString()+ " must implement BitcoinRateFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rate_fragment,container,false);

        txtEuro = (EditText) v.findViewById(R.id.txtEuro);
        btnWijzigen = (Button) v.findViewById(R.id.btnWijzigen);
        btnWijzigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRate();
                bitcoinRateFragmentListener.showFragmentChange(rate1BitcoinInEuros);
            }
        });

        return v;
    }

    public static BitcoinRateFragment newInstance(float bitcoinrate)
    {
        BitcoinRateFragment fragment = new BitcoinRateFragment();
        Bundle args = new Bundle();
        args.putFloat(BITCOIN_RATE, bitcoinrate);
        fragment.setArguments(args);
        return fragment;
    }

    public BitcoinRateFragment(){

    }

    private void getRate()
    {
        rate1BitcoinInEuros = Float.parseFloat(txtEuro.getText().toString());
    }

    public interface BitcoinRateFragmentListener{
        public void showFragmentChange(float rate);
    }
}

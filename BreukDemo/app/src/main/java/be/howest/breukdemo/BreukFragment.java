package be.howest.breukdemo;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by giles on 20/02/2015.
 */


public class BreukFragment extends Fragment {
private TextView tvTeller,tvNoemer;
    private Button btnBereken;
    private TextView tvResultaat;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_breuk_demo,container,false);

        tvTeller = (EditText) v.findViewById(R.id.tvTeller);
        tvNoemer = (EditText) v.findViewById(R.id.tvNoemer);
        btnBereken = (Button) v.findViewById(R.id.btnBereken);
        tvResultaat = (TextView) v.findViewById(R.id.tvResultaat);

        btnBereken.setOnClickListener(new Button.OnClickListener(){
            @Override
        public void onClick(View v){
                int t = Integer.parseInt(tvTeller.getText().toString());
                int n = Integer.parseInt(tvNoemer.getText().toString());
                double w = (double)(t/n);
                tvResultaat.setText(""+w);
            }
        });
        return v;
    }



}
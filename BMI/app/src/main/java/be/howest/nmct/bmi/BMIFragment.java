package be.howest.nmct.bmi;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lucas on 1/05/2015.
 */
public class BMIFragment extends Fragment {

    private TextView txtInput;
    private EditText txtHeight;
    private EditText txtMass;
    private Button btnUpdate;
    private TextView txtBMIinfo;
    private ImageView imgBMI;
    private EditText txtIndex;
    private EditText txtCategorie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        this.txtInput = (TextView) v.findViewById(R.id.txtInput);
        this.txtHeight = (EditText) v.findViewById(R.id.txtHeight);
        this.txtMass = (EditText) v.findViewById(R.id.txtMass);
        this.btnUpdate = (Button) v.findViewById(R.id.btnUpdate);
        this.txtBMIinfo = (TextView) v.findViewById(R.id.txtBmiInfo);
        this.imgBMI = (ImageView) v.findViewById(R.id.imgBMI);
        this.txtIndex  = (EditText) v.findViewById(R.id.txtIndex);
        this.txtCategorie = (EditText) v.findViewById(R.id.txtCategorie);

        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berekenBMI(v);
            }
        });
        return v;

    }

    public void berekenBMI(View v)
    {
        BMIInfo bmi = new BMIInfo();
        int gewicht = Integer.parseInt(this.txtMass.getText().toString());
        float lengte = Float.parseFloat(this.txtHeight.getText().toString());

        bmi.setHeight(lengte);
        bmi.setMass(gewicht);

        this.txtIndex.setText(bmi.toString());

        this.imgBMI.setImageResource(bmi.getResourceID());
    }
}

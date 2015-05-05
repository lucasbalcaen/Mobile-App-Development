package be.howest.bmi;

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
 * Created by Lucas on 26/02/2015.
 */
public class BMIFragment extends Fragment {

    private EditText txtHeight, txtMass;
    private Button btnBerekenen;
    private TextView txtBMI, txtCategorie;
    private ImageView imgImage;

    //dit zorgt ervoor dat je view die je gedesigned hebt gekoppeld wordt aan de code in deze classe.
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_bmi,container,false);

        this.txtHeight = (EditText) v.findViewById(R.id.txtHeight); //we steken in onze eigen variable wat er in ons design zit.
        this.txtMass = (EditText) v.findViewById(R.id.txtMass);
        this.btnBerekenen = (Button) v.findViewById(R.id.btnBereken);
        this.imgImage = (ImageView) v.findViewById(R.id.imgImage);
        this.txtBMI = (TextView) v.findViewById(R.id.txtBMI);
        this.txtCategorie = (TextView) v.findViewById(R.id.txtCategorie);

        this.btnBerekenen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berekenBMI(v);
            }
        });


        return v; //je view teruggeven

    }

    public void berekenBMI(View v)
    {
        BMIInfo bmi = new BMIInfo();
        int gewicht = Integer.parseInt(this.txtMass.getText().toString());
        float lengte = Float.parseFloat(this.txtHeight.getText().toString());

        bmi.setHeight(lengte); //we stellen in de bmi klasse ons gewicht in die we uit de tekstvelden gehaald hebben.
        bmi.setMass(gewicht);

        this.txtBMI.setText(bmi.toString()); //dus we doen de toString methode in onze bmi klasse. daarin staat die calculate enzo
        this.imgImage.setImageResource(bmi.getResourceID());
    }
}

package be.howest.stopafstandandroid;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import be.howest.StopAfstandInfo;


public class StopAfstandSeekbar extends Fragment {


        private TextView tvStopafstand;

        private Button btnBereken;
        private RadioGroup rbWegtype;
        private RadioButton rbDroog,rbNat;


        @Override
        public View onCreateView(LayoutInflater inflater , ViewGroup container,Bundle savedInstanceState){
            View v = inflater.inflate(R.layout.fragment_stop_afstand,container,false);



            this.btnBereken = (Button) v.findViewById(R.id.btnBereken);
            this.tvStopafstand = (TextView) v.findViewById(R.id.tvStopafstand);
            this.rbWegtype=(RadioGroup) v.findViewById(R.id.rbWegtype);
            this.rbDroog = (RadioButton) v.findViewById(R.id.rbDroog);
            this.rbNat = (RadioButton) v.findViewById(R.id.rbNat);





            this.btnBereken.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    toonStopAfstand(v);
                }
            });




            return v;
        }


        public void toonStopAfstand(View v) {
            StopAfstandInfo sai = new StopAfstandInfo();
            int snelheid = Integer.parseInt(this.tvSnelheid.getText().toString());
            float reactietijd = Integer.parseInt(this.tvReactietijd.getText().toString());

            if (this.rbDroog.isChecked()) {

                sai.setWegType(StopAfstandInfo.WegType.DROOG);
            } else {
                sai.setWegType(StopAfstandInfo.WegType.NAT);
            }
            sai.setSnelheid(snelheid);
            sai.setReactieTijd(reactietijd);


            this.tvStopafstand.setText(sai.toString());



        }
}

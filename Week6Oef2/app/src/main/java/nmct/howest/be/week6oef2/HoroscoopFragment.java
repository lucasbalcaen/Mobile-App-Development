package nmct.howest.be.week6oef2;

import android.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nmct.howest.be.week6oef2.data.Data;

/**
 * Created by Lucas on 2/05/2015.
 */
public class HoroscoopFragment extends ListFragment {

    public TextView textViewName = null;
    public Button buttonInfo = null;
    public ImageView imageViewIcon = null;


    public HoroscoopFragment()
    {

    }

    public static HoroscoopFragment newInstance()
    {
        HoroscoopFragment horoscoopFragment = new HoroscoopFragment();
        return horoscoopFragment;
    }


    class HoroscoopAdapter extends ArrayAdapter<Data.Horoscoop> {
        public HoroscoopAdapter() {
            super(getActivity(), R.layout.row_horoscoop, R.id.textViewName, Data.Horoscoop.values());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);

            final Data.Horoscoop horoscope = Data.Horoscoop.values()[position];

            ViewHolder viewHolder = (ViewHolder) row.getTag();

            if(viewHolder == null)
            {
                viewHolder = new ViewHolder(row);
                row.setTag(viewHolder);
            }

            TextView textviewName = viewHolder.textViewName;
            textviewName.setText("" + horoscope.getNaamHoroscoop());

            ImageView imageViewIcon = viewHolder.imageViewIcon;
            imageViewIcon.setImageResource(horoscope.getDrawable());

            Button buttonInfo = viewHolder.buttonInfo;
            buttonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + horoscope.getBeginDatum() + " - " + horoscope.getEindDatum(), Toast.LENGTH_SHORT).show();
                }
            });


            return row;
        }
    }

    public class ViewHolder
    {
        public TextView textViewName = null;
        public Button buttonInfo = null;
        public ImageView imageViewIcon = null;

        public ViewHolder(View row)
        {
            textViewName = (TextView) row.findViewById(R.id.textViewName);
            buttonInfo = (Button) row.findViewById(R.id.buttonInfo);
            imageViewIcon = (ImageView) row.findViewById(R.id.imageViewIcon);
        }
    }
}

package nmct.howest.be.horoscoop;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Horoscoop extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HoroscoopAdapter adapter = new HoroscoopAdapter();
        setListAdapter(adapter);
        //setContentView(R.layout.activity_horoscoop);
    }

    class HoroscoopAdapter extends ArrayAdapter<Data.Horoscoop>{
        public HoroscoopAdapter(){
            super(Horoscoop.this,R.layout.row_horoscoop, R.id.textViewNaamHoroscoop, Data.Horoscoop.values());

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = super.getView(position,convertView, parent);

            final Data.Horoscoop horoscoop = Data.Horoscoop.values()[position];

            TextView textViewNaamHoroscoop = (TextView) row.findViewById(R.id.textViewNaamHoroscoop);
            textViewNaamHoroscoop.setText(horoscoop.getNaamHoroscoop());

            //afbeelding ophalen
            ImageView imgPrentje = (ImageView) row.findViewById(R.id.imgTeken);
            imgPrentje.setImageResource(getResourceId(horoscoop));

            //info weergeven
            Button btnInfo = (Button) row.findViewById(R.id.btnInfo);
            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String beginDatum = horoscoop.getBeginDatum();
                    String eindDatum = horoscoop.getEindDatum();
                    Toast.makeText(Horoscoop.this,beginDatum+"-"+eindDatum,Toast.LENGTH_SHORT).show();
                }
            });

            return row;
        }
    }

    private int getResourceId(Data.Horoscoop horoscoop)
    {
        switch(horoscoop)
        {
            case WATERMAN:
                return R.drawable.waterman;
            case VISSEN:
                return R.drawable.vissen;
            case SCHORPIOEN:
                return R.drawable.schorpioen;
            case BOOGSCHUTTER:
                return R.drawable.boogschutter;
            case STEENBOK:
                return R.drawable.steenbok;
            case KREEFT:
                return R.drawable.kreeft;
            case WEEGSCHAAL:
                return R.drawable.weegschaal;
            case TWEELING:
                return R.drawable.tweeling;
            case LEEUW:
                return R.drawable.leeuw;
            case MAAGD:
                return R.drawable.maagd;
            case STIER:
                return R.drawable.stier;
            case RAM:
                return R.drawable.ram;
            default:
                return 0;
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String picture = ""+position;
        Intent intent = new Intent();
        intent.putExtra(MainActivity.IMAGE_HOROSCOOP, picture);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_horoscoop, menu);
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
}

package nmct.howest.be.week6oef2;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Lucas on 2/05/2015.
 */
public class SelectGeboortejaarFragment extends ListFragment {
    private final static List<String> GEBOORTEJAREN;
    private ListAdapter myListAdapter;
    private SelectGeboortejaarFragmentListener listener;
    static{
        GEBOORTEJAREN = new ArrayList<>(Calendar.getInstance().get(Calendar.YEAR) -1900);
        for (int jaar = 1900; jaar < Calendar.getInstance().get(Calendar.YEAR); jaar++){
            GEBOORTEJAREN.add(""+jaar);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myListAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, GEBOORTEJAREN);
        setListAdapter(myListAdapter);
    }

    public SelectGeboortejaarFragment()
    {

    }

    public static SelectGeboortejaarFragment newInstance()
    {
        SelectGeboortejaarFragment selectGeboortejaarFragment = new SelectGeboortejaarFragment();
        return selectGeboortejaarFragment;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String sGeboortejaar = GEBOORTEJAREN.get(position);
        listener.showMainFragment(sGeboortejaar);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            listener = (SelectGeboortejaarFragmentListener) activity;
        }catch(ClassCastException ex){
            throw new ClassCastException(activity.toString() + " must implement SelectGeboortejaarFragment");
        }


    }

    public interface SelectGeboortejaarFragmentListener{
        public void showMainFragment(String year);
    }
}

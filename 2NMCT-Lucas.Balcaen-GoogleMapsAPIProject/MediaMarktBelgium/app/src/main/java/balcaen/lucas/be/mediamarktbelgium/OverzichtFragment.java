package balcaen.lucas.be.mediamarktbelgium;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import balcaen.lucas.be.mediamarktbelgium.loader.Contract;
import balcaen.lucas.be.mediamarktbelgium.loader.MediaMarktLader;

/**
 * Created by Lucas on 2/05/2015.
 */
public class OverzichtFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter adapter;
    private OverzichtFragmentListener listener;
    private String naam;
    private String adres;
    private String huisnr;
    private String postcode;
    private String gemeente;





    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] columns = new String[]
                {
                        Contract.MediaMarktColumns.COLUMN_NAAM,
                        Contract.MediaMarktColumns.COLUMN_ADRES,
                        Contract.MediaMarktColumns.COLUMN_HUISNR,
                        Contract.MediaMarktColumns.COLUMN_POSTCODE,
                        Contract.MediaMarktColumns.COLUMN_GEMEENTE
                };



        int[] viewIds = new int[]
                {
                      R.id.textViewWinkel
                };

        this.adapter = new SimpleCursorAdapter(getActivity(), R.layout.row_mediamarkt, null, columns, viewIds);
        setListAdapter(this.adapter);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MediaMarktLader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        this.adapter.swapCursor(null);
    }

    public OverzichtFragment()
    {

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try
        {
            this.listener = (OverzichtFragmentListener) activity;
        }

        catch(ClassCastException ex)
        {
            throw new ClassCastException(activity.toString() + " must implement OverzichtFragmentListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        naam = MediaMarktLader.matrixCursor.getString(1);
        adres = MediaMarktLader.matrixCursor.getString(2);
        huisnr = MediaMarktLader.matrixCursor.getString(3);
        postcode = MediaMarktLader.matrixCursor.getString(4);
        gemeente = MediaMarktLader.matrixCursor.getString(5);

        this.listener.showDetails(naam,adres,huisnr,postcode,gemeente);
    }

    public interface OverzichtFragmentListener{
        public void showDetails(String naam, String adres, String huisnr, String postcode, String gemeente);
    }
}

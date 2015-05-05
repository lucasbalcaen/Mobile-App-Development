package nmct.howest.be.week8oef2;

import android.app.Fragment;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

import nmct.howest.be.week8oef2.loader.Contract;
import nmct.howest.be.week8oef2.loader.StudentenhuizenLoader;

/**
 * Created by Lucas on 2/05/2015.
 */
public class StudentenhuizenFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor>{

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] columns = new String[]{
                Contract.KotColumns.COLUMN_ADRES,
                Contract.KotColumns.COLUMN_HUISNUMMER,
                Contract.KotColumns.COLUMN_GEMEENTE,
                Contract.KotColumns.COLUMN_AANTAL_KAMERS
        };

        int[] viewIds = new int[]{
                R.id.textViewAddress,
                R.id.textViewHomeNumber,
                R.id.textViewCity,
                R.id.textViewNumber
        };

        this.adapter = new SimpleCursorAdapter(getActivity(),R.layout.row_studentenhuis,null,columns,viewIds);
        setListAdapter(this.adapter);
        getLoaderManager().initLoader(0,null,this);
    }

    private SimpleCursorAdapter adapter;
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new StudentenhuizenLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        this.adapter.swapCursor(null);
    }


}

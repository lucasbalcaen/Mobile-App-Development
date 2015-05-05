package nmct.howest.be.scoresstudenten.loader;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.BaseColumns;

import java.util.Map;

import nmct.howest.be.scoresstudenten.data.ModulePunt;
import nmct.howest.be.scoresstudenten.data.Student;

/**
 * Created by Lucas on 2/05/2015.
 */
public class ModulePuntLoader extends AsyncTaskLoader<Cursor> {
    private Cursor cursor;
    private final String[] columnNames = new String[]
            {
                    BaseColumns._ID,
                    Contract.ModulePuntColumns.COLUMN_MODULE_NAAM,
                    Contract.ModulePuntColumns.COLUMN_MODULE_SCORE,
                    Contract.ModulePuntColumns.COLUMN_MODULE_STUDIEPUNTEN
            };
    private static Object lock = new Object();
    private Student student;

    /*
    ** Constructor
     */

    public ModulePuntLoader(Context context, Student student)
    {
        super(context);
        this.student = student;
    }

    /*
    ** Events
     */

    @Override
    protected void onStartLoading()
    {
        if(cursor != null)
        {
            deliverResult(cursor);
        }

        if(takeContentChanged() || cursor == null)
        {
            forceLoad();
        }
    }

    @Override
    public Cursor loadInBackground() {
        if(cursor == null)
        {
            loadCursor();
        }
        return cursor;
    }

    /*
    ** Methods
     */
    private void loadCursor()
    {
        synchronized (lock)
        {
            if(cursor != null)
            {
                return;
            }

            MatrixCursor matrixCursor = new MatrixCursor(columnNames);
            int id = 1;
            for(Map.Entry<String, ModulePunt> modulePunt : this.student.getScoresStudent().entrySet())
            {
                MatrixCursor.RowBuilder row = matrixCursor.newRow();
                row.add(id);
                row.add(modulePunt.getValue().getModule());
                row.add(modulePunt.getValue().getScore());
                row.add(modulePunt.getValue().getAantalStudiePunten());
                id++;
            }
            cursor = matrixCursor;
        }
    }
}

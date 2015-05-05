package nmct.howest.be.scoresstudenten.loader;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.BaseColumns;

import nmct.howest.be.scoresstudenten.data.Student;
import nmct.howest.be.scoresstudenten.data.StudentAdmin;

/**
 * Created by Lucas on 2/05/2015.
 */
public class StudentsLoader extends AsyncTaskLoader<Cursor>{
    private Cursor mCursor;

    private final String[] mColumnNames = new String[]{
            BaseColumns._ID,
            Contract.StudentColumns.COLUMN_STUDENT_NAAM,
            Contract.StudentColumns.COLUMN_STUDENT_VOORNAAM,
            Contract.StudentColumns.COLUMN_STUDENT_EMAIL,
            Contract.StudentColumns.COLUMN_STUDENT_SCORE_TOTAAL
    };

    private static Object lock = new Object();

    public StudentsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if(mCursor != null){
            deliverResult(mCursor);
        }
        if(takeContentChanged() || mCursor == null){
            forceLoad();
        }
    }

    @Override
    public Cursor loadInBackground() {
        if(mCursor == null){
            loadCursor();
        }
        return mCursor;
    }

    private void loadCursor()
    {
        synchronized (lock){
            if(mCursor !=null) return;

            MatrixCursor cursor = new MatrixCursor(mColumnNames);
            int id = 1;

            for(Student student : StudentAdmin.getInstance().getStudenten()){
                MatrixCursor.RowBuilder row = cursor.newRow();
                row.add(id);
                row.add(student.getNaamStudent());
                row.add(student.getVoornaamStudent());
                row.add(student.getEmailStudent());
                row.add(student.getTotaleScoreStudent());
                id++;
            }
            mCursor = cursor;
        }
    }
}

package nmct.howest.be.scoresstudenten;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;

import nmct.howest.be.scoresstudenten.data.Student;
import nmct.howest.be.scoresstudenten.data.StudentAdmin;
import nmct.howest.be.scoresstudenten.loader.Contract;
import nmct.howest.be.scoresstudenten.loader.StudentsLoader;

/**
 * Created by Lucas on 2/05/2015.
 */
public class StudentsFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private StudentAdaptar mAdaptar;
    private StudentsFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_students, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] columns = new String[]{
                Contract.StudentColumns.COLUMN_STUDENT_NAAM,
                Contract.StudentColumns.COLUMN_STUDENT_VOORNAAM,
                Contract.StudentColumns.COLUMN_STUDENT_EMAIL,
                Contract.StudentColumns.COLUMN_STUDENT_SCORE_TOTAAL
        };

        int[] viewIds = new int[]{R.id.textViewName, R.id.textViewFirstname, R.id.textViewMail, R.id.textViewScore};
        mAdaptar = new StudentAdaptar(getActivity(),R.layout.row_student,null,columns,viewIds,0);
        setListAdapter(mAdaptar);
        getLoaderManager().initLoader(0,null,this);

        }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Student student = StudentAdmin.getInstance().getStudenten().get(position);
        this.listener.showStudentDetails(student.getEmailStudent());

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new StudentsLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdaptar.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdaptar.swapCursor(null);
    }

    class StudentAdaptar extends SimpleCursorAdapter{

        public StudentAdaptar(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            super.bindView(view, context, cursor);

            ImageView icon = (ImageView) view.findViewById(R.id.imageViewStudent);

            int colnr = cursor.getColumnIndex(Contract.StudentColumns.COLUMN_STUDENT_SCORE_TOTAAL);
            double score = cursor.getDouble(colnr);
            DecimalFormat df = new DecimalFormat("##.00");
            TextView textviewTotaleScore = (TextView) view.findViewById(R.id.textViewScore);
            textviewTotaleScore.setText(df.format(score));

            if(score < 8){
                icon.setImageResource(R.drawable.student_red);
            }else if(score < 10){
                icon.setImageResource(R.drawable.student_orange);
            }else{
                icon.setImageResource(R.drawable.student_green);
            }
        }
    }

    public interface StudentsFragmentListener
    {
        public void showStudentDetails(String email);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try
        {
            this.listener = (StudentsFragmentListener) activity;
        }

        catch(ClassCastException ex)
        {
            throw new ClassCastException(activity.toString() + " must implement StudentsFragmentListener");
        }
    }
}

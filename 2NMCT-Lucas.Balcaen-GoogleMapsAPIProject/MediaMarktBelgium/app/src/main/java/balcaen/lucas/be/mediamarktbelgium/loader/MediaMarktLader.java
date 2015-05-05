package balcaen.lucas.be.mediamarktbelgium.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.BaseColumns;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Lucas on 2/05/2015.
 */
public class MediaMarktLader extends AsyncTaskLoader<Cursor> {
    public static MatrixCursor matrixCursor;
    private Cursor cursor;
    private final String[] columnNames = new String[]
            {
                    BaseColumns._ID,
                    Contract.MediaMarktColumns.COLUMN_NAAM,
                    Contract.MediaMarktColumns.COLUMN_ADRES,
                    Contract.MediaMarktColumns.COLUMN_HUISNR,
                    Contract.MediaMarktColumns.COLUMN_POSTCODE,
                    Contract.MediaMarktColumns.COLUMN_GEMEENTE

            };
    private static Object lock = new Object();
    private final String url = "http://student.howest.be/lucas.balcaen/mobileappjson.json";

    /*
    ** Constructor
     */

    public MediaMarktLader(Context context)
    {
        super(context);
    }

    /*
    ** Events
     */

    @Override
    protected void onStartLoading()
    {
        if(cursor != null)
            deliverResult(cursor);

        if(takeContentChanged() || cursor == null)
            forceLoad();
    }

    @Override
    public Cursor loadInBackground()
    {
        if(cursor == null)
            loadCursor();

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
                return;

            matrixCursor = new MatrixCursor(columnNames);
            InputStream inputStream = null;
            JsonReader jsonReader = null;

            try
            {
                inputStream = new URL(url).openStream();
                jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

                int id = 1;
                jsonReader.beginArray();
                while(jsonReader.hasNext())
                {
                    jsonReader.beginObject();

                    String naam = "";
                    String adres = "";
                    String huisnummer = "";
                    String postcode = "";
                    String gemeente = "";

                    while(jsonReader.hasNext())
                    {
                        String name = jsonReader.nextName();
                        if(name.equals(Contract.MediaMarktColumns.COLUMN_NAAM))
                        {
                            naam = jsonReader.nextString();
                        }

                        else if(name.equals(Contract.MediaMarktColumns.COLUMN_ADRES))
                        {
                                adres = jsonReader.nextString();
                        }

                        else if(name.equals(Contract.MediaMarktColumns.COLUMN_HUISNR))
                        {
                                huisnummer = jsonReader.nextString();
                        }

                        else if(name.equals(Contract.MediaMarktColumns.COLUMN_POSTCODE))
                        {
                            postcode = jsonReader.nextString();
                        }

                        else if(name.equals(Contract.MediaMarktColumns.COLUMN_GEMEENTE))
                        {
                            gemeente = jsonReader.nextString();
                        }

                        else
                            jsonReader.skipValue();
                    }

                    MatrixCursor.RowBuilder row = matrixCursor.newRow();
                    row.add(id);
                    row.add(naam);
                    row.add(adres);
                    row.add(huisnummer);
                    row.add(postcode);
                    row.add(gemeente);

                    id++;

                    jsonReader.endObject();
                }
                jsonReader.endArray();

                cursor = matrixCursor;
            }

            catch(Exception ex)
            {
                Log.d("Exception occured: ", ex.getMessage());
            }

            finally
            {
                try
                {
                    jsonReader.close();
                }

                catch(Exception ex)
                {
                    Log.d("Exception occured: ", ex.getMessage());
                }

                try
                {
                    inputStream.close();
                }

                catch(Exception ex)
                {
                    Log.d("Exception occured: ", ex.getMessage());
                }
            }
        }
    }
}

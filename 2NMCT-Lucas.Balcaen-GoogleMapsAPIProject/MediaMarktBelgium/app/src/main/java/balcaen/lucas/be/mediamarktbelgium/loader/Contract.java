package balcaen.lucas.be.mediamarktbelgium.loader;

import android.provider.BaseColumns;

/**
 * Created by Lucas on 2/05/2015.
 */
public class Contract {
    public interface MediaMarktColumns extends BaseColumns{
        public static final String COLUMN_NAAM = "NAAM";
        public static final String COLUMN_ADRES = "ADRES";
        public static final String COLUMN_HUISNR = "HUISNR";
        public static final String COLUMN_POSTCODE = "POSTCODE";
        public static final String COLUMN_GEMEENTE = "GEMEENTE";
    }
}

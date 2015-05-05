package nmct.howest.be.scoresstudenten.loader;

import android.provider.BaseColumns;

/**
 * Created by Lucas on 2/05/2015.
 */
public class Contract {
    public interface StudentColumns extends BaseColumns{
        public static final String COLUMN_STUDENT_NAAM = "student_naam";
        public static final String COLUMN_STUDENT_VOORNAAM = "student_voornaam";
        public static final String COLUMN_STUDENT_EMAIL = "student_email";
        public static final String COLUMN_STUDENT_SCORE_TOTAAL = "student_score_totaal";
    }
}

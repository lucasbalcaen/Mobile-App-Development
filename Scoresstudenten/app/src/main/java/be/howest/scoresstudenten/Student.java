package be.howest.scoresstudenten;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lucas on 9/02/2015.
 */
public class Student {

    private String emailStudent;
    private HashMap<String,ModulePunt> scoresStudent;

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public void voegScoreToe(String sModuleNaam,double score){
        ModulePunt m = new ModulePunt();
        m.setModuleNaam(sModuleNaam);
        m.setScore(score);

        scoresStudent.put(sModuleNaam,m);

    }

    public double getTotaleScoreStudent(){
        int aantalStudiepunten =0;
        double totaleScore=0;
        for(ModulePunt m : scoresStudent.values()){
            aantalStudiepunten += m.getAantalStudiePunten();
       }

        for(ModulePunt p : scoresStudent.values()){
            double score = p.getScore();
            double gewicht = p.getAantalStudiePunten()/aantalStudiepunten;
            totaleScore += score*gewicht;
        }
        return totaleScore;
    }

    @Override
    public String toString() {
        return emailStudent+ " - Totale score: " + getTotaleScoreStudent();
    }

    public static List<Double> getScoresModule(List<Student> studenten,String moduleNaam){

    }

    public static void getGemiddelde
}



package be.howest.scoresstudenten;

/**
 * Created by lucas on 9/02/2015.
 */
public class ModulePunt {
    private String moduleNaam;
    private int aantalStudiePunten;
    private double score;

    public String getModuleNaam() {
        return moduleNaam;
    }

    public void setModuleNaam(String moduleNaam) {
        this.moduleNaam = moduleNaam;
    }

    public int getAantalStudiePunten() {
        return aantalStudiePunten;
    }

    public void setAantalStudiePunten(int aantalStudiePunten) {
        this.aantalStudiePunten = aantalStudiePunten;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    private boolean equals(){

    }

    @Override
    public String toString() {
        return "Totale score: ";
    }
}

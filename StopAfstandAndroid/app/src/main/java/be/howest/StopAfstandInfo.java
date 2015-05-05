package be.howest;

/**
 * Created by giles on 9/02/2015.
 */
public class StopAfstandInfo {

    private int snelheid;
    private float reactieTijd;
    //private float stopAfstand;
    private WegType wegType;

    public WegType getWegType() {
        return wegType;
    }

    public void setWegType(WegType wegType) {
        this.wegType = wegType;
    }


    public enum WegType{
        DROOG,NAT;
    }

    public float getStopAfstand(){
        if(getWegType() == WegType.DROOG){
            return getSnelheid()*getReactieTijd()+(float)Math.pow(getSnelheid(),2)/(2*8);
        }else {
            return getSnelheid() * getReactieTijd() + (float) Math.pow(getSnelheid(), 2) / (2*5);
        }
    }

    public StopAfstandInfo(){
        this(100,0.5f,/*0f,*/WegType.DROOG);
    }

    public StopAfstandInfo(int snelheid, float reactieTijd, /*float stopAfstand,*/ WegType wegType) {
        this.snelheid = snelheid;
        this.reactieTijd = reactieTijd;
        //this.stopAfstand = stopAfstand;
        this.wegType = wegType;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        this.snelheid = snelheid;
    }

    public float getReactieTijd() {
        return reactieTijd;
    }

    public void setReactieTijd(float reactieTijd) {
        this.reactieTijd = reactieTijd;
    }


    /*
    public float getStopAfstand() {
        return stopAfstand;
    }

    public void setStopAfstand(float stopAfstand) {
        this.stopAfstand = stopAfstand;
    }*/

    @Override
    public String toString() {
        return  getStopAfstand() + " meter";
    }
}

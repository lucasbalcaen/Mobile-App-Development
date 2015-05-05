package be.howest.bmicalculator;

/**
 * Created by lucas on 9/02/2015.
 */
public class BMIInfo {

    private float height;
    private int mass;
    private float bmiIndex;

    public enum Category{
       GROOTONDERGEWICHT(0,15),ERNSTIGONDERGEWICHT(15,16),ONDERGEWICHT(16,18.5f),NORMAAL(18.5f,25),OVERGEWICHT(25,30),MATIGOVERGEWICHT(30,35)
        ,ERNSTIGOVERGEWICHT(35,40),ZEERGROOTOVERGEWICHT(40,500);

        private final float lowerBoundary;   // in kilograms
        private final float upperBoundary; // in meters
        Category(float lowerBoundary, float upperBoundary) {
            this.lowerBoundary=lowerBoundary;
            this.upperBoundary = upperBoundary;
        }


        public float getLowerBoundary() {
            return lowerBoundary;
        }

        public float getUpperBoundary() {
            return upperBoundary;
        }

        private boolean isInBoundary(float index){
        if(index>lowerBoundary && index<=upperBoundary){
            return true;
        }else{
            return false;
        }
        }

        public static Category getCategory(float index) {
            for(Category category : Category.values()) {
                if(category.isInBoundary(index)) return category;
            }
            return null;
        }
    }

    public float recalculate(){
        return getMass()/(getHeight()*getHeight());
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setBmiIndex(float bmiIndex) {
        this.bmiIndex = bmiIndex;
    }

    @Override
    public String toString() {
        return "Je BMI is: "+ recalculate() +" categorie: "+Category.getCategory(recalculate());
    }
}

package be.howest.bmicalculator;

import java.util.Scanner;

/**
 * Created by lucas on 9/02/2015.
 */
public class RunBMI {
    public static void main(String[] args) {
        // Vaste waarden
        BMIInfo bmi = new BMIInfo();
        bmi.setHeight(1.80f);
        bmi.setMass(70);
        System.out.println(bmi);

        // waarden vragen aan de gebruiker
        BMIInfo test = new BMIInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Geef je lengte in: ");
        float lengte = sc.nextFloat();
        test.setHeight(lengte);
        System.out.print("Geef je gewicht in: ");
        int gewicht = sc.nextInt();
        test.setMass(gewicht);
        System.out.println(test);




    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package handsOn10;

/**
 *
 * @author AngelC-Linux
 */
public class MainRegressions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double data[][] = {
            {108, 95},{115, 96},{106, 95},
            {97, 97},{95, 93},{91, 94},
            {97, 95},{83, 93},{83, 92},
            {78, 86},{54, 73},{67, 80},
            {56, 65},{53, 69},{61, 77},
            {115, 96},{81, 87},{78, 89},
            {30, 60},{45, 63},{99, 95},
            {32, 61},{25, 55},{28, 56},
            {90, 94},{89, 93}
        };
        LinearRegression LR = new LinearRegression();
        QuadraticRegression QR = new QuadraticRegression();
        CubicRegression CR = new CubicRegression();
        System.out.println("");
        
        LR.analyze(data);
        System.out.println("");
        
        QR.analyze(data);
        System.out.println("");
        
        CR.analyze(data);
    }
}
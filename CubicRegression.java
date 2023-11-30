/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handsOn10;

/**
 *
 * @author AngelC-Linux
 */
public class CubicRegression {

    public void analyze(double[][] datos) {
        System.out.println("-------------------------------------------------------------------------------\n\n\n");
        System.out.println("Regresión Cúbica -->\n");

        int n = datos.length;

        double sumX = 0, sumY = 0, sumX2 = 0, sumX3 = 0, sumX4 = 0, sumX5 = 0, sumX6 = 0, sumXY = 0, 
                sumX2Y = 0, sumX3Y = 0;

        for (int i = 0; i < n; i++) {
            sumX += datos[i][0];
            sumY += datos[i][1];
            sumX2 += Math.pow(datos[i][0], 2);
            sumX3 += Math.pow(datos[i][0], 3);
            sumX4 += Math.pow(datos[i][0], 4);
            sumX5 += Math.pow(datos[i][0], 5);
            sumX6 += Math.pow(datos[i][0], 6);
            sumXY += datos[i][0] * datos[i][1];
            sumX2Y += Math.pow(datos[i][0], 2) * datos[i][1];
            sumX3Y += Math.pow(datos[i][0], 3) * datos[i][1];
        }

        double determinante = (sumX3 * sumX3 * sumX3 * sumX3) - (sumX3 * sumX3 * sumX2 * sumX4)
                - (sumX3 * sumX2 * sumX4 * sumX3) + (sumX3 * sumX2 * sumX2 * sumX5) + (sumX3 * sumX * sumX4 * sumX4)
                - (sumX3 * sumX * sumX3 * sumX5) - (sumX2 * sumX4 * sumX3 * sumX3) + (sumX2 * sumX4 * sumX2 * sumX4)
                + (sumX2 * sumX2 * sumX5 * sumX3) - (sumX2 * sumX2 * sumX2 * sumX6) - (sumX2 * sumX * sumX5 * sumX4)
                + (sumX2 * sumX * sumX3 * sumX6) + (sumX * sumX4 * sumX4 * sumX3) - (sumX * sumX4 * sumX2 * sumX5)
                - (sumX * sumX3 * sumX5 * sumX3) + (sumX * sumX3 * sumX2 * sumX6) + (sumX * sumX * sumX5 * sumX5)
                - (sumX * sumX * sumX4 * sumX6) - (n * sumX4 * sumX4 * sumX4) + (n * sumX4 * sumX3 * sumX5)
                + (n * sumX3 * sumX5 * sumX4) - (n * sumX3 * sumX3 * sumX6) - (n * sumX2 * sumX5 * sumX5)
                + (n * sumX2 * sumX4 * sumX6);

        double beta3 = (sumY * sumX3 * sumX3 * sumX3) - (sumY * sumX3 * sumX2 * sumX4) - (sumY * sumX2 * sumX4 * sumX3)
                + (sumY * sumX2 * sumX2 * sumX5) + (sumY * sumX * sumX4 * sumX4) - (sumY * sumX * sumX3 * sumX5)
                - (sumX2 * sumXY * sumX3 * sumX3) + (sumX2 * sumXY * sumX2 * sumX4) + (sumX2 * sumX2 * sumX2Y * sumX3)
                - (sumX2 * sumX2 * sumX2 * sumX3Y) - (sumX2 * sumX * sumX2Y * sumX4) + (sumX2 * sumX * sumX3 * sumX3Y)
                + (sumX * sumXY * sumX4 * sumX3) - (sumX * sumXY * sumX2 * sumX5) - (sumX * sumX3 * sumX2Y * sumX3)
                + (sumX * sumX3 * sumX2 * sumX3Y) + (sumX * sumX * sumX2Y * sumX5) - (sumX * sumX * sumX4 * sumX3Y)
                - (n * sumXY * sumX4 * sumX4) + (n * sumXY * sumX3 * sumX5) + (n * sumX3 * sumX2Y * sumX4)
                - (n * sumX3 * sumX3 * sumX3Y) - (n * sumX2 * sumX2Y * sumX5) + (n * sumX2 * sumX4 * sumX3Y);

        double beta2 = (sumX3 * sumXY * sumX3 * sumX3) - (sumX3 * sumXY * sumX4 * sumX2) - (sumX3 * sumX2 * sumX2Y * sumX3)
                + (sumX3 * sumX2 * sumX2 * sumX3Y) + (sumX3 * sumX * sumX2Y * sumX4) - (sumX3 * sumX * sumX3 * sumX3Y)
                - (sumY * sumX4 * sumX3 * sumX3) + (sumY * sumX4 * sumX2 * sumX4) + (sumY * sumX2 * sumX5 * sumX3)
                - (sumY * sumX2 * sumX2 * sumX6) - (sumY * sumX * sumX5 * sumX4) + (sumY * sumX * sumX3 * sumX6)
                + (sumX * sumX4 * sumX2Y * sumX3) - (sumX * sumX4 * sumX2 * sumX3Y) - (sumX * sumXY * sumX5 * sumX3)
                + (sumX * sumXY * sumX6 * sumX2) + (sumX * sumX * sumX5 * sumX3Y) - (sumX * sumX * sumX2Y * sumX6)
                - (n * sumX4 * sumX2Y * sumX4) + (n * sumX4 * sumX3 * sumX3Y) + (n * sumXY * sumX5 * sumX4)
                - (n * sumXY * sumX3 * sumX6) - (n * sumX2 * sumX5 * sumX3Y) + (n * sumX2 * sumX2Y * sumX6);

        double beta1 = (sumX3 * sumX3 * sumX2Y * sumX3) - (sumX3 * sumX3 * sumX3Y * sumX2) - (sumX3 * sumXY * sumX4 * sumX3)
                + (sumX3 * sumXY * sumX2 * sumX5) + (sumX3 * sumX * sumX4 * sumX3Y) - (sumX3 * sumX * sumX2Y * sumX5)
                - (sumX2 * sumX4 * sumX2Y * sumX3) + (sumX2 * sumX4 * sumX2 * sumX3Y) + (sumX2 * sumXY * sumX5 * sumX3)
                - (sumX2 * sumXY * sumX2 * sumX6) - (sumX2 * sumX * sumX5 * sumX3Y) + (sumX2 * sumX * sumX2Y * sumX6)
                + (sumY * sumX4 * sumX4 * sumX3) - (sumY * sumX4 * sumX2 * sumX5) - (sumY * sumX3 * sumX5 * sumX3)
                + (sumY * sumX3 * sumX2 * sumX6) + (sumY * sumX * sumX5 * sumX5) - (sumY * sumX * sumX4 * sumX6)
                - (n * sumX4 * sumX4 * sumX3Y) + (n * sumX4 * sumX2Y * sumX5) + (n * sumX3 * sumX5 * sumX3Y)
                - (n * sumX3 * sumX2Y * sumX6) - (n * sumXY * sumX5 * sumX5) + (n * sumXY * sumX4 * sumX6);

        double beta0 = (sumX3 * sumX3 * sumX3 * sumX3Y) - (sumX3 * sumX3 * sumX2Y * sumX4) - (sumX3 * sumX2 * sumX4 * sumX3Y)
                + (sumX3 * sumX2 * sumX2Y * sumX5) + (sumX3 * sumXY * sumX4 * sumX4) - (sumX3 * sumXY * sumX3 * sumX5)
                - (sumX2 * sumX4 * sumX3 * sumX3Y) + (sumX2 * sumX4 * sumX2Y * sumX4) + (sumX2 * sumX2 * sumX5 * sumX3Y)
                - (sumX2 * sumX2 * sumX2Y * sumX6) - (sumX2 * sumXY * sumX5 * sumX4) + (sumX2 * sumXY * sumX3 * sumX6)
                + (sumX * sumX4 * sumX4 * sumX3Y) - (sumX * sumX4 * sumX2Y * sumX5) - (sumX * sumX3 * sumX5 * sumX3Y)
                + (sumX * sumX3 * sumX2Y * sumX6) + (sumX * sumXY * sumX5 * sumX5) - (sumX * sumXY * sumX4 * sumX6)
                - (sumY * sumX4 * sumX4 * sumX4) + (sumY * sumX4 * sumX3 * sumX5) + (sumY * sumX3 * sumX5 * sumX4)
                - (sumY * sumX3 * sumX3 * sumX6) - (sumY * sumX2 * sumX5 * sumX5) + (sumY * sumX2 * sumX4 * sumX6);

        beta3 = beta3 / determinante;
        beta2 = beta2 / determinante;
        beta1 = beta1 / determinante;
        beta0 = beta0 / determinante;

        System.out.println("Beta0: " + beta0);
        System.out.println("Beta1: " + beta1);
        System.out.println("Beta2: " + beta2);
        System.out.println("Beta3: " + beta3);

        System.out.println("");

        System.out.println("Y = Beta0 " + beta0 + " + Beta1 " + beta1 + " x + Beta2 " + beta2 + " x (Cuadrada) + Beta3 " + beta3 + " x(Cúbica)");

        System.out.println("");

        double[] yPredictoria = new double[n];

        
        for (int i = 0; i < n; i++) {
            yPredictoria[i] = beta0 + beta1 * (datos[i][0]) + beta2 * (Math.pow(datos[i][0], 2)) + beta3 * (Math.pow(datos[i][0], 3));
            System.out.println((i + 1) + ": " + yPredictoria[i]);
        }

        double mediaY = 0;

        for (int i = 0; i < n; i++) {
            mediaY += datos[i][1];
        }

        double sumaTotalCuadrados = 0;

        for (int i = 0; i < n; i++) {
            sumaTotalCuadrados += Math.pow((datos[i][1] - mediaY), 2);
        }

        
        double sumaErroresCuadrados = 0;
        for (int i = 0; i < n; i++) {
            sumaErroresCuadrados += Math.pow((datos[i][1] - yPredictoria[i]), 2);
        }
        
        double rCuadrada = 1 - (sumaErroresCuadrados / sumaTotalCuadrados);

        System.out.println("");

        System.out.println("R (Cuadrada): " + rCuadrada);
    }
}

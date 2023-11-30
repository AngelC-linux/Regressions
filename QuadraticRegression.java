/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handsOn10;

/**
 *
 * @author AngelC-Linux
 */
public class QuadraticRegression {

    public void analyze(double[][] datos) {
        System.out.println("------------------------------------------------------------------------------\n\n\n");
        System.out.println("Regresión Cuadrática -->\n");

        int n = datos.length;

        double sumax = 0, sumay = 0, sumax2 = 0, sumax3 = 0, sumax4 = 0, sumaxy = 0, sumax2y = 0;

        for (int i = 0; i < n; i++) {
            double x = datos[i][0];
            double y = datos[i][1];
            double x2 = x * x;
            double x3 = x2 * x;
            double x4 = x2 * x2;

            sumax += x;
            sumay += y;
            sumax2 += x2;
            sumax3 += x3;
            sumax4 += x4;
            sumaxy += x * y;
            sumax2y += x2 * y;
        }

        double det = (sumax2 * sumax2 * sumax2) + (sumax * sumax * sumax4) + (n * sumax3 * sumax3) - (sumax4 * sumax2 * n) - (sumax3 * sumax * sumax2) - (sumax2 * sumax3 * sumax);
        double beta0 = (sumay * sumax2 * sumax2) + (sumaxy * sumax3 * n) + (sumax2y * sumax * sumax) - (sumaxy * sumax * sumax2) - (sumay * sumax3 * sumax) - (sumax2y * sumax2 * n);
        double beta1 = (sumax2 * sumaxy * sumax2) + (sumay * sumax * sumax4) + (n * sumax3 * sumax2y) - (sumax4 * sumaxy * n) - (sumax2y * sumax * sumax2) - (sumax2 * sumax3 * sumay);
        double beta2 = (sumax2 * sumax2 * sumax2y) + (sumax * sumaxy * sumax4) + (sumay * sumax3 * sumax3) - (sumax4 * sumax2 * sumay) - (sumax3 * sumaxy * sumax2) - (sumax2y * sumax3 * sumax);

        beta0 = beta0 / det;
        beta1 = beta1 / det;
        beta2 = beta2 / det;

        imprimirValoresBeta(beta0, beta1, beta2);
        System.out.println("Y = Beta0 " + beta0 + " + Beta1 " + beta1 + " x + Beta2 " + beta2 + " x (Cuadrada)");
        System.out.println("");

        double[] yPredicho = new double[n];

        // Predicción para un nuevo valor de x
        for (int i = 0; i < n; i++) {
            yPredicho[i] = beta0 * (Math.pow(datos[i][0], 2)) + beta1 * (datos[i][0]) + beta2;
            imprimirPrediccion(i, yPredicho[i]);
        }

        double mediaY = calcularMedia(datos, 1);
        double sumatoriaTotalCuadrado = calcularSumatoriaTotalCuadrado(datos, mediaY);
        double sumatoriaResidualCuadrado = calcularSumatoriaResidualCuadrado(datos, yPredicho);
        double rCuadrada = 1 - (sumatoriaResidualCuadrado / sumatoriaTotalCuadrado);

        imprimirRCuadrada(rCuadrada);
    }

    private void imprimirValoresBeta(double beta0, double beta1, double beta2) {
        System.out.println("B0: " + beta0);
        System.out.println("B1: " + beta1);
        System.out.println("B2: " + beta2);
    }

    private void imprimirPrediccion(int indice, double yPredicho) {
        System.out.println((indice + 1) + ": " + yPredicho);
    }

    private void imprimirRCuadrada(double rCuadrada) {
        System.out.println("");
        System.out.println("R (Cuadrada): " + rCuadrada);
    }

    private double calcularMedia(double[][] datos, int indiceColumna) {
        int cantidadFilas = datos.length;
        double suma = 0;

        for (int i = 0; i < cantidadFilas; i++) {
            suma += datos[i][indiceColumna];
        }

        return suma / cantidadFilas;
    }

    private double calcularSumatoriaTotalCuadrado(double[][] datos, double mediaY) {
        int n = datos.length;
        double sumatoriaTotalCuadrado = 0;

        for (int i = 0; i < n; i++) {
            sumatoriaTotalCuadrado += Math.pow((datos[i][1] - mediaY), 2);
        }

        return sumatoriaTotalCuadrado;
    }

    private double calcularSumatoriaResidualCuadrado(double[][] datos, double[] yPredicho) {
        int n = datos.length;
        double sumatoriaResidualCuadrado = 0;

        for (int i = 0; i < n; i++) {
            sumatoriaResidualCuadrado += Math.pow((datos[i][1] - yPredicho[i]), 2);
        }

        return sumatoriaResidualCuadrado;
    }
}

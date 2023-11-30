/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handsOn10;

/**
 *
 * @author AngelC-Linux
 */
public class LinearRegression {

    public void analyze(double[][] datos) {
        System.out.println("Regresión Lineal Clásica -->\n");

        int cantidadFilas = datos.length;

        double mediaX = calcularMedia(datos, 0);
        double mediaY = calcularMedia(datos, 1);

        double beta1 = calcularBeta1(datos, mediaX, mediaY);
        double beta0 = calcularBeta0(mediaY, beta1, mediaX);

        imprimirValoresBeta(beta1, beta0, mediaY, mediaX);
        System.out.println("y = Beta0 + Beta1 * x");
        System.out.println("");

        double[] yPredicho = new double[cantidadFilas];
        double sumatoriaResidualCuadrado = 0;
        double sumatoriaTotalCuadrado = 0;

        for (int i = 0; i < cantidadFilas; i++) {
            yPredicho[i] = beta0 + (beta1 * datos[i][0]);
            imprimirPrediccion(i, yPredicho[i]);
            sumatoriaResidualCuadrado += Math.pow((datos[i][1] - yPredicho[i]), 2);
            sumatoriaTotalCuadrado += Math.pow((datos[i][1] - mediaY), 2);
        }

        double rCuadrada = 1 - (sumatoriaResidualCuadrado / sumatoriaTotalCuadrado);
        imprimirRCuadrada(rCuadrada);
    }

    private double calcularMedia(double[][] datos, int indiceColumna) {
        int cantidadFilas = datos.length;
        double suma = 0;

        for (int i = 0; i < cantidadFilas; i++) {
            suma += datos[i][indiceColumna];
        }

        return suma / cantidadFilas;
    }

    private double calcularBeta1(double[][] datos, double mediaX, double mediaY) {
        int cantidadFilas = datos.length;
        double beta1 = 0;
        double sumatoriaDiferenciaCuadradoX = 0;

        for (int i = 0; i < cantidadFilas; i++) {
            beta1 += (datos[i][0] - mediaX) * (datos[i][1] - mediaY);
            sumatoriaDiferenciaCuadradoX += Math.pow((datos[i][0] - mediaX), 2);
        }

        return beta1 / sumatoriaDiferenciaCuadradoX;
    }

    private double calcularBeta0(double mediaY, double beta1, double mediaX) {
        return mediaY - (beta1 * mediaX);
    }

    private void imprimirValoresBeta(double beta1, double beta0, double mediaY, double mediaX) {
        System.out.println("Beta1: " + beta1);
        System.out.println("Beta0: " + beta0);
        System.out.println("beta = " + mediaY + " - " + beta1 + " * " + mediaX);
        System.out.println("");
    }

    private void imprimirPrediccion(int indice, double yPredicho) {
        System.out.println((indice + 1) + ": " + yPredicho);
    }

    private void imprimirRCuadrada(double rCuadrada) {
        System.out.println("");
        System.out.println("R (cuadrada): " + rCuadrada);
    }
}

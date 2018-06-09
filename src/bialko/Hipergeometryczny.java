/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

/**
 *
 * @author faust
 */
public class Hipergeometryczny {
    int M,k,N,n;
    public Hipergeometryczny(int a,int b,int c,int d){
        this.M = a;
        this.k = b;
        this.N = c;
        this.n = d;
    }
    
    
}
/**
 * The generalized hypergeometric function is a convergent power series \sum_{i=0}^{\infty} c_i x^i
 * where the coefficients satisfy c_{n+1}/c_n = A(n)/B(n) for some polynomials A and B in n.
 * It is customary to factor out the leading term, so c_0 is assumed to be 1
 */

    class HypergeometricFunction {
    private int degreeOfApproximation;
    private double[] coefficientsOfA;
    private double[] coefficientsOfB;
    private double[] coefficientsOfHypergeometricFunction;

    public HypergeometricFunction(int degreeOfApproximation, double[] coefficientsOfA, double[] coefficientsOfB) {
        this.degreeOfApproximation = degreeOfApproximation;
        this.coefficientsOfA = coefficientsOfA;
        this.coefficientsOfB = coefficientsOfB;
        this.coefficientsOfHypergeometricFunction = generateCoefficients();
    }

    /**
     * @param x input
     * @return Approximation to the hypergeometric function by taking the first
     * {@code degreeOfApproximation} terms from the series.
     */
    public double approximate(double x){
        return evaluatePolynomial(x, coefficientsOfHypergeometricFunction);
    }


    private double[] generateCoefficients() {
        double[] coefficients = new double[degreeOfApproximation];
        coefficients[0] = 1;
        for (int i = 1; i < degreeOfApproximation; i++)
            coefficients[i] = (evaluatePolynomial(i, coefficientsOfA) / evaluatePolynomial(i, coefficientsOfB)) * coefficients[i - 1];
        return coefficients;
    }

    private double evaluatePolynomial(double n, double[] coefficients) {
        int length = coefficients.length;
        double out = 0.0;
        for (int i = 0; i < length; i++) {
            out += coefficients[i] * pow(n, i);
        }
        return out;
    }

    private double pow(double a, int b) {
        double out = 1;
        for (int i = 0; i < b; i++) out *= a;
        return out;
    }
}


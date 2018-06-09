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


public class Poisson {
    public static int getPoisson(double dbLambda) {
        double L = Math.exp(-dbLambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

    return k - 1;
    }
}

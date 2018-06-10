/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
/**
 *
 * @author faust
 */


public class Poisson {
    
    private double dbLambda;
    List<Integer> lstWygenerowane = new ArrayList<Integer>();
    private final int intLiczbaZmiennych;
    
    public Poisson(double a, int b){
        this.dbLambda = a;
        this.intLiczbaZmiennych = b;
    }
    
    public int getPoisson() {
        double dbp = 1.0;
        int intk = 0;
        double dbL = Math.exp(-dbLambda);

        do {
            intk++;
            dbp *= Math.random();
        } while (dbp > dbL);

    return k - 1;
    }
}

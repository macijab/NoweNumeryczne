/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Random;
/**
 *
 * @author faust
 */
public class Poisson {
    
    private double dbLambda;
    List<Integer> lstWygenerowane = new ArrayList<Integer>();
    private final int intLiczbaZmiennych;
    
    public Poisson(double a, int b)
    {
        this.dbLambda = a;
        this.intLiczbaZmiennych = b;
    }
    public double getTeoreticalMean()
    {
        return dbLambda;//średnia w Poissonie to to samo co wariancja;
    }
    public double getGeneratedMean()
    {
        double suma = 0;
        for(int intZmienna :lstWygenerowane)
        {
           suma += (double)intZmienna;
        }
        return suma/lstWygenerowane.size();
    }
    public double getGeneratedVariance()
    {
        double dbVariance = 0;
        for(int intZmienna : this.lstWygenerowane)
        {
            dbVariance += Math.pow((double)intZmienna, 2);
        }
        return dbVariance/lstWygenerowane.size()- Math.pow(getGeneratedMean(),2);
    }
    public int generowanieZmiennej() 
    {
        double dbp = 1.0;
        int intk = 0;
        double dbL = Math.exp(-dbLambda);
        Random r1 = new Random();
        do {
            intk++;
            dbp *= r1.nextDouble();//dbp = dbp*Math.random
        } while (dbp > dbL);

        return intk - 1;
    }
    public void generowanie_zmiennych()
    {
        int a = 0;
        for(int i = 0; i < this.intLiczbaZmiennych;i++)
        {
            lstWygenerowane.add(generowanieZmiennej());
        }
    }
    public int getListaWygenerowanych(int i)
    {
        return lstWygenerowane.get(i);
    }
}

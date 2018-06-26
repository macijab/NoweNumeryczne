/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author faust
 */
public class Geometryczny {
    
List<Integer> lstWygenerowane = new ArrayList<Integer>();
public double p;
public int intLZmiennych;

    public Geometryczny(int LZmiennych, double p){
        this.p =p;
        this.intLZmiennych = LZmiennych;
    }

    public void generowanieZmiennej(){
        Random r1 = new Random();
        for (int i = 0; i < intLZmiennych; i++)
        {   
            double a = r1.nextDouble();
            if ((a == 0) || (a == 1)) 
            {
                continue;
            }
            else
            {
                int x = (int)Math.ceil(Math.log(1-a)/Math.log(1-p));
                lstWygenerowane.add(x);
            }
        }
    }
    public double getGeneratedMean(){
        double suma = 0;
        for(int intZmienna :lstWygenerowane)
        {
           suma += (double)intZmienna;
        }
        return suma/lstWygenerowane.size();
    }   
    public double getTeoreticalMean(){
        return 1/p;
    }
    public double getTeoreticalVariance(){
        return (1-p)/(p*p);
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
    public int getListaWygenerowanych(int i)
    {
        return lstWygenerowane.get(i);
    }
    
}

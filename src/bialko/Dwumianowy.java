/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faust
 */
public class Dwumianowy extends RozkładZeroJedynkowy {
    List <Integer> lstDwumianowy =  new ArrayList<Integer>();
    int  intN;

    public Dwumianowy(double a, int b) {
        super(a, b);
    }
    
    public void setIntN(int a)
    {
        intN = a;
    }
    public double getTeoreticalMean(){
        return intN*dbProbability;
    }
    public double getTeoreticalVariance()
    {
        return intN*dbProbability*(1-dbProbability);
    }
    
    
    public void generowanieRozkładu()
    {
        int suma = 0;
        for(int i = 0; i<intN; i++)
        {
            Zm_Generowana();
            for (int z=0; z < (lstZmienne.size()-1);z++)
            {
                suma += getListaZmiennych(z);
            }
            lstDwumianowy.add(suma);
            suma=0;
            lstZmienne.clear();
        }
        
    }
    public int getRozkładDwumianowy(int i){
        return lstDwumianowy.get(i);
    }
    
            public double getGenerated1Variance()
        {
            double dbVariance = 0;
            for(int intZmienna : this.lstDwumianowy)
            {
                dbVariance += Math.pow((double)intZmienna, 2);
            }
            return dbVariance/lstDwumianowy.size()- Math.pow(getGenerated1Mean(),2);
        }
        public double getGenerated1Mean()
        {
            double dbMean = 0;
            for(int intZmienna : this.lstDwumianowy){
              dbMean += (double)intZmienna;  
            }
            return dbMean/lstDwumianowy.size();
        }
    
}

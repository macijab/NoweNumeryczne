/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

import java.util.Random;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author faust
 */
public class RozkładZeroJedynkowy {
        private final double dbProbability;
        private final int intLiczbaWartosci;
        public double getTeoreticMean()
        {
           return dbProbability;
        }
        public double getTeoreticVariance()
        {
            return dbProbability*(1-dbProbability);
        }
        public double getGeneratedVariance()
        {
            double dbVariance = 0;
            for(int intZmienna : this.lstZmienne)
            {
                dbVariance += Math.pow((double)intZmienna, 2);
            }
            return dbVariance/lstZmienne.size()- Math.pow(getGeneratedMean(),2);
        }
        public double getGeneratedMean()
        {
            double dbMean = 0;
            for(int intZmienna : this.lstZmienne){
              dbMean += (double)intZmienna;  
            }
            return dbMean/lstZmienne.size();
        }
        public RozkładZeroJedynkowy(double a, int b)
        {
            this.dbProbability = a;
            this.intLiczbaWartosci = b;
        }
        public int getListaZmiennych(int i){
            return lstZmienne.get(i);
        }
        private final List<Integer> lstZmienne = new ArrayList<>();
        public void Zm_Generowana()
        {
            Random rdR1 = new Random();
            for(int i = 0; i<=intLiczbaWartosci; i++){
                
                if(rdR1.nextDouble()>=dbProbability)
                {
                    this.lstZmienne.add(1);
                }
                else
                {
                    this.lstZmienne.add(1);
                }
            }
        }
}

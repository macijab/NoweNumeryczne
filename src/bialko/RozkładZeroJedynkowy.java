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
        protected final double dbProbability;
        private final int intLiczbaWartosci;
        List<Dystrybuanta> lstWygenerowanaDystrybuanta = new ArrayList<Dystrybuanta>();
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
        protected List<Integer> lstZmienne = new ArrayList<>();
        public void Zm_Generowana()
        {
            Random rdR1 = new Random();
            for(int i = 0; i<=intLiczbaWartosci; i++){
                
                if(rdR1.nextDouble()>=dbProbability)
                {
                    this.lstZmienne.add(0);
                }
                else
                {
                    this.lstZmienne.add(1);
                }
            }
        }
        
        public void setDystrybuanta(){
        Dystrybuanta d1 = new Dystrybuanta();
        int licznik = 0;
        
        
        for(int intZmienna : this.lstZmienne)
        {
            if(lstWygenerowanaDystrybuanta.size() == 0){
                licznik++;
                d1.setJakaLicznik(intZmienna,licznik);
            }
            else{
                for(Dystrybuanta d2 : this.lstWygenerowanaDystrybuanta)
                    if(d2.getJaka() == intZmienna){
                        licznik++;
                        d1.setLiczni(licznik);
                    }
                    else{
                        licznik = 1;
                        d1.setJakaLicznik(intZmienna, licznik);
                }
            }
        double dystryb=0;
        for(Dystrybuanta d3 : this.lstWygenerowanaDystrybuanta){
            dystryb = (double)d3.getlicznik()/lstZmienne.size();
            d3.setPr(dystryb);
        }
            
            
        }
    }
    public void setDystrybuantaTeor(){
        this.lstWygenerowanaDystrybuanta.get(0).teorPr = 0;
        this.lstWygenerowanaDystrybuanta.get(1).teorPr = dbProbability;
    
    }
    public int getJakaZmienna(int l){
        return lstWygenerowanaDystrybuanta.get(l).getJaka();
    }
    public double getTeoretycznaDystrybuanta(int i){
        return lstWygenerowanaDystrybuanta.get(i).teorPr;
    }
    public double  getGenerowanaDystrybuanta(int i){
        return lstWygenerowanaDystrybuanta.get(i).dbPr;
    }
}

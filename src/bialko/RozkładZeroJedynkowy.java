/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bialko;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
        public double getGenericMean()
        {
            zmienne.forEach((_item) -> 
            {
                zmienne.get(_item) = 
            });
                
        }
        public RozkładZeroJedynkowy(double a, int b)
        {
            this.dbProbability = a;
            this.intLiczbaWartosci = b;
        }
        public int getListaZmiennych(int i){
            return zmienne.get(i);
        }
        private final List<Integer> zmienne = new ArrayList<>();
        public void Zm_Generowana()
        {
            Random r1 = new Random();
            for(int i = 0; i<=intLiczbaWartosci; i++){
                
                if(r1.nextDouble()>=dbProbability)
                {
                    this.zmienne.add(1);
                }
                else
                {
                    this.zmienne.add(0);
                }
            }
        }
}

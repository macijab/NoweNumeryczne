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
public class Dystrybuanta {
    int jaka;
    int licznik;
    double dbPr;
    double teorPr;
    public int getJaka(){
        return this.jaka;
    }
    public int getlicznik(){
        return this.licznik;
    }
    public void setJakaLicznik(int j,int l){
        this.jaka = j;
        this.licznik = l;
    }
    public void setLiczni(int l){
        this.licznik=l;
    }
    public double getPr(){
        return this.dbPr;
    }
    public void setPr(double d){
        this.dbPr = d;
    }
    public void setteorPr(double d){
        this.teorPr = d;
    }
    public double getteorPr(){
        return this.teorPr;
    }
    

    
}

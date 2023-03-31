/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author joshua
 */
class SprintEntry extends Entry {
       private int Repetitions;
       private int Recovery;
    
    public SprintEntry (String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec){
        super (n, d, m, y, h, min, s, dist);
        this.Repetitions = rep;
        this.Recovery = rec;
    }
        public int getRepetitions(){
                return Repetitions;
        }
        
        public int getRecovery(){
            
                return Recovery;
        }
    
    
    public String getSprint(){
String result = getName()+" ran " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()
             + "at" +getRepetitions() +"repetitions and" +getRecovery()+"mins" + "\n";
   return result;}
}

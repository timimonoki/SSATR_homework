/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.text;

/**
 *
 * @author evo
 */
public class ExempluText {
    public static void main(String[] args){       
        String s1 = "abc";
        String s2 = new String("xyz");
        
        if(s1.equals(s2)){
            System.out.println("Siruri egale.");
        }else{
            System.out.println("Siruri diferite.");
        }
        
        s1 = s1.toUpperCase();
        
        System.out.println(s1);
        
        int k = s1.indexOf("BC");
        System.out.println(k);
        
        String s3 = s1 + s2 +" !" +435;
        
        System.out.println("Valoarea lui s3="+s3);
     
        
    }
            
    
}

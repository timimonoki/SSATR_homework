/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.exempluarray;

import java.util.Arrays;

/**
 *
 * @author evo
 */
public class ExempluArray {
    
    static int[] generate(){
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10);
        }
        return a;
    }
    
    static void display(int[] a){
        for(int i:a)
            System.out.println(i);
    }
    
    public static void main(String[] args) {
        
        int [] x= generate();
        display(x);
        System.out.println("-----");
        Arrays.sort(x);
        display(x);
        
        
//        int[] a = new int[10];
//        for (int i = 0; i < a.length; i++) {          
//            System.out.println(a[i]);
//            a[i] = 5;
//        }
//        
//        Arrays.fill(a, 5);
//        
//        
//        
//        int[][] m = new int[4][3];
//        
//        m[1][2] = 9;
//        m[1][3] = 8; 
//       
        
    }
}

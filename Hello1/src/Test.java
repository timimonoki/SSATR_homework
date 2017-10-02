/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author evo
 */
public class Test {
    public static void main(String[] args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        int r = Integer.parseInt(args[0])+Integer.parseInt(args[1]);
        System.out.println("Resultat = "+r);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evo
 */
public class Simulator extends Thread {
    private Model m;

    public Simulator(Model m) {
        this.m = m;
    }
    
    boolean active = true;
    public void run() {
        int step = 0;
        try {
            while(!m.cannotExecute(step)){
                step++;
                System.out.println("Executing step " +step +"...\n");
                m.step(step);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println("Something wrong happened");
        }
    }
}

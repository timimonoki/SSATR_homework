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
public class Simulator extends Thread{
    private Model m;

    public Simulator(Model m) {
        this.m = m;
    }
    
    boolean active = true;
    public void run(){
        int step = 0;
        while(active){
            step++;      
            m.step(step);
            if(step>100)
                active = false;
            try {Thread.sleep(500);} catch (InterruptedException ex) {}
        }
    }
}

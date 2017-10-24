/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1.dummy;

import demosim1.dummy.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monokiT
 */
public class Branch extends Thread{
    
    List<Node> nodes;
    List<Transition> transitions;
    String transitionNameReceived;
    String name;
    
    public Branch(List<Node> nodes, List<Transition> transitions,  String transitionNameReceived, String nameIndex) {
        this.nodes = nodes;
        this.transitions = transitions;
        this.transitionNameReceived = transitionNameReceived;
        this.name = "Thread " + nameIndex;
    }
    
    public void run() {
        Node input;
        Node output;
        boolean deadlock = false;
        List<Branch> branches = new ArrayList<Branch>();
        int counter = 0;
        
        System.out.println("Executing " + this.name);
        Transition currentTransition = Utils.searchForATransitionAfterItsName(transitionNameReceived, transitions);
        System.out.println("Transition that is executing from Branch is: " +currentTransition.getName());
        try {
            while(counter < 5) {
                if(currentTransition.canExecute(nodes) && currentTransition.finishedWaiting()) {
                if(currentTransition.getOutputs().size() >= 2) {
                    System.out.println("Petri Net starts to execute " + currentTransition.getOutputs().size() + " threads in parallel from Branch");
                    for(int i=0; i<currentTransition.getOutputs().size(); i++) {
                        Node node = Utils.searchForANodeAfterItsName(currentTransition.getOutputs().get(i), nodes);
                        branches.add(new Branch(nodes, transitions, node.getOutputs().get(i), String.valueOf(i)));
                        branches.get(i).start();
                        branches.get(i).join();
                    }
                } 
                
                if(currentTransition.canWaitSomeMore()) {
                currentTransition.waitSomeMore();
                }
            
                for(String in: currentTransition.getInputs()) {
                    input = Utils.searchForANodeAfterItsName(in, nodes);
                    if(input.getToken() > 0) {
                        input.execute(-1);
                    }
                }      
                for(String out: currentTransition.getOutputs()) {
                    output = Utils.searchForANodeAfterItsName(out, nodes);
                    output.execute(+1);
                }
                System.out.println("Removed token from inputs ");
                for(String in: currentTransition.getInputs()) {
                    input = Utils.searchForANodeAfterItsName(in, nodes);
                    System.out.println(input.getName() + "  ");                    
                }
                System.out.println("\n");
                System.out.println("Added token to outputs ");
                for(String out: currentTransition.getOutputs()) {
                    output = Utils.searchForANodeAfterItsName(out, nodes);
                    System.out.println(output.getName() + "  ");                    
                }
                counter++;
                System.out.println("-------------------------------------------------------------- \n");
                }else {
                    deadlock = true;
                }                
            }
                                 
        } catch (InterruptedException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

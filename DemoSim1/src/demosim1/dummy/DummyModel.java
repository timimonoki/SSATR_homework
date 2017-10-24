
package demosim1.dummy;

import demosim1.Model;
import demosim1.dummy.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyModel implements Model {

    List<Node> nodes;
    List<Transition> transitions;
    
    public DummyModel(List<Node> nodes, List<Transition> transitions) {
        this.nodes = nodes;
        this.transitions = transitions;
    }
    
    @Override
    public void step(int step) throws InterruptedException{
        Node input;
        Node output;
        boolean deadlock = false;
        int necessaryToken = 0;
        Random r = new Random();
        List<Branch> branches = new ArrayList<Branch>();
        
        Transition transition = transitions.get((step -1) % (transitions.size() -1));
        System.out.println("Transition that is executing from DummyModel is: " +transition.getName());
        
        if(transition.canExecute(nodes) && transition.finishedWaiting()) {
            if(transition.getOutputs().size() >= 2) {
                System.out.println("Petri Net starts to execute " + transition.getOutputs().size() + " threads in parallel from DummyModel \n");
                for(int i=0; i<transition.getOutputs().size(); i++) {
                    Node node = Utils.searchForANodeAfterItsName(transition.getOutputs().get(i), nodes);
                    branches.add(new Branch(nodes, transitions, node.getOutputs().get(i), String.valueOf(i)));
                    branches.get(i).start();
                    branches.get(i).join();                                     
                }
            }
            if(transition.canWaitSomeMore()) {
                transition.waitSomeMore();
            }
            
            for(String in: transition.getInputs()) {
                input = Utils.searchForANodeAfterItsName(in, nodes);
                if(input.getToken() > 0) {
                    input.execute(-1);
                }
            }      
            for(String out: transition.getOutputs()) {
                output = Utils.searchForANodeAfterItsName(out, nodes);
                output.execute(+1);
            }
            System.out.println("Removed token from inputs ");
            for(String in: transition.getInputs()) {
                input = Utils.searchForANodeAfterItsName(in, nodes);
                System.out.println(input.getName() + "  ");                    
            }
            System.out.println("\n");
            System.out.println("Added token to outputs ");
            for(String out: transition.getOutputs()) {
                output = Utils.searchForANodeAfterItsName(out, nodes);
                System.out.println(output.getName() + "  ");                    
            }
            System.out.println("-------------------------------------------------------------- \n");
        }else {
            deadlock = true;
        }
        
        if(!deadlock) {
            System.out.println("Finished executing step " +step+  ". \n");
        }else {
            System.out.println("Cannot execute step " +step+ ". The timeout for the transitions did not finish or the Petri Net entered deadblock. \n");
        }
    }

    @Override
    public boolean cannotExecute(int step) throws InterruptedException {
        int necessaryToken = 0;
        Transition transition = transitions.get(step);
        Node input;
       
        Thread.sleep(Utils.getMaximumWaitTimeForATransition(transitions));
        for(String in: transition.getInputs()) {
            input = Utils.searchForANodeAfterItsName(in, nodes);
            if(input.getToken() > 0) {
                necessaryToken++;
            }
        }
        if(transition.getInputs().size() == necessaryToken) {
            System.out.println("Petri Net is at state " +step+ ". Can move on to the next step. \n");
            return false;
        }else {
            System.out.println("Petri Net is at state " +step+ ". Cannot move on to step " +(++step)+ " because it encoutered deadlock or the Petri Net finished. ");
            return true;
        }           
    }    
}

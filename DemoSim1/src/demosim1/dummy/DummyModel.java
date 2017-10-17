
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
        for(Transition transition: transitions) {
            System.out.println("Executing step " +step +"...\n");
            int necessaryToken = 0;
            Random r = new Random();
            for(String in: transition.getInputs()) {
                input = Utils.searchForANodeAfterItsName(in, nodes);
                if(input.getToken() > 0) {
                    necessaryToken++;
                }
            }
            if(transition.getInputs().size() == necessaryToken) {
                if(transition.getDuration().get("duration_abs") != 0) {
                    Thread.sleep(r.nextInt(transition.getDuration().get("duration_abs")));
                }else {
                    System.out.println("Random number is: " +((int)transition.getDuration().get("duration_max") - (int)transition.getDuration().get("duration_min") + (int)transition.getDuration().get("duration_min")));
                    Thread.sleep(Long.valueOf(r.nextInt((transition.getDuration().get("duration_max") - transition.getDuration().get("duration_min")) + transition.getDuration().get("duration_min"))+1));
                }
                for(String in: transition.getInputs()) {
                    input = Utils.searchForANodeAfterItsName(in, nodes);
                    input.execute(-1);
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
                System.out.println("\n");
            }else {
                System.out.println("Cannot execute step " +step+ ". The timeout for the transitions did not finish or the Petri Net entered deadblock. \n");
            }
            System.out.println("-------------------------------------------------------------- \n");
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
            System.out.println("Petri Net is at state " +step+ ". Cannot move on to step " +(++step)+ "because it encoutered deadlock or the Petri Net finished");
            return true;
        }           
    }    
}

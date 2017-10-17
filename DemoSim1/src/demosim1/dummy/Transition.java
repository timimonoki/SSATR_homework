/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1.dummy;

import demosim1.dummy.utils.Utils;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author monokiT
 */
public class Transition {
    private String name;
    private Map<String, Integer> duration;
    private List<String> inputs;
    private List<String> outputs;
    
    public Transition(String name, Map<String, Integer> duration, List<String> inputs, List<String> outputs) {
        this.name = name;
        this.duration = duration;
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public String getName() {
        return name;
    }
    
    public Map<String, Integer> getDuration() {
        return duration;
    }
    
    public List<String> getInputs() {
        return inputs;
    }
    
    public List<String> getOutputs() {
        return outputs;
    }
    
    public boolean canExecute(List<Node> nodes) {
        boolean canExecute = false;
        Node input;
        int necessaryToken = 0;
        for(String in: inputs) {
            input = Utils.searchForANodeAfterItsName(in, nodes);
            if(input.getToken() > 0) {
                necessaryToken++;
            }
        }  
        if(inputs.size() == necessaryToken) {
            canExecute = true; 
        }
        return canExecute;
    }
    
    public boolean finishedWaiting() throws InterruptedException {
        boolean finishedWaiting = false;
        Random r = new Random();
        if(duration.get("duration_abs") != 0) {
            Thread.sleep(r.nextInt(duration.get("duration_abs")));
            finishedWaiting = true;
        }else if((duration.get("duration_max") !=0) && (duration.get("duration_min") != 0)){
            Thread.sleep(Long.valueOf(r.nextInt((duration.get("duration_max") - duration.get("duration_min")) + duration.get("duration_min"))));
            finishedWaiting = true;
        }else {
            finishedWaiting = true;
        }
        return finishedWaiting;
    }
}

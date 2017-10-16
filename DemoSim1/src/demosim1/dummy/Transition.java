/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1.dummy;

import java.util.List;
import java.util.Map;

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
    
}

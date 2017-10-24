/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1.dummy;

import java.util.List;

/**
 *
 * @author evo
 */
public class Node {
    private String name;
    private int token;    
    private List<String> inputs;
    private List<String> outputs;

    
    public Node(String name, int token, List<String> inputs, List<String> outputs) {
        this.name = name;
        this.token = token;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public int getToken() {
        return token;
    }
    
    public String getName() {
        return name;
    }
    
    public List<String> getInputs() {
        return inputs;
    }
    
    public List<String> getOutputs() {
        return outputs;
    }
    
    public synchronized void execute(int numberOfTokens){
        token = token + numberOfTokens;
    }    
}

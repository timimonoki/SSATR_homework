/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1.dummy.utils;

import demosim1.dummy.Node;
import demosim1.dummy.Transition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author monokiT
 */
public class Utils {
    
    public static Node convertJsonObjectToNodeType(JSONObject json) {
        JSONObject node = json.getJSONObject("node");
        return new Node(node.getString("name"), node.getInt("token"));
    }
    
    public static Transition convertJsonObjectToTransition(JSONObject json) {
        Map<String, Integer> duration = new HashMap<String, Integer>();
        JSONObject jsonDuration = json.getJSONObject("duration");
        JSONArray jsonInputs = json.getJSONArray("inputs");
        JSONArray jsonOutputs = json.getJSONArray("outputs");
        List<String> inputs = new ArrayList<String>();
        List<String> outputs = new ArrayList<String>();
        
        duration.put("duration_abs", Integer.parseInt((jsonDuration.get("duration_abs").toString())));
        duration.put("duration_min", Integer.parseInt(jsonDuration.get("duration_min").toString()));
        duration.put("duration_max", Integer.parseInt(jsonDuration.get("duration_max").toString()));
        
        for(int i = 0; i<jsonInputs.length(); i++) {
            inputs.add(jsonInputs.getJSONObject(i).getString("name"));
        }
        
        for(int i = 0; i<jsonOutputs.length(); i++) {
            outputs.add(jsonOutputs.getJSONObject(i).getString("name"));
        }
        
        return new Transition(json.getString("name"), duration, inputs, outputs);
    }  
    
    public static Node searchForANodeAfterItsName(String name, List<Node> listToSearch) {
        for(Node node: listToSearch) {
            if(node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }
    
    public static int getMaximumWaitTimeForATransition(List<Transition> transitions) {
        int maximumWait = 0;
        for(Transition transition: transitions) {
            maximumWait = transition.getDuration().get("duration_abs");            
            if(maximumWait < transition.getDuration().get("duration_max")) {
                maximumWait = transition.getDuration().get("duration_max");
            }
        }
        return maximumWait;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1;

import demosim1.dummy.DummyModel;
import demosim1.dummy.Node;
import demosim1.dummy.Transition;
import demosim1.dummy.utils.Utils;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.json.*;

/**
 *
 * @author evo
 */
public class ModelFactory {

    
    public static Model loadDummyModelFromJSONFile(String modelFile) throws Exception{
        String jsonContent = new String(Files.readAllBytes(Paths.get(modelFile)));
        JSONObject obj = new JSONObject(jsonContent);
        
        List<Node> nodes = new ArrayList<Node>();
        List<Transition> transitions = new ArrayList<Transition>();
        
        JSONArray nodesArray = obj.getJSONArray("nodes");
        JSONArray transitionsArray = obj.getJSONArray("transitions");
        for(int i = 0 ; i < nodesArray.length(); i++) {
            nodes.add(Utils.convertJsonObjectToNodeType(nodesArray.getJSONObject(i)));                
        }
        for(int i=0; i < transitionsArray.length(); i++) {
            transitions.add(Utils.convertJsonObjectToTransition(transitionsArray.getJSONObject(i)));
        }
        
        DummyModel model = new DummyModel(nodes, transitions);
        
        return model;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1;

import demosim1.dummy.DummyModel;
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
        //JSONObject obj = new JSONObject("{nodes : [{node:10}, {node:30}]}");
        JSONObject obj = new JSONObject(jsonContent);

        List<Integer> list = new ArrayList<Integer>();
            JSONArray array = obj.getJSONArray("nodes");
            for(int i = 0 ; i < array.length() ; i++){
                list.add(array.getJSONObject(i).getInt("node"));
                
            }
        if(list.size()!=2)
            throw new Exception("Json must contani exactly 2 nodes.");
        
        DummyModel model = new DummyModel(list.get(0), list.get(1));
        
        return model;
    }
    
}

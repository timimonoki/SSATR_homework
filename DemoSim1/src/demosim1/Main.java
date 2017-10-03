/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1;

/**
 *
 * @author evo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Simulator s = new Simulator(ModelFactory.loadDummyModelFromJSONFile("model1.json"));
        s.start();
    }
    
}

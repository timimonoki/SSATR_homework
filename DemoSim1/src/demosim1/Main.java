
package demosim1;

/**
 * A sample application used as a starting point for implementing a timed petri net simulator.
 * SSATR / IASIC & ICAF / Master / An 1 / 2017 
 * @author evo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Simulator s = 
                new Simulator(ModelFactory.loadDummyModelFromJSONFile("model1.json"));
        s.start();
    }
    
}

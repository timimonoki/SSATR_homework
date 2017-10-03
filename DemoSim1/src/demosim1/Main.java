
package demosim1;

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

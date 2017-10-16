
package demosim1.dummy;

import demosim1.Model;
import java.util.ArrayList;
import java.util.List;

public class DummyModel implements Model{

    List<Node> nodes;
    List<Transition> transitions;
    
    public DummyModel(List<Node> nodes, List<Transition> transitions) {
        this.nodes = nodes;
        this.transitions = transitions;
    }
    
    @Override
    public void step(int step) {
        for(Node n: nodes)
            n.execute();
        System.out.println("node1 = "+nodes.get(0).getToken()+" node2 = "+nodes.get(1).getToken()+" at step "+step);
    }

    @Override
    public boolean canStop() {
        return Math.abs(nodes.get(1).getToken() - nodes.get(0).getToken()) <2;
    }
    
}

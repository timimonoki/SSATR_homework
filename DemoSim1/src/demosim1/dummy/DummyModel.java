
package demosim1.dummy;

import demosim1.Model;
import java.util.ArrayList;
import java.util.List;

public class DummyModel implements Model{

    List<Node> nodes;
    
    public DummyModel(int n1, int n2) {
        nodes = new ArrayList<Node>();
        nodes.add(new Node(n1,1));
        nodes.add(new Node(n2,-1));
    }
    
    @Override
    public void step(int step) {
        for(Node n: nodes)
            n.execute();
        System.out.println("node1 = "+nodes.get(0).getValue()+" node2 = "+nodes.get(1).getValue()+" at step "+step);
    }

    @Override
    public boolean canStop() {
        return Math.abs(nodes.get(1).getValue() - nodes.get(0).getValue()) <2;
    }
    
}

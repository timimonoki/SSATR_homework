
package demosim1;

public class DummyModel implements Model{
    int node1;
    int node2;

    public DummyModel(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
    
    @Override
    public void step(int step) {
        if(node1<node2){
            node1++;
            node2--;
        }
        System.out.println("node1 = "+node1+" node2 = "+node2+" at step "+step);
    }

    @Override
    public boolean canStop() {
        return node2 - node1 <2;
    }
    
}

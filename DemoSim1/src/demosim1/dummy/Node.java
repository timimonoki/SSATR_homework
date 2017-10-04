/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosim1.dummy;

/**
 *
 * @author evo
 */
public class Node {
    private int dir;
    private int value;

    public Node(int value, int dir) {
        this.dir = dir;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int execute(){
        value = value + dir;
        return value;
    }
    
}

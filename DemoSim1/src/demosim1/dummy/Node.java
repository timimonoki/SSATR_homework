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
    private String name;
    private int token;    

    public Node(String name, int token, int dir) {
        this.name = name;
        this.dir = dir;
        this.token = token;
    }
    
    public Node(String name, int token) {
        this.name = name;
        this.token = token;
    }

    public int getToken() {
        return token;
    }
    
    public String getName() {
        return name;
    }

    public int execute(){
        token = token + dir;
        return token;
    }    
}

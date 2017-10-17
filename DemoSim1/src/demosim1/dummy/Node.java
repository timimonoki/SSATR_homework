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
    private String name;
    private int token;    

    
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
    
    public void execute(int numberOfTokens){
        token = token + numberOfTokens;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuan
 */
public abstract class Node {
    Object value=null;
    ArrayList<Node> neighbourNodes=new ArrayList();

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    abstract public void addNeighbour(Node node);
    public List<Node> getNeighbours(){
        return this.neighbourNodes;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) return false;
        return this.value.equals(o);
    }
}

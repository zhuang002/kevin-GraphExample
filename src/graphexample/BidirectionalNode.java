/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexample;

/**
 *
 * @author zhuan
 */
public class BidirectionalNode extends Node {

    @Override
    public void addNeighbour(Node node) {
        if (this.neighbourNodes.contains(node)) return;
        this.neighbourNodes.add(node);
        node.addNeighbour(this);
    }
    
    
}

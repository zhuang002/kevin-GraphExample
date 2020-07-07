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
public class GraphExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        buildBidirectionalGraph();
        buildDirectionalGraph();
        
        
        
        
        
        
        
    }

    private static void buildBidirectionalGraph() {
        Node[] nodes=new Node[10];
        for (int i=0;i<10;i++) {
            nodes[i]=new BidirectionalNode();
            nodes[i].setValue(i+1);
        }
        nodes[0].addNeighbour(nodes[1]);
        nodes[0].addNeighbour(nodes[2]);
        nodes[0].addNeighbour(nodes[5]);
        
        nodes[1].addNeighbour(nodes[2]);
        
        nodes[2].addNeighbour(nodes[6]);
        nodes[2].addNeighbour(nodes[8]);
        nodes[2].addNeighbour(nodes[9]);
        
        nodes[5].addNeighbour(nodes[6]);
        
        nodes[6].addNeighbour(nodes[7]);
    }

    private static void buildDirectionalGraph() {
        Node[][] nodes=new Node[4][4];
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                nodes[i][j]=new DirectionalNode();
                nodes[i][j].setValue(new Coord(i,j));
            }
        }
        
        nodes[0][0].addNeighbour(nodes[0][1]);
        
        nodes[0][1].addNeighbour(nodes[0][2]);
        nodes[0][1].addNeighbour(nodes[1][1]);
        
        nodes[0][2].addNeighbour(nodes[0][3]);
        
        nodes[0][3].addNeighbour(nodes[1][3]);
        
        nodes[1][0].addNeighbour(nodes[0][0]);
        
        nodes[1][1].addNeighbour(nodes[1][2]);
        
        nodes[1][2].addNeighbour(nodes[1][3]);
        nodes[1][2].addNeighbour(nodes[2][2]);

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Node[] nodes1 = buildBidirectionalGraph();
        Node[][] nodes2 = buildDirectionalGraph();
        TreeNode root = buildTree();
        BinaryTreeNode binaryRoot=buildBinaryTree();

        Node[] nodes = getAllAchievableNodes1(nodes1[0]);
        Node[] coordNodes = getAllAchievableNodes2(nodes2[0][0]);
        int depthOfTree=root.getDepth();

    }

    private static Node[] buildBidirectionalGraph() {
        Node[] nodes = new Node[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new BidirectionalNode();
            nodes[i].setValue(i + 1);
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
        return nodes;
    }

    private static Node[][] buildDirectionalGraph() {
        Node[][] nodes = new Node[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nodes[i][j] = new DirectionalNode();
                nodes[i][j].setValue(new Coord(i, j));
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

        nodes[2][0].addNeighbour(nodes[2][1]);
        nodes[2][0].addNeighbour(nodes[3][1]);

        nodes[2][2].addNeighbour(nodes[2][3]);
        nodes[2][2].addNeighbour(nodes[3][2]);

        nodes[2][3].addNeighbour(nodes[3][3]);

        nodes[3][0].addNeighbour(nodes[3][1]);

        nodes[3][1].addNeighbour(nodes[2][1]);
        nodes[3][2].addNeighbour(nodes[2][2]);

        return nodes;
    }

    private static Node[] getAllAchievableNodes1(Node node) {
        Set<Node> ret = new HashSet();
        ret.add(node);
        ret.addAll(node.getNeighbours());
        Set<Node> visited = new HashSet();
        visited.add(node);
        return getAllAchievableNodes1(ret, visited);
    }

    private static Node[] getAllAchievableNodes1(Set<Node> currentNodes, Set<Node> visited) {
        Set<Node> ret = new HashSet();
        ret.addAll(currentNodes);
        for (Node n : currentNodes) {
            if (visited.contains(n)) {
                continue;
            }
            Node[] achievables = getAllAchievableNodes1(n);
            ret.addAll(Arrays.asList(achievables));
        }
        return (Node[]) ret.toArray();
    }

    private static TreeNode buildTree() {
        TreeNode[] nodes = new TreeNode[11];
        for (int i = 0; i < 11; i++) {
            nodes[i] = new TreeNode();
            nodes[i].setValue(i);
        }
        TreeNode root = nodes[7];
        root.addChild(nodes[5]);
        root.addChild(nodes[8]);

        nodes[5].addChild(nodes[1]);
        nodes[5].addChild(nodes[6]);

        nodes[8].addChild(nodes[10]);

        nodes[1].addChild(nodes[2]);
        nodes[1].addChild(nodes[0]);

        nodes[2].addChild(nodes[3]);
        nodes[2].addChild(nodes[4]);

        nodes[0].addChild(nodes[9]);

        return root;

    }

    private static BinaryTreeNode buildBinaryTree() {
    }

}

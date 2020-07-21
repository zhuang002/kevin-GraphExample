/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

        ArrayList<Node> nodes3 = getAllAchievableNodesBFS(nodes1[0]);
        ArrayList<Node> nodes4 = getAllAchievableNodesDFS(nodes1[0]);
        ArrayList<Node> nodes5 = getAllAchievableNodesDFSRecursive(nodes1[0]);
        int depthOfTree=root.getDepth();
        
        TreeNode treenode1=searchTreeNodeByValueBFS(root,8);
        TreeNode treenode2=searchTreeNodeByValueDFS(root,8);
        TreeNode treenode3=root.seachNodeByValue(8); //recursive (DFS)

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

    private static ArrayList<Node> getAllAchievableNodesBFS(Node node) {
        ArrayList<Node> nodesHaveProcessed=new ArrayList();
        ArrayList<Node> nodeToProcessCurrentLevel=new ArrayList();
        ArrayList<Node> nodeToProcessNextLevel=new ArrayList();
        
        
        nodesHaveProcessed.add(node);
        nodeToProcessCurrentLevel.addAll(node.neighbourNodes);
        do {
            for (Node n1:nodeToProcessCurrentLevel) {
                for (Node n2:n1.neighbourNodes) {
                    if (!nodesHaveProcessed.contains(n2))
                        nodeToProcessNextLevel.add(n2);
                }
                nodesHaveProcessed.add(n1);
            }
            nodeToProcessCurrentLevel=nodeToProcessNextLevel;
            nodeToProcessNextLevel=new ArrayList();
        } while (!nodeToProcessCurrentLevel.isEmpty());
        
        return nodesHaveProcessed;
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
        BinaryTreeNode[] binarytree = new BinaryTreeNode[11];
        for (int i = 0; i < 11; i++) {
            binarytree[i] = new BinaryTreeNode();
            binarytree[i].setValue(i);
        }
        BinaryTreeNode root = binarytree[7];
        root.setLeft(binarytree[5]);
        root.setRight(binarytree[8]);
        
        binarytree[8].setRight(binarytree[10]);
        
        binarytree[5].setLeft(binarytree[1]);
        binarytree[5].setRight(binarytree[6]);

        binarytree[1].setLeft(binarytree[2]);
        binarytree[1].setRight(binarytree[0]);

        binarytree[2].setLeft(binarytree[3]);
        binarytree[2].setRight(binarytree[4]);

        binarytree[0].setRight(binarytree[9]);



        return root;

    }

    private static ArrayList<Node> getAllAchievableNodesDFS(Node node) {
        ArrayList<Node> nodesHaveProcessed=new ArrayList();
        Stack<Node> nodesToProcess=new Stack();
        
        Node n=node;
        
        while (true) {
            for (Node n1:n.neighbourNodes) {
                if (!nodesHaveProcessed.contains(n1)) {
                    nodesToProcess.push(n1);
                }
            }
            nodesHaveProcessed.add(n);
            if (nodesToProcess.isEmpty()) break;
            n=nodesToProcess.pop();
        } 
        return nodesHaveProcessed;
    }

    private static ArrayList<Node> getAllAchievableNodesDFSRecursive(Node node) {
        ArrayList<Node> nodesHaveProcessed=new ArrayList();
        return getAllAchievableNodesDFSRecursive(node, nodesHaveProcessed);
    }

    private static ArrayList<Node> getAllAchievableNodesDFSRecursive(Node node, ArrayList<Node> nodesHaveProcessed) {
        ArrayList<Node> ret=new ArrayList();
        for (Node n:node.neighbourNodes) {
            if (!nodesHaveProcessed.contains(n)) {
                nodesHaveProcessed.add(n);
                ret.addAll(getAllAchievableNodesDFSRecursive(n,nodesHaveProcessed));
            }
        }
        nodesHaveProcessed.add(node);
        return ret;
    }

    private static TreeNode searchTreeNodeByValueBFS(TreeNode root,Object o) {
        ArrayList<TreeNode> currentProcessingNodes=new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextProcessingNodes=new ArrayList<TreeNode>();
        currentProcessingNodes.add(root);
        while (!currentProcessingNodes.isEmpty()) {
            for (TreeNode n:currentProcessingNodes) {
                if (n.getValue().equals(o)) return n;
                nextProcessingNodes.addAll(n.getChildren());
            }
            currentProcessingNodes=nextProcessingNodes;
            nextProcessingNodes=new ArrayList<TreeNode>();
        }
        return null;
    }
    
    private static TreeNode searchTreeNodeByValueDFS(TreeNode root, Object o) {
        
        Stack<TreeNode> nodes=new Stack<>();
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            TreeNode n=nodes.pop();
            if (n.getValue().equals(o)) return n;
            nodes.addAll(n.getChildren());
        }
        return null;
    }

}

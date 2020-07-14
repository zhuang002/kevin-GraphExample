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
public class BinaryTreeNode {
    Object value=null;
    BinaryTreeNode parent=null;
    BinaryTreeNode left=null;
    BinaryTreeNode right=null;

    public Object getValue() {
        return value;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    
    public boolean isLeaf() {
        return this.left==null && this.right==null;
    }
    public int getDepth() {
        if (this.isLeaf()) return 0;
        return Math.max(this.left.getDepth(), this.right.getDepth());
    }
}

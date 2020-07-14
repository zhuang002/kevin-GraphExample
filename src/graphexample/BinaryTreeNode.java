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
public class BinaryTreeNode implements IBinaryTreeNode{
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

    @Override
    public BinaryTreeNode getLeft() {
        return left;
    }

    @Override
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
    
    public BinaryTreeNode findValueNode(Object value) {
        if (this.getValue().equals(value)) return this;
        if (this.isLeaf()) return null;
        BinaryTreeNode node=this.left.findValueNode(value);
        if (node!=null) return node;
        return this.right.findValueNode(value);
    }
    
    public BinaryTreeNode findSortedValueNode(Comparable value) {
        if (this.getValue().equals(value)) return this;
        if (this.isLeaf()) return null;
        int compare=((Comparable)this.value).compareTo(value);
        if (compare<0) return this.left.findSortedValueNode(value);
        else return this.right.findSortedValueNode(value);
    }

    @Override
    public void setLeft(IBinaryTreeNode node) {
        this.left=(BinaryTreeNode)node;
    }

    @Override
    public void setRight(IBinaryTreeNode node) {
        this.right=(BinaryTreeNode)node;
    }
}

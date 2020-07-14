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
public class BinaryTreeNode2 extends TreeNode implements IBinaryTreeNode{

    @Override
    public IBinaryTreeNode getLeft() {
        if (this.children.size()>=1) return (IBinaryTreeNode)this.children.get(0);
        return null;
    }

    @Override
    public void setLeft(IBinaryTreeNode node) {
        if (this.children.size()>=1) this.children.set(0, (TreeNode)node);
        this.children.add((TreeNode)node);
    }

    @Override
    public IBinaryTreeNode getRight() {
        if (this.children.size()>=2) return (IBinaryTreeNode)this.children.get(1);
        return null;
    }

    @Override
    public void setRight(IBinaryTreeNode node) {
        if (this.children.size()>=2) this.children.set(1, (TreeNode)node);
        else if (this.children.size()>=1) this.children.add((TreeNode)node);
        else {
            this.children.add(null);
            this.children.add((TreeNode)node);
        }
    }
    
}

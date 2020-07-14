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
public interface IBinaryTreeNode {
    public IBinaryTreeNode getLeft();
    public void setLeft(IBinaryTreeNode node);
    public IBinaryTreeNode getRight();
    public void setRight(IBinaryTreeNode node);
}

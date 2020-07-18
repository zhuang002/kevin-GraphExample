/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexample;

import java.util.ArrayList;

/**
 *
 * @author zhuan
 */
public class TreeNode {
    Object value=null;
    TreeNode parent=null;
    ArrayList<TreeNode> children=new ArrayList();

    public Object getValue() {
        return value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    
    public void addChild(TreeNode node) {
        this.children.add(node);
        node.setParent(this);
    }
    
    public void removeChild(TreeNode node) {
        this.children.remove(node);
    }
    
    public boolean isLeaf() {
        return this.children.isEmpty();
    }
    
    public int getDepth() {
        if (this.isLeaf()) return 0;
        int maxSubDepth=0;
        for (TreeNode node:children) {
            int subDepth=node.getDepth();
            if (maxSubDepth<subDepth)
                maxSubDepth=subDepth;
        }
        return maxSubDepth+1;
    }
    
}

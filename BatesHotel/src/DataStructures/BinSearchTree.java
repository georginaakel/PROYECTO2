/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author Georgina
 */
public class BinSearchTree {
    
    private BinNode root;

    public BinSearchTree() {
        this.root = null;
    }

    public BinSearchTree(BinNode node) {
        this.root = node;
    }

    public BinNode getRoot() {
        return root;
    }

    public void setRoot(BinNode root) {
        this.root = root;
    }
    
    
    
}

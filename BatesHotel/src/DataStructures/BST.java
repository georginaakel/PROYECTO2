/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author Georgina
 */
public class BST {

    private NodeB root;

    public BST() {
        this.root = null;
    }

    public BST(NodeB node) {
        this.root = node;
    }

    public NodeB getRoot() {
        return root;
    }

    public void setRoot(NodeB root) {
        this.root = root;
    }

    public void inorden(NodeB root) {
        if (root != null){
            inorden(root.getLeft());
            System.out.println(root.getData() + " , ");
            inorden(root.getRight());
        }
    }

}

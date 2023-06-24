/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Booking;

/**
 *
 * @author Georgina
 */
public class BST<T> {

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

    public void insert(NodeB root, NodeB newNode) {
        if (this.root == null) {
            this.root = newNode;
        } else {
            if (newNode.getData() < root.getData()) {
                if (root.getLeft() == null) {
                    root.setLeft(newNode);
                } else {
                    insert(root.getLeft(), newNode);
                }
            } else if (newNode.getData() > root.getData()) {
                if (root.getRight() == null) {
                    root.setRight(newNode);
                } else {
                    insert(root.getRight(), newNode);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    public void insertbooking(NodeB root, Booking booking){
        if (this.root == null) {
            NodeB node = new NodeB(Integer.parseInt(booking.getId()));
            this.root = node ;
        } else {
            NodeB node = new NodeB(Integer.parseInt(booking.getId()));
            if (node.getData() < root.getData()) {
                if (root.getLeft() == null) {
                    root.setLeft(node);
                } else {
                    insert(root.getLeft(), node);
                }
            } else if (node.getData() > root.getData()) {
                if (root.getRight() == null) {
                    root.setRight(node);
                } else {
                    insert(root.getRight(), node);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    public void GetBooking(int ci){
        
    }
}

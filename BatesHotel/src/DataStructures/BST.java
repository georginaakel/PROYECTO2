/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Booking;
import static DataStructures.HashTable.BOOKING;

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
    
    public void preOrder(NodeB root){
        if(root != null){
            System.out.println(root.getData() + ", ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    public void inOrder(NodeB root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getData() + ", ");
            inOrder(root.getRight());
        }
    }
    
    public void postOrder(NodeB root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData() + ", ");
        }
    }

    public void insert(NodeB root, int data) {
        NodeB newNode = new NodeB(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            if (data < root.getData()) {
                if (root.getLeft() == null) {
                    root.setLeft(newNode);
                } else {
                    insert(root.getLeft(), data);
                }
            } else if (newNode.getData() > root.getData()) {
                if (root.getRight() == null) {
                    root.setRight(newNode);
                } else {
                    insert(root.getRight(), data);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    public void insertBooking(NodeB root, Booking booking){
        String StrId = booking.getId().replace(".", "");
        int id = Integer.parseInt(StrId);
        NodeB node = new NodeB(id);
        if (this.root == null) {
            this.root = node ;
        } else {
            if (node.getData() < root.getData()) {
                if (root.getLeft() == null) {
                    root.setLeft(node);
                } else {
                    insertBooking(root.getLeft(), booking);
                }
            } else if (node.getData() > root.getData()) {
                if (root.getRight() == null) {
                    root.setRight(node);
                } else {
                    insertBooking(root.getRight(), booking);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    public NodeB search(NodeB root, int data){
        if (this.root == null){
            return null;
        } else{
            if ((int)root.getData() == data){
                return root;
            } else{
                if (data < (int)root.getData()){
                    return search(root.getLeft(), data);
                } else {
                    return search(root.getRight(), data);
                }
            }
        }
    }
    
    public Booking searcBooking(HashTable ht, NodeB current, int data){
        NodeB node = search(current, data);
        if(node == null){
            return null;
        }
        else{
            Booking booking = ht.get1(node.getData());
            return booking;
        }
        
    }
    
}

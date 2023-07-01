/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Booking;
import Classes.Historic;


/**
 *
 * @author Georgina
 */
public class BST<T> {
    //Atributos de la clase
    private NodeB root;
    
    //Constructor 1: inicializar sin raiz
    public BST() {
        this.root = null;
    }
    
    //Constructor 2: inicializar con raiz
    public BST(NodeB node) {
        this.root = node;
    }
    
    //===========================Getters and Setters========================
    public NodeB getRoot() {
        return root;
    }

    public void setRoot(NodeB root) {
        this.root = root;
    }
    
    //======================Procedimientos y Metodos=======================
    
    //Recorrido preorder
    public void preOrder(NodeB root) {
        if (root != null)
        {
            System.out.println(root.getData() + ", ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    //Recorrido inorden
    public void inOrder(NodeB root) {
        if (root != null)
        {
            inOrder(root.getLeft());
            System.out.println(root.getData() + ", ");
            inOrder(root.getRight());
        }
    }
    
    //Recorrido postorden
    public void postOrder(NodeB root) {
        if (root != null)
        {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData() + ", ");
        }
    }
    
    //Insertar en el arbol
    public void insert(NodeB root, int data) {
        NodeB newNode = new NodeB(data);
        if (this.root == null)
        {
            this.root = newNode;
        } else
        {
            if (data < root.getData())
            {
                if (root.getLeft() == null)
                {
                    root.setLeft(newNode);
                } else
                {
                    insert(root.getLeft(), data);
                }
            } else if (newNode.getData() > root.getData())
            {
                if (root.getRight() == null)
                {
                    root.setRight(newNode);
                } else
                {
                    insert(root.getRight(), data);
                }
            } else
            {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }
    }
    
    //Metodo para buscar en el arbol
    public NodeB search(NodeB root, int data) {
        if (this.root == null){
            return null;
        } 
        else{
            if ((int) root.getData() == data){
                return root;
            } 
            else{
                if (data < (int) root.getData()){
                    return search(root.getLeft(), data);
                }
                else{
                    return search(root.getRight(), data);
                }
            }
        }
    }


}


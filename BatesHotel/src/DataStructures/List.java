/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author Georgina
 * @param <T>
 */
public class List <T> {
    
    private Node pfirst;
    private Node pLast;
    private int size;

    public List(Node pfirst, Node pLast, int size) {
        this.pfirst = pfirst;
        this.pLast = pLast;
        this.size = size;
    }

    public Node getPfirst() {
        return pfirst;
    }

    public void setPfirst(Node pfirst) {
        this.pfirst = pfirst;
    }

    public Node getpLast() {
        return pLast;
    }

    public void setpLast(Node pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
            
    
}

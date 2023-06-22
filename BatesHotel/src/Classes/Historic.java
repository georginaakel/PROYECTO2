/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Juan
 */
public class Historic extends Person {
    //Atributos de la clase
    private String ci;
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String dateIn;
    private String numRoom;
    
    //Constructor
    public Historic(String ci, String name, String lastName, String email, String gender, String dateIn, String numRoom) {
        super(name, lastName, email, gender, dateIn);
        this.ci = ci;
        this.numRoom = numRoom;
    }
    
    //===========================Getters and Setters=============================
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(String numRoom) {
        this.numRoom = numRoom;
    }
    
    
    
    
}

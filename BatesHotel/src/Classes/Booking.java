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
public class Booking extends Person {
    //Atributos de la clase
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String typeRoom;
    private String phoneNumber;
    private String dateIn;
    private String dateOut;
    
    //Constructor
    public Booking(String id, String name, String lastName, String email, String gender, String typeRoom, String phoneNumber, String dateIn, String dateOut){
        super(name, lastName, email, gender, dateIn);
        this.id = id;
        this.typeRoom = typeRoom;
        this.phoneNumber = phoneNumber;
        this.dateOut = dateOut;
    }
    
    //=========================Getters and Setters=========================
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    
    
    
}

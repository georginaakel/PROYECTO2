/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Orveo Di Luca
 */
public class Client extends Person {
    //Atributos de la clase
    private String numRoom;
    private String name; 
    private String lastName; 
    private String email; 
    private String gender; 
    private String phone; 
    private String dateIn;
    
    //Constructor
    public Client(String numRoom, String name, String lastName, String email, String gender, String phone, String dateIn) {
        super(name, lastName, email, gender, dateIn);
        this.numRoom = numRoom;
        this.phone = phone;
    }
    
    //========================Getters and Setters==========================
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
}

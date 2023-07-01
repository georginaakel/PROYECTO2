/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Orveo Di Luca
 */
public class Room {
    //Atributos de la clase
    private String numRoom; 
    private String typeRoom;
    private String floor;
    
    //Constructor
    public Room(String numRoom, String typeRoom, String floor) {
        this.numRoom = numRoom;
        this.typeRoom = typeRoom;
        this.floor = floor;
    }
    
    //========================Getters and Setters=========================
    public String getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(String num_room) {
        this.numRoom = num_room;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String type_room) {
        this.typeRoom = type_room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    
    
    
}

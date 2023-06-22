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
    private String num_room; 
    private String type_room;
    private String floor;

    public Room(String num_room, String type_room, String floor) {
        this.num_room = num_room;
        this.type_room = type_room;
        this.floor = floor;
    }

    public String getNum_room() {
        return num_room;
    }

    public void setNum_room(String num_room) {
        this.num_room = num_room;
    }

    public String getType_room() {
        return type_room;
    }

    public void setType_room(String type_room) {
        this.type_room = type_room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    
    
    
}

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
public class Booking {
    private String id;
    private String name;
    private String secondName;
    private String email;
    private String sex;
    private String typeRoom;
    private String phoneNumber;
    private String dateIn;
    private String dateOut;

    public Booking(String id, String name, String secondName, String email, String sex, String typeRoom, String phoneNumber, String dateIn, String dateOut) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.sex = sex;
        this.typeRoom = typeRoom;
        this.phoneNumber = phoneNumber;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    
    
    
}

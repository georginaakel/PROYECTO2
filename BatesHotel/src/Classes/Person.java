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
public class Person {
    //Atributos de la clase
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String dateIn;
    
    //Constructor
    public Person(String name, String lastName, String email, String gender, String dateIn) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateIn = dateIn;
    }
    
    //========================Getters and Setters=======================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
    
    
    
    
}

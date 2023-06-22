/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bateshotel;

import Classes.Booking;
import DataStructures.HashTable;
import DataStructures.List;
import DataStructures.Util;

/**
 *
 * @author Georgina
 */
public class BatesHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Util u = new Util();
        HashTable rooms = new HashTable(500);
        HashTable clients = new HashTable(500);
        HashTable hashtable = new HashTable(1500);
        u.ReadBooking(hashtable);
        u.Readclient(clients);
        System.out.println(clients.getClient("").getName());
//        u.Readroom(rooms);
//        System.out.println(rooms.getroom("15").getNum_room());
//        Booking client = hashtable.get("Zuzana");
//        System.out.println(client.getName());
    }
    
}

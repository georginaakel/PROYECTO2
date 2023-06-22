/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bateshotel;

import Classes.Client;
import DataStructures.HashTable;
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
        HashTable hashtable = new HashTable(1500);
        u.ReadExcel(hashtable);
        Client cliente = (Client) hashtable.get("Zuzana").get(0);
        System.out.println(cliente.getName());
    }
    
}

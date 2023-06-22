/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Booking;
import Classes.Client;
import Classes.Room;

/**
 *
 * @author Juan
 */
public class HashTable {
    private int size;
    private List[] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new List[size];
    }
    
    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getTable() {
        return table;
    }

    public void setTable(List[] table) {
        this.table = table;
    }
    
    //HashTable general. 
    public int hash(String name){
        int a = 31; 
        long hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (a * hash + name.charAt(i)) % size;
        }
        return (int) hash;
    }
    
    public int hashRoom(String num_room){
        return Integer.parseInt(num_room);
    }
    
    //Añade las reservas. 
    public void add(Booking booking){
        String name = booking.getName();
        int idx = hash(name);
        List list = new List(booking);
        if(table[idx] == null){
            table[idx] = list;
        }
        else{
            List auxList = table[idx];
            auxList.append(booking);
            table[idx] = auxList;
        }
    }
    
    //Añade el cliente.
    public void addClient(Client client){
        String name = client.getName();
        int idx = hash(name);
        List list = new List(client);
        if(table[idx] == null){
            table[idx] = list;
        }
        else{
            List auxList = table[idx];
            auxList.append(client);
            table[idx] = auxList;
        }
    }
    
    //Obtiene los nombres de las reservas. 
    public Booking get(String name){
        int idx = hash(name);
        List list = table[idx];

        if(list.len() == 1){
            return (Booking) list.get(0);
        }
        
        else{
            for (int x = 0; x < list.len(); x++) {
                Booking client = (Booking) list.get(x);
                if(client.getName().equals(name)){
                    return client;
                }
            }
        }

        return null;      
    }
    
    //Obtiene el cliente de la hoja cliente.
    public Client getClient(String name){
        int idx = hash(name);
        List list = table[idx];
        
        if(list.len() == 1){
            return  (Client) list.get(0);
        }
        
        else{
            for (int x = 0; x < list.len(); x++) {
                Client client = (Client) list.get(x);
                if(client.getName().equals(name)){
                    return client;
                }
            }
        }

        return null;      
    }
    
    //añade el cuarto. 
    public void addroom(Room room){
        int idx = hashRoom(room.getNum_room());
        List list = new List(room);
        if(table[idx] == null){
            table[idx] = list;
        }
        else{
            List auxList = table[idx];
            auxList.append(room);
            table[idx] = auxList;
        }
    }
    
    //Obtiene el cuarto.
    public Room getroom(String num_room){
        int idx = hashRoom(num_room);
        List list = table[idx];

        if(list.len() == 1){
            return (Room) list.get(0);
        }
        
        else{
            for (int x = 0; x < list.len(); x++) {
                Room room = (Room) list.get(x);
                if(room.getNum_room().equals(num_room)){
                    return room;
                }
            }
        }

        return null;      
    }
}


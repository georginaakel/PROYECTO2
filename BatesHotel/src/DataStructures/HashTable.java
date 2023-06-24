/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Booking;
import Classes.Client;
import Classes.Historic;
import Classes.Person;
import Classes.Room;

/**
 *
 * @author Juan
 * @param <T>
 */

public class HashTable<T> {
    //Atributos de la clase
    private int size;
    private List[] table;
    
    //Constantes
    public static final int BOOKING = 0;
    public static final int ROOM = 1;
    public static final int CLIENT = 2;
    public static final int HISTORIC = 3;
    
    //Constructor
    public HashTable(int size) {
        this.size = size;
        this.table = new List[size];
    }
    
    
    //====================Getters and Setters========================
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
    
    //===================Procedimientos y metodos===================
    
    //Metodo hash para retornar una llave utilizando el nombre y el apellido
    public int hash(String name, String secondName){
        int a = 31; 
        int hash1 = 0;
        int hash2 = 0;
        for (int i = 0; i < name.length(); i++) {
            hash1 = (a * hash1 + name.charAt(i));
        }
        
        for (int i = 0; i < name.length(); i++) {
            hash2 = (a * hash2 + name.charAt(i));
        }
        
        long hash = hash1 + hash2;
        if(hash < 0){
            hash = hash * -1;
            return (int) hash % size;
        }
        else{
            return (int) hash % size;
        }
    }
        
    //Añade al hashtable el elemento pasado por parametro 
    public void add(T data, int type){
        if(type == BOOKING){
            Booking booking = (Booking) data;
            int idx = hash(booking.getName(), booking.getLastName());
            if(table[idx] == null){
                List list = new List(booking);
                table[idx] = list;
            }
            else{
                List tableList = table[idx];
                tableList.append(booking);
                table[idx] = tableList;
            }
        }
        
        else if(type == ROOM){
            Room room = (Room) data;
            int idx = Integer.parseInt(room.getNumRoom());
            if(table[idx] == null){
                List list = new List(room);
                table[idx] = list;
            }
            else{
                List tableList = table[idx];
                tableList.append(room);
                table[idx] = tableList;
            }          
        }
        
        else if(type == CLIENT){
            Client client = (Client) data;
            int idx = hash(client.getName(), client.getLastName());
            if(table[idx] == null){
                List list = new List(client);
                table[idx] = list;
            }
            else{
                List tableList = table[idx];
                tableList.append(client);
                table[idx] = tableList;
            }          
        }
        
        else if(type == HISTORIC){
            Historic historic = (Historic) data;
            int idx = hash(historic.getName(), historic.getLastName());
            if(table[idx] == null){
                List list = new List(historic);
                table[idx] = list;
            }
            else{
                List tableList = table[idx];
                tableList.append(historic);
                table[idx] = tableList;
            }
        }
    }
    
    //Obtiene el valor del hashtable pasando como argumento el nombre y el apellido de la persona
    public T get(String name, String lastName){
        int idx = hash(name, lastName);
        if(table[idx] != null){
            if(table[idx].len() == 1){
                return (T) table[idx].get(0);
            }
            else if(table[idx].len() > 1){
                List list = table[idx];
                for(int x = 0; x < list.len(); x++){
                    Person value = (Person) list.get(x);
                    if(value.getName().equals(name) && value.getLastName().equals(lastName)){
                        return (T) value;
                    }
                }
            }
        }
        return null;
    }
    
    //Obtiene el valor del hashtable pasando como argumento el numero de habitacion
    public Room get(int numRoom){
        int idx = numRoom;
        if(table[idx] != null){
            if(table[idx].len() == 1){
                return (Room) table[idx].get(0);
            }
            else if(table[idx].len() > 1){
                List list = table[idx];
                for(int x = 0; x < list.len(); x++){
                    Room room = (Room) list.get(x);
                    if(room.getNumRoom().equals(Integer.toString(numRoom))){
                        return (Room) room;
                    }
                }
            }
        }
        return null;
    }
    //Obtiene el indice de cada valor del hashtable
    public List getindex(int idx){
        if(idx > size || idx < 0){
            System.out.println("No se encuentra el indice.");
            return null;
        }else{
            List aux = table[idx];
            return aux;
        }
    }

}


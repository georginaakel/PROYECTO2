/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Client;

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
    
    public int hash(String name){
        int a = 31; 
        long hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (a * hash + name.charAt(i)) % size;
        }
        return (int) hash;
    }
    
    public void add(Client client){
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
    
    public Client get(String name){
        int idx = hash(name);
        List list = table[idx];

        if(list.len() == 1){
            return (Client) list.get(0);
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
}

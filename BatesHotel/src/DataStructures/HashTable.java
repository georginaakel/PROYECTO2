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
        double value = 0;
        for (int x = 0; x < name.length(); x++) {
            char letter = name.charAt(x);
            value += (int) letter;
        }
        while(Integer.toString((int) value).length() > size || value > size){
            String valueStr = Integer.toString((int) value);
            String newStr = valueStr.substring(0, valueStr.length()-1);
            value = Integer.parseInt(newStr);
            value = Math.pow(value, (3/2));
        }
        
        return (int) value;
    }
    
    public void add(Client client){
        String name = client.getName();
        int idx = hash(name);
        table[idx].append(client);
    }
          
}

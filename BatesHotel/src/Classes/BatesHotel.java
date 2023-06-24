/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Classes;

import Classes.Booking;
import DataStructures.BST;
import DataStructures.HashTable;
import DataStructures.List;
import DataStructures.Util;
import static DataStructures.Util.BOOKING;
import static DataStructures.Util.CLIENT;
import static DataStructures.Util.HISTORIC;
import static DataStructures.Util.ROOM;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Georgina
 */
public class BatesHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable<Historic> ht = new HashTable(1500);
        Util.readExcel(ht, HISTORIC);
        
        BST arbol = new BST();
        Util.HashToTreeHistc(ht, arbol);
       
        List list = ht.gethistoric(48);
        for (int x = 0; x < list.len(); x++)
        {
            Historic h = (Historic) list.get(x);
            System.out.println(h.getNumRoom() + " " + h.getName());
        }
    }
    
    
}

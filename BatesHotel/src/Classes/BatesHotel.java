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
import Interfaces.LoadWindow;
import Interfaces.Main;
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
        LoadWindow loadwindow = new LoadWindow();
        loadwindow.setVisible(true);

    }
    
    
}

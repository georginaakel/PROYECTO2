/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructures;

import Classes.Booking;
import Classes.Client;
import Classes.Historic;
import Classes.Room;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        
/**
 *
 * @author Juan
 */
public class Util{
    //Constantes
    public static final int BOOKING = 0;
    public static final int ROOM = 1;
    public static final int CLIENT = 2;
    public static final int HISTORIC = 3;
    
   
    
    //Prodecimiento que permite leer cualquier hoja del excel
    public static void readExcel(HashTable hashtable, int type){
        try{           
            FileInputStream f = new FileInputStream("Booking_hotel.xlsx"); 
            XSSFWorkbook libro = new XSSFWorkbook(f); 
            XSSFSheet hoja = libro.getSheetAt(type); 

            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;

            Row fila = filas.next();
            Cell celda;
            while(filas.hasNext()){
                String auxiliar = "";
                boolean run = true;

                fila = filas.next();
                celdas = fila.cellIterator();

                DataFormatter dataFormatter = new DataFormatter();
                while(run){                                         
                    celda = celdas.next();

                    if(celda.getCellType() == 2){
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String s = sdf.format(celda.getDateCellValue());
                        auxiliar += s + "\n"; 
                    }
                    else{
                        auxiliar += dataFormatter.formatCellValue(celda) + "\n";
                    }

                    if(!celdas.hasNext()){
                        run = false;
                    }
                }

                if(type == BOOKING){               
                    String[] array = auxiliar.split("\n");
                    Booking booking = new Booking(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8]);
                    hashtable.add(booking, 0);
                }

                else if(type == ROOM){
                    String[] array = auxiliar.split("\n");
                    Room room = new Room(array[0],array[1],array[2]);
                    hashtable.add(room, 1);
                }

                else if(type == CLIENT){
                    String[] array = auxiliar.split("\n");
                    if(array.length == 7){
                        Client client = new Client(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
                        hashtable.add(client, 2);
                    }
                }

                else if(type == HISTORIC){
                    String[] array = auxiliar.split("\n");
                    Historic historic = new Historic(array[0],array[1],array[2],array[3],array[4],array[5],array[6]);
                    hashtable.add(historic, 3);
                }
            }                                                                 
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    

        
    
    
    
}

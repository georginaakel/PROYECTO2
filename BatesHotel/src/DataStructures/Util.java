/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructures;

import Classes.Booking;
import Classes.Client;
import Classes.Room;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        
/**
 *
 * @author Juan
 */
public class Util {
    
        public void ReadBooking(HashTable hashtable) {
            String str = "";
            try
            {
                FileInputStream f = new FileInputStream("Booking_hotel.xlsx");

                XSSFWorkbook libro = new XSSFWorkbook(f);

                //seleccionamos la primera hoja
                XSSFSheet hoja = libro.getSheetAt(0);

                //Cogemos todas las filas de esa hoja
                Iterator<Row> filas = hoja.iterator();
                Iterator<Cell> celdas;

                Row fila = filas.next();
                Cell celda;
                while(filas.hasNext())
                {
                    
                    //Agarramos la siguiente fila
                    fila = filas.next();

                    //Agarramos todas las celdas de esa fila
                    celdas = fila.cellIterator();

                    //Recorremos todas las celdas
                    boolean run = true;
                    DataFormatter dataFormatter = new DataFormatter();
                    String auxiliar = "";
                    while (run)
                    {
                         
                        //Cogemos la siguiente celda.
                        celda = celdas.next();
                        if(celda.getCellType() == 2){
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String s = sdf.format(celda.getDateCellValue());
                            auxiliar += s + "\n"; 
//                            System.out.println(s);
                        }
                        else{
                            auxiliar += dataFormatter.formatCellValue(celda) + "\n";
                        }
                                              
                        if(!celdas.hasNext()){
                            run = false;
                        }
                    }
                    String[] arreglo = auxiliar.split("\n");
                    Booking booking = new Booking(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4],arreglo[5],arreglo[6],arreglo[7],arreglo[8]);
                    hashtable.add(booking);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
        
    public void Readroom(HashTable hashtable){
        String str = "";
            try
            {
                FileInputStream f = new FileInputStream("Booking_hotel.xlsx");

                XSSFWorkbook libro = new XSSFWorkbook(f);

                 //seleccionamos la primera hoja
                XSSFSheet hoja = libro.getSheetAt(1);

                //Cogemos todas las filas de esa hoja
                Iterator<Row> filas = hoja.iterator();
                Iterator<Cell> celdas;

                Row fila = filas.next();
               Cell celda;
                while(filas.hasNext())
                {
                    
                    //Agarramos la siguiente fila
                    fila = filas.next();

                    //Agarramos todas las celdas de esa fila
                    celdas = fila.cellIterator();

                    //Recorremos todas las celdas
                    boolean run = true;
                    DataFormatter dataFormatter = new DataFormatter();
                    String auxiliar = "";
                    while (run)
                    {
                         
                        //Cogemos la siguiente celda.
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
                    String[] arreglo = auxiliar.split("\n");
                    Room room = new Room(arreglo[0],arreglo[1],arreglo[2]);
                    hashtable.addroom(room);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            
            
    }
    
    public void Readclient(HashTable hashtable){
        String str = "";
            try
            {
                FileInputStream f = new FileInputStream("Booking_hotel.xlsx");

                XSSFWorkbook libro = new XSSFWorkbook(f);

                 //seleccionamos la primera hoja
                XSSFSheet hoja = libro.getSheetAt(2);

                //Cogemos todas las filas de esa hoja
                Iterator<Row> filas = hoja.iterator();
                Iterator<Cell> celdas;

                Row fila = filas.next();
                Cell celda;
                while(filas.hasNext())
                {
                    
                    //Agarramos la siguiente fila
                    fila = filas.next();

                    //Agarramos todas las celdas de esa fila
                    celdas = fila.cellIterator();

                    //Recorremos todas las celdas
                    boolean run = true;
                    DataFormatter dataFormatter = new DataFormatter();
                    String auxiliar = "";
                    while (run)
                    {
                         
                        //Cogemos la siguiente celda.
                        celda = celdas.next();
                        
                        if(celda.getCellType() == 2){
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String s = sdf.format(celda.getDateCellValue());
                            auxiliar += s + "\n";                            
                        }
                        else{

                            if(!dataFormatter.formatCellValue(celda).isBlank()){
                                auxiliar += dataFormatter.formatCellValue(celda) + "\n";
                            }
                            
                        }                        
                        if(!celdas.hasNext()){
                            run = false;
                        }
                    }
                    String[] arreglo = auxiliar.split("\n");
                    Client client = new Client(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4],arreglo[5]);
                    hashtable.addClient(client);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
        
    
    
    
}

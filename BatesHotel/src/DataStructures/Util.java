/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructures;

import Classes.Client;
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
    
        public void ReadExcel(HashTable hashtable) {
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
//                            System.out.println(dataFormatter.formatCellValue(celda));
                        }
                        
//                        if(celda.getCellType() == 0 && DateUtil.isCellDateFormatted(celda)){
//                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                            String s = sdf.format(celda.getDateCellValue());
//                            System.out.println("fecha: " + s);
//                        }
//                        
//                        else if(celda.getCellType() == 1){
//                            System.out.println(celda.getStringCellValue());
//                        }
//                        
//                        else if(celda.getCellType() == 0 && !DateUtil.isCellDateFormatted(celda)){
//                            System.out.println(celda.getNumericCellValue());
//                        }
//                        
                        if(!celdas.hasNext()){
                            run = false;
                        }
                    }
                    String[] arreglo = auxiliar.split("\n");
                    Client cliente = new Client(arreglo[0],arreglo[1],arreglo[2],arreglo[3],arreglo[4],arreglo[5],arreglo[6],arreglo[7],arreglo[8]);
                    hashtable.add(cliente);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
        
    
    
    
}

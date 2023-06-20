/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructures;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        
/**
 *
 * @author Juan
 */
public class Util {
    
        public void readDates() {
        try
        {
            FileInputStream f = new FileInputStream("Booking_hotel.xlsx");
            
            XSSFWorkbook libro = new XSSFWorkbook(f);

            //seleccionamos la primera hoja
            XSSFSheet hoja = libro.getSheetAt(0);

            //Cogemos todas las filas de esa hoja
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;

            Row fila;
            Cell celda;
            while(filas.hasNext())
            {
                //Cogemos la siguiente fila
                fila = filas.next();

                //Cogemos todas las celdas de esa fila
                celdas = fila.cellIterator();

                //REcorremos todas las celdas
                while (celdas.hasNext())
                {

                    //Cogemos la siguiente celda.
                    celda = celdas.next();
                    if(celda.getCellType() == 0 && DateUtil.isCellDateFormatted(celda)){
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String s = sdf.format(celda.getDateCellValue());
                        System.out.println("fecha: " + s);
                    }
                    else if(celda.getCellType() == 0 && !DateUtil.isCellDateFormatted(celda)){
                        System.out.println(celda.getNumericCellValue());
                    }
                    else if(celda.getCellType() == 1){
                        System.out.println(celda.getStringCellValue());
                    }
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}

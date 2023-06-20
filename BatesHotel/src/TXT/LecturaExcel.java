/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TXT;

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

public class LecturaExcel {

    public void leer() {
        try
        {
            //abrimos el XSSFWorkbook
            FileInputStream f = new FileInputStream("datos.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(f);

            //seleccionamos la primera hoja
            XSSFSheet hoja = libro.getSheetAt(0);

            //Cogemos todas las filas de esa hoja
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;

            Row fila;
            Cell celda;
            //recorremos las filas
            while (filas.hasNext())
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

                    //Segun el tipo de celda, usaremos uno u otra funcion
                    if (celda.getCellType() == 0)
                    {
//                        System.out.println(DateUtil.isCellDateFormatted(celda));
                        if (celda.getCellType() == 0 && DateUtil.isCellDateFormatted(celda))
                        {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String s = sdf.format(celda.getDateCellValue());
                            System.out.println("fecha: " + s);
                        } else
                        {
                            System.out.println(celda.getNumericCellValue());
                        }
                    } else if (celda.getCellType() == 1)
                    {
                        System.out.println(celda.getStringCellValue());
                    }

//                    switch (celda.getCellType())
//                    {
//
//                        case Cell.CELL_TYPE_NUMERIC ->
//                        {
//                            if (DateUtil.isCellDateFormatted(celda))
//                            {
//                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                                String s = sdf.format(celda.getDateCellValue());
//                                System.out.println("fecha: " + s);
//                            }else{
//                                System.out.println(celda.getDateCellValue());
//                            }
//                        }
//                        case Cell.CELL_TYPE_STRING ->
//                            System.out.println(celda.getStringCellValue());
//
//                    }
//
//                }
                }
            }

            //cerramos el libro
            f.close();
            libro.close();

        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public void leerfechas() {
        try
        {
            FileInputStream f = new FileInputStream("datos.xlsx");
            
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

                    //Segun el tipo de celda, usaremos uno u otra funcion
//                    if (celda.getCellType() == 0)
//                    {
////                        System.out.println(DateUtil.isCellDateFormatted(celda));
//                        if (celda.getCellType() == 0 && DateUtil.isCellDateFormatted(celda))
//                        {
//                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                            String s = sdf.format(celda.getDateCellValue());
//                            System.out.println("fecha: " + s);
//                        } else
//                        {
//                            System.out.println(celda.getNumericCellValue());
//                        }
//                    } else if (celda.getCellType() == 1)
//                    {
//                        System.out.println(celda.getStringCellValue());
//                    }
//
////                    switch (celda.getCellType())
////                    {
////
////                        case Cell.CELL_TYPE_NUMERIC ->
////                        {
////                            if (DateUtil.isCellDateFormatted(celda))
////                            {
////                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////                                String s = sdf.format(celda.getDateCellValue());
////                                System.out.println("fecha: " + s);
////                            }else{
////                                System.out.println(celda.getDateCellValue());
////                            }
////                        }
////                        case Cell.CELL_TYPE_STRING ->
////                            System.out.println(celda.getStringCellValue());
////
////                    }
////
////                }
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

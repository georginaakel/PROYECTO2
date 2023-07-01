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
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Juan
 */
public class Util<T> {

    //Constantes
    public static final int BOOKING = 0;
    public static final int ROOM = 1;
    public static final int CLIENT = 2;
    public static final int HISTORIC = 3;

    //Prodecimiento que permite leer cualquier hoja del excel
    public static void readExcel(HashTable hashtable, int type) {
        try
        {
            FileInputStream f = new FileInputStream("Booking_hotel.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(f);
            XSSFSheet hoja = libro.getSheetAt(type);

            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;

            Row fila = filas.next();
            Cell celda;
            while (filas.hasNext())
            {
                String auxiliar = "";
                boolean run = true;

                fila = filas.next();
                celdas = fila.cellIterator();

                DataFormatter dataFormatter = new DataFormatter();
                while (run)
                {
                    celda = celdas.next();

                    if (celda.getCellType() == 2)
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String s = sdf.format(celda.getDateCellValue());
                        auxiliar += s + "\n";
                    } else
                    {
                        auxiliar += dataFormatter.formatCellValue(celda) + "\n";
                    }

                    if (!celdas.hasNext())
                    {
                        run = false;
                    }
                }

                if (type == BOOKING)
                {
                    String[] array = auxiliar.split("\n");
                    Booking booking = new Booking(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
                    hashtable.add(booking, 0);
                } else if (type == ROOM)
                {
                    String[] array = auxiliar.split("\n");
                    Room room = new Room(array[0], array[1], array[2]);
                    hashtable.add(room, 1);
                } else if (type == CLIENT)
                {
                    String[] array = auxiliar.split("\n");
                    if (array.length == 7)
                    {
                        Client client = new Client(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
                        hashtable.add(client, 2);
                    }
                } else if (type == HISTORIC)
                {
                    String[] array = auxiliar.split("\n");
                    Historic historic = new Historic(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
                    hashtable.add(historic, 3);
                }
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    //Agarra los elementos del hashtable y los coloca en el arbol binario de busqueda.
    public static void hashToTree(HashTable ht, BST bst) {
        for (int x = 0; x < ht.getSize(); x++)
        {
            if (ht.getindex(x) != null)
            {
                List aux = ht.getindex(x);
                if (aux.len() > 1)
                {
                    for (int j = 0; j < aux.len(); j++)
                    {
                        Booking data = (Booking) aux.get(j);
                        bst.insertBooking(bst.getRoot(), data);                      
                    }
                }
                else if(aux.len() == 1){
                    Booking data = (Booking) aux.get(0);
                    bst.insertBooking(bst.getRoot(), data);
                }
            }
           
        }
    }
    
    //Arbol para el historico
    public static void hashToTreeHistc(HashTable ht, BST bst){
        for (int x = 0; x < 10; x++){
            if(ht.getindex(x) != null){
                List aux = ht.getindex(x);
                Historic historic = (Historic) aux.get(0);
                bst.insert(bst.getRoot(), Integer.parseInt( historic.getNumRoom()));
            }
        }
    }
    
    public static void deleteRowExcel(int idx, int page){
        String filePath = "Booking_hotel.xlsx";

        try {
            // Abrir el archivo Excel
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);

            // Obtener la hoja de cálculo
            Sheet sheet = workbook.getSheetAt(page); // Índice de la hoja de cálculo (empezando desde 0)

            // Obtener la fila a eliminar
            Row row = sheet.getRow(idx);

            // Eliminar la fila de la hoja de cálculo
            sheet.removeRow(row);

            // Ajustar las referencias de las filas siguientes
            sheet.shiftRows(idx + 1, sheet.getLastRowNum(), -1);

            // Guardar los cambios en el archivo Excel
            FileOutputStream outFile = new FileOutputStream(filePath);
            workbook.write(outFile);
            outFile.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteByValue(int id){
        DecimalFormat format = new DecimalFormat("#,###");
        String num = format.format(id);
        String filePath = "Booking_hotel.xlsx";

        try {
            // Abrir el archivo Excel
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);

            // Obtener la hoja de cálculo
            Sheet sheet = workbook.getSheetAt(0); // Índice de la hoja de cálculo (empezando desde 0)

            // Iterar sobre todas las filas en reversa para evitar problemas de índices cambiantes
            int start = -1;
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    Cell cell = row.getCell(0);
                    if(cell.getCellType() == 0){
                        int cellNum = (int) cell.getNumericCellValue();

                        if (cellNum == id) {
                            start = rowIndex;
                            sheet.removeRow(row);
                            break;

                        }                       
                    }
                }
            }
            
            if(start != -1){
                // Ajustar las referencias de las filas siguientes
                sheet.shiftRows(start + 1, sheet.getLastRowNum(), -1);

                // Guardar los cambios en el archivo Excel
                FileOutputStream outFile = new FileOutputStream(filePath);
                workbook.write(outFile);
                outFile.close();

                // Cerrar el archivo Excel
                workbook.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertExcelClient(int idx, int page, Client client){
        String filePath = "Booking_hotel.xlsx";

        try {
            // Abrir el archivo Excel
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);

            // Obtener la hoja de cálculo
            Sheet sheet = workbook.getSheetAt(page); // Índice de la hoja de cálculo (empezando desde 0)

            // Crear una nueva fila
            Row row = sheet.createRow(idx);

            // Crear celdas y establecer los valores de los datos
            Cell cell1 = row.createCell(idx); // Índice de la celda (empezando desde 0)
            cell1.setCellValue("Dato 1");

            Cell cell2 = row.createCell(1);
            cell2.setCellValue("Dato 2");

            // Guardar los cambios en el archivo Excel
            FileOutputStream outFile = new FileOutputStream(filePath);
            workbook.write(outFile);
            outFile.close();

            System.out.println("Datos insertados correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Client toClient(Booking booking, HashTable clients){
        String numHab = "";
        
        for (int x = 0; x < 10; x++) {
            if(clients.getindex(x) == null){
                numHab = Integer.toString(x);
            }          
        }       
        
        String name = booking.getName();
        String lastName = booking.getLastName();
        String email = booking.getEmail();
        String gender = booking.getGender();
        String phone = booking.getPhoneNumber();
        String dateIn = booking.getDateIn();
        String id = booking.getId();
        
        Client client = new Client(numHab, name, lastName, email, gender, phone, dateIn, id);
        return client;
    }
    
    public static Historic toHistoric(Client client, HashTable historic){
        String numRoom = client.getNumRoom();
        String name = client.getName();
        String lastName = client.getLastName();
        String email = client.getEmail();
        String gender = client.getGender();
        String dateIn = client.getDateIn();
        String id = client.getId();
        
        Historic h = new Historic(id, name, lastName, email, gender, dateIn, numRoom);
        return h;
               
    }
    
    public static void checkIn(int id, HashTable bookings){
        int idx = bookings.hash(id);
        Booking b = bookings.get1(id);
        
        bookings.delete(idx);
        
    }
    
    
    
    

}

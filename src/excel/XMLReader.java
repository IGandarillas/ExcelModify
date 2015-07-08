package excel;
import java.io.File;
import java.io.FileInputStream;



import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XMLReader {


	private FileInputStream file;
	private XSSFRow row; 
	private Iterator<Row> rowIterator;
	private int rowCount=0;
	private int count=0;
	private Persona persona;
	private ArrayList<Persona> personas;
	

	
	public XMLReader(String path, String name) throws IOException{
		System.out.println("Leyendo datos");
		System.out.println();
		personas=new ArrayList<Persona>();
		file = new FileInputStream(new File(path+"\\"+name));
		//Get the workbook instance for XLS file 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		 
		//Get iterator to all the rows in current sheet
		rowIterator = sheet.rowIterator();		
		iterar();		
		workbook.close();		
	}
	public int[] getModCount(){
		int i[]= new int[2];
		i[0]=rowCount;
		i[1]=count;
		return i;
	}
	public void iterar(){
		while(rowIterator.hasNext()){
		
				row=(XSSFRow) rowIterator.next();

				try{
					persona = new Persona();
					persona.setNombre(row.getCell(0).getStringCellValue());	
					System.out.println(persona.getNombre());
					
					row=(XSSFRow) rowIterator.next();
					persona.setActividad(row.getCell(1).getStringCellValue());
					System.out.println(persona.getActividad());
					
					row=(XSSFRow) rowIterator.next();
					persona.setContacto(row.getCell(1).getStringCellValue());
					System.out.println(persona.getContacto());
					
					row=(XSSFRow) rowIterator.next();
					persona.setDireccion(row.getCell(1).getStringCellValue());
					System.out.println(persona.getDireccion());
					
					row=(XSSFRow) rowIterator.next();
					persona.setZona(row.getCell(1).getStringCellValue());
					System.out.println(persona.getZona());
					
					row=(XSSFRow) rowIterator.next();					
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					persona.setTelefono(row.getCell(1).getStringCellValue());
					System.out.println(persona.getTelefono());
					
					row=(XSSFRow) rowIterator.next();
					persona.setFax(row.getCell(1).getStringCellValue());
					System.out.println(persona.getFax());
					
					row=(XSSFRow) rowIterator.next();
					persona.setEmail(row.getCell(1).getStringCellValue());
					System.out.println(persona.getEmail());
					
					row=(XSSFRow) rowIterator.next();
					persona.setWeb(row.getCell(1).getStringCellValue());
					personas.add(persona);
					System.out.println(count++);
				}catch(NoSuchElementException | NullPointerException | java.lang.IllegalStateException a){
					System.out.println("Ultima fila");
				}
						
		}
		Iterator<Persona> itPersonas = personas.iterator();
		while(itPersonas.hasNext()){
			Persona p = itPersonas.next();
			System.out.println(p.getNombre());
		}

	}
	
	public String parseTelefono(double telefono){
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);
        return df.format(telefono);
        
	}
	public ArrayList<Persona> getPersonas(){
		return personas;
	}

}

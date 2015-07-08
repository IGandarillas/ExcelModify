package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XMLWriter {
	private Persona p ;
	private int rowCount;
	private FileOutputStream fileOut;
	private XSSFWorkbook workbook;
	
	public  XMLWriter(String path, String name) throws FileNotFoundException{
		fileOut = new FileOutputStream(new File(path+"\\"+name));
		workbook = new XSSFWorkbook();
		rowCount=1;//La primera fila define que es el resto. Se empieza en 1.

	}
	public void fill(Iterator<Persona> iterator) throws IOException{
		
		
		XSSFSheet worksheet = workbook.createSheet("Hoja");
		XSSFRow row = worksheet.createRow((short) 0);
		
		XSSFCell 
		cell = row.createCell((short) 0);
		cell.setCellValue("Nombre");
		cell = row.createCell((short) 1);
		cell.setCellValue("Actividad");
		cell = row.createCell((short) 2);
		cell.setCellValue("Contacto");
		cell = row.createCell((short) 3);
		cell.setCellValue("Dirección");
		cell = row.createCell((short) 4);
		cell.setCellValue("Zona");
		cell = row.createCell((short) 5);
		cell.setCellValue("Teléfono");
		cell = row.createCell((short) 6);
		cell.setCellValue("Fax");
		cell = row.createCell((short) 7);
		cell.setCellValue("E-mail");
		cell = row.createCell((short) 8);
		cell.setCellValue("Web");
		
		
		while(iterator.hasNext()){
			p = iterator.next();
			
			row = worksheet.createRow((short) rowCount);
			
			//Columnas
			 cell = row.createCell((short) 0);
			 cell.setCellValue(p.getNombre());
			 cell = row.createCell((short) 1);
			 cell.setCellValue(p.getActividad());
			 cell = row.createCell((short) 2);
			 cell.setCellValue(p.getContacto());
			 cell = row.createCell((short) 3);
			 cell.setCellValue(p.getDireccion());
			 cell = row.createCell((short) 4);
			 cell.setCellValue(p.getZona());
			 cell = row.createCell((short) 5);
			 cell.setCellValue(p.getTelefono());
			 cell = row.createCell((short) 6);
			 cell.setCellValue(p.getFax());
			 cell = row.createCell((short) 7);
			 cell.setCellValue(p.getEmail());
			 cell = row.createCell((short) 8);
			 cell.setCellValue(p.getWeb());
			 System.out.println(p.getNombre()+" "+p.getActividad()+" "+p.getContacto()+" "+p.getDireccion()+" "+ p.getZona()+" "+ p.getTelefono()+" "+p.getFax()+" "+p.getEmail()+" "+p.getWeb());		
			rowCount++;
		}
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
}

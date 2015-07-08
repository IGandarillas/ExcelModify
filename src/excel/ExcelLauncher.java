package excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class ExcelLauncher {
	
	public static String EXCEL_NAME = "Alcobendas.xlsx";
	
	public static void main(String[] args) throws IOException {
		String path = new File (".").getCanonicalPath(); //Path current folder
		
		XMLReader reader = new XMLReader(path, EXCEL_NAME);
		ArrayList<Persona> personas = reader.getPersonas();
		XMLWriter writer = new XMLWriter(path,"HPrueba.xlsx");
		writer.fill(personas.iterator());

		
	}

}

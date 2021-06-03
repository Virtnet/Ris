import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFile {
	private static int lineNumber = 1;
	private String fileName = "menu.txt";
	Menu menu;
	
	InputFile(){
		menu = new Menu();
	}
	
	public Menu readFile(){
		Scanner in;
		try {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			throw new BadDataException("Il programma non ha trovato il file menu.txt");
		}
		if(!in.hasNext()) {
			throw new BadDataException("Il menu non inizia col stringa");
		}
		while (in.hasNextLine()) {
			
			String[] results = in.nextLine().split(";");
			
			// if extends the size of the line should be string and double in 0,1 places
			if(results.length <= 1 || results.length > 2) { 
				throw new BadDataException("La riga " + lineNumber + " non è correttamente formata");
			}
			
			// check if does exists a price for a plate
			try {
			  Double.parseDouble(results[1]);
			}
			catch(NumberFormatException e) {
				throw new BadDataException("Il formato di prezzo non è correttamente formato in linea " + lineNumber);
			}
			lineNumber ++;
			String nomePiatto = results[0];
			double number = Double.parseDouble(results[1]);
			
			Menu.Piatto piatto = new Menu.Piatto(nomePiatto,number);
			menu.addPiatto(piatto);
			
		}
		return menu;
	}
}

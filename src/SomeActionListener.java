import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class SomeActionListener extends TableActions implements ActionListener {

	private JTextField fieldText;
	private JTextField fieldText2;
	private List<JTextField> listOfFields;
	private int operationNumber;
	private int rowNumber;
	GUI gui;
	Menu menu;

	
	public SomeActionListener(JTextField fieldText, JTextField fieldText2,int operationNumber,GUI gui,Menu menu){
	  
	  this.fieldText = fieldText; 
	  this.fieldText2 = fieldText2; 
	  this.operationNumber = operationNumber;
	  this.gui = gui;
	  this.menu = menu;
	  listOfFields = new ArrayList<JTextField>();
	  
	  collectAllFields();
	  }
	
	public void collectAllFields() {
		listOfFields.add(fieldText);
		listOfFields.add(fieldText2);
	}
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object row[];
		String name = fieldText.getText(); 
		double prezzo = Double.parseDouble(fieldText2.getText());
		//double vecchioPrezzo = Double.parseDouble(tempPrezzoField);
		
		switch (operationNumber) {
		case 1:
			
			if(!(menu.doesExist(new Menu.Piatto(name,prezzo)))) {
				row = new Object[] {name,prezzo};
				gui.model.addRow(row);
				menu.addPiatto(new Menu.Piatto(name,prezzo));
			}
			System.out.println(menu.numeroDiPiatti);
			reset(listOfFields);
			break;
		case 2:
			//System.out.println("Modifica");
			rowNumber = gui.table.getSelectedRow();
			String tempNome = gui.model.getValueAt(rowNumber, 0).toString();
			double tempPrezzo = Double.parseDouble(gui.model.getValueAt(rowNumber, 1).toString());
			if(menu.modificaPiatto(tempNome,name,tempPrezzo, prezzo)) {
				gui.model.setValueAt(name, rowNumber, 0);
				gui.model.setValueAt(prezzo, rowNumber, 1);
				System.out.println("Il piatto é stato aggiornato"); 
				} else { 
					throw new BadDataException("Non é stato possibile aggiornare il piatto"); 
			}
			break;
		case 3:
			//System.out.println("Rimuove");
			rowNumber = gui.table.getSelectedRow();
			System.out.println(rowNumber);
			gui.model.removeRow(rowNumber);
			menu.removePiatto(name);
			
			reset(listOfFields);
			break;
		}

	}

}

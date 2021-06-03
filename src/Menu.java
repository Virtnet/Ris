import java.util.ArrayList;

/*
 * Classe Menu - una classe che crea una arraylist di oggeto di tipo Piatto 
 * abbia la variabile che conta il numero di piatto che è stato aggiunto.
*/

public class Menu {
	
	private ArrayList<Piatto> menu;
	public int numeroDiPiatti = 0;

	Menu() {
		menu = new ArrayList<Piatto>();
	}
	
	/*
	 * Aggiunge un piatto all'arraylist
	 * @param piatto - un piatto di classe Piatto (composto da nome e prezzo)
	*/
	public void addPiatto(Piatto piatto) {
		if (!(doesExist(piatto))){
			menu.add(piatto);
			numeroDiPiatti++;
		} else {System.out.println("Gia esiste");}
		
	}
	
	/*
	 * Controlla se il piatto relativo già esiste nell'arraylist
	 * @param piatto - un piatto di classe Piatto (composto da nome e prezzo)
	*/
	public boolean doesExist(Piatto piatto) {
		for(Piatto piattoElement : menu) {
	        if(piattoElement.getPiattoNome().equals(piatto.getPiattoNome())) {
	           return true;
	        }
	    }
	    return false;
	}
	
	public Piatto getPiatto(int piattoIndex) {
		return menu.get(piattoIndex);
	}
	
	/*
	 * Rimuove un piatto dall'arraylist
	 * @param piattoNome - nome di piatto da rimuovere
	*/
	
	public void removePiatto(String piattoNome) {
		for(Piatto piattoElement : menu) {
			if(piattoNome.equals(piattoElement.getPiattoNome())) {
				menu.remove(piattoElement);
				System.out.println("Il piatto " + piattoElement.getPiattoNome() + " è stato rimosso");
				numeroDiPiatti--;
				break;
			}
		}
	}
	
	/*
	 * Modifica un piatto che già esiste nell'arraylist
	 * @param piattoNome - nome di piatto da modificare
	 * @param nuovoPiattoNome - il nuovo nome del piatto da inserire al posto del piattoNome
	 * @param vecchioPrezzo - il corrente del piatto
	 * @param nuovoPrezzo - il nuovo prezzo del piatto
	 * 
	*/
	
	public boolean modificaPiatto(String piattoNome,String nuovoPiattoNome,double vecchioPrezzo,double nuovoPrezzo) {
		for(Piatto piattoElement : menu) {
			if(piattoNome.equals(piattoElement.getPiattoNome()) && !(nuovoPiattoNome.isEmpty())) { //Nomi dei piatti ugali ma il prezzo è diverso
				piattoElement.setPrezzo(nuovoPrezzo);
				piattoElement.setPiattoNome(nuovoPiattoNome);
				//System.out.println("Il piatto " + piattoNome + " è stato modificato in " + "col prezzo " + nuovoPrezzo);
				return true;
				}
			}
		return false;
		}
	
	public void showMenu() {
		//JButton btns[] = new JButton[Piatto.numeroDiPiatti];
		for(Piatto piattoElement: menu) {
			System.out.println("Nome: " + piattoElement.getPiattoNome() + " Prezzo: " + piattoElement.getPrezzo());
		}
	}
	
	public ArrayList<Piatto> getArray(){
		return menu;
	}
	
	/*
	 * Classe Piatto - usato come un oggeto nell'arraylist in menu
	 * ogni piatto viene composto da nome di piatto e prezzo
	*/
	
	public static class Piatto {
		private String piattoNome;
		private double prezzo;
		
	
		/*
		 * Costrutore che inizializza le variabili del piatto e il suo prezzo
		 * @piattoNome - iniziliza il nome di piatto
		 * @prezzo  - iniziliza il prezzo di piatto
		*/
		
		Piatto(String piattoNome,double prezzo){
			this.setPiattoNome(piattoNome);
			this.setPrezzo(prezzo);
		}
		
		/*
		 * Restituisce il nome del piatto relativo
		*/
		
		public String getPiattoNome() {
			return piattoNome;
		}
		
		/*
		 * Setta il nome del piatto 
		 * @piattoNome - sett la variabile locale del piatto al quello inserito come argumento
		*/
		
		public void setPiattoNome(String piattoNome) {
			this.piattoNome = piattoNome;
		}
		
		/*
		 * Restituisce il prezzo del piatto relativo
		*/
		
		public double getPrezzo() {
			return prezzo;
		}
		
		/*
		 * Setta il prezzo del piatto relativo
		 * @prezzo - sett la variabile locale del prezzo al quello inserito come argumento
		*/
		
		public void setPrezzo(double prezzo) {
			this.prezzo = prezzo;
		}
		
	}



}

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BadDataException extends RuntimeException {
	String title = "Attenzione";
	BadDataException(){}
	BadDataException(String messaggio){
		super(messaggio);
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, messaggio,title,JOptionPane.ERROR_MESSAGE);
	}
}

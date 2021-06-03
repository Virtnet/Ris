import java.util.List;
import javax.swing.JTextField;

public class TableActions {
	
	public static void reset(List<JTextField> fieldList) {
		for(JTextField field: fieldList) {
			field.setText("");
		}
	}
}

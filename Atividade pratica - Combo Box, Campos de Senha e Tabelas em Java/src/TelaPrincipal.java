import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPrincipal extends JFrame{
	private JComboBox periodos;
	private JTable jtable;
	private JScrollPane jScrollPane;
	
	Object[][] data = { { "20080001", "Antonio", "11 98888-0001", "antonio@gmail.com" },
			{ "20080002", "José", "11 98111-3333", "jose@hotmail.com" },
			{ "20080003", "Ricardo", "13 9876-5432", "ricardo@bol.com.br" },
			{ "20080004", "Roberto", "11 98765-4321", "roberto@gmail.com" },
			{ "20080005", "Valter", "11 2666-6666", "valter@yahoo.com.br" } };
	
	public TelaPrincipal(){
		super("Escola São Judas");
		setLayout(new FlowLayout());
		
	}
}

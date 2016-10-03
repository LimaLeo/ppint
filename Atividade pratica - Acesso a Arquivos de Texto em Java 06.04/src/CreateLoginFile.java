import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;
//import java.util.Scanner;

public class CreateLoginFile {
	private Formatter output;

	public void openFile() {
		try {
			output = new Formatter("login.txt");
		} // end try
		catch (SecurityException securityException) {
			System.err.println("Você não tem acesso para criar esse arquivo.");
			System.exit(1);
		} // end catch
		catch (FileNotFoundException filesNotFoundException) {
			System.err.println("Erro ao criar arquivo.");
			System.exit(1);
		} // end catch
	}

	public void addRecords() { // object to be written to file
		AccontLogin record = new AccontLogin();
		String usuario = JOptionPane.showInputDialog("Infome o nome de usuário: ");
		String senha = JOptionPane.showInputDialog("Infome uma senha: ");
		try // output values to file
		{
			// retrieve data to be output
			record.setLogin(usuario);
			record.setSenha(senha);
			output.format("%s %s\n", record.getLogin(), record.getSenha());
		} // end try
		catch (FormatterClosedException formatterClosedException) {
			System.err.println("Erro ao escrever para o arquivo.");
			return;
		} // end catch
		catch (NoSuchElementException elementException) {
			System.err.println("Entrada inválida. Por favor tente novamente.");
		} // end catch
		JOptionPane.showMessageDialog(null, "Incluído com sucesso!!");
	} // end method addRecords
		// close file

	public void closeFile() {
		if (output != null)
			output.close();
	} // end method closeFile
} // end class CreateTextFile

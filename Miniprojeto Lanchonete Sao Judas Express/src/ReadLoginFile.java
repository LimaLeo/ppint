
// Fig. 14.11: ReadTextFile.java
// This program reads a text file and displays each record.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReadLoginFile
{
	private Scanner input;
	private static boolean gerente;

	// enable user to open file
	public void openFile()
	{
		try
		{
			input = new Scanner(new File("login.txt"));
		} // end try
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		} // end catch
	} // end method openFile
		// read record from file

	public void readRecords()
	{ // object to be written to screen
		AccontLogin record = new AccontLogin();
		System.out.printf("%-12s%-12s\n", "Usuário", "Senha");
		try // read records from file using Scanner object
		{
			while (input.hasNext())
			{
				;
				record.setLogin(input.next());
				record.setSenha(input.next());
				// display record contents
				System.out.printf("%-12s%-10s\n", record.getLogin(), record.getSenha());
			} // end while
		} // end try
		catch (NoSuchElementException elementException)
		{
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		} // end catch
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		} // end catch
	} // end method readRecords
		// close file and terminate application

	public boolean validaDadosLogin(String login, String senha)
	{
		AccontLogin record = new AccontLogin();
		try // read records from file using Scanner object
		{
			while (input.hasNext())
			{
				record.setLogin(input.next());
				record.setSenha(input.next());
				record.setPermissao(input.next());
				// display record contents
				if (login.equals(record.getLogin()) && senha.equals(record.getSenha()))
				{
					JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
					setGerente(record.getPermissao().equals("gerente"));
					return true;
				}
			} // end while
			JOptionPane.showMessageDialog(null, "LOGIN E/OU SENHA ERRADO(S)");
			return false;
		} // end try
		catch (NoSuchElementException elementException)
		{
			JOptionPane.showMessageDialog(null, "File improperly formed.");
			input.close();
			System.exit(1);
			return false;
		} // end catch
		catch (IllegalStateException stateException)
		{
			JOptionPane.showMessageDialog(null, "Error reading from file.");
			System.exit(1);
			return false;
		} // end catch
	}

	public void closeFile()
	{
		if (input != null)
			input.close(); // close file
	} // end method closeFile

	public static boolean isGerente()
	{
		return gerente;
	}

	public void setGerente(boolean gerente)
	{
		this.gerente = gerente;
	}
} // end class ReadTextFile
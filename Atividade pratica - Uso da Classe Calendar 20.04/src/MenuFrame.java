import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFrame extends JFrame
{
	// array listando tipos de formatação
	private JLabel saidaJLabel;
	private String tipoString;

	public MenuFrame()
	{
		super("JCalendar - Formatação");
		JMenuBar bar = new JMenuBar(); // cria a barra de menus
		setJMenuBar(bar); // adiciona uma barra de menus ao aplicativo

		JMenu fileMenu = new JMenu("Arquivo");

		JMenuItem exitItem = new JMenuItem("Sair"); // cria o item exit
		exitItem.setMnemonic('x'); // configura o mnemônico como x
		fileMenu.add(exitItem); // adiciona o item exit ao menu File
		exitItem.addActionListener(new ActionListener() // classe interna
														// anônima
		{
			// termina o aplicativo quando o usuário clica exitItem
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0); // encerra o aplicativo
			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener
		bar.add(fileMenu);

		JMenu formatMenu = new JMenu("Tipo"); // cria o menu Format
		; // adiciona o menu File à barra de menus
		formatMenu.setMnemonic('r'); // configura o mnemônico como r

		JMenuItem dateTime1 = new JMenuItem("dateTime1");
		formatMenu.add(dateTime1);
		dateTime1.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%tc\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime2 = new JMenuItem("dateTime2");
		formatMenu.add(dateTime2);
		dateTime2.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%tF\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime3 = new JMenuItem("dateTime3");
		formatMenu.add(dateTime3);
		dateTime3.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%tD\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime4 = new JMenuItem("dateTime4");
		formatMenu.add(dateTime4);
		dateTime4.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%tr\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime5 = new JMenuItem("dateTime5");
		formatMenu.add(dateTime5);
		dateTime5.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%tT\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime6 = new JMenuItem("dateTime6");
		formatMenu.add(dateTime6);
		dateTime6.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%1$tA, %1$tB %1$td, %1$tY\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime7 = new JMenuItem("dateTime7");
		formatMenu.add(dateTime7);
		dateTime7.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%1$TA, %1$TB %1$Td, %1$TY\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime8 = new JMenuItem("dateTime8");
		formatMenu.add(dateTime8);
		dateTime8.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%1$ta, %1$tb %1$te, %1$ty\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime9 = new JMenuItem("dateTime9");
		formatMenu.add(dateTime9);
		dateTime9.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%1$tH:%1$tM:%1$tS\n", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem dateTime10 = new JMenuItem("dateTime10");
		formatMenu.add(dateTime10);
		dateTime10.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event)
			{
				Calendar dateTime = Calendar.getInstance();
				tipoString = String.format("%1$tZ %1$tI:%1$tM:%1$tS %tp", dateTime);
				saidaJLabel.setText(tipoString);

			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener
		bar.add(formatMenu);

		Calendar dateTime = Calendar.getInstance();
		tipoString = String.format("%1$tA, %1$tB %1$td, %1$tY\n", dateTime);

		saidaJLabel = new JLabel();
		saidaJLabel.setText(tipoString);

		add(saidaJLabel, BorderLayout.CENTER); // adiciona displayJLabel
		bar.add(formatMenu);
	}
}

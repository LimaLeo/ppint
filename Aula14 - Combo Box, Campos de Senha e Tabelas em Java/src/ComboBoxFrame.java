
// Fig. 11.21: ComboBoxFrame.java
// Using a JComboBox to select an image to display.
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame {
	private JComboBox imagesJComboBox; // combobox to hold names of icons
	private JLabel label; // label to display selected icon
	private String names[] = { "android1.gif", "android2.gif", "android3.gif", "android4.gif" };
	private Icon icons[] = { new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])), new ImageIcon(getClass().getResource(names[2])),
			new ImageIcon(getClass().getResource(names[3])) };

	// ComboBoxFrame constructor adds JComboBox to JFrame
	public ComboBoxFrame() {
		super("Testing JComboBox");
		setLayout(new FlowLayout()); // set frame layout
		imagesJComboBox = new JComboBox(names); // set up JComboBox
		imagesJComboBox.setMaximumRowCount(3); // display three rows
		imagesJComboBox.addItemListener(new ItemListener() // anonymous inner
															// class
		{
			// handle JComboBox event
			public void itemStateChanged(ItemEvent event) {
				// determine whether check box selected
				if (event.getStateChange() == ItemEvent.SELECTED)
					label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
			} // end method itemStateChanged
		} // end anonymous inner class
		); // end call to addItemListener
		add(imagesJComboBox); // add combobox to JFrame
		label = new JLabel(icons[0]); // display first icon
		add(label); // add label to JFrame
	} // end ComboBoxFrame constructor
} // end class ComboBoxFrame
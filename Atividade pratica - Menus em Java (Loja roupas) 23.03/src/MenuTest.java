
// Fig. 22.6: MenuTest.java
// Testando MenuFrame.
import javax.swing.JFrame;

public class MenuTest {
	public static void main(String args[]) {
		MenuFrame menuFrame = new MenuFrame(); // criar MenuFrame
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(600, 100); // configura o tamanho do frame
		menuFrame.setLocation( 350, 200 ); //configura a localização do frame
		menuFrame.setVisible(true); // exibe o frame
	} // fim de main
} // fim da classe MenuTest

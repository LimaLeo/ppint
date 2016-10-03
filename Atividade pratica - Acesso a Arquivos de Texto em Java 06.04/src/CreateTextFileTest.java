// Fig. 14.9: CreateTextFileTest.java
// Testing the CreateTextFile class.
public class CreateTextFileTest {
	public static void main(String args[]) {
		CreateLoginFile application = new CreateLoginFile();
		application.openFile();
		application.addRecords();
		application.closeFile();
	} // end main
} // end class CreateTextFileTest
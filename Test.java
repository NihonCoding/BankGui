import javax.swing.JFrame;

public class Test {

	/* Creates a BankGUIFrame and makes it visible */
	public static void main(String[] args) {
		// Creates BankGUIFrame and its components
		BankGUIFrame myFrame = new BankGUIFrame();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);

	}

}

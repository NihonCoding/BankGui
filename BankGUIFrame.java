import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BankGUIFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4709661162977627541L;
	private JTextField firstNameField;             		// Holds first name
	private JTextField lastNameField;              		// Holds last name
	private JFormattedTextField accountIDField;      	// Holds accountID number
  	private JFormattedTextField balanceField;   		// Holds account balance
  	private JFormattedTextField depositField;   		// Holds account deposit amount
  	private JFormattedTextField withdrawalField;   		// Holds account withdrawal amount
	private JLabel tableLabel;                     		// Label for table display
	private JLabel accountIDLabel;                   	// Label for accountID number
	private JLabel firstNameLabel;                 		// Label for first name
	private JLabel lastNameLabel;                  		// Label for last name
	private JLabel balanceLabel;                		// Label for account balance
	private JLabel depositLabel;                		// Label for account deposit
	private JLabel withdrawalLabel;                		// Label for account withdrawal
	private JButton applyButton;						// Triggers application
	private JButton depositButton;                 		// Triggers deposit
	private JButton withdrawalButton;                 	// Triggers withdrawal
	private JButton quitButton;                    		// Triggers termination of GUI   
	private JTable accountStatusTable;                	// Table tracks account status
	private static ArrayList<BankAccount> accountAppArr;// ArrayList of Account objects
	
   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   BankGUIFrame() {
      Object[][] tableVals = new Object[6][6];                	// Bank account table
      String[] columnHeadings = {"AccountID", "First Name", 	// Column headings for reservation table
                                 "Last Name", "Balance"};
      GridBagConstraints layoutConst = null;                  	// GUI component layout
      NumberFormat currencyFormat = null;                     	// Format for amount paid

      // Set frame's title
      setTitle("Bank Account Application");
      
      // Add 1 account object to ArrayList
      accountAppArr = new ArrayList<BankAccount>();
      
//      // Make account empty
//      accountMakeEmpty(accountAppArr);
      
      // Create account table
      tableLabel = new JLabel("Account Information: ");
      accountIDLabel = new JLabel("AccountID Number:");
      firstNameLabel = new JLabel("First Name:");
      lastNameLabel = new JLabel("Last Name:");
      balanceLabel = new JLabel("Balance:");
      depositLabel = new JLabel("Deposit:");
      withdrawalLabel = new JLabel("Withdrawal:");
      
      accountIDField = new JFormattedTextField(NumberFormat.getIntegerInstance());
      accountIDField.setEditable(true);
      accountIDField.setValue(0);      
      
      firstNameField = new JTextField(20);
      firstNameField.setEditable(true);
      firstNameField.setText("John");

      lastNameField = new JTextField(20);
      lastNameField.setEditable(true);
      lastNameField.setText("Doe");

      currencyFormat = NumberFormat.getCurrencyInstance();
      currencyFormat.setMaximumFractionDigits(0);
      balanceField = new JFormattedTextField(currencyFormat);
      balanceField.setEditable(true);
      balanceField.setValue(0.0);
      
      currencyFormat = NumberFormat.getCurrencyInstance();
      currencyFormat.setMaximumFractionDigits(0);
      depositField = new JFormattedTextField(currencyFormat);
      depositField.setEditable(true);
      depositField.setValue(0.0);    
      
      currencyFormat = NumberFormat.getCurrencyInstance();
      currencyFormat.setMaximumFractionDigits(0);
      withdrawalField = new JFormattedTextField(currencyFormat);
      withdrawalField.setEditable(true);
      withdrawalField.setValue(0.0);   
      
      applyButton = new JButton("Apply");
      applyButton.addActionListener(this);
      
      depositButton = new JButton("Deposit");
      depositButton.addActionListener(this);

      withdrawalButton = new JButton("Withdraw");
      withdrawalButton.addActionListener(this);
      
      quitButton = new JButton("Quit");
      quitButton.addActionListener(this);
      
      // Initialize table
      accountStatusTable = new JTable(tableVals, columnHeadings);
      accountStatusTable.setEnabled(false); // Prevent user input via table   
      
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(tableLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 0, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      layoutConst.gridwidth = 4;
      add(accountStatusTable.getTableHeader(), layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.gridwidth = 4;
      add(accountStatusTable, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(accountIDLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      add(accountIDField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      add(firstNameLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 4;
      add(firstNameField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 3;
      add(lastNameLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 2;
      layoutConst.gridy = 4;
      add(lastNameField, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 3;
      add(balanceLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 3;
      layoutConst.gridy = 4;
      add(balanceField, layoutConst);
        
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 3;
      add(depositLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 4;
      layoutConst.gridy = 4;
      add(depositField, layoutConst);     
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 10, 1, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 3;
      add(withdrawalLabel, layoutConst);

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 0);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 5;
      layoutConst.gridy = 4;
      add(withdrawalField, layoutConst);
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 6;
      layoutConst.gridy = 1;
      add(applyButton, layoutConst);   

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 6;
      layoutConst.gridy = 2;
      add(depositButton, layoutConst);   
      
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 5, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 6;
      layoutConst.gridy = 3;
      add(withdrawalButton, layoutConst);
     
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(0, 5, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 6;
      layoutConst.gridy = 4;
      add(quitButton, layoutConst);
   }  
	      
   /* Called when either button is pressed. */
   @Override
   public void actionPerformed(ActionEvent event) {
	  BankAccount accountElement; 	// Account information
      String firstName;     		// First name
      String lastName;      		// Last name
      int accountID;        		// AccountID
      double balance;       		// Balance
      double deposit;       		// Deposit
      double withdrawal;       		// Withdrawal

      // Get source of event (3 buttons in GUI)
      JButton sourceEvent = (JButton) event.getSource();  
	   
      // User pressed the reserve button
      if (sourceEvent == applyButton) {
    	  accountID = ((Number) accountIDField.getValue()).intValue();
    	  firstName = firstNameField.getText();
          lastName = lastNameField.getText();
          balance = ((Number) balanceField.getValue()).doubleValue();
          accountElement = new BankAccount();			// Create new account object
          accountElement.accessAccount(firstName, lastName, accountID, balance);
          accountAppArr.add(accountElement);// Add account to ArrayList   	  
          
          updateTable();                        		// Synchronize table with sts ArrayList
   	   
          // Show successful dialog
          JOptionPane.showMessageDialog(this, "Application complete.");    	  
    	  
      } else if(sourceEvent == depositButton) {
          deposit = ((Number) depositField.getValue()).doubleValue();
          
          accountAppArr.get(0).deposit(deposit);
          
          updateTable();                        		// Synchronize table with sts ArrayList
	   
          // Show successful dialog
          JOptionPane.showMessageDialog(this, "Deposit complete.");
      } else if (sourceEvent == withdrawalButton) {
          withdrawal = ((Number) withdrawalField.getValue()).doubleValue();

          accountAppArr.get(0).withdrawal(withdrawal);
          
          updateTable();                        		// Synchronize table with sts ArrayList
	   
          // Show successful dialog
          JOptionPane.showMessageDialog(this, "Withdrawal complete.");
   	} else if (sourceEvent == quitButton) {
  		dispose();                               		// Terminate program
   	}
   	}  
	   
	/* Updates the account information displayed by the table */
	public void updateTable () {
		final int accountIDCol = 0;		// Col num for accountID
		final int firstNameCol = 1;		// Col num for first name
		final int lastNameCol = 2;		// Col num for last name
		final int balanceCol = 3;		// Col num for balance
	
		accountStatusTable.setValueAt(accountAppArr.get(0).getAccountID(), 0, accountIDCol);
		accountStatusTable.setValueAt(accountAppArr.get(0).getFirstName(), 0, firstNameCol);
		accountStatusTable.setValueAt(accountAppArr.get(0).getLastName(), 0, lastNameCol);
		accountStatusTable.setValueAt(accountAppArr.get(0).getBalance(), 0, balanceCol);

	}
	
	/*Makes account empty */
//	public static void accountMakeEmpty (ArrayList<BankAccount> accountApp) {
//		int i = 0;
//		
//		accountApp.get(i).makeEmpty();
//	}
	
}   
	   

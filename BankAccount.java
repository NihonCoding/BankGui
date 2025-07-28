
public class BankAccount {
	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;
	
	public void accessAccount(String firstName, String lastName, int accountID, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = balance;
	}
	
	public void deposit(double depositAmount) {
		double deposit = depositAmount;
		balance = balance + deposit;
	}
	
	public void withdrawal(double withdrawalAmount) {
		double withdrawal = withdrawalAmount;
		balance = balance - withdrawal;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public double getBalance() {
		return balance;
	}
	
//	public void makeEmpty() {
//		accountID = 0;
//		firstName = "empty";
//		lastName = "empty";
//		balance = 0.0;
//	}
}

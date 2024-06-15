package bk;

public class Bk {

	
	  private double balance;
	  private int accountNumber;
	  private static int lastAssignedNumber;    // automatically initialized with zero
	  public static final double OVERDRAFT_FEE=5;   // constant
	
	  public Bk() {   //  two overloaded constructors 
	    balance=0;
	    lastAssignedNumber++;
	    accountNumber= lastAssignedNumber;
	  }
	  public Bk(double initialBalance) {
	    balance= initialBalance;
	    lastAssignedNumber++;
	    accountNumber= lastAssignedNumber;
	  }
	
	  public static int showLastAccountNumber(){
	    return lastAssignedNumber;
	  }
	
	  public void deposit(double amount) {
	    double newBalance=balance+amount;   // newBalance and amount are local variables
	    balance = newBalance;
	  }
	  public double withdraw(double amount) {     
	    double newBalance=balance-amount;
	    balance=newBalance;
	    return newBalance;
	  }

	  public double getBalance() {   // an accessor method
	    return balance;
	  }    

	  public void transfer (double amount, Bk other) {  
	          // this method affects the content of two objects
	      balance = balance-amount;
	      other.balance = other.balance+amount;
	   

	}


	public class BankAccountTest {
	  public static void main (String[] args) {
	    Bk b1=new Bk();
	    double a = 100.0;
	    Bk b2 = new Bk(a);

	    a = 2000.0;
	    b1.deposit(a);
	    System.out.println(b1.withdraw(500.0));
	    b1.transfer(500.0, b2);
	    System.out.println(b1.getBalance());
	    System.out.println(b2.getBalance());
	    System.out.println(Bk.showLastAccountNumber());
	    System.out.println(Bk.OVERDRAFT_FEE);            
	 }



	}


	
}

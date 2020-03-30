import java.util.Scanner;
class Account{
	private String cname;
	private String pan;
	private int accno;
	private String branch;
	private float balance;
	private float min_bal;


	public Account(String cname,int accno,String branch,float balance){
		this.cname = cname;
		this.accno = accno;
		this.branch = branch;
		this.balance = balance;
		this.pan = "";
		this.min_bal = 5000;
	}

	public Account(String cname,String pan,int accno,String branch,float balance){
		this.cname = cname;
		this.pan = pan;
		this.accno = accno;
		this.branch = branch;
		this.balance = balance;
		this.min_bal = 5000;
	}

	public String getCName(){
		return cname;
	}

	public String getPan(){
		return pan;
	}

	public int getAccNo(){
		return accno;
	}

	public String getBranch(){
		return branch;
	}

	public float getBalance(){
		return balance;
	}

	public void setPan(String pan){
		this.pan = pan;
	}

	public void setBalance(float balance){
		this.balance = balance;
	}

	public void deposit(int accno,float amount) throws PANRequiredException{
		if(this.accno == accno){
			if(amount >= 50000 && pan == "")
				throw new PANRequiredException(amount);
			else this.balance += amount;
		}
	}

	public void withdraw(int accno,float amount) throws MinBalRequiredException,NotEnoughMoneyException	{
		if(this.accno == accno){
			if(amount > balance)
				throw new NotEnoughMoneyException(balance);
			else if(balance - amount < min_bal)
				throw new MinBalRequiredException(balance);
			else
				this.balance -= amount;
		}
	}
	
	public String toString(){
		return "Name       : " + cname + "\n" +
			   "Pan Number : " + pan + "\n" +
			   "Acc Number : " + accno + "\n" +
			   "Branch     : " + branch + "\n" +
			   "Balance    : " + balance + "\n";
	} 
}

class AccountNotFoundException extends Exception{
	private int accno;
	
	AccountNotFoundException(int accno){
		this.accno = accno;
	}
	
	public String toString(){
		return "Account number " + accno + " is invalid!";
	}
}

class NotEnoughMoneyException extends Exception{
	private float balance;
	
	NotEnoughMoneyException(float balance){
		this.balance = balance;
	}
	
	public String toString(){
		return "NotEnoughMoneyException: balance( " + balance + ") insufficient";
	}
}

class PANRequiredException extends Exception{
	private float amount;
	
	PANRequiredException(float amount){
		this.amount = amount;
	}
	
	public String toString(){
		return "PANRequiredException: Amount ( " + amount + " ) greater than 50000";
	}
}

class MinBalRequiredException extends Exception{
	private float amount;
	
	MinBalRequiredException(float amount){
		this.amount = amount;
	}
	
	public String toString(){
		return "Mininum Balance Required!";
	}
}
	
class TestException{	

	public static void search(Account[] acc,int accno) throws AccountNotFoundException{
		int index = -1;
		for(int i = 0 ; i < acc.length ; i++)
			if(acc[i].getAccNo() == accno){
				index = i;
				break;
			}
		if(index == -1)
			throw new AccountNotFoundException(accno);
		System.out.println("Account Details\n" + acc[index]);
	}
	
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String customer_name;
		String branch;
		float balance;
		String pan;
		int acno;
		int no_of_people;
		String choice;
		int amt;
		System.out.print("Enter Number of People : ");
		no_of_people = input.nextInt();
		Account a[] = new Account[no_of_people];
	
		for(int i = 0; i< no_of_people ; i++){
			System.out.print("\nEnter Customer Name : ");
			customer_name = input.next();
			System.out.print("Enter Account Number : ");
			acno = input.nextInt();
			System.out.print("Enter Branch : ");
			branch = input.next();
			System.out.print("Enter Balance : ");
			balance = input.nextFloat();
			System.out.println("PAN Number? (Y/N)");
			choice = input.next();
			if (choice.equals("Y")){
				System.out.print("Enter PAN Number : ");
				pan = input.next();
				a[i] = new Account(customer_name,pan,acno,branch,balance) ;
			}
			else
				a[i] = new Account(customer_name,acno,branch,balance) ;
		}

		int ch;
		int flag = 0;
		do
		{
			System.out.println("\nMENU");
			System.out.println("1 - Deposit ");
			System.out.println("2 - Withdraw ");
			System.out.println("3 - Search ");
			System.out.println("4 - Exit ");
			System.out.println("-------------------");
			System.out.print("Enter choice : ");
			ch = input.nextInt();
			System.out.println();

			if(ch == 1){
				flag=0;
				System.out.print("Enter Account Number for Deposit : ");
				acno = input.nextInt();
				for (int i = 0;i <no_of_people; i++)
				{
				if (a[i].getAccNo() == acno)
				{
				System.out.println();
				System.out.println( "Account Details:");
				System.out.println( "Name        : " + a[i].getCName());
				System.out.println( "PAN         : " + a[i].getPan());
				System.out.println( "Branch      : " + a[i].getBranch());
				System.out.println( "Old Balance : " + a[i].getBalance());
				System.out.println("\n-----------------------------------------------------\n");

				System.out.print("Enter Amount to be Deposited : ");
				amt = input.nextInt();
				try
				{
					a[i].deposit(acno,amt);
					System.out.println(" Account Details ");
					System.out.println( "Name        : " + a[i].getCName());
					System.out.println( "PAN         : " + a[i].getPan());
					System.out.println( "Branch      : " + a[i].getBranch());
					System.out.println( "New Balance : " + a[i].getBalance());
					System.out.println("\n-----------------------------------------------------\n");
				}
				catch(Exception e)
				{
					System.out.println( e );
					System.out.println();
					System.out.print("Enter Pan Number : ");
					pan = input.next();
					a[i].setPan(pan);
				try
				{
					a[i].deposit(acno,amt);
				}
				catch(Exception q)
				{
					System.out.println( q );
					System.out.println();
				}

				System.out.println( "New Balance : " + a[i].getBalance());
				}
				flag = 1;
				break;
				}
				}
				if(flag == 0)
				System.out.println("Account Not Found");

			}

			else if (ch == 2){
				flag=0;
				System.out.print("Enter Account Number for Withdrawal : ");
				acno = input.nextInt();
			
				for (int i = 0;i <no_of_people; i++){
					if (a[i].getAccNo() == acno){
						System.out.println(" Account Details ");
						System.out.println( "Name        : " + a[i].getCName());
						System.out.println( "PAN         : " + a[i].getPan());
						System.out.println( "Branch      : " + a[i].getBranch());
						System.out.println( "Old Balance : " + a[i].getBalance());		
						System.out.println("\n-----------------------------------------------------\n");
						System.out.println("Enter Amount to be Withdrawn");
						amt = input.nextInt();
						try{
							a[i].withdraw(acno,amt);
							System.out.println(" Account Details ");
							System.out.println( "Name        : " + a[i].getCName());
							System.out.println( "PAN         : " + a[i].getPan());
							System.out.println( "Branch      : " + a[i].getBranch());
							System.out.println( "New Balance : " + a[i].getBalance());
							System.out.println("\n-----------------------------------------------------\n");
						}
						catch(Exception e){
							System.out.println( e );
							System.out.println();
						}
						flag = 1;
						break;
					}
				}
				if(flag == 0)
				System.out.println("Account Not Found");
			}

			else if (ch == 3){
				System.out.println("Enter Account number to be Searched");
				acno = input.nextInt();
			
				try{
					search(a,acno);
					
				}
				catch(Exception e){
					System.out.println(e );
					System.out.println();
				}
			}
		
		}while (ch!=4);
	
	}
	
}		
			
	


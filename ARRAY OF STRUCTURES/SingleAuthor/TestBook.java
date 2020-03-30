//SINGLE AUTHOR
import java.util.Scanner;

class Author{
	private String name;
	private String email;
	private char gender;

	Author(String name,String email,char gender){
		this.name   = new String(name);
		this.email  = new String(email);
		this.gender = gender;
	}

	String getName(){
		return name;
	}

	String getEMail(){
		return email;
	}

	char getGender(){
		return gender;
	}

	void setEMail(String email){
		this.email = new String(email);
	}
}

class Book{
	private String name;
	private Author author;
	private double price;
	private int qty;

	Book(String name,Author author,double price){
		this.name   = new String(name);
		this.author = author;
		this.price  = price;
	}

	Book(String name,Author author,double price,int qty){
		this(name,author,price);
		this.qty = qty;
	}

	String getName(){
		return name;
	}

	Author getAuthor(){
		return author;
	}

	void setPrice(double price){
		this.price = price;
	}

	double getPrice(){
		return price;
	}

	void setQty(int qty){
		this.qty = qty;
	}

	int getQty(){
		return qty;
	}
	
	String getAuthorName(){
		return author.getName();
	}
	
	String getAuthorEMail(){
		return author.getEMail();
	}
}


class TestBook{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String nameA,nameB,email;
		char gender;
		int qty;
		double price;
		int opt = -1;
		Book b[] = new Book[2];
		Author a;
		
		for(int i = 0 ; i < 2 ; i++){
			System.out.print("ENTER BOOK DETAILS\n");
			System.out.print("Enter name of book  : ");
			nameB = input.next();
			System.out.print("Enter price of book : ");
			price = input.nextDouble();
			System.out.print("Enter quantity      : ");
			qty = input.nextInt();
	
			System.out.print("-----------------------------------------------\n");
		
	
			System.out.print("ENTER AUTHOR DETAILS\n");
			System.out.print("Enter name of author       : ");
			nameA = input.next();
			System.out.print("Enter email of author      : ");
			email = input.next();
			System.out.print("Enter the gender of author : ");
			gender = input.next().charAt(0);

			a = new Author(nameA,email,gender);
			b[i] = new Book(nameB,a,price,qty);
		
			System.out.print("------------------------------------------------\n");
		}
		
		for(int i = 0 ; i < 2 ; i++){
			System.out.print("BOOK DETAILS\n");
			System.out.println("Name         : " + b[i].getName());
			System.out.println("Author       : " + b[i].getAuthorName());
			System.out.println("Author E-Mail: " + b[i].getAuthorEMail());
			System.out.println("Price        : " + b[i].getPrice());
			System.out.println("Quantity     : " + b[i].getQty());

			System.out.print("------------------------------------------------\n");
		}
					
	}
}



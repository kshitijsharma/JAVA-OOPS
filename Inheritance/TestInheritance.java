class Person{
	private int aadhaar;
	private String name;
	private String address;
	private char gender;

	public Person(int aadhaar,String name,String address,char gender){
		this.aadhaar = aadhaar;
		this.name = name;
		this.address = address;
		this.gender = gender;
	}

	public String getName(){
		return name;
	}

	public  String getAddress(){
		return address;
	}

	public int getAadhaar(){
		return aadhaar;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public char getGender(){
		return gender;
	}
}

class Student extends Person{
	private String program;
	private int year;
	private float totalmark;

	public Student(int aadhaar,String name,String address,char gender,
			       String program,int year,float total){
		super(aadhaar,name,address,gender);
		this.program = program;
		this.year = year;
		this.totalmark = total;
	}

	public String getProgram(){
		return program;
	}

	public int getYear(){
		return year;
	}

	public void setYear(int year){
		this.year = year;
	}

	public float getTotal(){
		return totalmark;
	}

	public void setTotal(float total){
		this.totalmark = total;
	}

	public float calGPA(){
		return (totalmark/500 * 10);
	}
}

class Faculty extends Person{
	private String designation;
	private	String department;
	private float basicpay;

	public Faculty(int aadhaar,String name,String address,char gender,
				   String designation,String dept,float pay){
		super(aadhaar,name,address,gender);
		this.designation = designation;
		this.department = dept;
		this.basicpay = pay;
	}

	public String getDesig(){
		return designation;
	}

	public void setDesig(String desig){
		this.designation = desig;
	}

	public void setBasic(float pay){
		this.basicpay = pay;
	}

	public float getBasic(){
		return basicpay;
	}

	public float calSalary(){
		float gross_sal,deductions,net_sal,da,hra,ins,pf;

		da  = (float)(60/100.0) * basicpay;
		hra = (float)(10/100.0) * basicpay;
		
		ins = (float)(8.5/100)  * basicpay;
		pf  = (float)(8/100.0)  * basicpay;

		gross_sal  = basicpay + da + hra;
		deductions = ins + pf;

		net_sal = gross_sal - deductions;

		return net_sal;
	}
}

class TestInheritance{
	public static Person getPerson(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		String name,address;
		int aadhaar;
		char gender;
		System.out.print("Enter the name     : ");
		name = input.nextLine();
		System.out.print("Enter aadhaar      : ");
		aadhaar = input.nextInt();
		input.nextLine();
		System.out.print("Enter the address  : ");
		address = input.nextLine();
		System.out.print("Enter the gender   : ");
		gender = input.nextLine().charAt(0);
		return new Person(aadhaar,name,address,gender);

	}
	
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		int aadhaar,year;
		String name,address,program,designation,department;
		char gender;
		float basicpay,total;
		Person p;
		
		System.out.println("ENTER STUDENT DETAILS");		
		p = getPerson();
		name = p.getName();
		address = p.getAddress();
		aadhaar = p.getAadhaar();
		gender = p.getGender();
		System.out.print("Enter the program  : ");
		program = input.nextLine();
		System.out.print("Enter the year     : ");
		year = input.nextInt();
		System.out.print("Enter total mark   : ");
		total = input.nextFloat();
		input.nextLine();
		Student s = new Student(aadhaar,name,address,gender,program,year,total);
		
		System.out.println("--------------------------------------------------------");
		p = getPerson();
		name = p.getName();
		aadhaar = p.getAadhaar();
		address = p.getAddress();
		gender = p.getGender();
		System.out.print("Enter Designation  : ");
		designation = input.nextLine();
		System.out.print("Enter Department   : ");
		department = input.nextLine();
		System.out.print("Enter basic Pay    : ");
		basicpay = input.nextFloat();
		input.nextLine();
		Faculty f = new Faculty(aadhaar,name,address,gender,designation,department,basicpay);
		System.out.println("--------------------------------------------------------");
		System.out.println("STUDENT DETAILS");
		System.out.println("Name        : " + s.getName());
		System.out.println("Address     : " + s.getAddress());
		System.out.println("Aadhaar     : " + s.getAadhaar());
		System.out.println("Gender      : " + s.getGender());
		System.out.println("Program     : " + s.getProgram());
		System.out.println("Year        : " + s.getYear());
		System.out.println("Total       : " + s.getTotal());
		System.out.println("GPA         : " + s.calGPA());
		
		System.out.println("--------------------------------------------------------");
		System.out.println("FACULTY DETAILS");
		System.out.println("Name        : " + f.getName());
		System.out.println("Address     : " + f.getAddress());
		System.out.println("Aadhaar     : " + f.getAadhaar());
		System.out.println("Gender      : " + f.getGender());
		System.out.println("Designation : " + f.getDesig());
		System.out.println("Basic Pay   : " + f.getBasic());
		System.out.println("Salary      : " + f.calSalary());
		


	}	
}

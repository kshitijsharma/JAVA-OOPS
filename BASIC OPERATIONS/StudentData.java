import java.util.Scanner;

class Student{
	private int regno;
	private String name ;
	private String dept ;
	private double marks[] = new double[3];
	
	Student(int rno,String n,String d,double[] m){
		regno = rno;
		name = new String(n);
		dept = new String(d);
		for(int i = 0 ; i < 3 ; i++) {
			marks[i] = m[i];
		}
	}
	
	double getTotal(){
		return marks[0] + marks[1] + marks[2];
	}
	
	String getGrade(){
		String grade = "\0";
		double total = getTotal();
		total = total/3.0;
		if(total >= 90)
			grade = "A";
		else if(total >= 80)
			grade = "B";
		else if(total >= 70)
			grade = "C";
		else if(total >= 60)
			grade = "D";
		else
			grade = "F";
		return grade;
	}
	
	void printData(){	
		System.out.println("Register Number     : " + regno);
		System.out.println("Name                : " + name);
		System.out.println("Department          : " + dept);
		System.out.print  ("Marks in 3 Subjects : ");
		for(int i = 0 ; i < 3; i++)
			System.out.print(marks[i] + " ");
		System.out.println();
		System.out.println("Total Marks         : " + getTotal());
		System.out.println("Grade               : " + getGrade());
		System.out.println("-----------------------------------------");
	}
	
	String getName(){return name;}
	int getRegNo(){return regno;}
	String getDept(){return dept;}
}


class StudentData{
	
	void getStudentData(Student[] s,int size){
		Scanner input = new Scanner(System.in);
	
		int rno;
		String n,dept;
		double m[] = new double[3];
			
		for(int i = 0 ; i < size ; i++){
			System.out.print("Enter Register Number        : ");
			rno= input.nextInt();
			System.out.print("Enter Name                   : ");
			n = input.next();
			System.out.print("Enter Department             : ");
			dept = input.next();
			System.out.print("Enter the marks in 3 subjects: ");
			for (int j=0;j<3;j++) {
				m[j]=input.nextDouble();
			}
			Student tmp = new Student(rno,n,dept,m);
			s[i]= tmp;
			System.out.println("-----------------------------------------");
		}
		
	}
	
	void putStudentData(Student[] s,int size){
		for(int i = 0 ; i < size ; i++)
			s[i].printData();
	}
	
	void searchStudent(Student s[],int size,int id){
		for(int i = 0 ; i < size ; i++)
			if(s[i].getRegNo() == id)
				s[i].printData();
	}
		
	void searchStudent(Student s[],int size,String d){
		System.out.println("Rno  Name");
		for(int i = 0 ; i < size ; i++)
			if(s[i].getDept().equals(d)){
				System.out.println(s[i].getRegNo() + "    " + s[i].getName());
			}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);	
		StudentData d = new StudentData();
		int size = 0;
		String dept;
		int id;
		int opt = 0;
		Student s[] = new Student[100];
		while(opt != 5){
			
			System.out.println("1 - Enter Details\n2 - Search by department\n3 - Search by id");
			System.out.println("4 - Display all records\n5 - Stop\nEnter your choice: ");
			opt = input.nextInt();
			
			switch(opt){
				case 1: {
						System.out.print("Enter the number of students: ");
						size = input.nextInt();
						s = new Student[100];

						d.getStudentData(s,size);

						System.out.println();
						}
						break;		
						
				case 2: {
						System.out.print("Enter the department to search for: ");
						dept = input.next();
						
						d.searchStudent(s,size,dept);
						break;
						}
				case 3:{			
						System.out.print("Enter the id to search for: ");
						id = input.nextInt();
						
						d.searchStudent(s,size,id);
						break;
						}
				case 4: {
						d.putStudentData(s,size);
						break;
						}
				case 5: {break;}
				default:{
						System.out.println("Invalid Input!");
						}
			}
			
			System.out.print("Press Enter to continue......");
			try{System.in.read();}
			catch (Exception e){}
			System.out.print("\033[H\033[2J");  
    		System.out.flush();  
		}
	}
}

		
	



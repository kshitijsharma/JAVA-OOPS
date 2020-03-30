class Person{
    private String name;
    private String address;
    
    public Person(String name,String address){
	this.name = name;
	this.address = address;
    }

    public String getName(){
	return name;
    }

    public String getAddress(){
	return address;
    }

    public void setAddress(String address){
	this.address = address;
    }

}

class Employee extends Person{
    private int  empid;
    private String dept;
    private int basic;

    public Employee(String name,String address,int empid,String dept,int basic){
	super(name,address);
	this.empid = empid;
	this.dept = dept;
	this.basic = basic;
    }

    public int getEmpid(){
	return empid;
    }
    
       
    public String getDept(){
	return dept;
    }

    public void setDept(String dept){
	this.dept = dept;
    }

    public void setBasic(int basic){
	this.basic = basic;
    }

    public int getBasic(){
	return basic;
    }

    public float calSalary(){
	float gross_sal,deductions,net_sal,da,hra,ins,pf;
	da  = (float)(60/100.0) * basic;
	hra = (float)(10/100.0) * basic;
		
	ins = (float)(8.5/100)  * basic;
	pf  = (float)(8/100.0)  * basic;

	gross_sal  = basic + da + hra;
	deductions = ins + pf;
	
	net_sal = gross_sal - deductions;
	
	return net_sal;
    }

     public String toString(){
	return "Name         : " + getName() + "\n" +
	       "Address      : " + getAddress() + "\n" +
	       "Emp ID       : " + getEmpid() + "\n" +
	       "Department   : " + getDept() + "\n" +
	       "Basic        : " + getBasic() + "\n";
     }
}


class Faculty extends  Employee{
    private String designation;
    private String course;

    public Faculty(String name,String address,int empid,String dept,int basic,
		   String desig,String course){
	super(name,address,empid,dept,basic);
	this.designation = desig;
	this.course = course;
    }

    public String getDesig(){
	return designation;
    }

    public void setDesig(String desig){
	this.designation = desig;
    }

    public void setCourse(String course){
	this.course = course;
    }

    public String getCourse(){
	return course;
    }

     public float calSalary(){
	 float gross_sal,deductions,net_sal,da,hra,ins,pf;
	 
	 da  = (float)(50/100.0) * getBasic();
	 hra = (float)(8/100.0) * getBasic();
	 
	 ins = (float)(9.5/100)  * getBasic();
	 pf  = (float)(8/100.0)  * getBasic();
	 
	 gross_sal  = getBasic() + da + hra;
	 deductions = ins + pf;
	 
	 net_sal = gross_sal - deductions;
	 
	 return net_sal;
     }

    public String toString(){
	return "Name         : " + getName() + "\n" +
	       "Address      : " + getAddress() + "\n" +
	       "Emp ID       : " + getEmpid() + "\n" +
	       "Department   : " + getDept() + "\n" +
	       "Basic        : " + getBasic() + "\n" +
	       "Designation  : " + designation + "\n" +
               "Course       : " + course + "\n";
	
    }

}

interface Student{
    public float[] getMarks();
    public float calcGPA();

}


class ResearchAssistant extends Employee implements Student{
    private String project;
    private String course;
    private float[] marks;

    
    public ResearchAssistant(String name,String address,int empid,String dept,int basic,String project,String course,float[] marks){
	super(name,address,empid,dept,basic);
	this.project = project;
	this.course = course;
	this.marks = marks;
    }

    public String getProject(){
	return project;
    }

    
    public String getCourse(){
	return course;
    }

    public void setCourse(String course){
	this.course = course;
    }

    public float[] getMarks(){
	return marks;
    }

    public float calcGPA(){
	float total = 0.0f;
	for(int i = 0 ; i < marks.length ; i++)
	    total += marks[i];

	return (total/300*10);
    }

    public float calSalary(){
	float gross_sal,deductions,net_sal,da,hra,ins,pf;
	
	da  = (float)(30/100.0) * getBasic();
	hra = (float)(5/100.0) * getBasic();
	
	ins = (float)(8.5/100)  * getBasic();
	pf  = (float)(8/100.0)  * getBasic();
	
	gross_sal  = getBasic() + da + hra;
	deductions = ins + pf;
	
	net_sal = gross_sal - deductions;
	
	return net_sal;
    }

     public String toString(){
	return "Name         : " + getName() + "\n" +
	       "Address      : " + getAddress() + "\n" +
	       "Emp ID       : " + getEmpid() + "\n" +
	       "Department   : " + getDept() + "\n" +
	       "Basic        : " + getBasic() + "\n" +
	       "Project      : " + project + "\n" +
	       "Course       : " + course + "\n" +
	       "Marks        : " + marks[0] +" " + marks[1] +" " + marks[2] + "\n" + 
	       "CGPA         : " + calcGPA() + "\n";
    }
}


class TestInterface{
    public static void main(String[] args){
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	String name,address,dept,project,course,desig;
	int empid,basic;
	float marks[] = new float[5];

	System.out.println("ENTER THE DETAILS OF EMPLOYEE");
	System.out.print("Enter the name           : ");
	name = input.nextLine();
	System.out.print("Enter the address        : ");
	address = input.nextLine();
	System.out.print("Enter the empid          : ");
	empid = input.nextInt();
	input.nextLine();
	System.out.print("Enter the department     : ");
	dept = input.nextLine();
	System.out.print("Enter the basic pay      : ");
	basic = input.nextInt();
	input.nextLine();
	Employee e = new Employee(name,address,empid,dept,basic);
	
	System.out.println("\n---------------------------------------\n");

	
	
	System.out.println("ENTER THE DETAILS OF FACULTY");
	System.out.print("Enter the name           : ");
	name = input.nextLine();
	System.out.print("Enter the address        : ");
	address = input.nextLine();
	System.out.print("Enter the empid          : ");
	empid = input.nextInt();
	input.nextLine();
	System.out.print("Enter the department     : ");
	dept = input.nextLine();
	System.out.print("Enter the basic pay      : ");
	basic = input.nextInt();
	input.nextLine();
	System.out.print("Enter the designation    : ");
	desig = input.nextLine();
	System.out.print("Enter the course         : ");
	course = input.nextLine();
	Faculty f = new Faculty(name,address,empid,dept,basic,desig,course);
	
	System.out.println("\n---------------------------------------\n");
	
	System.out.println("ENTER THE DETAILS OF RESEARCH ASSISTANT");
	System.out.print("Enter the name           : ");
	name = input.nextLine();
	System.out.print("Enter the address        : ");
	address = input.nextLine();
	System.out.print("Enter the empid          : ");
	empid = input.nextInt();
	input.nextLine();
	System.out.print("Enter the department     : ");
	dept = input.nextLine();
	System.out.print("Enter the basic pay      : ");
	basic = input.nextInt();
	input.nextLine();
	System.out.print("Enter the project        : ");
	project = input.nextLine();
	System.out.print("Enter the course         : ");
	course = input.nextLine();
	System.out.print("Enter marks[3]           : ");
	for(int i = 0 ; i < 3 ; i++)
	    marks[i] = input.nextFloat();

	ResearchAssistant r = new ResearchAssistant(name,address,empid,dept,basic,project,course,marks);
	
	System.out.println("\n********************************************\n");
	
	System.out.println("DETAILS OF EMPLOYEE\n" + e);
	
	System.out.println("\n********************************************\n");

	System.out.println("DETAILS OF FACULTY\n" + f);

	System.out.println("\n********************************************\n");
	
	System.out.println("DETAILS OF RESEARCH ASSISTANT\n" + r);

	Employee arr[] = {e,f,r};
	for(int i = 0 ; i < arr.length ; i++){
	    switch(i){
	    case 0: System.out.print("Salary of employee: "); break;
	    case 1: System.out.print("Salary of Faculty : "); break;
	    case 2: System.out.print("Salary of Research Assistant : "); break;
	    }
	    System.out.println(arr[i].calSalary());
	}

	
    }
}
	

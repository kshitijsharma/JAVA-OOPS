import java.util.Scanner;
import java.util.Calendar;

public class PaySlip {
   int id, hours, exp;
   String name, desig, dob, doj;
   double bp, hra, da, lic, pf, ded, net, gross, hwage;
   static Scanner input = new Scanner(System.in);
   
   PaySlip(){
   	this(0,"","","","");
   	}	
   
   PaySlip(int id,String name,String desig,String dob,String doj){
   		this.id = id;
   		this.name = name;
   		this.desig = desig;
   		this.dob = dob;
   		this.doj = doj;
   	}
    
    void getData()
    {
        System.out.println("Enter details");
        System.out.print("Employee ID              : ");
        id = input.nextInt();
        System.out.print("Employee name            : ");
        name = new String(input.next());
        System.out.print("Designation              : ");
        desig = new String(input.next());
        System.out.print("Date of Birth(DD/MM/YYYY): ");
        dob = input.next();
        System.out.print("Date of Join(DD/MM/YYYY) : ");
        doj = input.next();
        
        if(desig.equals("Intern"))
        {
        	System.out.print("No. of hours worked      : ");
            hours = input.nextInt();
            System.out.print("Hourly wage              : ");
            hwage = input.nextDouble();
        }
        else
        {
            System.out.print("Basic pay                : ");
            bp = input.nextDouble();
        }
        
        System.out.print("LIC Premium(0 if not appl.)  : ");
        lic = input.nextDouble();
        int year = Calendar.getInstance().get(Calendar.YEAR);		//getting the current year from System
		exp = (year-Integer.parseInt(doj.substring(6)));			//calculating years of experience		
		
        System.out.println("*********************************************");
    }
    
    void calc()
    {
        if(desig.equals("Intern"))
        {
            da=2000;
            hra=1000;
            pf=500;
            bp=hours*hwage;
        }
        else if(desig.equals("Manager"))
        {
            da=0.4*bp;
            hra=0.1*bp;
            pf=0.08*bp;
        }
        else if(desig.equals("Trainee")||
               desig.equals("Analyst") ||
               desig.equals("SoftwareEngineer")||
               desig.equals("TeamLeader") )
        {
            da=0.3*bp;
            hra=0.1*bp;
            pf=0.08*bp;
        }
        else
        {
            System.out.println("Invalid choice\n");
        }
        
        gross=bp+da+hra;
        ded=lic+pf;
        net=gross-ded;
    }

    void paySlipReduced()
    {
    	calc();
		System.out.println("PAYSLIP");
		System.out.println("ID              : "+id);
		System.out.println("Name            : "+name);
		System.out.println("Designation     : "+desig);	
		System.out.println("DOB             : "+dob);
		System.out.println("DOJ             : "+doj);
		System.out.println();
		System.out.println("Net Salary      : "+net);        
        System.out.println("*********************************************");
    }
    
    void paySlip()
    {
    	calc();
		System.out.println("PAYSLIP");
		System.out.println("ID              : "+id);
		System.out.println("Name            : "+name);
		System.out.println("Designation     : "+desig);	
		System.out.println("DOB             : "+dob);
		System.out.println("DOJ             : "+doj);
		System.out.println();
		System.out.println("Basic Pay       : "+bp);
		System.out.println("DA              : "+da);
		System.out.println("HRA             : "+hra);
		System.out.println("LIC             : "+lic);
		System.out.println("PF              : "+pf);
		System.out.println();
		System.out.println("Gross Salary    : "+gross);
		System.out.println("Deductions      : "+ded);
        System.out.println("                  ---------");
		System.out.println("Net Salary      : "+net);        
        System.out.println("                  ---------");
        System.out.println("*********************************************");
    }
    
    void promote()
    {	
    	if(desig.equals("Manager")){
    		System.out.println("You are a manger and hence not eligible!");
    	}
    	else{
    		if(exp > 1){
    		
    		  if (desig.equals("Intern")){
    			System.out.println("Enter designation to promote: ");
         		desig=input.next();
         		System.out.println("Enter basic pay: ");
         		bp = input.nextDouble();
         		hours = 0;
         		hwage = 0.0;
          		}
         	  else
         		desig = new String("Manager");
           	  System.out.println("Promotion Succesfull!"); 
         	}
         	else
         		System.out.println("Not enough experience!");
	     }
           
    }

    public static void main(String[] args) {
        int i,n = 0,o,flag=0,stop = 0;
        String ename;
        int eid;
        char ch;
        PaySlip p[] = new PaySlip[100];
        
        
        do
        {
            System.out.println("1.Enter details\n2.Display Employee Record\n3.Payslip of an employee\n4.Promotion\n5.Stop\nEnter choice: ");
            o = input.nextInt();
            switch(o)
            {
            	case 1:
            		System.out.println("PaySlip Manager");
					System.out.print("Enter no. of employees: ");
					n=input.nextInt();
					p = new PaySlip[n];
				
					for(i=0;i<n;i++){
						p[i]=new PaySlip();
						p[i].getData();
						p[i].calc();
					}
					break;
			   case 2:
                    for(i=0;i<n;i++)
                    {
                        p[i].paySlipReduced();
                    }
                    break;
                case 3:
                    System.out.print("Enter id of employee to view payslip: ");
                    eid=input.nextInt();
                    for(i=0;i<n;i++){
                        if(p[i].id ==eid){
                          p[i].paySlip();
                          flag=1;
                          break;                     
                        }
                    }
                    if(flag == 0 && i != n)
                        System.out.println("Employee not found");
                    break;
                case 4:
                    System.out.print("Enter id of employee to promote: ");
                    eid=input.nextInt();
                    for(i=0;i<n;i++)
                    {
                         if(p[i].id ==eid)
                        {
                         flag=1;
                         break;
                        }
                    }
                    if(flag==1 && i != n)
                       p[i].promote();
                    else
                       System.out.println("Employee not found");
                    break;
                case 5: stop = 1;
                		break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Press Enter to continue......");
			try{System.in.read();}
			catch (Exception e){}
			System.out.print("\033[H\033[2J");  
    		System.out.flush();
        }while(stop != 1);
    }
}

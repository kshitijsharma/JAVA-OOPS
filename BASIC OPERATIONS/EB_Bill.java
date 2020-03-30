import java.util.Scanner;

class ElectricityBill{
	private int custNo;
	private String name;
	private double prev_mon;
	private double cur_mon;
	private String connection_type;

	public ElectricityBill(){
		custNo = 0;
		name = "";
		prev_mon = (double)0.0;
		cur_mon = (double)0.0;
		connection_type = "";
	}	

	void setCustNo(int c){
		custNo = c;
	}

	void setName(String n){
		name = n;
	}

	void setPrevMon(double p){
		prev_mon = p;
	}

	void setCurMon(double c){
		cur_mon = c;
	}
	
	void setConnectionType(String type){
		connection_type = type;
	}

	double getUnits(){
		return cur_mon - prev_mon;
	}

	double getCost(){
		double units = getUnits();
		double cost = 0.0;
		
		if(connection_type.equals("Commercial")){
			if(units <= 100){
				cost = units * 2.0;
			}
			else if(units <= 200){
				cost = 100 * 2.0 + (units-100) * 4.50;
			}
			else if(units <= 500){
				cost = 100 * 2.0 + 100 * 4.50 + (units-200) * 6.0;
			}
			else{
	 			cost = 100 * 2.0 + 100 * 4.50 + 300 * 6.0 + (units-500) * 7.0;
			}
		}
		else{
			if(units <= 100){
				cost = units * 1.0;
			}
			else if(units <= 200){
				cost = 100 * 1.0 + (units-100) * 2.50;
			}
			else if(units <= 500){
				cost = 100 * 1.0 + 100 * 2.50 + (units-200) * 4.0;
			}
			else{
	 			cost = 100 * 1.0 + 100 * 2.50 + 300 * 4.0 + (units-500) * 6.0;
			}
		}
	
		return cost;
	}


	int getCustNo(){	return custNo;}
	
	String getCustName(){	return name;}
	
	double getPrevMon(){ return prev_mon;}

	double getCurMon(){	return cur_mon;}

	String getConnectionType(){return connection_type;}
	
	void displayBill(){
		System.out.print("-------------------------------------------\n");


		System.out.println("Customer Number     : " + custNo);
		System.out.println("Customer Name       : " + name);
		System.out.println("Customer Type       : " + connection_type);
		System.out.println("Previous Reading    : " + prev_mon);
		System.out.println("Current Reading     : " + cur_mon);
		System.out.println("                      ---------");
		System.out.println("Total Units         : " + this.getUnits());		
		System.out.println("                      ---------");
		System.out.println("Tariff              : " + this.getCost());
	}
}
			

public class EB_Bill{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ElectricityBill bill = new ElectricityBill();
		int cno;
		String name,type;
		double current,previous,cost,units;

		System.out.print("Enter the name            : ");
		name = input.next();
		System.out.print("Enter the customer type   : ");
		type = input.next();
		System.out.print("Enter current month units : ");
		current = input.nextDouble();
		System.out.print("Enter previous month units: ");
		previous = input.nextDouble();
		System.out.print("Enter the customer number : ");
		cno = input.nextInt();

		bill.setCustNo(cno);
		bill.setName(name);
		bill.setConnectionType(type);
		bill.setCurMon(current);
		bill.setPrevMon(previous);

		bill.displayBill();		
	}
} 
		
	




















		

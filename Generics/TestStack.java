class Stack<T>{
	int top;
	T a[];
	int capacity;
	
	Stack(int n,T arr[]){
		top = -1;
		capacity = n;	
		a = arr;
	}
	
	boolean isEmpty(){
		return top == -1;
	}
	
	boolean isFull(){
		return top == capacity - 1;
	}
	
	void push(T x) throws StackFullException{
		if(isFull())
			throw new StackFullException();
		else
			a[++top]=x;
	}

	T pop() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException();
		return a[top--];
	}

	void display() throws StackEmptyException{
		int i;
		if(isEmpty())
			throw new StackEmptyException();
			
		System.out.println("\nThe Elements are :");
		for(i=top;i>=0;i--)
			System.out.println(a[i] + " ");
	}		
}

class StackEmptyException extends Exception{
	public String toString(){
		return "Stack Empty!";
	}
}

class StackFullException extends Exception{
	public String toString(){
		return "Stack Full!";
	}
}


class TestStack{
	public static void main(String[] args){
		
		java.util.Scanner input = new java.util.Scanner(System.in);
	
		int opt = 0;
		int ch = 0;
		
		while(opt != 4){
			ch = 0;	
			System.out.println("1 - Integer Stack");
			System.out.println("2 - Double Stack");
			System.out.println("3 - String Stack");
			System.out.println("4 - Exit");
			System.out.print("Enter your choice: ");
			opt = input.nextInt();
			
			switch(opt){
				case 1: {
							int temp;
							Integer arr[] = new Integer[10];
							Stack<Integer> intStack = new Stack<Integer>(4,arr);
					
							while(ch != 4){
								System.out.println("1 - Push");
								System.out.println("2 - Pop");
								System.out.println("3 - Display");
								System.out.println("4 - Back");
								System.out.println("Enter your choice: ");
								ch = input.nextInt();
						
								switch(ch){
									case 1: {
											 System.out.print("Enter the value to push: ");
											 temp = input.nextInt();
											 try{
											 	intStack.push(temp);
											 }
											 catch(StackFullException e){
											 	System.out.println(e);
											 }
											 System.out.println("\n----------------------------\n");
											 }
											 break;
									case 2: {
											 try{
											 	temp = intStack.pop();
	    										System.out.println("Value Popped: " + temp);
											 }
											 catch(StackEmptyException e){
											 	System.out.println(e);
											 }
											 System.out.println("\n----------------------------\n");
											}
											 break;
									case 3: {
 											 try{
 											 	intStack.display();	
 											 }
 											 catch(StackEmptyException e){
 											 	System.out.println(e);
 											 }
											 System.out.println("\n----------------------------\n");
											}
											break;
									case 4: break;
								}
							}
						}
						break;
				case 2: {
							double temp;
							Double arr[] = new Double[10];
							Stack<Double> dStack = new Stack<Double>(10,arr);
					
							while(ch != 4){
								System.out.println("1 - Push");
								System.out.println("2 - Pop");
								System.out.println("3 - Display");
								System.out.println("4 - Back");
								System.out.println("Enter your choice: ");
								ch = input.nextInt();
						
								switch(ch){
									case 1: {
											 System.out.print("Enter the value to push: ");
											 temp = input.nextDouble();
											 try{
											 	dStack.push(temp);
											 }
											 catch(StackFullException e){
											 	System.out.println(e);
											 }
											 System.out.println("\n----------------------------\n");
											}
											break;
									case 2: {
											 try{
											 	temp = dStack.pop();
											 	System.out.println("Value Popped: " + temp);
											 }
											 catch(StackEmptyException e){
											 	System.out.println(e);
											 }
											 
											 System.out.println("\n----------------------------\n");
											}
											break;
									case 3: {
												try{
													dStack.display();	
												}
												catch(StackEmptyException e){
													System.out.println(e);
												}
												System.out.println("\n----------------------------\n");
											}
											break;
									case 4: break;
											
								}
							}
						}
						break;
				case 3: {
							String temp;
							String arr[] = new String[10];
							Stack<String> sStack = new Stack<String>(10,arr);
					
							while(ch != 4){
								System.out.println("1 - Push");
								System.out.println("2 - Pop");
								System.out.println("3 - Display");
								System.out.println("4 - Back");
								System.out.println("Enter your choice: ");
								ch = input.nextInt();
						
								switch(ch){
									case 1: {
											 System.out.print("Enter the value to push: ");
											 temp = input.next();
											 try{
											 	sStack.push(temp);
											 }
											 catch(StackFullException e){
											 	System.out.println(e);
											 }
											 System.out.println("\n----------------------------\n");
											 }
											 break;
									case 2: {
											 try{
											 	temp = sStack.pop();
											 	System.out.println("String Popped: " + temp);
											 }
											 catch(StackEmptyException e){
											 	System.out.println(e);
											 }
											 System.out.println("\n----------------------------\n");
											 }
											 break;
									case 3: {
												try{
													sStack.display();
												}
												catch(StackEmptyException e){
													System.out.println(e);
												}
												System.out.println("\n----------------------------\n");
											}
											break;
									case 4: break;		
								}
							}
						}
						break;
			}
		}
	}
}
			

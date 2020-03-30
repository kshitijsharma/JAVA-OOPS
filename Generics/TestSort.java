class Sort<T extends Comparable<T>>{
	T arr[];

	public Sort(T arr[]){
		this.arr = arr;

		for(int i = 0 ; i < arr.length ; i++)
			for(int j = i + 1 ; j < arr.length ; j++)
				if(arr[i].compareTo(arr[j]) > 0 ){
					T tmp = arr[i];
					arr[i] =  arr[j];
					arr[j] = tmp;
				}
	}

	public void display(){
		for(int i = 0 ; i < arr.length ; i++)
			System.out.println(arr[i] + "\t");

	}
}


class TestSort{
	public static void main(String[] args){

		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int opt = 0;
		int ch = 0;

		while(opt != 4){
			System.out.println("1 - Integer Array");
			System.out.println("2 - Double Array");
			System.out.println("3 - String Array");
			System.out.println("4 - Exit");
			System.out.print("Enter your choice: ");
			opt = input.nextInt();
			System.out.println("\n----------------------------\n");
			
			switch(opt){
				case 1: {
							int temp;
							int size;
							System.out.print("Enter the size of the array: ");
							size = input.nextInt();

							Integer arr[] = new Integer[size];
							
							System.out.print("Enter the elements: ");	
							
							for(int i = 0 ; i < arr.length ; i++)
								arr[i] = input.nextInt();
							Sort<Integer> s = new Sort<Integer>(arr);

							System.out.println("Sorted Array: ");
							s.display();
							System.out.println("\n----------------------------\n");
						}
						break;
				case 2: {
							double temp;
							int size;
							System.out.print("Enter the size of the array: ");
							size = input.nextInt();

							Double arr[] = new Double[size];
							
							System.out.print("Enter the elements: ");	
							
							for(int i = 0 ; i < arr.length ; i++)
								arr[i] = input.nextDouble();
							Sort<Double> s = new Sort<Double>(arr);

							System.out.println("Sorted Array: ");
							s.display();
							System.out.println("\n----------------------------\n");
						}
						break;
				case 3: {
							String temp;
							int size;
							System.out.print("Enter the size of the array: ");
							size = input.nextInt();

							String arr[] = new String[size];
							
							System.out.print("Enter the elements: ");	
							
							for(int i = 0 ; i < arr.length ; i++)
								arr[i] = input.next();
							Sort<String> s = new Sort<String>(arr);

							System.out.println("Sorted Array: ");
							s.display();
							System.out.println("\n----------------------------\n");
						}
						break;
			}
		}
	}
}

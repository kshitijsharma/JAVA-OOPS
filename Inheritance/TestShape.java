class Shape{
	protected String color = "Red";

	public Shape(){
		color = "Red";
	}

	public Shape(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public  void setColor(String color){
		this.color = color;
	}

}

class Circle extends Shape{
	protected float radius = 1.0f;

	public Circle(){
		radius = 1.0f;
	}

	public Circle(float radius){
		this.radius = radius;
	}

	public Circle(float radius,String color){
		super(color);
		this.radius = radius;
	}

	public float getRadius(){
		return radius;
	}

	public void setRadius(float radius){
		this.radius = radius;
	}

	public float getArea(){
		return (float)3.14 * radius * radius;
	}

	public float getPerimeter(){
		return (float)2 * (float)3.14 * radius;
	}

}

class Rectangle extends Shape{
	protected float length =  1.0f;
	protected float width =  1.0f;

	public  Rectangle(){
		length = width = 1.0f;
	}	

	public Rectangle(float width,float length){
		this.length = length;
		this.width  = width;
	}

	public Rectangle(float width,float length,String color){
		super(color);
		this.length = length;
		this.width  = width;
	}

	public float getWidth(){
		return width;
	}

	public float getLength(){
		return length;
	}

	public void setWidth(float width){
		this.width = width;
	}

	public void setLength(float length){
		this.length = length;
	}

	public float getArea(){
		return length * width;
	}

	public float getPerimeter(){
		return 2 * (length + width);
	}

}

class Square extends Rectangle{
	public Square(){
		super();
	}

	public Square(float side){
		super(side,side);
	}

	public Square(float side,String color){
		super(side,side,color);
	}

	public float getSide(){
		return length;
	}

	public void setSide(float side){
		setLength(side);
		setWidth(side);
	}

}

class TestShape{
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String color;
		float dim1,dim2;
		
		System.out.println("ENTER DETAILS OF CIRCLE");
		System.out.print("Enter the radius    : ");
		dim1 = input.nextFloat();
		input.nextLine();
		System.out.print("Enter the color     : ");
		color = input.nextLine();
		Circle c[] = {new Circle(),new Circle(dim1),new Circle(dim1,color)};
		

		System.out.println("\nENTER DETAILS OF RECTANGLE");
		System.out.print("Enter the length    : ");
		dim1 = input.nextFloat();
		System.out.print("Enter the width     : ");
		dim2 = input.nextFloat();
		input.nextLine();
		System.out.print("Enter the color     : ");
		color = input.nextLine();
		Rectangle r[] = {new Rectangle(),new Rectangle(dim1,dim2),new Rectangle(dim1,dim2,color)};

		System.out.println("\nENTER DETAILS OF SQUARE");
		System.out.print("Enter the side      : ");
		dim1 = input.nextFloat();
		input.nextLine();
		System.out.print("Enter the color     : ");
		color = input.nextLine();
		Square s[] = {new Square(),new Square(dim1),new Square(dim1,color)};
		Rectangle sq[] = s;

		System.out.println("\n*********************************************************************\n");


		System.out.println("CIRCLE DETAILS\n");
		for(int i = 0 ; i < 3 ; i++){
			switch(i){
				case 0 :System.out.println("Default constructor Circle():");				break;
				case 1: System.out.println("1 parameter constructor Circle(radius)");		break;
				case 2: System.out.println("2 parameter constructor Circle(radius,color)");	break;
			}
			System.out.println("Area      = " + c[i].getArea());
			System.out.println("Perimeter = " + c[i].getPerimeter());
			System.out.println("Color     = " + c[i].getColor());
			System.out.println("\n---------------------------------------------------------------------\n");
		}
		System.out.println("\n*********************************************************************\n");

		System.out.println("RECTANGLE DETAILS\n");
		for(int i = 0 ; i < 3 ; i++){
			switch(i){
				case 0 :System.out.println("Default constructor Rectangle():");							break;
				case 1: System.out.println("2 parameter constructor Rectangle(width,length)");			break;
				case 2: System.out.println("3 parameter constructor Rectangle(width,length,color)");	break;
			}
			System.out.println("Area      = " + r[i].getArea());
			System.out.println("Perimeter = " + r[i].getPerimeter());
			System.out.println("Color     = " + r[i].getColor());
			System.out.println("\n---------------------------------------------------------------------\n");
		}
		System.out.println("\n*********************************************************************\n");
		
		for(int i = 0 ; i < 3 ; i++){
				switch(i){
				case 0 :System.out.println("Default constructor Sqaure():");				break;
				case 1: System.out.println("1 parameter constructor Sqaure(side)");			break;
				case 2: System.out.println("2 parameter constructor Sqaure(side,color)");	break;
			}
			System.out.println("Area      = " + sq[i].getArea());
			System.out.println("Perimeter = " + sq[i].getPerimeter());
			System.out.println("Color     = " + sq[i].getColor());
			System.out.println("\n---------------------------------------------------------------------\n");
		}
	}
}

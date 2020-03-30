abstract class Shape{
	protected String color;

	Shape(){
		color = "red";
	}

	public Shape(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

 	public void setColor(String color){
 		this.color = color;
 	}
	

 	abstract public float getArea();
 	abstract public float getPerimeter();
 	
}


class Circle extends Shape{
	protected float radius;

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
		return 3.14f * radius * radius;
	}

	public float getPerimeter(){
		return 2 * 3.14f * radius;
	}
	
	public String toString(){
		return "The details of the circle are\n" + 
			   "Color       : " + getColor() + "\n" +  
			   "Area        : " + getArea() + "\n" +
			   "Perimeter   : " + getPerimeter() + "\n";
	}
}

class Rectangle extends Shape{
	protected float width;
	protected float length;

	public Rectangle(){
		length = width = 1.0f;
	}

	public Rectangle(float width,float length){
		this.width = width;
		this.length = length;
	}

	public Rectangle(float width,float length,String color){
		super(color);
		this.width = width;
		this.length = length;
	}

	public float getWidth(){
		return width;
	}

	public float getLength(){
		return 	length;
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
		return 2 * ( length + width);
	}
	
	public String toString(){
		return "The details of the rectangle are\n" +
			   "Color       : " + getColor() + "\n" + 
			   "Area        : " + getArea() + "\n" +
			   "Perimeter   : " + getPerimeter() + "\n";
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
		return getLength();
	}

	public void setSide(float side){
		setLength(side);
		setWidth(side);
	}

	public float getArea(){
		return super.getArea();
	}

	public float getPerimeter(){
		return super.getPerimeter();
	}
	
	public String toString(){
		return "The details of the square are\n" +
			   "Color       : " + getColor() + "\n" +  
			   "Area        : " + getArea() + "\n" +
			   "Perimeter   : " + getPerimeter() + "\n";
	}
	
}

class TestAbstract{
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);

		float length,width,side,radius;
		String color[] = new String[3];
	
		System.out.println("-----------------------------------------");
	
		System.out.print("Enter the radius of the circle    : ");
		radius = input.nextFloat(); 
		System.out.print("Enter the color of the circle     : ");
		color[0] = input.next();
		
		System.out.println("-----------------------------------------");
		
		System.out.print("Enter the length of the rectangle : ");
		length = input.nextFloat();
		System.out.print("Enter the width of the rectangle  : ");
		width = input.nextFloat(); 
		System.out.print("Enter the color of the rectangle  : ");
		color[1] = input.next();
		
		System.out.println("-----------------------------------------");
		
		System.out.print("Enter the side of the square      : ");
		side = input.nextFloat();
		System.out.print("Enter the color of the square     : ");
		color[2] = input.next();
		
		System.out.println("-----------------------------------------");
		
		Shape s[] = { new Circle(),new Circle(radius),new Circle(radius,color[0]),
		              new Rectangle(),new Rectangle(width,length),new Rectangle(width,length,color[1]),
					  new Square(), new Square(side),new Square(side,color[2]) };
					 
		
		System.out.println("\n\nTHE DETAILS OF THE OBJECTS\n");
		for(int i = 0 ; i < s.length ; i++){
			System.out.println(s[i]);
			System.out.println("*****************************************");
		}
	}
}





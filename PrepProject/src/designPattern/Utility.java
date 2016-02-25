package designPattern;

interface Shape
{
	void draw();
}

interface Color
{
	void color();
}


abstract class ImplementFactory
{
	abstract Shape getShape(String shape);
	abstract Color getColor(String color);
}

class Rectangle implements Shape
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing rectangle");
		
	}
}

class Triangle implements Shape
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing triangle");
	}
}


class White implements Color
{

	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("Coloring with white color.");
	}
}

class Red implements Color
{

	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("Coloring with red color.");
	}
	
}

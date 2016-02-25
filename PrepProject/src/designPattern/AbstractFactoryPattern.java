package designPattern;


class ShapeFactory extends ImplementFactory
{

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		if(shape.equals("triangle"))
		{
			return new Triangle();
		}
		else
		{
			return new Rectangle();
		}
	}

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}	
}


class ColorFactory extends ImplementFactory
{

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		if(color.equals("white"))
		{
			return new White();
		}
		else
		{
			return new Red();
		}
	}
}


class FactoryProducer
{
	public static ImplementFactory getFactory(String choice)
	{
		if(choice.equals("SHAPE"))
		{
			return new ShapeFactory();
		}
		else
		{
			return new ColorFactory();
		}
	}
}

public class AbstractFactoryPattern {
	
	public static void main(String[] args)
	{
		ImplementFactory obj = FactoryProducer.getFactory("SHAPE");
		
		obj.getShape("triangle").draw();
		
		obj = FactoryProducer.getFactory("");
		obj.getColor("white").color();
		
		
	}
}

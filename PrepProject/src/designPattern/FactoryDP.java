package designPattern;

public class FactoryDP {
	
	private Shape getShape(String shape)
	{
		if(shape.equals("Triangle"))
		{
			return new Rectangle();
		}
		else
		{
			return new Triangle();
		}
	}
	
	public static void main(String[] args)
	{
		FactoryDP obj = new FactoryDP();
		Shape newObj = obj.getShape("");
		newObj.draw();
	}

}

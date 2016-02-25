package testPackage;

public class Pattern {
	
	public static void main(String[] args)
	{
		int a = Integer.parseInt("5");
		String character ="#";
		String spaces=" ";
		int numberOfSpaces = a-1;
		int numberOfCharacter=1;
		
		int tempSpaces = numberOfSpaces;
		int tempChar = numberOfCharacter;
		
		while(a!=0)
		{
			while(numberOfSpaces!=0)
			{
				System.out.print(spaces);
				numberOfSpaces--;
			}
			tempSpaces--;
			numberOfSpaces = tempSpaces;
			
			while(numberOfCharacter!=0)
			{
				System.out.print(character);
				numberOfCharacter--;
			}
			System.out.println();
			tempChar++;
			numberOfCharacter = tempChar;
			a--;
		}
		
	}

}


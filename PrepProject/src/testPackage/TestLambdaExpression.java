package testPackage;


interface MathOperation
{
	int operation(int a);
}

public class TestLambdaExpression {
	
	static MathOperation checkOddEven = (int a) -> {return ((a%2==0) ? 0 : 1);};
	
	static MathOperation checkPrime = (int a) -> checkPrime(a);
	
	static MathOperation checkPalindrome = (int a) -> checkPalindrome(a);
	
	private int operate(int a, MathOperation op)
	{
		return op.operation(a);
	}
	
	
	private static int checkPrime(int num)
	{
		boolean isPrime = false;
		if(num == 1)
		{
			isPrime = false;
			return 1;
		}
		else if(num == 2)
		{
			isPrime = true;
			return 0;
		}
		System.out.println(5%2);
		if((num%2==1) && (num%3==1 || num%3==2))
		{
			isPrime = true;
		}
		//If isPrime is true then the number is prime else not
		if(isPrime)
		   return 0;
		else
		   return 1;
	}
	
	private static int checkPalindrome(int number) {
		// TODO Auto-generated method stub
		int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        if (number == reverse) {
            return 0;
        }
        return 1;
	}


	public static void main(String[] args)
	{
		TestLambdaExpression list = new TestLambdaExpression();
		System.out.println(list.operate(10, checkOddEven) == 0 ? "Even":"Odd");
		System.out.println(list.operate(97, checkPrime)==0 ? "Prime":"Not Prime");
		System.out.println(list.operate(898, checkPalindrome)==0 ? "Plaindrom" : "Not Plaindrome");
	}	
}

	

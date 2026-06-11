import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Entere any no:");
		int num = sc.nextInt();
		boolean isPrime = false;
		if(num ==0 || num==1)
		{
			System.out.println(num+" is not a prime number");
		}
		else
		{
			for(int i=2;i<num;i++)
			{
				if(num%i!=0)
				isPrime=true;
				break;
			}
		}
		if(isPrime)
		{
			System.out.println(num+" is a prime number");
		}
		else{
			(num+" is not a prime number");
		}
		
	}
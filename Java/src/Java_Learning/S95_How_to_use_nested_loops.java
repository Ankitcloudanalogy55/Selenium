package Java_Learning;

public class S95_How_to_use_nested_loops 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int count = 0;
		for(int i=1;i<=4;i++) 
		{
			int j=1; // initialize the variable for while loop
			while(j<=5)
			{
				
				for(int x=1;x<=2;x++)
				{
					System.out.println("value of i is " + i + " value of j is " + j + " value of x is "+x);
					count++;
				}
				j++;
				
			}
		}
		System.out.println(count);
	}

}

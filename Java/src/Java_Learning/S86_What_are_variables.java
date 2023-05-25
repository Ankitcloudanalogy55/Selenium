package Java_Learning;

public class S86_What_are_variables {

	int j = 20; // Instance variable - scope of this variable is only this class and all methods/functions of this class.
	
	public static void main(String[] args) {
		
		int myNumber1 = 10;
		int myNumber2 = 10;
		char ch = 'A';
		String str1 = "RCV";
		System.out.println(str1+" "+myNumber1);
		System.out.println(myNumber2+myNumber1);

	}

	public void myMethod()
	{
		int i =20; // Local variable - scope of this variable is only in this class
	}
}

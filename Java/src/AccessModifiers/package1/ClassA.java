package AccessModifiers.package1;

public class ClassA {

	public int publicVariable = 1;
	int defaultVariable = 2;
	private int privateVariable = 3;
	protected int protectedVariable = 4;
	
	public static void main() {
		ClassA ob = new ClassA();
		ob.privateMethod();
	}
		
	
	public void publicMethod() {
		System.out.println("Public Method");
	}
	void defaultMethod() {
		System.out.println("Default Method");
	}
	private  void privateMethod() {
		System.out.println("Private Method");
	}
	protected  void protectedMethod() {
		System.out.println("Protected Method");
	}
}

/* NOTE - 
1. For Class:
a. We only use public and default access modifiers in class name.
b. We can access all type of methods rather than private for another class with same package.
c. We can access another class with another package when class access modifier is public but we can access only public method.
d. If we create class with default access modifier then we cannot access that class in another package class 
which means that default access modifier classes are accessible within same package.
*/
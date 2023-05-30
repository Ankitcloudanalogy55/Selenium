package AccessModifers.package2;

import AccessModifiers.package1.*;
//import AccessModifiers.package1.ClassA;
//import AccessModifiers.package1.ClassAA;

public class ClassB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassA ob = new ClassA();
		ob.publicMethod();


		ClassAA ob1 = new ClassAA();
		ob1.methodAA();
	}

}

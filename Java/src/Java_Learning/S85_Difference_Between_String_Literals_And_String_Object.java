package Java_Learning;

public class S85_Difference_Between_String_Literals_And_String_Object {

	public static void main(String[] args) {


		String str1 = "RCV"; // this is string literal
		String str3 = "RCV";
		String str2 = new String("RCV"); // this is string object
		System.out.println(str1==str3); // same
		System.out.println(str1==str2); // same
		System.out.println(str1.equals(str2)); // new container is create with new location
	}

}

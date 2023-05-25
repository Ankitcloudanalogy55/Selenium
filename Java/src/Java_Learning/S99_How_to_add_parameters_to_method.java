package Java_Learning;

public class S99_How_to_add_parameters_to_method {

	public static void main(String[] args) {
		
		doLogin();
		S99_How_to_add_parameters_to_method md = new S99_How_to_add_parameters_to_method();
		System.out.println(md.addNumbers(5,10));
		md.diifParameters("This is string",5,10); // this is arguments

	}

	private static void doLogin() {
		// TODO Auto-generated method stub
		System.out.println("Login Success");
	}

	private void diifParameters(String s, int i, float j) { // s,i,j are parameters
		// TODO Auto-generated method stub
		System.out.println(s);
		System.out.println(i);
		System.out.println(j);
	}

	private int addNumbers(int i, int j) {
		// TODO Auto-generated method stub
		int z = i+j;
		return z;
	}

}

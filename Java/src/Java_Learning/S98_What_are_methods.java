package Java_Learning;

public class S98_What_are_methods {
	
	public static void main(String[] args) {
	
	S98_What_are_methods md = new S98_What_are_methods(); // Here md is object
	md.doLogin(); // We call method with the help of md object
	md.doLogin();
	md.doLogin();
	md.doLogin();
	md.doLogout();
}

 public void doLogin() { // Method 1
	 System.out.println("Login Succesfully");
 }
 
 public void doLogout() { // Method 2
	 doLogin();
	 System.out.println("Logout Succesfully");
 }
 }
 
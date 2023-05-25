package Java_Learning;

public class S94_Break_and_Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=10;i++) {
			if(i==3) {
				break; // it will completely  jump out the loop
			}
			System.out.println(i);
		}
		
		System.out.println("Continue statement");
		for(int i=1;i<=10;i++) {
			if(i==3) {
				continue;// when condition is meet skip that condition
			}
			System.out.println(i);
		}
		System.out.println("FInal statement");
	}

}

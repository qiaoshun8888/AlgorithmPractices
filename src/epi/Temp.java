package epi;

public class Temp {
	
	public static void main(String[] args) {
		int empty = 7;
		System.out.println(Integer.toBinaryString(empty));
		empty &= ~(0 << 0);
		System.out.println(Integer.toBinaryString(empty));
		empty &= ~(1 << 1);
		System.out.println(Integer.toBinaryString(empty));
		empty &= ~(0 << 2);
		System.out.println(Integer.toBinaryString(empty));
		
		System.out.println(empty);
		
		boolean company_empty = ((empty >> 0) & 1) == 0;
		boolean contact_empty = ((empty >> 1) & 1) == 0;
		boolean googler_empty = ((empty >> 2) & 1) == 0;
		
		System.out.println(company_empty);
		System.out.println(contact_empty);
		System.out.println(googler_empty);
	}
}

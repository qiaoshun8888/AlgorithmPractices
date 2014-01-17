package programcreek;

public class JavaAliasing {

	public static void main(String[] args) {
		JavaAliasingClassB [] b = new JavaAliasingClassB[10];
		JavaAliasingClassA [] a = b;
		
		// a[0] = new JavaAliasingClassA();
		a[0] = new JavaAliasingClassB();
		a[0].methodParent();
	}
}

class JavaAliasingClassA {
	
	public void methodParent() {
		System.out.println("Method in parent");
	}
}

class JavaAliasingClassB extends JavaAliasingClassA {
	
	public void methodParent() {
		System.out.println("Override method in child");
	}
	
	public void methodChild() {
		System.out.println("Method in child");
	}
}

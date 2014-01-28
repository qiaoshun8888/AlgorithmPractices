package google;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ReflectionExample.java
 * 
 * Description: Explain what object reflection is in Java and why it is useful.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 28, 2014
 */

public class ReflectionExample {

	public static void main(String[] args) {
		try {
			// Parameters
			Object[] dobuleArgs = new Object[] { 2.2, 3.3 };

			// Get class
			Class rectangleDefinition = Class
					.forName("google.ReflectionExampleRectangle");

			// Equivalent: ReflectionExampleRectangle rec = new
			// ReflectionExampleRectangle(2.2, 3.3)
			Class[] doubleArgsClass = new Class[] { double.class, double.class };
			Constructor doubleArgsConstructor = rectangleDefinition
					.getConstructor(doubleArgsClass);
			ReflectionExampleRectangle rec = (ReflectionExampleRectangle) doubleArgsConstructor
					.newInstance(dobuleArgs);

			// Equivalent: Double area = rec.area();
			Method m = rectangleDefinition.getDeclaredMethod("area");
			System.out.println("Area is: " + m.invoke(rec));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class ReflectionExampleRectangle {
	double width, height;

	public ReflectionExampleRectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double area() {
		return width * height;
	}
}

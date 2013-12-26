package other_practices1;

import java.io.File;
import java.util.Scanner;

public class JavaIO {

	public static void main(String [] args) {
		File file = new File("bin/other_practices1/test_data");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.isFile());
		System.out.println(file.exists());
		
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

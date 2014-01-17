package programcreek;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestExampleTest {

	@Test
	public void testCapitalize() {
		assertEquals(null, JUnitTestExample.capitalize(null));
		// Similarity we can use assertTrue()
		assertTrue(null == JUnitTestExample.capitalize(null));
		
		assertEquals("capitalize(empty-string) failed", "", JUnitTestExample.capitalize(""));
		
		assertEquals("capitalize(hello world) failed", "Hello world", JUnitTestExample.capitalize("hello world"));
	}
}

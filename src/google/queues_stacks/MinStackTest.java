package google.queues_stacks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *	MinStackTest.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 23, 2014
 */

public class MinStackTest {
	
	@Before
	public void setUp() {
		System.out.println("setUp");
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown");
	}

	@Test(expected=Exception.class)
	public void testPush() throws Exception {
		System.out.println("testPush");
		
		int capacity = 20;
		MinStack ms = new MinStack(capacity);
		
		for (int i = 0; i < 19; i++) {
			ms.push(i);
		}
		
		assertEquals("Size is wrong", 19, ms.size());
		
		for (int i = 0; i < 5; i++) {
			ms.push(i);
		}
	}

}

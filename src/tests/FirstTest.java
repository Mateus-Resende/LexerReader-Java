package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.Token;

public class FirstTest {
	Token a;
	
	@BeforeClass
	public void firstSetUp() throws Exception {
		a = new Token();
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String bla = "bla";
		
		boolean expected = true;
		boolean actual = a.isValidString(bla);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInvalidString() {
		String ble = "1234";
		
		boolean expected = false;
		boolean actual = a.isValidString(ble);
		
		assertEquals(expected, actual);
	}

}

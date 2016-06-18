package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import core.Token;

public class TokenTests {

	@Test
	public void tokenDoesntHaveNextTest() {
        Token a = new Token("");
        boolean expected = false;
        boolean actual = a.hasNext();

        assertEquals(expected, actual);
	}
	
	@Test
	public void tokenHasNextTest() {
		Token bla = new Token("bla");
        boolean expected = true;
        boolean actual = bla.hasNext();

        assertEquals(expected, actual);
	}

}

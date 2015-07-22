package unitTests;

import static org.junit.Assert.*;
import naturalLanguageProcessor.Adjective;

import org.junit.Test;

/*
 * Purpose:	Unit testing for the Adjective class
 */
public class AdjectiveTest {

	/*
	 * Purpose:	Test the equals method
	 */
	@Test
	public void equals() {
		Adjective brown = new Adjective("brown");
		Adjective brown2 = new Adjective("brown");
		assertEquals(brown, brown2);
	}

}

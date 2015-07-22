package unitTests;

import static org.junit.Assert.*;
import naturalLanguageProcessor.Dictionary;
import naturalLanguageProcessor.Word.wordType;

import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Purpose:	Unit testing for the Dictionary class
 */
public class DictionaryTest {
	
	private static Dictionary dict;	//General use dictionary doesn't need to be loaded each time
	
	/*
	 * Purpose:	Create a dictionary that most tests will use
	 */
	@BeforeClass
	public static void setup() {
		dict = new Dictionary("Dictionary.txt");
	}
	
	/*
	 * Purpose:	Test loading a new dictionary on top of an old one.
	 */
	@Test
	public void loadTest() {
		assertTrue(dict.hasWord("over"));
		assertFalse(dict.hasWord("strawberry"));
		dict.load("TestDictionary.txt");
		assertFalse(dict.hasWord("over"));
		assertTrue(dict.hasWord("strawberry"));
		dict.load("Dictionary.txt");	//cleanup - put the old dictionary back into memory
	}
	
	/*
	 * Purpose:	Test the hasWord method
	 */
	@Test
	public void hasWordTest() {
		assertTrue(dict.hasWord("fox"));
		assertFalse(dict.hasWord("blueberry"));
	}

	/*
	 * Purpose:	Test the getType method
	 */
	@Test
	public void getType() {
		assertEquals(wordType.verb, dict.getType("jumped"));
	}
}

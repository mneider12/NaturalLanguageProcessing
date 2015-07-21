package unitTests;

import static org.junit.Assert.*;

import java.io.File;

import naturalLanguageProcessor.Dictionary;

import org.junit.Test;

public class DictionaryTest {
	
	@Test
	public void hasWordTest() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		
		assertTrue(dict.hasWord("fox"));
		assertFalse(dict.hasWord("blueberry"));
	}

}

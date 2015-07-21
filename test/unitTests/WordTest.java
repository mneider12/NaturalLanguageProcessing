package unitTests;

import static org.junit.Assert.*;
import naturalLanguageProcessor.Noun;
import naturalLanguageProcessor.Word;
import naturalLanguageProcessor.Verb;

import org.junit.Test;

public class WordTest {

	@Test
	public void compareToTest() {
		Word verb = new Verb("back");
		Word noun = new Noun("back");
		Word ran = new Verb("ran");
		
		assertTrue(verb.compareTo(noun) > 0);
		assertFalse(noun.compareTo(verb) > 0);
		
		assertTrue(verb.compareTo(ran) < 0);
	}

}

package unitTests;

import static org.junit.Assert.*;
import naturalLanguageProcessor.Verb;
import naturalLanguageProcessor.Word;

import org.junit.Test;

public class VerbTest {

	@Test
	public void toStringTest() {
		Word verb = new Verb("run");
		assertTrue(verb.getType().getAbbrev().equals("v."));
		assertTrue(verb.toString().equals("run (v.)"));
	}

}

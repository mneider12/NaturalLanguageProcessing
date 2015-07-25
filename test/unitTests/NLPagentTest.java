package unitTests;

import static org.junit.Assert.*;
import naturalLanguageProcessor.NLPagent;
import naturalLanguageProcessor.Verb;

import org.junit.Test;

public class NLPagentTest {

	/*
	 * Purpose: Test changing the dictionary for an agent
	 */
	@Test
	public void setDictTest() {
		NLPagent agent = new NLPagent("This is not a drill");
		Verb testWord = new Verb("is");
		assertFalse(agent.getWords().get(1).equals(testWord));
		agent.setDictionary("TestDictionary.txt");
		assertEquals(testWord, agent.getWords().get(1));
	}
	
}

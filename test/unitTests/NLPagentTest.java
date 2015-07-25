package unitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import naturalLanguageProcessor.Adjective;
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
	
	/*
	 * Purpose:	Test interactive mode
	 */
	@Test
	public void interactTest() {
		File inputFile = new File("test/unitTests/interactiveTestInput.txt");
		try {
			FileInputStream inputStream = new FileInputStream(inputFile);
			System.setIn(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		NLPagent agent = new NLPagent("the cellar door is the most beuatiful phrase"
				+ " in the english language", true);
		Adjective[] adjectives = {new Adjective("cellar")};
		ArrayList<Adjective> testAdjectives = agent.getAdjectives("door");
		assertArrayEquals(adjectives, testAdjectives.toArray());
	}
	
}

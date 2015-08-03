package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import naturalLanguageProcessor.Adjective;
import naturalLanguageProcessor.Frame;
import naturalLanguageProcessor.NLPagent;
import naturalLanguageProcessor.Noun;
import naturalLanguageProcessor.PrepClauseFrame;
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
	 * Purpose:	Check that we can extract adjectives positioned directly before a noun
	 */
	@Test
	public void quickFox() {
		NLPagent agent = new NLPagent("the quick brown fox jumped over the lazy dog");
		ArrayList<Adjective> foxDesc = agent.getAdjectives("fox");
		ArrayList<Adjective> foxDescAns = new ArrayList<Adjective>();
		foxDescAns.add(new Adjective("quick"));
		foxDescAns.add(new Adjective("brown"));
		assertArrayEquals(foxDescAns.toArray(), foxDesc.toArray());
		
		ArrayList<Adjective> dogDesc = agent.getAdjectives("dog");
		ArrayList<Adjective> dogDescAns = new ArrayList<Adjective>();
		dogDescAns.add(new Adjective("lazy"));
		assertArrayEquals(dogDescAns.toArray(), dogDesc.toArray());
		
		// check that non-nouns do not get associated with adjectives
		ArrayList<Adjective> jump = agent.getAdjectives("jump");
		assertArrayEquals(new ArrayList<Adjective>().toArray(), jump.toArray());
	}
	
	/*
	 * Purpose: Test preposition frame
	 */
	@Test
	public void quickFoxPrep() {
		NLPagent agent = new NLPagent("the quick brown fox jumped over the lazy dog");
		Noun dog = new Noun("dog");
		PrepClauseFrame clause = null;
		int clauseCnt = 0;
		ArrayList<Frame> frames = agent.getFrames();
		
		for (Frame frame : frames) {
			if (frame.getClass() == PrepClauseFrame.class) {
				clause = (PrepClauseFrame) frame;
				clauseCnt++;
			}
		}
		assertEquals(1, clauseCnt);
		assertEquals(dog, clause.getTarget());
	}
	
	/*
	 * Purpose:	Test that the current adjectives not preceeding a noun are not associated with that
	 * 			noun
	 */
	@Test
	public void earlyAdj() {
		NLPagent agent = new NLPagent("the dog is big but the quick fox jumped over him");
		Adjective[] foxDesc = {new Adjective("quick")};
		assertArrayEquals(foxDesc, agent.getAdjectives("fox").toArray());
	}
	
	/*
	 * Purpose:	Test interactive mode
	 */
	/*
	// TODO: Need to update input reader creation (possibly Guice) in order 
	// 		 to successfully test
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
	*/
}
